# 1. Access elements of a vector and list
# Vector example
v <- c(1, 2, 3, 4)
print(v[2])  # Access second element, prints 2

# List example
l <- list(a = 1, b = 2, c = 3)
print(l[[2]])  # Access second element, prints 2

# 2. Create and perform matrix operation
# Create matrix
m <- matrix(1:6, nrow = 2, ncol = 3)
print(m)  # Print matrix

# Matrix operations
print(m + 1)  # Add 1 to each element
print(m * 2)  # Multiply each element by 2

# 3. Calculate length of a vector
length_v <- length(v)
print(length_v)  # Output: 4

# 4. If else, for & while loop in R
# If else example
x <- 5
if (x > 3) {
  print("Greater")
} else {
  print("Smaller or equal")
}

# For loop example
for (i in 1:5) {
  print(i)
}

# While loop example
i <- 1
while (i <= 5) {
  print(i)
  i <- i + 1
}

# 5. Create a function in R
my_function <- function(x) {
  return(x^2)
}
print(my_function(3))  # Output: 9

# 6. Pass arguments to a function
sum_function <- function(a, b) {
  return(a + b)
}
print(sum_function(3, 5))  # Output: 8

# 7. Use apply() family of functions
# Matrix example for apply()
matrix_data <- matrix(1:6, nrow = 2, ncol = 3)

# apply() - Apply function across rows or columns
print(apply(matrix_data, 1, sum))  # Sum of rows
print(apply(matrix_data, 2, sum))  # Sum of columns

# lapply() - Apply function to each element of a list and return a list
list_data <- list(a = 1, b = 2, c = 3)
print(lapply(list_data, function(x) x^2))  # Square each element

# sapply() - Apply function and simplify output
print(sapply(list_data, function(x) x^2))  # Simplified output

# 8. Find help or documentation for a specific function
# Example: Get help for the 'sum' function
# help(sum)
# # or
# ?sum

# 9. Import a CSV file into R
data <- read.csv("path_to_your_file.csv")
print(head(data))  # Print first few rows

# 10. Write data from R to a CSV file
write.csv(data, "output.csv", row.names = FALSE)

# 11. Difference between read.csv() and read.table()
# read.csv() assumes the separator is a comma (CSV format).
# read.table() is more general, allowing customization of delimiters.

# 12. Check the working directory in R
print(getwd())

# 13. Change the working directory
setwd("path_to_your_directory")  # Replace with the path of your directory
