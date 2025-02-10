
# 5. Roll a die n times and compute probabilities
n <- as.integer(system("read -p 'Enter number of die rolls: ' input; echo ", intern=TRUE))
n <- 3
rolls <- sample(1:6, n, replace = TRUE)
probabilities <- table(rolls) / n
print(probabilities)
