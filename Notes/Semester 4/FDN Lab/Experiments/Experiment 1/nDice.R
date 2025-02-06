
# 5. Roll a die n times and compute probabilities
n <- as.integer(readline("Enter number of die rolls: "))
n <- 3
rolls <- sample(1:6, n, replace = TRUE)
probabilities <- table(rolls) / n
print(probabilities)
