# %% codecell


# %% codecell
pip install ucimlrepo matplotlib seaborn

# %% codecell
!which python3
# %% codecell

# %% codecell
from ucimlrepo import fetch_ucirepo
import matplotlib.pyplot as plt
import pandas as pd
import numpy as np
import seaborn as sb
# %% codecell
dataset_ids = {
"iris" :53,
"heart_disease" :45,
"wine_quality" :186,
"student_performance" :320,
"abalone" :1,
"breast_cancer" :17,
"apartment_rent" :555,
"cover_type" :31,
"LetterRecog_MMST" :59
}
# %% codecell
def ScatterXY(X, Y):
  for i in X.keys():
    plt.scatter(y = X[i], x = Y['class'], s = 10)
    plt.xlabel('class')
    plt.ylabel(i)
    plt.title(i + " " + "Scatter Plot")
    plt.show()
# %% codecell
def Scatter(i, j, X=0, Y=None, num_rows = 1000):
  if type(Y) == type(None):
    plt.scatter(y = X[i][:num_rows], x = X[j][:num_rows] )
    plt.xlabel(j)
    plt.ylabel(i)
    plt.title(i + " " + j + " Plot")
    plt.show()
  else:
    plt.scatter(y = X[i][:num_rows], x = Y[j][:num_rows])
    plt.xlabel(j)
    plt.ylabel(i)
    plt.title(i + " " + j + " Plot")
    plt.show()
# %% codecell
def ScatterEverything(X):
  for i in X.keys():
    for j in X.keys():
      if i == j: continue;
      Scatter(i, j, X)
# %% codecell
def fetch(z):
  current_dataset = z
  print(current_dataset)
  current_dataset = fetch_ucirepo(id=dataset_ids[current_dataset])
  X, Y = current_dataset.data.features, current_dataset.data.targets
  variables = current_dataset.variables
  metadata = current_dataset.metadata
  return X, Y, variables, metadata
# %% codecell
def DatasetInit(z):
  X, Y, variables, metadata = fetch(z)
  #ScatterXY(X, Y)
  ScatterEverything(X)
# %% codecell
def Histogram(column_name, X):
    """
    Generates a histogram for the specified column in the DataFrame.

    Args:
    column_name (str): The name of the column to plot.
    X (pd.DataFrame): The DataFrame containing the data.
    """

    plt.hist(X[column_name])
    plt.xlabel(column_name)
    plt.ylabel("Frequency")
    plt.title(f"Histogram of {column_name}")
    plt.show()
# %% codecell
def MulticolorHistogram(X, column_name, Y, color_col, num_bins=10):
    """
    Generates a multicolor histogram for the specified column in the DataFrame.

    Args:
        column_name (str): The name of the column to plot.
        X (pd.DataFrame): The DataFrame containing the data.
        color_col (str): The name of the column to use for coloring the bars.
        num_bins (int, optional): The number of bins to use for the histogram. Defaults to 10.
    """

    # Get unique values in color_col
    unique_colors = Y[color_col].unique()

    # Create histogram for each unique color
    for color in unique_colors:
        subset = X[Y[color_col] == color]  # Filter data for current color
        plt.hist(subset[column_name], num_bins, alpha=0.5, label=color)  # Plot histogram for subset

    plt.xlabel(column_name)
    plt.ylabel("Frequency")
    plt.title(f"Multicolor Histogram of {column_name} by {color_col}")
    plt.legend()  # Add legend to show color mapping
    plt.show()


# %% codecell
  X, Y, variables, metadata = fetch("cover_type")
  colors = [tuple(np.random.rand(3)) for _ in set(Y["Cover_Type"])]

# %% codecell
Scatter("Horizontal_Distance_To_Hydrology", "Elevation" , X)
Scatter("Vertical_Distance_To_Hydrology", "Elevation" , X)
# %% codecell
MulticolorHistogram(X, "Elevation", Y, "Cover_Type")
# %% codecell
Scatter("Cover_Type", "Horizontal_Distance_To_Roadways", X=Y, Y=X, num_rows=100000000)

# %% codecell
