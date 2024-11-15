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
    data_pedido DATE NOT NULL,
    status_pedido ENUM('PENDENTE', 'EM PROCESSAMENTO', 'ENVIADO', 'ENTREGUE') NOT NULL,
    FOREIGN KEY(id_cliente) REFERENCES clientes(id_cliente)
);

CREATE TABLE cupons_desconto(
	id_cupom INT PRIMARY KEY AUTO_INCREMENT,
    codigo_cupom VARCHAR(10) UNIQUE NOT NULL,
    percentual_desconto DECIMAL(5, 2) NOT NULL,
    data_validade DATE NOT NULL
);

CREATE TABLE itens_pedidos(
	id_item_pedido INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido INT NOT NULL, -- FK
    id_produto INT NOT NULL, -- FK
    id_cupom INT, -- pode ser null se o pedido nao possuir cupom de desconto
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    valor_total DECIMAL(10, 2) NOT NULL, -- o valor total varia entre quantidade * preco_unitario ou (quantidade * preco_unitario) - desconto
    FOREIGN KEY(id_pedido) REFERENCES pedidos(id_pedido) ON DELETE CASCADE,
    FOREIGN KEY(id_cupom) REFERENCES cupons_desconto(id_cupom),
    FOREIGN KEY(id_produto) REFERENCES produtos(id_produto)
);

CREATE TABLE pagamentos(
	id_pagamento INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido INT NOT NULL, -- FK
    data_pagamento DATE NOT NULL,
    valor_pago DECIMAL(10, 2) NOT NULL,
    metodo_pagamento ENUM('CARTAO', 'BOLETO', 'PIX') NOT NULL,
    FOREIGN KEY(id_pedido) REFERENCES pedidos(id_pedido)
);

CREATE TABLE funcionarios(
	id_funcionario INT PRIMARY KEY AUTO_INCREMENT,
    nome_funcionario VARCHAR(200) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(50) NOT NULL,
    data_admissao DATE NOT NULL
);

CREATE TABLE avaliacoes(
	id_avaliacao INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT NOT NULL, -- FK
    id_produto INT NOT NULL, -- FK
    nota INT NOT NULL,
    CHECK(nota BETWEEN 0 AND 5), -- restringe avaliacoes/notas somente no intervalo de 0 a 5
    comentario TEXT,
    data_avaliacao DATE NOT NULL,
    FOREIGN KEY(id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY(id_produto) REFERENCES produtos(id_produto)
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
    FOREIGN KEY(id_cliente) REFERENCES clientes(id_cliente)
);

CREATE TABLE pedidos_entregues(
	id_pedido_entregue INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido INT NOT NULL, -- FK
    data_entrega DATE NOT NULL,
    FOREIGN KEY(id_pedido) REFERENCES pedidos(id_pedido)
);