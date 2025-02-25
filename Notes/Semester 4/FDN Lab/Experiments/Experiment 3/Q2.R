
# %%
library(tidyverse)
# %%
setwd("/home/asus/content/Notes/Semester 4/FDN Lab/Experiments/Experiment 3")
# %%
df_mean <- data.frame(
  ID = c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
  Name = c("Alice", "Bob", NA, "David", "Emma", "Frank", NA, "Hannah", "Ian", "Jack"),
  Age = c(25, NA, 30, 29, NA, 35, 40, NA, 50, 27),
  Salary = c(50000, 60000, 55000, NA, 70000, 75000, 80000, 65000, NA, 72000),
  Score = c(80, 90, NA, 85, 88, 92, NA, 77, 95, Inf)
)


# %%
###############################
# Handling Missing Data
###############################
# %%
# i. Identify missing data
print(is.na(df_mean))  # Identify missing values
print(sum(is.na(df_mean)))  # Count total missing values

# %%

# ii. Remove missing rows
df_mean_no_na <- na.omit(df_mean)
print(df_mean_no_na)

# %%

# iii. Replace NA with zero
df_mean_zero <- df_mean
df_mean_zero[is.na(df_mean_zero)] <- 0
print(df_mean_zero)


# %%

# iv. Replace NA with column mean (for numeric columns)
df_mean_mean <- df_mean

df_mean$Age[is.na(df_mean$Age)] <- mean(df_mean$Age, na.rm = TRUE)
df_mean$Salary[is.na(df_mean$Salary)] <- mean(df_mean$Salary, na.rm = TRUE)
df_mean$Score[is.na(df_mean$Score)] <- mean(df_mean$Score, na.rm = TRUE)

print(df_mean_mean)

# %%

# v. Remove Inf and NaN
df_mean_clean <- df_mean
df_mean_clean$Score[is.infinite(df_mean_clean$Score) | is.nan(df_mean_clean$Score)] <- NA
print(df_mean_clean)

# %%

# vi. Use tidyverse's replace_na() for selective columns
df_mean_tidy <- df_mean %>%
  mutate(
    Age = replace_na(Age, mean(Age, na.rm = TRUE)),
    Salary = replace_na(Salary, median(Salary, na.rm = TRUE))
  )
print(df_mean_tidy)


# %%
# vii. Drop columns with excessive missing data (more than 50% missing)
df_mean_filtered <- df_mean[, colSums(is.na(df_mean)) < (nrow(df_mean) * 0.5)]
print(df_mean_filtered)


# %%
# viii. Fill missing categorical values with mode
fill_mode <- function(x) {
  if (is.character(x)) {
    mode_value <- names(sort(table(x), decreasing = TRUE))[1]
    x[is.na(x)] <- mode_value
  }
  return(x)
}
df_mean_mode <- df_mean
df_mean_mode$Name <- fill_mode(df_mean_mode$Name)
print(df_mean_mode)
