CREATE DATABASE IF NOT EXISTS `pos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pos`;

CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `category` VALUES
(1, 'electronics'),
(2, 'furniture'),
(3, 'clothing');

CREATE TABLE `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `phoneNumber` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;

INSERT INTO `customers` VALUES
(1, 'John Doe', '1234567890'),
(2, 'Jane Smith', '0987654321'),
(3, 'Alice Johnson', '1122334455');

CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

INSERT INTO `employees` VALUES
(1, 'Michael Brown', '555-1234'),
(2, 'Emily Davis', '555-5678'),
(3, 'David Wilson', '555-9101');


CREATE TABLE `suppliers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

INSERT INTO `suppliers` VALUES
(1, 'Global Supplies', '12345'),
(2, 'Home Essentials', '54321'),
(3, 'Tech Gear', '98765');

CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `barcode` varchar(50) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `stock_quantity` decimal(10,2) NOT NULL,
  `category_id` int DEFAULT '1',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `quantity_type` varchar(15) NOT NULL DEFAULT 'counted',
  `suppliers_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `barcode` (`barcode`),
  KEY `category_id` (`category_id`),
  KEY `fk_products_suppliers1_idx` (`suppliers_id`),
  CONSTRAINT `fk_products_suppliers1` FOREIGN KEY (`suppliers_id`) REFERENCES `suppliers` (`id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `products` VALUES
(1, 'Laptop', '1001', 800.00, 50.00, 1, '2024-02-13 06:05:31', '2024-02-15 08:18:05', 'counted', 1),
(2, 'Chair', '1002', 120.00, 150.00, 2, '2024-02-13 06:11:02', '2024-02-15 08:18:05', 'counted', 2);


CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `users` VALUES
('admin', 'admin123', 'admin'),
('cashier', 'cashier123', 'cashier');
CREATE TABLE IF NOT EXISTS sales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    sale_date DATE NOT NULL,
    foreign key(product_id) references products(id)
);
CREATE TABLE IF NOT EXISTS sales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    sale_date DATE NOT NULL,
    foreign key(product_id) references products(id)
);
INSERT INTO sales (product_id, total_price, sale_date) VALUES 
(1, 150.00, '2025-02-10'),
(2, 200.50, '2025-02-15'),
(1, 99.99, '2025-02-20'),
(1, 50.00, '2025-02-28'),
(2, 300.00, '2025-03-01');
ALTER TABLE employees ADD COLUMN salary decimal(10,2);
ALTER TABLE employees ADD COLUMN payment_date DATE;
INSERT INTO employees (name,phoneNumber, salary, payment_date) VALUES 
('Alice Johnson',1234567890, 2500.00, '2025-02-28'),
('Bob Smith',1243567890,2800.00, '2025-02-28'),
('Charlie Brown',1254367890, 3000.00, '2025-03-01');