CREATE DATABASE gestao_bancaria;
USE gestao_bancaria;

CREATE TABLE Cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100), 
    sexo VARCHAR(1),
    cpf VARCHAR(14),
    endereco VARCHAR(100),
    email VARCHAR(100),
    telefone VARCHAR(15),
    dataNascimento DATE,
    login VARCHAR(100),
    senha VARCHAR(100)
);

CREATE TABLE Conta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    saldo DECIMAL(10,2),
    tipoConta VARCHAR(10),
    idCliente INT,
    FOREIGN KEY (idCliente) REFERENCES Cliente(id)
);

CREATE TABLE Cartao (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero VARCHAR(16),
    dataVencimento DATE,
    cvv VARCHAR(3),
    limite DECIMAL(10,2),
    tipo VARCHAR(10),
    idConta INT,
    FOREIGN KEY (idConta) REFERENCES Conta(id)
);

CREATE TABLE Emprestimo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    valor DECIMAL(10,2),
    parcelas INT,
    juros DECIMAL(5,2),
    garantia VARCHAR(20),
    dataVencimento DATE,
    idConta INT,
    FOREIGN KEY (idConta) REFERENCES Conta(id)
);

CREATE TABLE Funcionario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    cargo VARCHAR(50),
    telefone VARCHAR(15),
    cpf VARCHAR(14),
    endereco VARCHAR(100),
    dataNascimento DATE,
    email VARCHAR(100),
    salario DECIMAL(10,2),
    dataAdmissao DATE
);
