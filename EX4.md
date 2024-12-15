# Отримання деталей конкретного  замовлення 1, включаючи інформацію про одяг, кількість та ціну за одиницю.

## GET до http://localhost:8080/api/order-items/1


200 OK
Request successful. The server has responded as required.
{
"id": 1,
"clothingItem": {
"id": 1,
"name": "T-Shirt",
"size": "M",
"price": 19.99,
"brand": "NIKE",
"type": "SHIRT"
},
"quantity": 2,
"unitPrice": 29.99
}