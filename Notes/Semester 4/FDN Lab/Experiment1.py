# %% code cell
from SelfLibrary import *

# %% code cell
getDataset()
# %% code cell
datasets_to_use = ["car_evaluation", "abalone", "breast_cancer"]
currently_on = ["car_evaluation"]
_ = fetchDatasets(currently_on)

# %% code cell
JoinFeaturesAndTargets()


# %% code cell
print_stats()


# %% code cell
AllHistograms()

# %% code cell
AllScatters()

# %% code cell
ScatterSNSEverything()
