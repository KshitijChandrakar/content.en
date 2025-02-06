# 8. Compute Poisson probability
lambda <- as.numeric(readline("Enter average rate per hour (lambda): "))
k <- as.integer(readline("Enter number of events (k): "))
poisson_prob <- dpois(k, lambda)
cat("Poisson probability:", poisson_prob, "\n")
