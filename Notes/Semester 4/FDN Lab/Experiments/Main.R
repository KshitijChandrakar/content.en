dirs <- list.dirs(path = ".", recursive = FALSE)

for (i in seq_along(dirs)) {
  cat(i, ":", dirs[i], "\n")
}
choice <- as.integer(readline("Enter the number of your choice: "))
# experiment <- as.integer(readline("Enter Which Experiment: "))
if (!is.na(choice) && choice >= 1 && choice <= length(dirs)) {
  cat("You selected:", dirs[choice], "\n")
} else {
  cat("Invalid selection.\n")
}
}
