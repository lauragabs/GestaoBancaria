INSERT INTO
    Cliente
VALUES
    (
        1,
        "Ana Beatriz",
        "F",
        "12345678901",
        "Rua 4, São Paulo-SP",
        "Aninha@gmail.com",
        "011993052145",
        "1999-05-12",
        "Aninha22",
        "1999Ana"
    ),
    (
        2,
        "Carlos Eduardo",
        "M",
        "98765432100",
        "Rua das Flores, Belo Horizonte-MG",
        "carlos.e@gmail.com",
        "031991234567",
        "1991-03-21",
        "Eduardo99",
        "Carlos1991"
    ),
    (
        3,
        "Mariana Silva",
        "F",
        "34567890123",
        "Avenida Paulista, São Paulo-SP",
        "mariana_silva@hotmail.com",
        "011997123456",
        "1997-09-14",
        "MariSilva92",
        "Mariana97"
    ),
    (
        4,
        "Lucas Oliveira",
        "M",
        "56789012345",
        "Rua XV de Novembro, Curitiba-PR",
        "lucas.oliveira@yahoo.com.br",
        "041991234890",
        "1991-04-11",
        "LucasOliveira91",
        "Lucas91"
    ),
    (
        5,
        "Fernanda Souza",
        "F",
        "78901234567",
        "Rua Maria Antônia, Recife-PE",
        "fer.souza@outlook.com",
        "081992987654",
        "1992-08-20",
        "Fernanda92",
        "Souza92"
    ),
    (
        6,
        "Ricardo Pereira",
        "M",
        "89012345678",
        "Rua Rio de Janeiro, Porto Alegre-RS",
        "ricardo_pereira@gmail.com",
        "051993098765",
        "1993-05-17",
        "Ricardo93",
        "Pererira93"
    ),
    (
        7,
        "Patrícia Gomes",
        "F",
        "90123456789",
        "Avenida do Contorno, Salvador-BA",
        "patricia.gomes@icloud.com",
        "071990123456",
        "1990-07-25",
        "PatiGomes90",
        "Gomes1990"
    ),
    (
        8,
        "Gabriel Costa",
        "M",
        "12345678901",
        "Rua 15, Florianópolis-SC",
        "gabrielcosta@live.com",
        "049992345678",
        "1992-04-09",
        "GabiCosta92",
        "Gabriel92"
    ),
    (
        9,
        "Júlia Martins",
        "F",
        "23456789012",
        "Rua Dona Isabel, Fortaleza-CE",
        "julia.martins@yahoo.com",
        "021991876543",
        "1991-02-18",
        "JuliMartins91",
        "Julia1991"
    ),
    (
        10,
        "Vinícius Barbosa",
        "M",
        "34567890123",
        "Avenida Central, Rio de Janeiro-RJ",
        "vinicius_barbosa@gmail.com",
        "091994345678",
        "1994-09-12",
        "ViniBarbosa94",
        "Vinícius94"
    ),
    (
        11,
        "Isabela Lima",
        "F",
        "45678901234",
        "Rua São Jorge, Manaus-AM",
        "isabelalima@outlook.com",
        "111993234567",
        "1993-11-30",
        "IsaLima93",
        "Isabela1993"
    );

INSERT INTO
    Agencia
VALUES
    (
        1,
        'Agência Centro',
        'Rua da Paz, 120, Centro, São Paulo-SP',
        '011-30301234'
    ),
    (
        2,
        'Agência Norte',
        'Avenida das Nações, 500, Bairro Jardim, São Paulo-SP',
        '011-32659874'
    ),
    (
        3,
        'Agência Sul',
        'Rua Vitória, 240, Bairro Santa Mônica, São Paulo-SP',
        '011-32345678'
    ),
    (
        4,
        'Agência Oeste',
        'Avenida João Pessoa, 85, Bairro Imperial, São Paulo-SP',
        '011-32220101'
    ),
    (
        5,
        'Agência Leste',
        'Rua do Sol, 325, Bairro Taboão, São Paulo-SP',
        '011-33987654'
    );

INSERT INTO
    Conta
VALUES
    (
        1,
        1200.50,
        'corrente',
        '2022-06-15 10:30:00',
        1,
        1
    ),
    (
        2,
        5000.75,
        'poupanca',
        '2023-06-15 10:35:00',
        1,
        1
    ),
    (
        3,
        2300.00,
        'corrente',
        '2024-03-10 09:20:00',
        2,
        2
    ),
    (
        4,
        12000.00,
        'poupanca',
        '2023-03-10 09:25:00',
        2,
        2
    ),
    (
        5,
        750.25,
        'corrente',
        '2023-07-05 13:45:00',
        3,
        3
    ),
    (
        6,
        10000.00,
        'poupanca',
        '2020-07-05 13:50:00',
        3,
        3
    ),
    (
        7,
        950.00,
        'corrente',
        '2021-05-20 14:00:00',
        4,
        4
    ),
    (
        8,
        1500.30,
        'corrente',
        '2023-08-10 11:10:00',
        5,
        5
    ),
    (
        9,
        3100.10,
        'corrente',
        '2024-09-25 15:25:00',
        6,
        1
    ),
    (
        10,
        3800.00,
        'corrente',
        '2023-11-30 12:00:00',
        7,
        2
    ),
    (
        11,
        2200.00,
        'corrente',
        '2022-10-15 16:00:00',
        8,
        3
    ),
    (
        12,
        5800.50,
        'corrente',
        '2021-07-19 14:30:00',
        9,
        4
    ),
    (
        13,
        2100.58,
        'poupanca',
        '2024-03-15 16:22:45',
        10,
        2
    ),
    (
        14,
        12596.22,
        'poupanca',
        '2022-05-04 11:41:30',
        11,
        5
    ),
    (
        15,
        210.44,
        'corrente',
        '2024-12-10 09:55:24',
        11,
        5
    );

INSERT INTO
    Transacao
VALUES
    (1, 'depósito', 500.00, '2023-06-16', 1),
    (2, 'saque', 200.00, '2023-06-18', 1),
    (3, 'transferência', 1500.00, '2023-07-01', 2),
    (4, 'depósito', 1200.50, '2023-07-10', 2),
    (5, 'saque', 500.00, '2023-07-12', 3),
    (6, 'depósito', 3000.00, '2023-07-20', 4),
    (7, 'transferência', 250.00, '2023-07-25', 4),
    (8, 'saque', 100.00, '2023-08-05', 5),
    (9, 'depósito', 800.00, '2023-08-10', 5),
    (10, 'transferência', 500.00, '2023-08-15', 6),
    (11, 'depósito', 2000.00, '2023-09-01', 7),
    (12, 'saque', 300.00, '2023-09-10', 8),
    (13, 'depósito', 1500.00, '2023-09-15', 9),
    (14, 'transferência', 750.00, '2023-10-01', 10),
    (15, 'saque', 1200.00, '2023-10-10', 11),
    (16, 'transferência', 600.00, '2023-10-12', 12),
    (17, 'transferência', 1200.00, '2023-10-15', 13);

INSERT INTO
    Transferencia
VALUES
    (1, 3, 3),
    (2, 4, 7),
    (3, 5, 10),
    (4, 6, 14),
    (5, 7, 16),
    (6, 8, 17);

INSERT INTO
    Funcionario
VALUES
    (
        1,
        'Carlos Alberto',
        'Gerente',
        '011987654321',
        '12345678901',
        'Rua 1, São Paulo-SP',
        '1985-01-15',
        5000.00,
        'M',
        1
    ),
    (
        2,
        'Fernanda Souza',
        'Caixa',
        '011998765432',
        '23456789012',
        'Rua 2, São Paulo-SP',
        '1990-02-20',
        2500.00,
        'F',
        1
    ),
    (
        3,
        'Roberta Martins',
        'Assistente',
        '011923456789',
        '34567890123',
        'Rua 3, São Paulo-SP',
        '1995-03-12',
        3500.00,
        'F',
        2
    ),
    (
        4,
        'João Silva',
        'Gerente',
        '011934567890',
        '45678901234',
        'Rua 4, São Paulo-SP',
        '1980-04-25',
        5500.00,
        'M',
        2
    ),
    (
        5,
        'Maria Oliveira',
        'Caixa',
        '011945678901',
        '56789012345',
        'Rua 5, São Paulo-SP',
        '1992-05-30',
        2300.00,
        'F',
        3
    ),
    (
        6,
        'Luciana Costa',
        'Gerente',
        '011956789012',
        '67890123456',
        'Rua 6, São Paulo-SP',
        '1983-06-22',
        6000.00,
        'F',
        3
    ),
    (
        7,
        'Carlos Henrique',
        'Assistente',
        '011967890123',
        '78901234567',
        'Rua 7, São Paulo-SP',
        '1990-07-10',
        3000.00,
        'M',
        4
    ),
    (
        8,
        'Ana Paula',
        'Caixa',
        '011978901234',
        '89012345678',
        'Rua 8, São Paulo-SP',
        '1994-08-18',
        2400.00,
        'F',
        4
    ),
    (
        9,
        'Paulo Santos',
        'Assistente',
        '011989012345',
        '90123456789',
        'Rua 9, São Paulo-SP',
        '1996-09-02',
        3100.00,
        'M',
        5
    ),
    (
        10,
        'Cláudia Pereira',
        'Gerente',
        '011990123456',
        '01234567890',
        'Rua 10, São Paulo-SP',
        '1982-10-14',
        6500.00,
        'F',
        5
    ),
    (
        11,
        'Roberto Lima',
        'Caixa',
        '011912345678',
        '22345678901',
        'Rua 11, São Paulo-SP',
        '1989-11-05',
        2200.00,
        'M',
        1
    ),
    (
        12,
        'Fernanda Oliveira',
        'Assistente',
        '011923456790',
        '33456789012',
        'Rua 12, São Paulo-SP',
        '1993-12-17',
        3200.00,
        'F',
        2
    ),
    (
        13,
        'Ricardo Costa',
        'Gerente',
        '011934567891',
        '44567890123',
        'Rua 13, São Paulo-SP',
        '1980-01-22',
        5900.00,
        'M',
        3
    ),
    (
        14,
        'Juliana Gomes',
        'Assistente',
        '011945678902',
        '55678901234',
        'Rua 14, São Paulo-SP',
        '1994-02-28',
        3300.00,
        'F',
        4
    ),
    (
        15,
        'Carlos Eduardo',
        'Caixa',
        '011956789013',
        '66789012345',
        'Rua 15, São Paulo-SP',
        '1991-03-12',
        2500.00,
        'M',
        5
    ),
    (
        16,
        'Juliana Lima',
        'Gerente',
        '011967890124',
        '77890123456',
        'Rua 16, São Paulo-SP',
        '1984-04-08',
        5700.00,
        'F',
        1
    ),
    (
        17,
        'Felipe Souza',
        'Caixa',
        '011978901235',
        '88901234567',
        'Rua 17, São Paulo-SP',
        '1997-05-20',
        2100.00,
        'M',
        2
    ),
    (
        18,
        'Daniela Alves',
        'Assistente',
        '011989012346',
        '99012345678',
        'Rua 18, São Paulo-SP',
        '1993-06-03',
        3400.00,
        'F',
        3
    ),
    (
        19,
        'Pedro Rocha',
        'Gerente',
        '011990123457',
        '10123456789',
        'Rua 19, São Paulo-SP',
        '1981-07-16',
        6400.00,
        'M',
        4
    ),
    (
        20,
        'Mariana Santos',
        'Caixa',
        '011912345679',
        '21234567890',
        'Rua 20, São Paulo-SP',
        '1992-08-09',
        2300.00,
        'F',
        5
    );

INSERT INTO
    Gerente VALUE (1, 'Junior', 1),
    (2, 'Pleno', 4),
    (3, 'Senior', 6),
    (4, 'Pleno', 10),
    (5, 'Junior', 13),
    (6, 'Senior', 16),
    (7, 'Junior', 19);

INSERT INTO
    Cartao
VALUES
    (
        1,
        'credito',
        5000.00,
        '2026-06-15',
        1111222233334444,
        1
    ),
    (
        2,
        'debito',
        2000.00,
        '2026-06-15',
        5555666677778888,
        2
    ),
    (
        3,
        'credito',
        7000.00,
        '2026-03-10',
        9999000011112222,
        3
    ),
    (
        4,
        'debito',
        15000.00,
        '2026-03-10',
        3333444455556666,
        4
    ),
    (
        5,
        'credito',
        2500.00,
        '2026-07-05',
        7777888899990000,
        5
    ),
    (
        6,
        'debito',
        12000.00,
        '2025-07-05',
        2222333344445555,
        6
    ),
    (
        7,
        'debito',
        1800.00,
        '2025-05-20',
        8888999900001111,
        7
    ),
    (
        8,
        'credito',
        3000.00,
        '2026-08-10',
        4444555566667777,
        8
    ),
    (
        9,
        'debito',
        3500.00,
        '2026-09-25',
        6666777788889999,
        9
    ),
    (
        10,
        'credito',
        5000.00,
        '2025-11-30',
        1111333355557777,
        10
    ),
    (
        11,
        'debito',
        4000.00,
        '2025-10-15',
        2222444466668888,
        11
    ),
    (
        12,
        'credito',
        6000.00,
        '2025-07-19',
        3333555577779999,
        12
    ),
    (
        13,
        'debito',
        2500.00,
        '2026-03-15',
        4444666688881111,
        13
    ),
    (
        14,
        'debito',
        13000.00,
        '2025-05-04',
        5555777799993333,
        14
    ),
    (
        15,
        'debito',
        1000.00,
        '2026-12-10',
        6666888811115555,
        15
    );

INSERT INTO
    Fatura
VALUES
    (1, '2024-12-15', 1500.00, 1),
    (2, '2025-01-15', 1450.00, 1),
    (3, '2025-02-15', 1600.00, 1),
    (4, '2024-12-15', 1200.00, 3),
    (5, '2025-01-15', 1150.00, 3),
    (6, '2025-02-15', 1300.00, 3),
    (7, '2024-12-15', 900.00, 5),
    (8, '2025-01-15', 950.00, 5),
    (9, '2025-02-15', 1000.00, 5),
    (10, '2024-12-15', 1100.00, 8),
    (11, '2025-01-15', 1050.00, 8),
    (12, '2025-02-15', 1200.00, 8),
    (13, '2024-12-15', 1300.00, 10),
    (14, '2025-01-15', 1250.00, 10),
    (15, '2025-02-15', 1400.00, 10),
    (16, '2024-12-15', 1350.00, 12),
    (17, '2025-01-15', 1300.00, 12),
    (18, '2025-02-15', 1450.00, 12);

INSERT INTO
    Emprestimos
VALUES
    (1, 5000.00, 12, 1.5, 'carro', '2025-12-15', 1),
    (2, 3000.00, 24, 1.2, 'casa', '2026-01-15', 5),
    (3, 4000.00, 18, 1.8, 'terreno', '2025-12-15', 7),
    (4, 4500.00, 20, 1.6, 'carro', '2026-02-15', 8),
    (5, 3500.00, 15, 1.4, 'moto', '2025-12-15', 9),
    (6, 6000.00, 25, 1.7, 'casa', '2026-03-15', 10),
    (7, 2000.00, 10, 1.3, 'carro', '2025-12-15', 11),
    (8, 2500.00, 12, 1.5, 'moto', '2026-01-15', 15);

INSERT INTO
    Pagamento (
        id_pag,
        data_pag,
        valor_pag,
        descricao_pag,
        id_empr
    )
VALUES
    (
        1,
        '2024-07-15',
        1000.00,
        'Parcela 1 do empréstimo 1',
        1
    ),
    (
        2,
        '2024-08-15',
        1000.00,
        'Parcela 2 do empréstimo 1',
        1
    ),
    (
        3,
        '2024-09-15',
        1000.00,
        'Parcela 3 do empréstimo 1',
        1
    ),
    (
        4,
        '2024-10-15',
        1000.00,
        'Parcela 4 do empréstimo 1',
        1
    ),
    (
        5,
        '2024-11-15',
        1000.00,
        'Parcela 5 do empréstimo 1',
        1
    ),
    (
        6,
        '2024-05-15',
        600.00,
        'Parcela 1 do empréstimo 2',
        2
    ),
    (
        7,
        '2024-06-15',
        600.00,
        'Parcela 2 do empréstimo 2',
        2
    ),
    (
        8,
        '2024-07-15',
        600.00,
        'Parcela 3 do empréstimo 2',
        2
    ),
    (
        9,
        '2024-08-15',
        600.00,
        'Parcela 4 do empréstimo 2',
        2
    ),
    (
        10,
        '2024-09-15',
        600.00,
        'Parcela 5 do empréstimo 2',
        2
    ),
    (
        11,
        '2024-06-15',
        800.00,
        'Parcela 1 do empréstimo 3',
        3
    ),
    (
        12,
        '2024-07-15',
        800.00,
        'Parcela 2 do empréstimo 3',
        3
    ),
    (
        13,
        '2024-08-15',
        800.00,
        'Parcela 3 do empréstimo 3',
        3
    ),
    (
        14,
        '2024-09-15',
        800.00,
        'Parcela 4 do empréstimo 3',
        3
    ),
    (
        15,
        '2024-10-15',
        800.00,
        'Parcela 5 do empréstimo 3',
        3
    ),
    (
        16,
        '2024-04-15',
        900.00,
        'Parcela 1 do empréstimo 4',
        4
    ),
    (
        17,
        '2024-05-15',
        900.00,
        'Parcela 2 do empréstimo 4',
        4
    ),
    (
        18,
        '2024-06-15',
        900.00,
        'Parcela 3 do empréstimo 4',
        4
    ),
    (
        19,
        '2024-07-15',
        900.00,
        'Parcela 4 do empréstimo 4',
        4
    ),
    (
        20,
        '2024-08-15',
        900.00,
        'Parcela 5 do empréstimo 4',
        4
    ),
    (
        21,
        '2024-05-15',
        700.00,
        'Parcela 1 do empréstimo 5',
        5
    ),
    (
        22,
        '2024-06-15',
        700.00,
        'Parcela 2 do empréstimo 5',
        5
    ),
    (
        23,
        '2024-07-15',
        700.00,
        'Parcela 3 do empréstimo 5',
        5
    ),
    (
        24,
        '2024-08-15',
        700.00,
        'Parcela 4 do empréstimo 5',
        5
    ),
    (
        25,
        '2024-09-15',
        700.00,
        'Parcela 5 do empréstimo 5',
        5
    ),
    (
        26,
        '2024-03-15',
        1200.00,
        'Parcela 1 do empréstimo 6',
        6
    ),
    (
        27,
        '2024-04-15',
        1200.00,
        'Parcela 2 do empréstimo 6',
        6
    ),
    (
        28,
        '2024-05-15',
        1200.00,
        'Parcela 3 do empréstimo 6',
        6
    ),
    (
        29,
        '2024-06-15',
        1200.00,
        'Parcela 4 do empréstimo 6',
        6
    ),
    (
        30,
        '2024-07-15',
        1200.00,
        'Parcela 5 do empréstimo 6',
        6
    ),
    (
        31,
        '2024-08-15',
        400.00,
        'Parcela 1 do empréstimo 7',
        7
    ),
    (
        32,
        '2024-09-15',
        400.00,
        'Parcela 2 do empréstimo 7',
        7
    ),
    (
        33,
        '2024-10-15',
        400.00,
        'Parcela 3 do empréstimo 7',
        7
    ),
    (
        34,
        '2024-11-15',
        400.00,
        'Parcela 4 do empréstimo 7',
        7
    ),
    (
        35,
        '2024-12-15',
        400.00,
        'Parcela 5 do empréstimo 7',
        7
    ),
    (
        36,
        '2024-09-15',
        500.00,
        'Parcela 1 do empréstimo 8',
        8
    ),
    (
        37,
        '2024-10-15',
        500.00,
        'Parcela 2 do empréstimo 8',
        8
    ),
    (
        38,
        '2024-11-15',
        500.00,
        'Parcela 3 do empréstimo 8',
        8
    ),
    (
        39,
        '2024-12-15',
        500.00,
        'Parcela 4 do empréstimo 8',
        8
    ),
    (
        40,
        '2024-12-20',
        500.00,
        'Parcela 5 do empréstimo 8',
        8
    );