
# %% code cell
from SelfLibrary import *

# %% code cell
print(dataset_ids)
# %% code cell
datasets_to_use = ["car_evaluation", "abalone", "breast_cancer"]
datasets1 = setDataset(fetchDatasets(datasets_to_use))

# %% code cell
print_stats()

# %% code cell
AllHistograms()

# %% code cell
AllScatters()
