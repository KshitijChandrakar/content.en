

# 2. Probability of rolling two specific numbers
num1 <- as.integer(readline("Enter first number (1-6): "))
num2 <- as.integer(readline("Enter second number (1-6): "))
if (num1 >= 1 & num1 <= 6 & num2 >= 1 & num2 <= 6) {
  cat("Probability of rolling both:", (1/6) * (1/6), "\n")
} else {
  cat("Invalid input.\n")
}
