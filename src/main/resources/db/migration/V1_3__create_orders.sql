CREATE TABLE IF NOT EXISTS `orders` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `order_number` int NOT NULL,
    `payment_type_id` varchar(50) NOT NULL,
    `cost` DECIMAL(10,2) NOT NULL,
    `address` varchar(200),
    `user_id` INT,
    FOREIGN KEY (`user_id`) REFERENCES users (id),
    `description` varchar(500),
    `order_date` DATETIME DEFAULT CURRENT_TIMESTAMP
);
