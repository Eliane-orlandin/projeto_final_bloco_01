USE db_rocwear;
SHOW TABLES;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    categoria VARCHAR(100),
    tamanho VARCHAR(50),
    cor VARCHAR(50),
    quantidade INT DEFAULT 0,
    tipo VARCHAR(50),
    tecido VARCHAR(100),
    material VARCHAR(100)
);
