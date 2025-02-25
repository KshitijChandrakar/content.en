
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
# Data Imputation
###############################

# %%
df[df == Inf | df == -Inf] <- NA  # Convert Inf to NA
df[is.nan(df)] <- NA  # Convert NaN to NA

# %%
df_no_na <- na.omit(df)  # Remove rows with any NA

# %%
df <- df[, colSums(is.na(df)) < (0.5 * nrow(df))]

# %%
df[sapply(df, is.numeric)] <- lapply(df[sapply(df, is.numeric)], function(x) { replace(x, is.na(x), 0) })

# %%
df$Age[is.na(df$Age)] <- mean(df$Age, na.rm = TRUE)

# %%
df$Salary[is.na(df$Salary)] <- median(df$Salary, na.rm = TRUE)

# %%
fill_mode <- function(x) {
  mode_value <- names(sort(table(x), decreasing = TRUE))[1]
  x[is.na(x)] <- mode_value
  return(x)
}

df$Name <- fill_mode(df$Name)  # Apply mode function to Name column

# %%
summary(df)  # Check if missing values are handled
