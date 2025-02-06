# 1. Compute probability of rolling a specific die face
# print()
die_face <- as.integer(system("read -p 'Enter a Die Number(1-6): ' input; echo $input", intern = TRUE))
print(die_face)
if (die_face >= 1 & die_face <= 6) {
  cat("Probability:", 1/6, "\n")
} else {
  cat("Invalid input.\n")
}
