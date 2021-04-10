CREATE TABLE IF NOT EXISTS `drinks_orders` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `total_price` DECIMAL(10,2) NOT NULL,
    `order_id` INT,
    FOREIGN KEY (`order_id`) REFERENCES orders (id),
    `drink_id` INT,
    FOREIGN KEY (`drink_id`) REFERENCES drinks (id),
);
