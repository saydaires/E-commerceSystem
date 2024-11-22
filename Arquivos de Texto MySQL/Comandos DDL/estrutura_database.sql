CREATE DATABASE ecommerce_db;
USE ecommerce_db;

CREATE TABLE clientes(
	id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nome_cliente VARCHAR(200) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(50) NOT NULL,
    data_nascimento DATE
);

CREATE TABLE categorias(
	id_categoria INT PRIMARY KEY AUTO_INCREMENT,
    nome_categoria VARCHAR(100) NOT NULL,
    descricao TEXT
);

CREATE TABLE produtos(
	id_produto INT PRIMARY KEY AUTO_INCREMENT,
    nome_produto VARCHAR(100) NOT NULL,
    cod_produto VARCHAR(10) UNIQUE NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    qtd_estoque INT NOT NULL,
    id_categoria INT NOT NULL, -- FK
    FOREIGN KEY(id_categoria) REFERENCES categorias(id_categoria)
);

CREATE TABLE pedidos(
	id_pedido INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL, -- FK
    codigo_pedido INT NOT NULL UNIQUE KEY,
    data_pedido DATE NOT NULL,
    status_pedido ENUM('PENDENTE', 'EM PROCESSAMENTO', 'ENVIADO', 'ENTREGUE') NOT NULL,
    FOREIGN KEY(id_cliente) REFERENCES clientes(id_cliente) ON DELETE CASCADE
);

CREATE TABLE itens_pedidos(
	id_item_pedido INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido INT NOT NULL, -- FK
    codigo_pedido INT NOT NULL, -- FK
    id_produto INT NOT NULL, -- FK
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    valor_total DECIMAL(10, 2) NOT NULL, -- o valor total varia entre quantidade * preco_unitario ou (quantidade * preco_unitario) - desconto
    FOREIGN KEY(id_pedido) REFERENCES pedidos(id_pedido) ON DELETE CASCADE,
    FOREIGN KEY(codigo_pedido) REFERENCES pedidos(codigo_pedido) ON DELETE CASCADE,
    FOREIGN KEY(id_produto) REFERENCES produtos(id_produto)
);

CREATE TABLE funcionarios(
	id_funcionario INT PRIMARY KEY AUTO_INCREMENT,
    nome_funcionario VARCHAR(200) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(50) NOT NULL,
    data_admissao DATE NOT NULL
);

CREATE TABLE enderecos(
	id_endereco INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL, -- FK
    logradouro VARCHAR(200) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(100),
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    cep VARCHAR(8) NOT NULL,
    FOREIGN KEY(id_cliente) REFERENCES clientes(id_cliente) ON DELETE CASCADE
);

CREATE TABLE pedidos_entregues(
	id_pedido_entregue INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido INT NOT NULL, -- FK
    data_entrega DATE NOT NULL,
    FOREIGN KEY(id_pedido) REFERENCES pedidos(id_pedido) ON DELETE CASCADE
);