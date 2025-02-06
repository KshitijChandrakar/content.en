# 7. Compute expected value
cost <- as.numeric(system("read -p 'Enter cost of the game: ' input; echo $input" )
outcomes <- as.numeric(strsplit(system("read -p 'Enter possible outcomes (comma-separated): ' input; echo "), ",")[[1]])
probabilities <- as.numeric(strsplit(system("read -p 'Enter their probabilities (comma-separated): ' input; echo ", intern=TRUE), ",")[[1]])
expected_value <- sum(outcomes * probabilities) - cost
cat("Expected Value:", expected_value, "\n")
