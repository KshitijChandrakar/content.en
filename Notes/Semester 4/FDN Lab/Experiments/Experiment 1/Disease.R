
# 4. Compute probability of disease given a positive test (Bayes' Theorem)
command = paste("read -p 'Enter prior probability of disease: ' input; echo $input", sep="")

prior <- as.numeric(system("read -p 'Enter prior probability of disease: ' input; echo $input", intern=TRUE))
sensitivity <- as.numeric(system("read -p 'Enter sensitivity (true positive rate):  ' input; echo $input",intern=TRUE))
false_positive <- as.numeric(system("read -p 'Enter false positive rate: ' input; echo $input", intern=TRUE))
posterior <- (sensitivity * prior) / ((sensitivity * prior) + (false_positive * (1 - prior)))
cat("Probability of having disease given a positive test:", posterior, "\n")
