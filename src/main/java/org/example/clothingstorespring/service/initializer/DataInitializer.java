//package org.example.clothingstorespring.service.initializer;
//
//import jakarta.annotation.PostConstruct;
//import org.example.clothingstorespring.model.*;
//import org.example.clothingstorespring.repository.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Component
//public class DataInitializer {
//
//    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
//
//    @Autowired
//    private DeliveryRepository deliveryRepository;
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private StoreRepository storeRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @PostConstruct
//    public void insertInitialData() {
//        logger.info("Starting data insertion...");
//        insertRoles(); // Додано виклик методу для вставки ролей
//        insertUsers(); // Додано виклик методу для вставки користувачів
//        insertStores(); // Додано виклик методу для вставки магазинів
//        insertOrders(); // Додати метод для вставки замовлень
//        insertDeliveries(); // Вставка доставок
//        logger.info("Data insertion completed.");
//    }
//    private void insertRoles() {
//        // Перевірка наявності ролі ROLE_ADMIN
//        if (!roleRepository.existsByName("ROLE_ADMIN")) {
//            Role adminRole = new Role();
//            adminRole.setName("ROLE_ADMIN");
//            roleRepository.save(adminRole);
//            logger.info("Inserted role: {}", adminRole.getName());
//        } else {
//            logger.info("Role ROLE_ADMIN already exists.");
//        }
//
//        // Перевірка наявності ролі ROLE_USER
//        if (!roleRepository.existsByName("ROLE_USER")) {
//            Role userRole = new Role();
//            userRole.setName("ROLE_USER");
//            roleRepository.save(userRole);
//            logger.info("Inserted role: {}", userRole.getName());
//        } else {
//            logger.info("Role ROLE_USER already exists.");
//        }
//    }
//    private void insertUsers() {
//        // Додати нового користувача
//        User user = new User();
//        user.setUsername("JohnDoe"); // Використовуйте setUsername замість setName
//        user.setPassword("$2a$10$RqE9O2E9hh4YLRVrYC.GFe.Xk7OhR4uzyTJG4HtPaTawQKzx08WTe"); // Додайте пароль
//        user.setEmail("john.doe@example.com");
//        user.setCreatedAt(LocalDateTime.now()); // Додайте дату створення
//        userRepository.save(user);
//        logger.info("Inserted user: {}", user.getUsername());
//    }
//    private void insertStores() {
//        // Додати новий магазин
//        Store store = new Store();
//        store.setName("My Clothing Store");
//        store.setLocation("123 Fashion St");
//        store.setContactEmail("contact@myclothingstore.com");
//        store.setEstablishedDate(LocalDate.now());
//
//        // Збереження магазину в базі даних
//        storeRepository.save(store);
//        logger.info("Inserted store: {}", store.getName());
//    }
//
//    private void insertOrders() {
//        // Додайте записи в таблицю orders
//        createOrder(1L);
//        createOrder(2L);
//        createOrder(3L);
//    }
//
//    private void createOrder(Long orderId) {
//        // Створення нового об'єкта Order
//        Order order = new Order();
//
//        // Встановлення ID (необхідно, якщо ви не використовуєте auto-generated ID)
//        order.setId(orderId);
//
//        // Встановлення дати замовлення на поточну дату та час
//        order.setOrderDate(LocalDateTime.now());
//
//        // Отримання користувача (User) за ID
//        User user = userRepository.findById(1L) // Замість 1L використовуйте реальний ID
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        // Отримання магазину (Store) за ID
//        Store store = storeRepository.findById(1L) // Замість 1L використовуйте реальний ID
//                .orElseThrow(() -> new RuntimeException("Store not found"));
//
//        // Встановлення користувача та магазину
//        order.setUser(user);
//        order.setStore(store);
//
//        // Встановлення загальної вартості замовлення
//        order.setTotal(new BigDecimal("100.00")); // Вставте відповідну суму
//
//        // Збереження замовлення в базі даних
//        orderRepository.save(order);
//
//        // Логування інформації про вставлене замовлення
//        logger.info("Inserted order with ID: {}", orderId);
//    }
//
//    private void insertDeliveries() {
//        insertDelivery(1L, "123 Main St, Cityville", LocalDateTime.parse("2024-10-23T10:00:00"), DeliveryStatus.PENDING, DeliveryType.STANDARD);
//        insertDelivery(2L, "456 Elm St, Townsville", LocalDateTime.parse("2024-10-24T12:30:00"), DeliveryStatus.IN_TRANSIT, DeliveryType.EXPRESS);
//        insertDelivery(3L, "789 Maple St, Villagetown", LocalDateTime.parse("2024-10-25T09:15:00"), DeliveryStatus.DELIVERED, DeliveryType.STANDARD);
//    }
//
//    private void insertDelivery(Long orderId, String address, LocalDateTime date, DeliveryStatus status, DeliveryType type) {
//        Order order = orderRepository.findById(orderId).orElse(null);
//        if (order != null) {
//            Delivery delivery = new Delivery();
//            delivery.setOrder(order);
//            delivery.setDeliveryAddress(address);
//            delivery.setDeliveryDate(date);
//            delivery.setStatus(status);
//            delivery.setDeliveryType(type);
//            deliveryRepository.save(delivery);
//            logger.info("Inserted delivery for order ID: {}", orderId);
//        } else {
//            logger.warn("Order ID {} not found. Delivery not inserted.", orderId);
//        }
//    }
//}