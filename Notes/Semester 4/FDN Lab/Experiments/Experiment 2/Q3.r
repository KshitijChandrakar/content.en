library(ggplot2)

# Load the iris dataset
data(iris)

# Scatterplot: Sepal Length vs. Petal Length
ggplot(iris, aes(x = Sepal.Length, y = Petal.Length, color = Species)) +
  geom_point(size = 3, alpha = 0.7) +
  labs(title = "Sepal Length vs Petal Length",
       x = "Sepal Length",
       y = "Petal Length") +
  theme_bw()

# Save the plot
ggsave("iris_scatterplot.png", width = 8, height = 6)
