CREATE TABLE
    Cliente (
        id_cliente INT AUTO_INCREMENT PRIMARY KEY,
        nome_cliente VARCHAR(100),
        sexo_cliente VARCHAR(4),
        cpf_cliente VARCHAR(11),
        endereco_cliente VARCHAR(100),
        email_cliente VARCHAR(100),
        telefone_cliente VARCHAR(15),
        dataNasc_cliente DATE,
        login_cliente VARCHAR(20),
        senha_cliente VARCHAR(20)
    );

CREATE TABLE
    Agencia (
        id_agencia INT AUTO_INCREMENT PRIMARY KEY,
        nome_agencia VARCHAR(50),
        endereco_agencia VARCHAR(100),
        telefone_agencia VARCHAR(15)
    );

CREATE TABLE
    Conta (
        id_conta INT AUTO_INCREMENT PRIMARY KEY,
        saldo_conta NUMERIC(7, 2),
        tipo_conta VARCHAR(10),
        dataAbertura_conta DATETIME,
        id_cliente INT,
        id_agencia INT,
        FOREIGN KEY (id_cliente) REFERENCES Cliente (id_cliente),
        FOREIGN KEY (id_agencia) REFERENCES Agencia (id_agencia)
    );

CREATE TABLE
    Transacao (
        id_transacao INT AUTO_INCREMENT PRIMARY KEY,
        tipo_transacao VARCHAR(20),
        valor_transacao NUMERIC(7, 2),
        data_transacao DATE,
        id_conta INT,
        FOREIGN KEY (id_conta) REFERENCES Conta (id_conta)
    );

CREATE TABLE
    Transferencia (
        id_transferencia INT AUTO_INCREMENT PRIMARY KEY,
        contaDestino_transferencia INT,
        id_transacao INT,
        FOREIGN KEY (id_transacao) REFERENCES Transacao (id_transacao)
    );

CREATE TABLE
    Funcionario (
        id_func INT AUTO_INCREMENT PRIMARY KEY,
        nome_func VARCHAR(100),
        cargo_func VARCHAR(50),
        telefone_func VARCHAR(15),
        cpf_func VARCHAR(11) UNIQUE,
        endereco_func VARCHAR(100),
        dataNasc_func DATE,
        salario_func NUMERIC(7, 2),
        sexo_func VARCHAR(4),
        id_agencia INT,
        FOREIGN KEY (id_agencia) REFERENCES Agencia (id_agencia)
    );

CREATE TABLE
    Gerente (
        id_gerente INT AUTO_INCREMENT PRIMARY KEY,
        nivel_gerente VARCHAR(10),
        id_func INT,
        FOREIGN KEY (id_func) REFERENCES Funcionario (id_func)
    );

CREATE TABLE
    Cartao (
        id_cartao INT AUTO_INCREMENT PRIMARY KEY,
        tipo_cartao VARCHAR(20),
        limite_cartao NUMERIC(7, 2),
        dataValidade_cartao DATE,
        num_cartao BIGINT,
        id_conta INT,
        FOREIGN KEY (id_conta) REFERENCES Conta (id_conta)
    );

CREATE TABLE
    Fatura (
        id_fatura INT AUTO_INCREMENT PRIMARY KEY,
        dataVencimento_fatura DATE,
        valor_fatura NUMERIC(7, 2),
        id_cartao INT,
        FOREIGN KEY (id_cartao) REFERENCES Cartao (id_cartao)
    );

CREATE TABLE
    Emprestimos (
        id_empr INT AUTO_INCREMENT PRIMARY KEY,
        valor_empr NUMERIC(7, 2),
        numParcelas_empr INT,
        juros_empr FLOAT,
        garantia_empr VARCHAR(20),
        dataVencimento_empr DATE,
        id_conta INT,
        FOREIGN KEY (id_conta) REFERENCES Conta (id_conta)
    );

CREATE TABLE
    Pagamento (
        id_pag INT AUTO_INCREMENT PRIMARY KEY,
        data_pag DATE,
        valor_pag NUMERIC(7, 2),
        descricao_pag VARCHAR(50),
        id_empr INT,
        FOREIGN KEY (id_empr) REFERENCES Emprestimos (id_empr)
    );