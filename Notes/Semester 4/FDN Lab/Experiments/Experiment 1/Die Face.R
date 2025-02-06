# Load necessary library
library(ggplot2)

# 1. Compute probability of rolling a specific die face
die_face <- as.integer(readline("Enter a die face (1-6): "))
if (die_face >= 1 & die_face <= 6) {
  cat("Probability:", 1/6, "\n")
} else {
  cat("Invalid input.\n")
}

# 2. Probability of rolling two specific numbers
num1 <- as.integer(readline("Enter first number (1-6): "))
num2 <- as.integer(readline("Enter second number (1-6): "))
if (num1 >= 1 & num1 <= 6 & num2 >= 1 & num2 <= 6) {
  cat("Probability of rolling both:", (1/6) * (1/6), "\n")
} else {
  cat("Invalid input.\n")
}

# 3. Union probability of two sets
set1 <- as.integer(strsplit(readline("Enter first set of numbers (comma-separated, 1-6): "), ",")[[1]])
set2 <- as.integer(strsplit(readline("Enter second set of numbers (comma-separated, 1-6): "), ",")[[1]])
union_prob <- length(unique(c(set1, set2))) / 6
cat("Union probability:", union_prob, "\n")

# 4. Compute probability of disease given a positive test (Bayes' Theorem)
prior <- as.numeric(readline("Enter prior probability of disease: "))
sensitivity <- as.numeric(readline("Enter sensitivity (true positive rate): "))
false_positive <- as.numeric(readline("Enter false positive rate: "))
posterior <- (sensitivity * prior) / ((sensitivity * prior) + (false_positive * (1 - prior)))
cat("Probability of having disease given a positive test:", posterior, "\n")

# 5. Roll a die n times and compute probabilities
n <- as.integer(readline("Enter number of die rolls: "))
rolls <- sample(1:6, n, replace = TRUE)
probabilities <- table(rolls) / n
print(probabilities)

# 6. Generate and plot 1000 random normal values
mean_value <- as.numeric(readline("Enter mean: "))
sd_value <- as.numeric(readline("Enter standard deviation: "))
random_values <- rnorm(1000, mean_value, sd_value)
ggplot(data.frame(x = random_values), aes(x)) +
  geom_histogram(binwidth = 0.5, fill = "blue", alpha = 0.7) +
  theme_minimal() +
  ggtitle("Normal Distribution")

# 7. Compute expected value
cost <- as.numeric(readline("Enter cost of the game: "))
outcomes <- as.numeric(strsplit(readline("Enter possible outcomes (comma-separated): "), ",")[[1]])
probabilities <- as.numeric(strsplit(readline("Enter their probabilities (comma-separated): "), ",")[[1]])
expected_value <- sum(outcomes * probabilities) - cost
cat("Expected Value:", expected_value, "\n")

# 8. Compute Poisson probability
lambda <- as.numeric(readline("Enter average rate per hour (lambda): "))
k <- as.integer(readline("Enter number of events (k): "))
poisson_prob <- dpois(k, lambda)
cat("Poisson probability:", poisson_prob, "\n")
