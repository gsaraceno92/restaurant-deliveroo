CREATE TABLE IF NOT EXISTS `food_orders` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `total_price` DECIMAL(10,2) NOT NULL,
    `order_id` INT,
    FOREIGN KEY (`order_id`) REFERENCES orders (id),
    `food_id` INT,
    FOREIGN KEY (`food_id`) REFERENCES foods (id)
);
