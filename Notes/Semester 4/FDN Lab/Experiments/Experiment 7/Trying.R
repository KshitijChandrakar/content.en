library(tidyverse)
library(caret)
library(glmnet)
library(corrplot)

df <- read.csv("C:/Users/HP/Desktop/Sem4/Fundamentals of Data Science Lab/Heart_disease_cleveland_new.csv")

str(df)
summary(df)


# 2. Feature Engineering

# (i) Normalize numerical features
num_cols <- c("age", "trestbps", "chol", "thalach", "oldpeak")

# Normalize using scale()
df[num_cols] <- scale(df[num_cols])

# (ii) Create BMI-to-Age Ratio
df$bmi <- df$chol / 10

df$bmi_age_ratio <- df$bmi / (df$age + 1)

head(df)

# (iii) Correlation Matrix Visualization
corr_matrix <- cor(df %>% select_if(is.numeric), use = "complete.obs")
corrplot(corr_matrix, method = "color", tl.cex = 0.7)


# 3. Feature Selection

# (i) Recursive Feature Elimination (RFE)

df$target <- as.factor(df$target)

control <- rfeControl(functions = rfFuncs, method = "cv", number = 5)

set.seed(123)
rfe_result <- rfe(
  x = df[, -which(names(df) == "target")],
  y = df$target,
  sizes = c(1:10),
  rfeControl = control
)

print(rfe_result$optVariables)

# (ii) LASSO Feature Selection

x <- model.matrix(target ~ ., df)[, -1]
y <- as.numeric(as.character(df$target))

lasso_model <- cv.glmnet(x, y, alpha = 1, family = "binomial")

print(coef(lasso_model, s = "lambda.min"))


# 4. Model training and performance metrics

df$mass <- df$chol / 10

selected_features <- c("glucose", "mass", "bmi_age_ratio")

if (!"glucose" %in% names(df)) {
  df$glucose <- df$chol / 5
}

df_model <- df[, c(selected_features, "target")]

set.seed(123)
model <- train(target ~ ., data = df_model, method = "glm", family = "binomial")

print(model)
