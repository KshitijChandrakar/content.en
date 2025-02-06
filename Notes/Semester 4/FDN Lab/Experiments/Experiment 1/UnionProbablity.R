# 3. Union probability of two sets
set1 <- as.integer(strsplit(readline("Enter first set of numbers (comma-separated, 1-6): "), ",")[[1]])
set2 <- as.integer(strsplit(readline("Enter second set of numbers (comma-separated, 1-6): "), ",")[[1]])
union_prob <- length(unique(c(set1, set2))) / 6
cat("Union probability:", union_prob, "\n")
