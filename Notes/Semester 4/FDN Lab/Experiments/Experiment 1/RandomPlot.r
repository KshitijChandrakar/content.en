library(ggplot2)

# 6. Generate and plot 1000 random normal values
mean_value <- as.numeric(readline("Enter mean: "))
sd_value <- as.numeric(readline("Enter standard deviation: "))
mean_value <- 10
sd_value <- 20
random_values <- rnorm(1000, mean_value, sd_value)
ggplot(data.frame(x = random_values), aes(x)) +
  geom_histogram(binwidth = 0.5, fill = "blue", alpha = 0.7) +
  theme_minimal() +
  ggtitle("Normal Distribution")
