POST http://localhost:8080/api/payment/correct
{
"amount": 100.00,
"order_id": 2,
"method": "CREDIT_CARD",
"paymentDate": "2024-11-06T12:00:00" // або інша дата у форматі ISO
}

201 Created
{
"id": 6,
"orderId": 2,
"amount": 100.00,
"method": "CREDIT_CARD",
"paymentDate": "2024-11-06T12:00:00"
}


POST http://localhost:8080/api/orders/createOrder
{
"user": {
"id": 1
},
"customerName": "John Doe",
"total": 100.50,
"orderDate": "2024-11-19T10:00:00",
"status": "PENDING"
}

201 Created
{
"id": 6,
"customerName": "John Doe",
"total": 100.50,
"orderDate": "2024-11-19T04:59:57.5725106",
"status": "PENDING"
}

POST http://localhost:8080/api/deliveries/createDelivery
{
"orderId": 3,   
"deliveryAddress": "123 Main St",
"deliveryDate": "2024-11-20T10:00:00",
"status": "PENDING",
"deliveryType": "STANDARD"
}
201 Created
A new resource was created successfully.
{
"id": 15,
"orderId": 3,
"deliveryAddress": "123 Main St",
"deliveryDate": "2024-11-20T10:00:00",
"status": "PENDING",
"deliveryType": "STANDARD"
}