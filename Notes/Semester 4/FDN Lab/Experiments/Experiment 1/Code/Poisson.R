# 8. Compute Poisson probability
lambda <- as.numeric(system("read -p 'Enter average rate per hour (lambda): ' input; echo $input", intern=TRUE))
k <- as.integer(system("read -p 'Enter number of events (k): ' input; echo $input", intern=TRUE))
poisson_prob <- dpois(k, lambda)
cat("Poisson probability:", poisson_prob, "\n")
