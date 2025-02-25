library(ggplot2)

# 6. Generate and plot 1000 random normal values
mean_value <- as.numeric(system("read -p 'Enter mean: ' input; echo $input", intern=TRUE))
sd_value <- as.numeric(system("read -p 'Enter standard deviation: ' input; echo $input", intern=TRUE))

# Generate random values from normal distribution
random_values <- rnorm(1000, mean_value, sd_value)

# Create the plot
p <- ggplot(data.frame(x = random_values), aes(x)) +
  geom_histogram(binwidth = 0.5, fill = "blue", alpha = 0.7) +
  theme_minimal() +
  ggtitle("Normal Distribution") +
  theme(
    panel.background = element_rect(fill = "white", color = "white"),  # White panel
    plot.background = element_rect(fill = "white", color = "white"),   # White plot area
    panel.grid.major = element_line(color = "gray90"),                 # Light grid lines
    panel.grid.minor = element_blank()                                  # Remove minor grid lines
  )


# Save the plot
ggsave("normal_distribution.png", plot = p, width = 6, height = 4, dpi = 300)
