CREATE TABLE IF NOT EXISTS `users` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(50) NOT NULL,
    `phone_number` varchar(50) NOT NULL,
    `email` varchar(100),
    `address` varchar(200),
    `date_creation` DATETIME DEFAULT CURRENT_TIMESTAMP
);
