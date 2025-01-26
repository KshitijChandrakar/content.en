# %% codecell
# pip install ucimlrepo columnar
# %% code cell

# %% codecell
#!which python3

# %% codecell
from ucimlrepo import fetch_ucirepo, list_available_datasets
import matplotlib.pyplot as plt
import pandas as pd
import numpy as np
from pprint import pprint
import seaborn as sb
from columnar import columnar

# %% codecell
dataset_ids = {
    "iris": 53,
    "heart_disease": 45,
    "wine_quality": 186,
    "student_performance": 320,
    "abalone": 1,
    "breast_cancer": 17,
    "apartment_rent": 555,
    "cover_type": 31,
    "letterrecog_MMST": 59,
    "car_evaluation": 19,
}
datasets = 0


# %% code cell
def fetch(z):
    current_dataset = z
    current_dataset = fetch_ucirepo(id=dataset_ids[current_dataset])
    print("Fetched", z)
    # X, Y = current_dataset.data.features, current_dataset.data.targets
    # variables = current_dataset.variables
    # metadata = current_dataset.metadata
    return current_dataset


def fetchDatasets(datasets_to_use):
    global datasets
    print("Fetching: ", datasets)
    datasets = {i: fetch(i) for i in datasets_to_use}
    return datasets


def setDataset(dataset1):
    # global datasets
    datasets = dataset1
    return dataset1
    pass


def getDataset():
    global datasets
    print(datasets)
    return datasets
    pass


# %% codecell
def ScatterXY(X, Y):
    for i in X.keys():
        plt.scatter(y=X[i], x=Y["class"], s=10)
        plt.xlabel("class")
        plt.ylabel(i)
        plt.title(i + " " + "Scatter Plot")
        plt.show()


def Scatter(i, j, X=0, Y=None, num_rows=1000):
    if type(Y) == type(None):
        plt.scatter(y=X[i][:num_rows], x=X[j][:num_rows])
        plt.xlabel(j)
        plt.ylabel(i)
        plt.title(i + " " + j + " Plot")
        plt.show()
    else:
        plt.scatter(y=X[i][:num_rows], x=Y[j][:num_rows])
        plt.xlabel(j)
        plt.ylabel(i)
        plt.title(i + " vs " + j + " Plot")
        plt.show()


def ScatterColors(X):
    for i in X.keys():
        for j in X.keys():
            if i == j:
                continue
            sns.scatterplot(
                data=X,
                x=i,
                y=j,
                # hue="category",  # Color based on 'category'
                # palette="coolwarm",  # Custom color palette
                s=100,  # Marker size
            )
            pass
    pass


def ScatterEverything(X):
    for i in X.keys():
        for j in X.keys():
            if i == j:
                continue
            Scatter(i, j, X)


def Histogram(name, data):
    """
    Generates a histogram for the specified column in the DataFrame.

    Args:
    column_name (str): The name of the column to plot.
    X (pd.DataFrame): The DataFrame containing the data.
    """

    plt.hist(data)
    plt.xlabel(name)
    plt.ylabel("Frequency")
    plt.title(f"Histogram of {name}")
    plt.show()


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
        plt.hist(
            subset[column_name], num_bins, alpha=0.5, label=color
        )  # Plot histogram for subset

    plt.xlabel(column_name)
    plt.ylabel("Frequency")
    plt.title(f"Multicolor Histogram of {column_name} by {color_col}")
    plt.legend()  # Add legend to show color mapping
    plt.show()


# %% code cell
def features_end_index(variables):
    for i in range(len(variables["role"])):
        if variables["role"][i] == "Target":
            return i
    return -1


# %% code cell
def get_variables_and_missing_values():
    for dataset in datasets:
        variables = datasets[dataset].variables
        end_index = features_end_index(variables)
        missing_values = datasets[dataset].variables.missing_values[:end_index]
        names = datasets[dataset].variables.name[:end_index]
        return names, missing_values


# %% code cell
def print_stats():
    global datasets
    for dataset in datasets:
        print("=" * 10, "Current Dataset: " + dataset, sep="\n")
        features = datasets[dataset].data.features
        names, missing_values = get_variables_and_missing_values()
        stats = []
        for j in features:
            feature = features[j]
            try:
                stats.append(
                    [
                        j,
                        feature.mean(),
                        feature.median(),
                        feature.std(),
                        feature.max(),
                        feature.min(),
                        feature.isnull().sum(),
                    ]
                )
            except TypeError:
                stats.append([j] + ["Non-Numerical Value"] * 6)
        funcs = [
            "Feature",
            "Mean",
            "Median",
            "Standard Deviation",
            "Maximum Value",
            "Minimum Value",
            "Missing Values",
        ]
        table = columnar(stats, funcs, no_borders=False)
        print(table)


# print_stats()


# %% code cell
def AllHistograms():
    global datasets
    for dataset in datasets:
        print("=" * 10, "Current Dataset: " + dataset, sep="\n")
        data = datasets[dataset].data.features.join(datasets[dataset].data.targets)
        for i in data:
            Histogram(dataset + " | " + i, data[i])


# AllHistograms()


# %% code cell
def AllScatters():
    for dataset in datasets:
        print("=" * 10, "Current Dataset: " + dataset, sep="\n")
        data = datasets[dataset].data.features.join(datasets[dataset].data.targets)
        ScatterEverything(data)


# AllScatters()
