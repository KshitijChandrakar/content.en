# Load required libraries
set.seed(1)
library(tidyverse)
library(caret)
# library(glmnet)
library(mlbench)
library(randomForest)
library(corrplot)

# %%
# Load Pima Indians Diabetes dataset
data("PimaIndiansDiabetes2")
df <- PimaIndiansDiabetes2

# %%
# Check structure & missing values
glimpse(df)
summary(df)
df <- na.omit(df)

# %%
preProc <- preProcess(df[, -9], method = c("center", "scale"))
df_scaled <- predict(preProc, df)

# %%
df_scaled <- df_scaled %>% mutate(bmi_age_ratio = mass / age)

# %%
cor_matrix <- cor(df_scaled %>% select(-diabetes))
corrplot(cor_matrix, method = "color", type = "upper", tl.cex = 0.7)

# %%
ctrl <- rfeControl(functions = rfFuncs, method = "cv", number = 10)
rfe_result <- rfe(
  x = df_scaled %>% select(-diabetes),
  y = df_scaled$diabetes,
  sizes = 1:8,
  rfeControl = ctrl
)

# %%
print(rfe_result)
plot(rfe_result, type = c("g", "o"))

# %%

# Recursive feature selection
#
# Outer resampling method: Cross-Validated (10 fold)
#
# Resampling performance over subset size:
#
#  Variables Accuracy  Kappa AccuracySD KappaSD Selected
#          1   0.7370 0.4015    0.08246  0.1738
#          2   0.7550 0.4302    0.09990  0.2373
#          3   0.7982 0.5375    0.07832  0.1764        *
#          4   0.7960 0.5395    0.09471  0.2082
#          5   0.7883 0.5197    0.07887  0.1734
#          6   0.7883 0.5076    0.06279  0.1399
#          7   0.7780 0.4840    0.06170  0.1334
#          8   0.7729 0.4693    0.07216  0.1671
#          9   0.7779 0.4860    0.07502  0.1732
#
# The top 3 variables (out of 3):
#    glucose, age, insulin
#

# %%
x <- model.matrix(diabetes ~ ., df_scaled)[, -1]
y <- ifelse(df_scaled$diabetes == "pos", 1, 0)

# %%
# Fit LASSO
cv_lasso <- cv.glmnet(x, y, alpha = 1, family = "binomial")
plot(cv_lasso)


# %%
# Coefficients at optimal lambda
coef(cv_lasso, s = "lambda.min")

# %%
trainIndex <- createDataPartition(df_scaled$diabetes, p = 0.8, list = FALSE)
train <- df_scaled[trainIndex, ]
test <- df_scaled[-trainIndex, ]

# %%
model_all <- train(
  diabetes ~ .,
  data = train,
  method = "glm",
  family = "binomial",
  trControl = trainControl(method = "cv", number = 10)
)

# %%
pred_all <- predict(model_all, test)
confusionMatrix(pred_all, test$diabetes)

# %%
model_selected <- train(
  diabetes ~ glucose + mass + bmi_age_ratio,
  data = train,
  method = "glm",
  family = "binomial",
  trControl = trainControl(method = "cv", number = 10)
)


# %%
# Predictions
pred_selected <- predict(model_selected, test)
confusionMatrix(pred_selected, test$diabetes
