Name: Kshitij Chandrakar
SAP: 500124827
Batch: 49
# Q1
### Query
```javascript
db.products.insertMany([
  { "product_id": 2021, "name": "Laptop", "brand": "Dell", "price": 802, "stock": 50 },
  { "product_id": 2012, "name": "Smartphone", "brand": "Samsung", "price": 603, "stock": 200 },
  { "product_id": 2023, "name": "Headphones", "brand": "Sony", "price": 157, "stock": 2045 }
]);

db.products.insertOne({
  "product_id": 2042,
  "name": "Tablet",
  "brand": "Apple",
  "price": 900000000000000,
  "stock": 01
});
```

### Output
```JSON
{
	"acknowledged" : true,
	"insertedIds" : [
		ObjectId("673de9fadb5605ecdb781aec"),
		ObjectId("673de9fadb5605ecdb781aed"),
		ObjectId("673de9fadb5605ecdb781aee")
	]
}
{
	"acknowledged" : true,
	"insertedId" : ObjectId("673de9fadb5605ecdb781aef")
}
```
# Q2
### Query
```javascript
// a Retrieve all documents:  

db.products.find({});

// b Retrieve only `name` and `price` fields, excluding `_id`:  

db.products.find({}, { name: 1, price: 1, _id: 0 });

// c Find products with a price greater than 500:  

db.products.find({ price: { $gt: 500 } });

// d Retrieve products where the brand is "Sony":  

db.products.find({ brand: "Sony" });


// e Retrieve products with a price less than 500 and stock greater than 200:  

db.products.find({ price: { $lt: 500 }, stock: { $gt: 200 } });

// f Retrieve products where the name starts with "S":  

db.products.find({ name: { $regex: /^S/ } });
```

### Output
```json
{ "_id" : ObjectId("673de93a6080430c5525858a"), "product_id" : 201, "name" : "Laptop", "brand" : "Dell", "price" : 800, "stock" : 50 }
{ "_id" : ObjectId("673de93a6080430c5525858b"), "product_id" : 202, "name" : "Smartphone", "brand" : "Samsung", "price" : 600, "stock" : 200 }
{ "_id" : ObjectId("673de93a6080430c5525858c"), "product_id" : 203, "name" : "Headphones", "brand" : "Sony", "price" : 150, "stock" : 200 }
{ "_id" : ObjectId("673de93a6080430c5525858d"), "product_id" : 204, "name" : "Tablet", "brand" : "Apple", "price" : 700, "stock" : 30 }
{ "name" : "Laptop", "price" : 800 }
{ "name" : "Smartphone", "price" : 600 }
{ "name" : "Headphones", "price" : 150 }
{ "name" : "Tablet", "price" : 700 }
{ "_id" : ObjectId("673de93a6080430c5525858a"), "product_id" : 201, "name" : "Laptop", "brand" : "Dell", "price" : 800, "stock" : 50 }
{ "_id" : ObjectId("673de93a6080430c5525858b"), "product_id" : 202, "name" : "Smartphone", "brand" : "Samsung", "price" : 600, "stock" : 200 }
{ "_id" : ObjectId("673de93a6080430c5525858d"), "product_id" : 204, "name" : "Tablet", "brand" : "Apple", "price" : 700, "stock" : 30 }
{ "_id" : ObjectId("673de93a6080430c5525858c"), "product_id" : 203, "name" : "Headphones", "brand" : "Sony", "price" : 150, "stock" : 200 }
{ "_id" : ObjectId("673de93a6080430c5525858c"), "product_id" : 203, "name" : "Headphones", "brand" : "Sony", "price" : 150, "stock" : 200 }
{ "_id" : ObjectId("673de93a6080430c5525858b"), "product_id" : 202, "name" : "Smartphone", "brand" : "Samsung", "price" : 600, "stock" : 200 }
```

# Q3 
### Query
 ```javascript
// a Increase the price of all products by 10%:  
db.products.updateMany({}, { $mul: { price: 1.10 } });


// b Update the stock of the product with `product_id: 102` to 120:  
db.products.updateOne({ product_id: 102 }, { $set: { stock: 120 } });


// c Change the brand of all products where the brand is "Samsung" to "Samsung Electronics":  
db.products.updateMany({ brand: "Samsung" }, { $set: { brand: "Samsung Electronics" } });


// d Add a new field `category` with value "Electronics" to all products:  
db.products.updateMany({}, { $set: { category: "Electronics" } });


// e Check if a product with `product_id: 104` exists; if not, insert a new document:  
db.products.updateOne(
  { product_id: 104 },
  {
    $setOnInsert: {
      product_id: 104,
      name: "Tablet",
      brand: "Apple",
      price: 700,
      stock: 30,
      category: "Electronics"
    }
  },
  { upsert: true }
);
```
### Output
```JSON
{ "acknowledged" : true, "matchedCount" : 4, "modifiedCount" : 4 }
{ "acknowledged" : true, "matchedCount" : 0, "modifiedCount" : 0 }
{ "acknowledged" : true, "matchedCount" : 1, "modifiedCount" : 1 }
{ "acknowledged" : true, "matchedCount" : 4, "modifiedCount" : 4 }
{
	"acknowledged" : true,
	"matchedCount" : 0,
	"modifiedCount" : 0,
	"upsertedId" : ObjectId("673dec44ee0093466552723f")
}
```

# Q4
### Query
```javascript
// a Delete the product with `product_id: 103`:  
db.products.deleteOne({ product_id: 103 });


// b Delete all products with a price less than 200:  
db.products.deleteMany({ price: { $lt: 200 } });


// c Clear the entire products collection:  
db.products.deleteMany({});
```
### Output
```JSON
{ "acknowledged" : true, "deletedCount" : 0 }
{ "acknowledged" : true, "deletedCount" : 1 }
{ "acknowledged" : true, "deletedCount" : 4 }
```

# Q5
### Query
```javascript
// a Retrieve all products, sorted by price in descending order:  
db.products.find({}).sort({ price: -1 });


// b Fetch the first 3 products from the sorted list:  
db.products.find({}).sort({ price: -1 }).limit(3);


// c Calculate the average price of all products:  
db.products.aggregate([{ $group: { _id: null, avgPrice: { $avg: "$price" } } }]);


// d Group products by brand and count the number of products for each brand:  
db.products.aggregate([{ $group: { _id: "$brand", count: { $sum: 1 } } }]);


// e Insert the document:  
db.products.insertOne({
  "product_id": 105,
  "name": "Smartwatch",
  "brand": "Apple",
  "price": 300,
  "stock": 50,
  "specifications": { "color": "Black", "battery": "24 hours", "warranty": "1 year" }
});


// f Find all products where `specifications.color` is "Black":  
db.products.find({ "specifications.color": "Black" });
```

### Output
```JSON
{ "_id" : ObjectId("673ded992199abcc44c729dd"), "product_id" : 2042, "name" : "Tablet", "brand" : "Apple", "price" : 990000000000000.1, "stock" : 1, "category" : "Electronics" }
{ "_id" : ObjectId("673ded992199abcc44c729da"), "product_id" : 2021, "name" : "Laptop", "brand" : "Dell", "price" : 882.2, "stock" : 50, "category" : "Electronics" }
{ "_id" : ObjectId("673ded993ed4f0cf03b8b929"), "product_id" : 104, "brand" : "Apple", "category" : "Electronics", "name" : "Tablet", "price" : 700, "stock" : 30 }
{ "_id" : ObjectId("673ded992199abcc44c729db"), "product_id" : 2012, "name" : "Smartphone", "brand" : "Samsung Electronics", "price" : 663.3000000000001, "stock" : 200, "category" : "Electronics" }
{ "_id" : ObjectId("673ded992199abcc44c729dc"), "product_id" : 2023, "name" : "Headphones", "brand" : "Sony", "price" : 172.70000000000002, "stock" : 2045, "category" : "Electronics" }
{ "_id" : ObjectId("673ded992199abcc44c729dd"), "product_id" : 2042, "name" : "Tablet", "brand" : "Apple", "price" : 990000000000000.1, "stock" : 1, "category" : "Electronics" }
{ "_id" : ObjectId("673ded992199abcc44c729da"), "product_id" : 2021, "name" : "Laptop", "brand" : "Dell", "price" : 882.2, "stock" : 50, "category" : "Electronics" }
{ "_id" : ObjectId("673ded993ed4f0cf03b8b929"), "product_id" : 104, "brand" : "Apple", "category" : "Electronics", "name" : "Tablet", "price" : 700, "stock" : 30 }
{ "_id" : null, "avgPrice" : 198000000000483.7 }
{ "_id" : "Apple", "count" : 2 }
{ "_id" : "Samsung Electronics", "count" : 1 }
{ "_id" : "Sony", "count" : 1 }
{ "_id" : "Dell", "count" : 1 }
{
	"acknowledged" : true,
	"insertedId" : ObjectId("673ded992199abcc44c729de")
}
{ "_id" : ObjectId("673ded992199abcc44c729de"), "product_id" : 105, "name" : "Smartwatch", "brand" : "Apple", "price" : 300, "stock" : 50, "specifications" : { "color" : "Black", "battery" : "24 hours", "warranty" : "1 year" } }
```
