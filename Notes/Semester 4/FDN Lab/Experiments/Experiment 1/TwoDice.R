

# 2. Probability of rolling two specific numbers
num1 <- as.integer(system("read -p 'Enter first number (1-6): ' input; echo ", intern=TRUE))
num2 <- as.integer(system("read -p 'Enter second number (1-6): ' input; echo ", intern=TRUE))
if (num1 >= 1 & num1 <= 6 & num2 >= 1 & num2 <= 6) {
  cat("Probability of rolling both:", (1/6) * (1/6), "\n")
} else {
  cat("Invalid input.\n")
}
