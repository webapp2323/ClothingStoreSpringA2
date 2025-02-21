# Promotion

🌐 [ClothingStoreSpringA2](https://github.com/webapp2323/ClothingStoreSpringA2/tree/promotion/src/main/java/org/example/clothingstorespring)

🌐

## Postman
GET localhost:8080/id/1
{
"id": 1,
"name": "Summer Sale",
"description": "Discounts on summer clothing",
"type": "PERCENTAGE_DISCOUNT",
"discount": 20.0,
"startDate": "2025-06-01T00:00:00",
"endDate": "2025-06-30T23:59:59",
"clothingItems": [
{
"id": 2,
"name": "Jeans",
"size": "L",
"price": 49.99,
"brand": "ADIDAS",
"type": "PANTS"
},
{
"id": 1,
"name": "T-Shirt",
"size": "M",
"price": 19.99,
"brand": "NIKE",
"type": "SHIRT"
}
]
}

GET localhost:8080/all
[
{
"id": 1,
"name": "Summer Sale",
"description": "Discounts on summer clothing",
"type": "PERCENTAGE_DISCOUNT",
"discount": 20.0,
"startDate": "2025-06-01T00:00:00",
"endDate": "2025-06-30T23:59:59",
"clothingItems": [
{
"id": 1,
"name": "T-Shirt",
"size": "M",
"price": 19.99,
"brand": "NIKE",
"type": "SHIRT"
},
{
"id": 2,
"name": "Jeans",
"size": "L",
"price": 49.99,
"brand": "ADIDAS",
"type": "PANTS"
}
]
},
{
"id": 2,
"name": "Winter Clearance",
"description": "End of season clearance sale",
"type": "FIXED_DISCOUNT",
"discount": 50.0,
"startDate": "2025-12-01T00:00:00",
"endDate": "2025-12-31T23:59:59",
"clothingItems": [
{
"id": 3,
"name": "Jacket",
"size": "M",
"price": 89.99,
"brand": "PUMA",
"type": "JACKET"
}
]
},
{
"id": 3,
"name": "Black Friday",
"description": "Special discounts for Black Friday",
"type": "PERCENTAGE_DISCOUNT",
"discount": 30.0,
"startDate": "2025-11-27T00:00:00",
"endDate": "2025-11-27T23:59:59",
"clothingItems": [
{
"id": 4,
"name": "Sweater",
"size": "S",
"price": 39.99,
"brand": "UNDER_ARMOUR",
"type": "SHIRT"
}
]
},
{
"id": 4,
"name": "Holiday Special",
"description": "Holiday season special offers",
"type": "FIXED_DISCOUNT",
"discount": 10.0,
"startDate": "2025-12-15T00:00:00",
"endDate": "2025-12-31T23:59:59",
"clothingItems": [
{
"id": 5,
"name": "Cargo Pants",
"size": "L",
"price": 59.99,
"brand": "NIKE",
"type": "PANTS"
}
]
},
{
"id": 5,
"name": "Flash Sale",
"description": "Limited time flash sale",
"type": "PERCENTAGE_DISCOUNT",
"discount": 25.0,
"startDate": "2025-10-01T00:00:00",
"endDate": "2025-10-02T23:59:59",
"clothingItems": []
}
]

PUT localhost:8080/update/1
{
"id": 1,
"name": "Summer Sale",
"description": "Discounts on summer clothing",
"type": "PERCENTAGE_DISCOUNT",
"discount": 11.0,
"startDate": "2025-06-01T00:00:00",
"endDate": "2025-06-30T23:59:59",
"clothingItems": [
{
"id": 1,
"name": "T-Shirt",
"size": "M",
"price": 19.99,
"brand": "NIKE",
"type": "SHIRT"
},
{
"id": 2,
"name": "Jeans",
"size": "L",
"price": 49.99,
"brand": "ADIDAS",
"type": "PANTS"
}
]
}
2025-02-21 02:33:34 - Existing promotion before update: Promotion{id=1, name='Summer Sale', description='Discounts on summer clothing', type=PERCENTAGE_DISCOUNT, discount=150.0, startDate=2025-06-01T00:00, endDate=2025-06-30T00:00, clothingItems=[ClothingItem(id=1, name=T-Shirt, size=M, price=19.99, brand=NIKE, type=SHIRT), ClothingItem(id=2, name=Jeans, size=L, price=49.99, brand=ADIDAS, type=PANTS)]}
2025-02-21 02:33:34 - Updated promotion: Promotion{id=1, name='Summer Sale', description='Discounts on summer clothing', type=PERCENTAGE_DISCOUNT, discount=11.0, startDate=2025-06-01T00:00, endDate=2025-06-30T00:00, clothingItems=[ClothingItem(id=1, name=T-Shirt, size=M, price=19.99, brand=NIKE, type=SHIRT), ClothingItem(id=2, name=Jeans, size=L, price=49.99, brand=ADIDAS, type=PANTS)]}

DELETE localhost:8080/delete/1
2025-02-21 02:47:18 - Deleting promotion: Promotion{id=1, name='Summer Sale', description='Discounts on summer clothing', type=PERCENTAGE_DISCOUNT, discount=11.0, startDate=2025-06-01T00:00, endDate=2025-06-30T00:00, clothingItems=[ClothingItem(id=1, name=T-Shirt, size=M, price=19.99, brand=NIKE, type=SHIRT), ClothingItem(id=2, name=Jeans, size=L, price=49.99, brand=ADIDAS, type=PANTS)]}
2025-02-21 02:47:18 - Deleted promotion with ID: 1

POST localhost:8080/add
{
"id": 1,
"name": "Summer Sale",
"description": "Discounts on summer clothing",
"type": "PERCENTAGE_DISCOUNT",
"discount": 25.0,
"startDate": "2025-06-01T00:00:00",
"endDate": "2025-06-30T23:59:59",
"clothingItems": [
{
"id": 1,
"name": "T-Shirt",
"size": "M",
"price": 19.99,
"brand": "NIKE",
"type": "SHIRT"
},
{
"id": 2,
"name": "Jeans",
"size": "L",
"price": 49.99,
"brand": "ADIDAS",
"type": "PANTS"
}
]
}
2025-02-21 03:02:44 - Added new promotion: Promotion{id=7, name='Summer Sale', description='Discounts on summer clothing', type=PERCENTAGE_DISCOUNT, discount=25.0, startDate=2025-06-01T00:00, endDate=2025-06-30T00:00, clothingItems=[ClothingItem(id=1, name=T-Shirt, size=M, price=19.99, brand=NIKE, type=SHIRT), ClothingItem(id=2, name=Jeans, size=L, price=49.99, brand=ADIDAS, type=PANTS)]}
