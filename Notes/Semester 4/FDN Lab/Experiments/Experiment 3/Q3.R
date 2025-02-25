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
# Outlier Detection and Handling
###############################
# %%
# i. Boxplot Visualization to visualize Salary data
ggplot(df_mean, aes(y = Salary)) +
  geom_boxplot(fill = "skyblue", outlier.color = "red", outlier.shape = 16) +
  labs(title = "Boxplot of Salary", y = "Salary")


# %%
# ii. Z-Score Method (Values outside ±3 standard deviations)
df_mean_z <- df_mean %>%
  mutate(Salary_Z = as.numeric(scale(Salary))) %>%  # Convert scale output to numeric
  filter(abs(Salary_Z) <= 3) %>%  # Remove outliers
  select(-Salary_Z)  # Remove Z-score column
print(df_mean_z)


# %%
# iii. IQR Method: Remove values outside Q1 - 1.5*IQR and Q3 + 1.5*IQR
Q1 <- quantile(df_mean$Salary, 0.25)
Q3 <- quantile(df_mean$Salary, 0.75)
IQR_value <- Q3 - Q1
lower_bound <- Q1 - 1.5 * IQR_value
upper_bound <- Q3 + 1.5 * IQR_value

df_mean_iqr <- df_mean %>%
  filter(Salary >= lower_bound & Salary <= upper_bound)


# %%
# iv. Winsorization: Replace extreme values with 5th and 95th percentiles
df_mean_winsorized <- df_mean %>%
  mutate(Salary = Winsorize(Salary, probs = c(0.05, 0.95)))

# %%
# v. Detect & Remove Outliers Using tidyverse (filter method)
df_mean_tidy_outliers <- df_mean %>%
  filter(between(Salary, lower_bound, upper_bound))

# %%
# vi. Detect Outliers in Multiple Columns using apply() (Z-score method)
detect_outliers <- function(x) {
  if (is.numeric(x)) {
    z_scores <- scale(x)
    return(abs(z_scores) > 3)
  } else {
    return(rep(FALSE, length(x)))
  }
}

outlier_matrix <- apply(df_mean, 2, detect_outliers)
df_mean_clean <- df_mean[!rowSums(outlier_matrix), ]  # Remove rows with outliers

# %%
# vii. Create a Clean Dataset After Removing Outliers
df_mean_final <- df_mean_iqr  # Using IQR method for final clean dataset
write.csv(df_mean_final, "Clean_Dataset.csv", row.names = FALSE)
