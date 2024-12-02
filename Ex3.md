# Перевірка методу PaymentCleanupService

1. Додав: testold.sql (чотири фіктивні старі записи про оплату 
    31,1,100.00,Credit Card,2022-11-01 10:00:00.000000
   32,2,200.00,PayPal,2022-12-15 15:30:00.000000
   33,3,150.00,Bank Transfer,2022-01-20 12:45:00.000000
   34,4,250.00,Cash,2022-09-10 09:00:00.000000
   )

POST  http://localhost:8080/cleanup-payments
Payment cleanup triggered.

2. Отримав в логах:
   2024-12-02 05:11:07 - Found 4 old payments to delete:
   2024-12-02 05:11:07 - Old payment ID: 31, Amount: 100.00
   2024-12-02 05:11:07 - Old payment ID: 32, Amount: 200.00
   2024-12-02 05:11:07 - Old payment ID: 33, Amount: 150.00
   2024-12-02 05:11:07 - Old payment ID: 34, Amount: 250.00
   2024-12-02 05:11:07 - Deleted payment with ID: 31
   2024-12-02 05:11:07 - Deleted payment with ID: 32
   2024-12-02 05:11:07 - Deleted payment with ID: 33
   2024-12-02 05:11:07 - Deleted payment with ID: 34
   2024-12-02 05:11:07 - Deleted 4 old payments.

# Перевірка на роботу контроллера ItemController щодо роботи методу createOrderItems
1. POST http://localhost:8080/api/order-items
   [
   {
   "order": {"id": 1},
   "clothingItem": {
   "type": "shirt",
   "id": 1,
   "brand": "NIKE",  // Зверніть увагу на регістр
   "size": "M"
   },
   "quantity": 3,
   "unitPrice": 19.99
   },
   {
   "order": {"id": 1},
   "clothingItem": {
   "type": "pants",
   "id": 2,
   "brand": "ADIDAS",  // Зверніть увагу на регістр
   "size": "L"
   },
   "quantity": 2,
   "unitPrice": 49.99
   }
   ]
2. 201 Created
   A new resource was created successfully.
   [
   {
   "id": 9,
   "order": {
   "id": 1,
   "customerName": null,
   "total": null,
   "orderDate": null,
   "status": null,
   "store": null,
   "user": null,
   "payment": null,
   "delivery": null,
   "orderItems": []
   },
   "clothingItem": {
   "type": "shirt",
   "id": 1,
   "name": null,
   "size": "M",
   "price": null,
   "brand": "NIKE",
   "sleeve_type": null,
   "color": null,
   "material": null
   },
   "quantity": 3,
   "unitPrice": 19.99
   },
   {
   "id": 10,
   "order": {
   "id": 1,
   "customerName": null,
   "total": null,
   "orderDate": null,
   "status": null,
   "store": null,
   "user": null,
   "payment": null,
   "delivery": null,
   "orderItems": []
   },
   "clothingItem": {
   "type": "pants",
   "id": 2,
   "name": null,
   "size": "L",
   "price": null,
   "brand": "ADIDAS",
   "material": null,
   "color": null
   },
   "quantity": 2,
   "unitPrice": 49.99
   }
   ]