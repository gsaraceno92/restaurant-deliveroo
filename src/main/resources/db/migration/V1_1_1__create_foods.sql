CREATE TABLE IF NOT EXISTS `foods` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(50) NOT NULL,
    `price` DECIMAL(10,2) NOT NULL,
    `category` varchar(100),
    `description` varchar(200),
    `image_url` varchar(400),
    `available` boolean default 1
);
