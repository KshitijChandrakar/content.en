# 3. Union probability of two sets
set1 <- as.integer(strsplit(system("read -p 'Enter first set of numbers (comma-separated, 1-6): ' input; echo ", intern=TRUE), ",")[[1]])
set2 <- as.integer(strsplit(system("read -p 'Enter second set of numbers (comma-separated, 1-6): ' input; echo ", intern=TRUE), ",")[[1]])
union_prob <- length(unique(c(set1, set2))) / 6
cat("Union probability:", union_prob, "\n")
