CREATE TABLE product (
    id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(19,2) NOT NULL,
    description VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;