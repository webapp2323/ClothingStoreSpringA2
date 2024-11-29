# Додаєм в БД Jacket

POST http://localhost:8080/api/jackets/add
{
"name": "Stylish Jacket",
"brand": "BrandName",
"price": 199.99,
"size": "M",
"material": "COTTON",
"color": "BLUE",
"has_Hood": true
}
201 Created
A new resource was created successfully.

{
"id": 24,
"name": "Stylish Jacket",
"brand": "BrandName",
"color": "BLUE",
"size": "M",
"price": 199.99,
"material": "COTTON",
"hasHood": true,
"message": "Jacket added successfully!"
}

POST http://localhost:8080/api/pants/add
{
"name": "Pants Rants",
"brand": "Brand PRPants",
"price": 22.99,
"size": "M",
"material": "COTTON",
"color": "BLUE"
}

{
"id": 7,
"name": "Pants Rants",
"brand": "Brand PRPants",
"price": 22.99,
"size": "M",
"color": "BLUE",
"material": "COTTON",
"message": "Pants added successfully!"
}

POST http://localhost:8080/api/shirts/add
{
"name": "Shirts Shirts",
"brand": "Brand Shirts",
"price": 12.99,
"size": "M",
"material": "DENIM",
"color": "GRAY",
"sleeve_type": "LONG"
}

201 Created
A new resource was created successfully.
{
"id": 19,
"name": "Shirts Shirts",
"brand": "Brand Shirts",
"price": 12.99,
"size": "M",
"color": "GRAY",
"material": "DENIM",
"sleeve_type": "LONG",
"message": "shirt added successfully !"
}
