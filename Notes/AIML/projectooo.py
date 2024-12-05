import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.preprocessing import MinMaxScaler

sns.set_theme(style="whitegrid")

df = pd.read_csv('retail_sales_final.csv')

print("Dataset Preview:")
print(df.head())

#---------------------------------------------Data Preprocessing---------------------------------------------

# 1. Handle Missing Values
print("\nMissing values per column:")
print(df.isnull().sum())

# Fill missing numerical values with median
numerical_columns = df.select_dtypes(include=['float64', 'int64']).columns
df[numerical_columns] = df[numerical_columns].fillna(df[numerical_columns].median())

# Fill missing categorical values with mode
categorical_columns = df.select_dtypes(include=['object']).columns
df[categorical_columns] = df[categorical_columns].fillna(df[categorical_columns].mode().iloc[0])

# 2. Handle Outliers using IQR
for column in numerical_columns:
    Q1 = df[column].quantile(0.25)
    Q3 = df[column].quantile(0.75)
    IQR = Q3 - Q1
    lower_bound = Q1 - 1.5 * IQR
    upper_bound = Q3 + 1.5 * IQR
    df[column] = np.where(df[column] < lower_bound, lower_bound, df[column])
    df[column] = np.where(df[column] > upper_bound, upper_bound, df[column])

# 3. Normalize Numerical Data
scaler = MinMaxScaler()
df[numerical_columns] = scaler.fit_transform(df[numerical_columns])

#---------------------------------------------Exploratory Data Analysis---------------------------------------------

# 1. Top-Selling Product Categories
plt.figure(figsize=(10, 6))
sns.countplot(data=df, x='Product Category', order=df['Product Category'].value_counts().index)
plt.title("Top Selling Product Categories")
plt.xticks(rotation=45)
plt.show()

# 2. Monthly Sales Trends
df['Purchase Date'] = pd.to_datetime(df['Purchase Date'])
monthly_sales = df.groupby(df['Purchase Date'].dt.month)['Revenue'].sum().reset_index()
monthly_sales.columns = ['Month', 'Revenue']

plt.figure(figsize=(10, 6))
sns.lineplot(data=monthly_sales, x='Month', y='Revenue', marker='o')
plt.title("Monthly Sales Trends")
plt.xticks(range(1, 13))
plt.show()

# 3. Revenue by Region
plt.figure(figsize=(8, 6))
sns.barplot(data=df, x='Region', y='Revenue', estimator=np.sum)
plt.title("Revenue by Region")
plt.show()

# 4. Profit Analysis by Holiday Season
plt.figure(figsize=(8, 6))
sns.barplot(data=df, x='Holiday Season', y='Profit', estimator=np.mean, palette="viridis")
plt.title("Average Profit by Holiday Season")
plt.show()

# 5. Revenue by Product Name
top_products = df.groupby('Product Name')['Revenue'].sum().nlargest(10).reset_index()

plt.figure(figsize=(12, 6))
sns.barplot(data=top_products, x='Revenue', y='Product Name', palette="Blues_r")
plt.title("Top 10 Products by Revenue")
plt.show()

# --- Recommendations ---
print("\n--- Recommendations ---")
print("1. Focus on top-selling product categories and high-revenue products for marketing campaigns.")
print("2. Offer promotions and discounts during the holiday season to boost sales further.")
print("3. Optimize inventory management in high-performing regions to avoid stockouts.")
print("4. Increase discounts on less popular products to clear inventory and attract more customers.")
print("5. Leverage monthly sales trends to plan seasonal promotions and optimize staff scheduling.")
