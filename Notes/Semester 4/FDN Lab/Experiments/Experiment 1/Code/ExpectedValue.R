# 7. Compute expected value
cost <- as.numeric(system("read -p 'Enter cost of the game: ' input; echo $input", intern=TRUE))
outcomes <- as.character(system("read -p 'Enter possible outcomes (comma-separated): ' input; echo $input", intern=TRUE))
outcomes <- as.numeric(strsplit(outcomes, ",")[[1]])
probabilities <- system("read -p 'Enter their probabilities (comma-separated): ' input; echo $input", intern=TRUE)
probabilities <- as.numeric(strsplit(probabilities, ",")[[1]])
expected_value <- sum(outcomes * probabilities) - cost
cat("Expected Value:", expected_value, "\n")
