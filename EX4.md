# Тестування через Postman перевіряє коректність виконання методу getOrderItemById, включаючи логіку отримання даних, обробку помилок і формування відповідей. Отримання деталей конкретного  замовлення 1, включаючи інформацію про одяг, кількість та ціну за одиницю.

## Після надсилання GET запиту метод getOrderItemById(@PathVariable Long id) викликається для отримання елемента замовлення з вказаним id (@GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        OrderItem orderItem = orderItemService.getOrderItemById(id);
        return orderItem != null ? ResponseEntity.ok(orderItem) : ResponseEntity.notFound().build();
    })
## У методі  звертаємося до сервісу (orderItemService.getOrderItemById(id)), щоб отримати конкретний об'єкт OrderItem.Метод перевіряє, чи orderItem не є null. Якщо елемент з таким id не знайдено, повертається ResponseEntity.notFound().build(), що відповідає статусу 404 (Not Found).Якщо orderItem знайдено, повертається відповідь з кодом 200 (OK) і об'єктом orderItem.


У методі ви звертаєтеся до сервісу (orderItemService.getOrderItemById(id)), щоб отримати конкретний об'єкт OrderItem.

Успішний Запит GET до http://localhost:8080/api/order-items/1
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
"unitPrice": 29.99,
"createdDate": "2024-12-14T23:57:55",
"status": "PENDING"
}

Неуспішний Запит
http://localhost:8080/api/order-items/999
404 Not Found
Requested resource could not be found

## Перевірка на очікувану структуру відповіді
GET до http://localhost:8080/api/order-items/1
{
"id": 1,
"orderId": 1,                  
"clothingItem": {
"id": 1,
"name": "T-Shirt",
"size": "M",
"price": 19.99,
"brand": "NIKE",
"type": "SHIRT"
},
"quantity": 2,
"unitPrice": 29.99,
"createdDate": "2024-12-15T12:00:00",
"status": "CONFIRMED"             
}

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
"unitPrice": 29.99,
"createdDate": "2024-12-14T23:57:55",
"status": "PENDING"
}
