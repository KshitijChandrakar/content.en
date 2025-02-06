# 7. Compute expected value
cost <- as.numeric(readline("Enter cost of the game: "))
outcomes <- as.numeric(strsplit(readline("Enter possible outcomes (comma-separated): "), ",")[[1]])
probabilities <- as.numeric(strsplit(readline("Enter their probabilities (comma-separated): "), ",")[[1]])
expected_value <- sum(outcomes * probabilities) - cost
cat("Expected Value:", expected_value, "\n")
