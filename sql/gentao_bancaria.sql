create database gentao_bancaria;
use gentao_bancaria;

create table Cliente{
    id int primary key auto_increment,
    nome varchar(100), 
    sexo varchar(1),
    cpf varchar(11),
    endereco varchar(100),
    email varchar(100),
    telefone varchar(11),
    dataNascimento date,
    login varchar(100),
    senha varchar(100)
}

create table Conta{
    id int primary key auto_increment,
    saldo float,
    tipoConta varchar(10),
    idCliente int,
    foreign key (idCliente) references Cliente(id)
}

create table Cartao{
    id int primary key auto_increment,
    numero varchar(16),
    dataVencimento date,
    cvv varchar(3),
    limite float,
    tipo varchar(10),
    idConta int,
    foreign key (idConta) references Conta(id)
}

create table Emprestimo{
    id int primary key auto_increment,
    valor float,
    parcelas int,
    juros float,
    garantia varchar(20),
    dataVencimento date,
    idConta int,
    foreign key (idConta) references Conta(id)
}

create table Funcionario{
    id int primary key auto_increment,
    nome varchar(100),
    cargo varchar(50),
    telefone varchar(11),
    cpf varchar(11),
    endereco varchar(100),
    dataNascimento date,
    email varchar(100),
    salario float,
    email varchar(100),
    dataAdmissao date,
}