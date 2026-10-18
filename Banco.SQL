CREATE DATABASE Banco_Spartacus;

USE Banco_Spartacus;

-- Criação da tabela DESCONTO (Criada primeiro para poder ser referenciada por carro)
CREATE TABLE desconto (
    id_desconto_pk INT AUTO_INCREMENT PRIMARY KEY,
    porcentagem_desconto DECIMAL(5,2) NOT NULL,
    data_final_desconto DATE,
    data_inicio_desconto DATE
) ENGINE=InnoDB;

-- Criação da tabela MOTOR
CREATE TABLE motor (
    id_motor INT AUTO_INCREMENT PRIMARY KEY,
    Potencia_motor VARCHAR(50),
    Tipo_motor VARCHAR(50),
    NumDeCilindros_motor INT
) ENGINE=InnoDB;

-- Criação da tabela CARRO (Agora com a ligação correta para DESCONTO)
CREATE TABLE carro (
    id_carro_pk INT AUTO_INCREMENT PRIMARY KEY,
    modelo_carro VARCHAR(50) NOT NULL,
    ano_carro INT NOT NULL,
    cor_carro VARCHAR(30),
    Disponibilidade_carro BOOLEAN DEFAULT TRUE,
    id_motor INT,
    id_desconto_pk INT, -- Nova FK ligando o Carro ao seu Desconto correspondente
    FOREIGN KEY (id_motor) REFERENCES motor(id_motor) ON DELETE SET NULL,
    FOREIGN KEY (id_desconto_pk) REFERENCES desconto(id_desconto_pk) ON DELETE SET NULL
) ENGINE=InnoDB;

-- Criação da tabela CLIENTE
CREATE TABLE cliente (
    id_cliente_pk INT AUTO_INCREMENT PRIMARY KEY,
    nome_cliente VARCHAR(100) NOT NULL,
    senha_cliente VARCHAR(255) NOT NULL,
    email_cliente VARCHAR(100) NOT NULL,
    telefone_cliente VARCHAR(20),
    CEP VARCHAR(9) NOT NULL
) ENGINE=InnoDB;

-- Criação da tabela COMPRA
CREATE TABLE compra (
    id_compra_pk INT AUTO_INCREMENT PRIMARY KEY,
    DataAgendadaParaColeta_compra DATE,
    DataDeColeta_compra DATE,
    HorarioAgendadoParaColeta_compra TIME,
    HorarioDeColeta_compra TIME,
    id_cliente_pk INT NOT NULL,
    id_carro_pk INT NOT NULL,
    FOREIGN KEY (id_cliente_pk) REFERENCES cliente(id_cliente_pk),
    FOREIGN KEY (id_carro_pk) REFERENCES carro(id_carro_pk)
) ENGINE=InnoDB;

-- Criação da tabela LOCACAO (Removida a FK do desconto daqui, pois agora ela está no carro)
CREATE TABLE locacao (
    id_locacao_pk INT AUTO_INCREMENT PRIMARY KEY,
    DataAgendadaParaColeta_locacao DATE,
    HorarioAgendadoParaColeta_locacao TIME,
    HorarioDeColeta_locacao TIME,
    DataDeColeta_locacao DATE,
    Periodo_locacao VARCHAR(50),
    id_cliente_pk INT NOT NULL,
    id_carro_pk INT NOT NULL,
    FOREIGN KEY (id_cliente_pk) REFERENCES cliente(id_cliente_pk),
    FOREIGN KEY (id_carro_pk) REFERENCES carro(id_carro_pk)
) ENGINE=InnoDB;

-- Criação da tabela PAGAMENTO
CREATE TABLE pagamento (
    id_pagamento_pk INT AUTO_INCREMENT PRIMARY KEY,
    MetodoDePagamento_pagamento VARCHAR(50) NOT NULL,
    HorarioDePagamento_pagamento TIME,
    DataDePagamento_pagamento DATE,
    ValorDeEntrada_pagamento DECIMAL(10,2),
    ValorTotal_pagamento DECIMAL(10,2) NOT NULL,
    id_compra_pk INT UNIQUE,
    id_locacao_pk INT UNIQUE,
    FOREIGN KEY (id_compra_pk) REFERENCES compra(id_compra_pk) ON DELETE CASCADE,
    FOREIGN KEY (id_locacao_pk) REFERENCES locacao(id_locacao_pk) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Criação da tabela PARCELA
CREATE TABLE parcela (
    id_parcela INT AUTO_INCREMENT PRIMARY KEY,
    Numero_parcela INT NOT NULL,
    DataVencimento_parcela DATE NOT NULL,
    Status_parcela VARCHAR(30),
    id_pagamento_pk INT NOT NULL,
    FOREIGN KEY (id_pagamento_pk) REFERENCES pagamento(id_pagamento_pk) ON DELETE CASCADE
) ENGINE=InnoDB;
