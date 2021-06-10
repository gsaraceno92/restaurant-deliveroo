CREATE TABLE IF NOT EXISTS `orders` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `purchase_method` varchar(50) NOT NULL,
    `purchase_status` varchar(50) NOT NULL,
    `total_price` DECIMAL(10,2) NOT NULL,
    `user_id` INT,
    FOREIGN KEY (`user_id`) REFERENCES users (id),
    `description` varchar(500),
    `order_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `items` json DEFAULT NULL
);
