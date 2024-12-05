Name - Naman DIXIT 
SAP ID - 500125539
BATCH - 50
SEM - 3
## Q1
### Query
```javascript
// a. Create the collection and insert 10 documents
db.createCollection("products");
db.products.insertMany([
    { name: "Smartphone", category: "Electricals", price: 500, stock: 20 },
    { name: "Laptop", category: "Electricals", price: 1200, stock: 15 },
    { name: "Headphones", category: "Electricals", price: 80, stock: 50 },
    { name: "Microwave", category: "applicances", price: 150, stock: 10 },
    { name: "Refrigerator", category: "applicances", price: 800, stock: 5 },
    { name: "Blender", category: "applicances", price: 60, stock: 25 },
    { name: "Tablet", category: "Electricals", price: 300, stock: 30 },
    { name: "Monitor", category: "Electricals", price: 200, stock: 18 },
    { name: "Gaming Console", category: "Electricals", price: 400, stock: 12 },
    { name: "Keyboard", category: "Electricals", price: 50, stock: 40 }
]);

// b.i. Create a single-field index on category
db.products.createIndex({ category: 1 });

// b.ii. Create a compound index on category and price
db.products.createIndex({ category: 1, price: 1 });

// c. Find all products in the Electricals category
db.products.find({ category: "Electricals" });

// d. Find all products in the Electricals category with a price less than 100
db.products.find({ category: "Electricals", price: { $lt: 100 } });

// e. Drop the single-field index
db.products.dropIndex({ category: 1 });

// f. Create a text index on name
db.products.createIndex({ name: "text" });

// g. Test a text search for a product containing the word "phone"
db.products.find({ $text: { $search: "phone" } });
```

### Output
```json
{ "ok" : 1 }
{
	"acknowledged" : true,
	"insertedIds" : [
		ObjectId("674745ba51b1b9206e4eee7c"),
		ObjectId("674745ba51b1b9206e4eee7d"),
		ObjectId("674745ba51b1b9206e4eee7e"),
		ObjectId("674745ba51b1b9206e4eee7f"),
		ObjectId("674745ba51b1b9206e4eee80"),
		ObjectId("674745ba51b1b9206e4eee81"),
		ObjectId("674745ba51b1b9206e4eee82"),
		ObjectId("674745ba51b1b9206e4eee83"),
		ObjectId("674745ba51b1b9206e4eee84"),
		ObjectId("674745ba51b1b9206e4eee85")
	]
}
{
	"numIndexesBefore" : 1,
	"numIndexesAfter" : 2,
	"createdCollectionAutomatically" : false,
	"ok" : 1
}
{
	"numIndexesBefore" : 2,
	"numIndexesAfter" : 3,
	"createdCollectionAutomatically" : false,
	"ok" : 1
}
{ "_id" : ObjectId("674745ba51b1b9206e4eee7c"), "name" : "Smartphone", "category" : "Electricals", "price" : 500, "stock" : 20 }
{ "_id" : ObjectId("674745ba51b1b9206e4eee7d"), "name" : "Laptop", "category" : "Electricals", "price" : 1200, "stock" : 15 }
{ "_id" : ObjectId("674745ba51b1b9206e4eee7e"), "name" : "Headphones", "category" : "Electricals", "price" : 80, "stock" : 50 }
{ "_id" : ObjectId("674745ba51b1b9206e4eee82"), "name" : "Tablet", "category" : "Electricals", "price" : 300, "stock" : 30 }
{ "_id" : ObjectId("674745ba51b1b9206e4eee83"), "name" : "Monitor", "category" : "Electricals", "price" : 200, "stock" : 18 }
{ "_id" : ObjectId("674745ba51b1b9206e4eee84"), "name" : "Gaming Console", "category" : "Electricals", "price" : 400, "stock" : 12 }
{ "_id" : ObjectId("674745ba51b1b9206e4eee85"), "name" : "Keyboard", "category" : "Electricals", "price" : 50, "stock" : 40 }
{ "_id" : ObjectId("674745ba51b1b9206e4eee85"), "name" : "Keyboard", "category" : "Electricals", "price" : 50, "stock" : 40 }
{ "_id" : ObjectId("674745ba51b1b9206e4eee7e"), "name" : "Headphones", "category" : "Electricals", "price" : 80, "stock" : 50 }
{ "nIndexesWas" : 3, "ok" : 1 }
{
	"numIndexesBefore" : 2,
	"numIndexesAfter" : 3,
	"createdCollectionAutomatically" : false,
	"ok" : 1
}
```

## Q2
### Query
```javascript
// a. Create the collection and insert 10 documents representing daily sales
db.createCollection("sales");
db.sales.insertMany([
    { productid: "p1", quantity: 10, price: 50, date: ISODate("2024-11-01T00:00:00Z") },
    { productid: "p2", quantity: 5, price: 120, date: ISODate("2024-11-01T00:00:00Z") },
    { productid: "p1", quantity: 7, price: 50, date: ISODate("2024-11-02T00:00:00Z") },
    { productid: "p3", quantity: 3, price: 300, date: ISODate("2024-11-02T00:00:00Z") },
    { productid: "p2", quantity: 8, price: 120, date: ISODate("2024-11-03T00:00:00Z") },
    { productid: "p4", quantity: 2, price: 800, date: ISODate("2024-11-03T00:00:00Z") },
    { productid: "p1", quantity: 15, price: 50, date: ISODate("2024-11-04T00:00:00Z") },
    { productid: "p3", quantity: 6, price: 300, date: ISODate("2024-11-04T00:00:00Z") },
    { productid: "p2", quantity: 10, price: 120, date: ISODate("2024-11-05T00:00:00Z") },
    { productid: "p4", quantity: 1, price: 800, date: ISODate("2024-11-05T00:00:00Z") }
]);

// b. Calculate the total revenue for each product
db.sales.aggregate([
    { $group: { _id: "$productid", totalRevenue: { $sum: { $multiply: ["$quantity", "$price"] } } } }
]);

// c. Find the top 5 products with the highest revenue
db.sales.aggregate([
    { $group: { _id: "$productid", totalRevenue: { $sum: { $multiply: ["$quantity", "$price"] } } } },
    { $sort: { totalRevenue: -1 } },
    { $limit: 5 }
]);

// d. Calculate the average sales per day
db.sales.aggregate([
    { $group: { _id: "$date", dailySales: { $sum: { $multiply: ["$quantity", "$price"] } } } },
    { $group: { _id: null, avgDailySales: { $avg: "$dailySales" } } }
]);

// e. Filter sales for a specific date range
db.sales.find({
    date: { $gte: ISODate("2024-11-02T00:00:00Z"), $lte: ISODate("2024-11-04T23:59:59Z") }
});

// f. Group by product and calculate total quantity sold
db.sales.aggregate([
    { $group: { _id: "$productid", totalQuantity: { $sum: "$quantity" } } }
]);

// g. Sort the results in descending order by total quantity
db.sales.aggregate([
    { $group: { _id: "$productid", totalQuantity: { $sum: "$quantity" } } },
    { $sort: { totalQuantity: -1 } }
]);
```
### Output
```json
{ "ok" : 1 }
{
	"acknowledged" : true,
	"insertedIds" : [
		ObjectId("674748196f6f3f2b5616d0f2"),
		ObjectId("674748196f6f3f2b5616d0f3"),
		ObjectId("67474
		8196f6f3f2b5616d0f4"),
		ObjectId("674748196f6f3f2b5616d0f5"),
		ObjectId("674748196f6f3f2b5616d0f6"),
		ObjectId("674748196f6f3f2b5616d0f7"),
		ObjectId("674748196f6f3f2b5616d0f8"),
		ObjectId("674748196f6f3f2b5616d0f9"),
		ObjectId("674748196f6f3f2b5616d0fa"),
		ObjectId("674748196f6f3f2b5616d0fb")
	]
}
{ "_id" : "p1", "totalRevenue" : 1600 }
{ "_id" : "p2", "totalRevenue" : 2760 }
{ "_id" : "p3", "totalRevenue" : 2700 }
{ "_id" : "p4", "totalRevenue" : 2400 }
{ "_id" : "p2", "totalRevenue" : 2760 }
{ "_id" : "p3", "totalRevenue" : 2700 }
{ "_id" : "p4", "totalRevenue" : 2400 }
{ "_id" : "p1", "totalRevenue" : 1600 }
{ "_id" : null, "avgDailySales" : 1892 }
{ "_id" : ObjectId("674748196f6f3f2b5616d0f4"), "productid" : "p1", "quantity" : 7, "price" : 50, "date" : ISODate("2024-11-02T00:00:00Z") }
{ "_id" : ObjectId("674748196f6f3f2b5616d0f5"), "productid" : "p3", "quantity" : 3, "price" : 300, "date" : ISODate("2024-11-02T00:00:00Z") }
{ "_id" : ObjectId("674748196f6f3f2b5616d0f6"), "productid" : "p2", "quantity" : 8, "price" : 120, "date" : ISODate("2024-11-03T00:00:00Z") }
{ "_id" : ObjectId("674748196f6f3f2b5616d0f7"), "productid" : "p4", "quantity" : 2, "price" : 800, "date" : ISODate("2024-11-03T00:00:00Z") }
{ "_id" : ObjectId("674748196f6f3f2b5616d0f8"), "productid" : "p1", "quantity" : 15, "price" : 50, "date" : ISODate("2024-11-04T00:00:00Z") }
{ "_id" : ObjectId("674748196f6f3f2b5616d0f9"), "productid" : "p3", "quantity" : 6, "price" : 300, "date" : ISODate("2024-11-04T00:00:00Z") }
{ "_id" : "p4", "totalQuantity" : 3 }
{ "_id" : "p1", "totalQuantity" : 32 }
{ "_id" : "p2", "totalQuantity" : 23 }
{ "_id" : "p3", "totalQuantity" : 9 }
{ "_id" : "p1", "totalQuantity" : 32 }
{ "_id" : "p2", "totalQuantity" : 23 }
{ "_id" : "p3", "totalQuantity" : 9 }
{ "_id" : "p4", "totalQuantity" : 3 }```

## Q3

### Query
```javascript
// Create the collection and insert 20 user records with random data
db.createCollection("users");
db.users.insertMany([
    { username: "Vi", email: "vi@arcane.com", created_at: ISODate("2024-11-01T00:00:00Z") },
    { username: "Jinx", email: "jinx@arcane.com", created_at: ISODate("2024-11-02T00:00:00Z") },
    { username: "Caitlyn", email: "caitlyn@arcane.com", created_at: ISODate("2024-11-03T00:00:00Z") },
    { username: "Jayce", email: "jayce@arcane.com", created_at: ISODate("2024-11-04T00:00:00Z") },
    { username: "Viktor", email: "viktor@arcane.com", created_at: ISODate("2024-11-05T00:00:00Z") },
    { username: "Ekko", email: "ekko@arcane.com", created_at: ISODate("2024-11-06T00:00:00Z") },
    { username: "Heimerdinger", email: "heimer@arcane.com", created_at: ISODate("2024-11-07T00:00:00Z") },
    { username: "Mel", email: "mel@arcane.com", created_at: ISODate("2024-11-08T00:00:00Z") },
    { username: "Silco", email: "silco@arcane.com", created_at: ISODate("2024-11-09T00:00:00Z") },
    { username: "Grayson", email: "grayson@arcane.com", created_at: ISODate("2024-11-10T00:00:00Z") },
    { username: "Marcus", email: "marcus@arcane.com", created_at: ISODate("2024-11-11T00:00:00Z") },
    { username: "Sevika", email: "sevika@arcane.com", created_at: ISODate("2024-11-12T00:00:00Z") },
    { username: "Mylo", email: "mylo@arcane.com", created_at: ISODate("2024-11-13T00:00:00Z") },
    { username: "Claggor", email: "claggor@arcane.com", created_at: ISODate("2024-11-14T00:00:00Z") },
    { username: "Vander", email: "vander@arcane.com", created_at: ISODate("2024-11-15T00:00:00Z") },
    { username: "Singed", email: "singed@arcane.com", created_at: ISODate("2024-11-16T00:00:00Z") },
    { username: "Ryze", email: "ryze@arcane.com", created_at: ISODate("2024-11-17T00:00:00Z") },
    { username: "Teemo", email: "teemo@arcane.com", created_at: ISODate("2024-11-18T00:00:00Z") },
    { username: "Thresh", email: "thresh@arcane.com", created_at: ISODate("2024-11-19T00:00:00Z") },
    { username: "Zeri", email: "zeri@arcane.com", created_at: ISODate("2024-11-20T00:00:00Z") }
]);

// a. Skip-Limit Pagination
// Page 1: First 5 users
db.users.find().sort({ created_at: 1 }).skip(0).limit(5);

// Page 2: Next 5 users
db.users.find().sort({ created_at: 1 }).skip(5).limit(5);

// b. Range-Based Pagination using created_at field
// Page 1: First 10 users by creation date
db.users.find().sort({ created_at: 1 }).limit(10);

// Page 2: Next 10 users after the last document on Page 1
let lastDocument = db.users.find().sort({ created_at: 1 }).skip(9).limit(1).toArray()[0];
db.users.find({ created_at: { $gt: lastDocument.created_at } }).sort({ created_at: 1 }).limit(10);
```
### Output
```json
{ "ok" : 1 }
{
	"acknowledged" : true,
	"insertedIds" : [
		ObjectId("674747fe160bf103af921fbe"),
		ObjectId("674747fe160bf103af921fbf"),
		ObjectId("674747fe160bf103af921fc0"),
		ObjectId("674747fe160bf103af921fc1"),
		ObjectId("674747fe160bf103af921fc2"),
		ObjectId("674747fe160bf103af921fc3"),
		ObjectId("674747fe160bf103af921fc4"),
		ObjectId("674747fe160bf103af921fc5"),
		ObjectId("674747fe160bf103af921fc6"),
		ObjectId("674747fe160bf103af921fc7"),
		ObjectId("674747fe160bf103af921fc8"),
		ObjectId("674747fe160bf103af921fc9"),
		ObjectId("674747fe160bf103af921fca"),
		ObjectId("674747fe160bf103af921fcb"),
		ObjectId("674747fe160bf103af921fcc"),
		ObjectId("674747fe160bf103af921fcd"),
		ObjectId("674747fe160bf103af921fce"),
		ObjectId("674747fe160bf103af921fcf"),
		ObjectId("674747fe160bf103af921fd0"),
		ObjectId("674747fe160bf103af921fd1")
	]
}
{ "_id" : ObjectId("674747fe160bf103af921fbe"), "username" : "user1", "email" : "user1@example.com", "created_at" : ISODate("2024-11-01T10:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fbf"), "username" : "user2", "email" : "user2@example.com", "created_at" : ISODate("2024-11-02T11:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc0"), "username" : "user3", "email" : "user3@example.com", "created_at" : ISODate("2024-11-03T12:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc1"), "username" : "user4", "email" : "user4@example.com", "created_at" : ISODate("2024-11-04T13:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc2"), "username" : "user5", "email" : "user5@example.com", "created_at" : ISODate("2024-11-05T14:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc3"), "username" : "user6", "email" : "user6@example.com", "created_at" : ISODate("2024-11-06T15:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc4"), "username" : "user7", "email" : "user7@example.com", "created_at" : ISODate("2024-11-07T16:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc5"), "username" : "user8", "email" : "user8@example.com", "created_at" : ISODate("2024-11-08T17:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc6"), "username" : "user9", "email" : "user9@example.com", "created_at" : ISODate("2024-11-09T18:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc7"), "username" : "user10", "email" : "user10@example.com", "created_at" : ISODate("2024-11-10T19:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fbe"), "username" : "user1", "email" : "user1@example.com", "created_at" : ISODate("2024-11-01T10:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fbf"), "username" : "user2", "email" : "user2@example.com", "created_at" : ISODate("2024-11-02T11:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc0"), "username" : "user3", "email" : "user3@example.com", "created_at" : ISODate("2024-11-03T12:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc1"), "username" : "user4", "email" : "user4@example.com", "created_at" : ISODate("2024-11-04T13:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc2"), "username" : "user5", "email" : "user5@example.com", "created_at" : ISODate("2024-11-05T14:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc3"), "username" : "user6", "email" : "user6@example.com", "created_at" : ISODate("2024-11-06T15:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc4"), "username" : "user7", "email" : "user7@example.com", "created_at" : ISODate("2024-11-07T16:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc5"), "username" : "user8", "email" : "user8@example.com", "created_at" : ISODate("2024-11-08T17:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc6"), "username" : "user9", "email" : "user9@example.com", "created_at" : ISODate("2024-11-09T18:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc7"), "username" : "user10", "email" : "user10@example.com", "created_at" : ISODate("2024-11-10T19:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc8"), "username" : "user11", "email" : "user11@example.com", "created_at" : ISODate("2024-11-11T20:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fc9"), "username" : "user12", "email" : "user12@example.com", "created_at" : ISODate("2024-11-12T21:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fca"), "username" : "user13", "email" : "user13@example.com", "created_at" : ISODate("2024-11-13T22:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fcb"), "username" : "user14", "email" : "user14@example.com", "created_at" : ISODate("2024-11-14T23:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fcc"), "username" : "user15", "email" : "user15@example.com", "created_at" : ISODate("2024-11-15T09:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fcd"), "username" : "user16", "email" : "user16@example.com", "created_at" : ISODate("2024-11-16T08:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fce"), "username" : "user17", "email" : "user17@example.com", "created_at" : ISODate("2024-11-17T07:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fcf"), "username" : "user18", "email" : "user18@example.com", "created_at" : ISODate("2024-11-18T06:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fd0"), "username" : "user19", "email" : "user19@example.com", "created_at" : ISODate("2024-11-19T05:00:00Z") }
{ "_id" : ObjectId("674747fe160bf103af921fd1"), "username" : "user20", "email" : "user20@example.com", "created_at" : ISODate("2024-11-20T04:00:00Z") }
```
