# Generate random monthly sales data (e.g., 12 months)
set.seed(42)
monthly_sales <- rnorm(12, mean = 50000, sd = 10000)
png("test_scores_histogram.png", width = 800, height = 600)

# Create a boxplot
boxplot(monthly_sales, col = "lightgreen", main = "Monthly Sales Data",
        ylab = "Sales", outline = TRUE)

# Add a horizontal line for the mean
abline(h = mean(monthly_sales), col = "red", lty = 2)
legend("topright", legend = "Mean", col = "red", lty = 2)
