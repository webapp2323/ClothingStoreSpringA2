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