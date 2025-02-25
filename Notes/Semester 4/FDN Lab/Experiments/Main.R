
files <- list.files(path = ".", recursive = FALSE)
for (i in seq_along(files)) {
  cat(paste(i, files[i]))
  cat("\n")
}
command = paste("read -p 'Enter Experiment Number(1 - ", length(files), "): ' input; echo $input", sep="")
Experiment <- as.integer(system(command, intern = TRUE))
source(files[Experiment])
