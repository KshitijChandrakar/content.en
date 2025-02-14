# Generate random test scores (normal distribution, mean=75, sd=10)
set.seed(123)  # For reproducibility
scores <- rnorm(100, mean = 75, sd = 10)
# Create a histogram
png("test_scores_histogram.png", width = 800, height = 600)
hist(scores,
     main = "Distribution of Students' Test Scores",
     xlab = "Test Scores",
     col = "skyblue",
     border = "black",
    )
summary(scores)   # Summary statistics
dev.off()

# Check skewness and spread
# library(moments)
# skewness(scores)  # Measure skewness
