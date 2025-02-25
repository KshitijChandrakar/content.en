
# %%
library(tidyverse)
# %%
setwd("/home/asus/content/Notes/Semester 4/FDN Lab/Experiments/Experiment 3")
# %%
df <- data.frame(
  ID = c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
  Name = c("Alice", "Bob", NA, "David", "Emma", "Frank", NA, "Hannah", "Ian", "Jack"),
  Age = c(25, NA, 30, 29, NA, 35, 40, NA, 50, 27),
  Salary = c(50000, 60000, 55000, NA, 70000, 75000, 80000, 65000, NA, 72000),
  Score = c(80, 90, NA, 85, 88, 92, NA, 77, 95, Inf)
)

# %%
###############################
# Exploring Inbuilt Functions
###############################
# %%
is.na(df)

# %%
complete.cases(df)


# %%
df[complete.cases(df), ]

# %%
summary(df)


# %%
# Boxplot to detect outliers
boxplot(df$Salary, main = "Salary Outliers", horizontal = FALSE)

# %%
# Identify outliers using IQR
Q1 <- quantile(df$Salary, 0.25, na.rm = TRUE)
Q3 <- quantile(df$Salary, 0.75, na.rm = TRUE)
IQR <- Q3 - Q1
lower_bound <- Q1 - 1.5 * IQR
upper_bound <- Q3 + 1.5 * IQR
outliers <- df$Salary[df$Salary < lower_bound | df$Salary > upper_bound]
print(outliers)

# %% Calculate IQR using IQR()
iqr_value <- IQR(df$Salary, na.rm=TRUE)
print(iqr_value)

# %% Full Rows
df_clean <- na.omit(df)
print(df_clean)


# %% Replace NA in Salary with mean
df$Age[is.na(df$Age)] <- mean(df$Age, na.rm = TRUE)
df$Salary[is.na(df$Salary)] <- mean(df$Salary, na.rm = TRUE)
df$Score[is.na(df$Score)] <- mean(df$Score, na.rm = TRUE)
print(df)
