####################################################
# Assignment 1
# Name: Kshtiij Chandrakar
# SAP: 500124827
# Batch: DS 5
# Course: BTech CSE Semester 4
####################################################



# %%
import matplotlib.pyplot as plt
import seaborn as sns
import pandas as pd
import numpy as np

import os as os
import warnings
warnings.simplefilter(action='ignore', category=FutureWarning)
warnings.simplefilter(action='ignore', category=UserWarning)

# %%
df = pd.read_csv("/home/asus/content/Notes/Semester 4/FDS/Assignment 1/customer_data.csv")
print(df.head())

# %%
rows = df.shape[0]

# %%
unique_categories = df["Product_Category"].nunique()
print(unique_categories)

# %%
sum_by_category = df.groupby("Product_Category")["Purchase_Amount"].sum()
print(sum_by_category)

# %%
probablity = lambda x: x / rows
expected_value = lambda x,y: x * y

# %%
category_count = df["Product_Category"].value_counts()
print(category_count)

# %%
category_probablity = df["Product_Category"].value_counts().map(probablity)
print(category_probablity)

# %% codecell
expected_counts = category_count * category_probablity
print(expected_counts)

# %%
cond_probablity = pd.crosstab(df['Product_Category'], df['Payment_Method'], normalize='columns')
joint_probablity = pd.crosstab(df['Product_Category'], df['Payment_Method'], normalize=True)
joint_probablity2 = pd.crosstab(df['Payment_Method'], df['Product_Category'], normalize='columns')

print(joint_probablity)
print(joint_probablity2)
print(cond_probablity)

# %%
#------------------------
# Preprocessing
#------------------------
df['Purchase_Amount'] = pd.to_numeric(df['Purchase_Amount'], errors='coerce') # Convert 'Purchase_Amount' to numeric
df['Purchase_Date'] = pd.to_datetime(df['Purchase_Date']) # Ensure 'Purchase_Date' is in datetime format
df['YearMonth'] = df['Purchase_Date'].dt.to_period('M').astype(str) # Extract Year-Month for grouping

plt.figure(figsize=(10, 5))
def MetaPlotDetails(xlabel = "", ylabel = "", title = "", rotation = 0):
    plt.xticks(rotation=rotation)
    plt.xlabel(xlabel)
    plt.ylabel(ylabel)
    plt.title(title)
    pass


# %%

####################################################
# Trends Analysis
####################################################

# %%
#------------------------
# Monthly Sales Trends
#------------------------
# Sales Fluctuate with a downward trend
monthly_sales = df.groupby('YearMonth')['Purchase_Amount'].sum().reset_index()
sns.barplot(x='YearMonth', y='Purchase_Amount', palette=['lightcoral', 'lightskyblue'], data=monthly_sales, color='b')
MetaPlotDetails(xlabel="Month", ylabel="Total Sales", title="Monthly Sales Trend", rotation=45)
plt.show()


# %%
#------------------------
# Customer Retention Analysis
#------------------------
# All customers are onetime Customers
customer_purchases = df.groupby('Customer_ID')['Purchase_Date'].nunique().reset_index()
customer_purchases['Retention_Category'] = customer_purchases['Purchase_Date'].apply(lambda x: 'One-time' if x == 1 else 'Repeat')

sns.countplot(x='Retention_Category', data=customer_purchases, palette=['lightcoral', 'lightskyblue'])
MetaPlotDetails(xlabel="Customer Type", ylabel="Count", title="Customer Retention Analysis")
plt.show()


# %%
#------------------------
# Spending Behavior Distribution
#------------------------
#Behaviour Is Random
sns.histplot(df['Purchase_Amount'], bins=30, kde=True, palette=['lightcoral', 'lightskyblue'])
MetaPlotDetails(xlabel="Purchase Amount", ylabel="Frequency", title="Spending Behavior Distribution")
plt.show()


# %%
#------------------------
# Outlier Detection in Spending
#------------------------
# Most Purchases are between 150 and 400
sns.boxplot(x=df['Purchase_Amount'], palette=['lightcoral', 'lightskyblue'])
MetaPlotDetails(xlabel="Purchase Amount", ylabel="", title="Outlier Detection in Spending")
plt.show()



# %%
#------------------------
# Monthly Sales By Category
#------------------------
category_sales = df.groupby(['YearMonth', 'Product_Category'])['Purchase_Amount'].sum().reset_index()
sns.lineplot(x='YearMonth', y='Purchase_Amount', hue='Product_Category', data=category_sales, marker='o')
plt.grid()
MetaPlotDetails(xlabel = "Month", ylabel = "Category Sales", title = "Monthly Sales Trend By Category")
plt.show()
# %%
#------------------------
# Monthly Sales
#------------------------
monthly_sales = df.groupby('YearMonth')['Purchase_Amount'].sum().reset_index()

# plt.figure(figsize=(10, 5))
sns.barplot(x='YearMonth', y='Purchase_Amount', data=monthly_sales)
MetaPlotDetails(title="Monthly Sales Trends", xlabel="Month", ylabel="Total Sales")
plt.show()

# %%
# Group by 'Product_Category' and sum 'Purchase_Amount'
category_revenue = df.groupby('Product_Category')['Purchase_Amount'].sum()

plt.pie(category_revenue, labels=category_revenue.index, autopct='%1.1f%%', wedgeprops={'edgecolor': 'black'})

MetaPlotDetails(title = "Category-Wise Revenue Distribution")
plt.show()

# %%
#------------------------
# Payment Method Trends
#------------------------
payment_trends = df.pivot_table(index='YearMonth', columns='Payment_Method', values='Purchase_Amount', aggfunc='sum')
payment_trends.plot(kind='bar', stacked=True, colormap='coolwarm')
plt.xticks(rotation=45)
MetaPlotDetails(xlabel = "Month", ylabel = "Total Sales", title = "Payment Method Trends Over Time")
plt.show()

# %%
#------------------------
# Customer Purchase Frequency
#------------------------
customer_purchases = df.groupby('Customer_ID')['Purchase_Date'].nunique()
sns.histplot(customer_purchases, bins=20, palette=['lightcoral', 'lightskyblue'])
MetaPlotDetails(xlabel = "Number of Purchases", ylabel = "Number of Customers", title = "Customer Purchase Frequency")
plt.show()

# %%
#------------------------
# Spending Pattern
#------------------------
sns.boxplot(y=df['Purchase_Amount'])
MetaPlotDetails(ylabel = "Purchase Amount", title = "Spending Pattern (Box Plot)")
plt.show()

# %%
#------------------------
# Joint Probablity Heatmap
#------------------------
sns.heatmap(joint_probablity, annot=True, fmt=".2%", cmap="Blues")
MetaPlotDetails(xlabel = "Payment Method", ylabel = "Product Category", title = "Joint Probability of Product Category & Payment Method", rotation = 90)
plt.show()
