-- Criar Banco de Dados
CREATE DATABASE IF NOT EXISTS BancoBD;
USE BancoBD;

-- 1. TABELA: cliente
CREATE TABLE cliente (
    id_cliente_pk INT NOT NULL AUTO_INCREMENT,
    nome_cliente VARCHAR(150) NOT NULL,
    senha_cliente VARCHAR(100) NOT NULL,
    email_cliente VARCHAR(150) NOT NULL,
    cpf_cliente VARCHAR(11) NOT NULL,
    PRIMARY KEY (id_cliente_pk)
);

-- 2. TABELA: telefoneCliente
CREATE TABLE telefoneCliente (
    id_telefoneCliente_pk INT NOT NULL AUTO_INCREMENT,
    telefone_telefoneCliente VARCHAR(15) NOT NULL,
    cliente_id_cliente_fk INT NOT NULL,
    PRIMARY KEY (id_telefoneCliente_pk),
    FOREIGN KEY (cliente_id_cliente_fk) REFERENCES cliente(id_cliente_pk) ON DELETE CASCADE
);

-- 3. TABELA: motor
CREATE TABLE motor (
    id_motor_pk INT NOT NULL AUTO_INCREMENT,
    potencia_motor DOUBLE NOT NULL,
    tipo_motor ENUM('Flex', 'Gasolina', 'Diesel', 'Elétrico', 'Híbrido') NOT NULL, -- Valores comuns ajustáveis
    numDeCilindros_motor INT NOT NULL,
    PRIMARY KEY (id_motor_pk)
);

-- 4. TABELA: desconto
CREATE TABLE desconto (
    id_desconto_pk INT NOT NULL AUTO_INCREMENT,
    data_inicio_desconto DATE NOT NULL,
    data_final_desconto DATE NOT NULL,
    porcentagem_desconto DOUBLE NOT NULL,
    PRIMARY KEY (id_desconto_pk)
);

-- 5. TABELA: carro
CREATE TABLE carro (
    id_carro_pk INT NOT NULL AUTO_INCREMENT,
    modelo_carro VARCHAR(100) NOT NULL,
    ano_carro VARCHAR(50) NOT NULL,
    cor_carro VARCHAR(50) NOT NULL,
    disponibilidade_carro TINYINT NOT NULL,
    motor_id_motor_fk INT NOT NULL,
    desconto_id_desconto_pk INT DEFAULT NULL,
    nota DOUBLE NOT NULL,
    PRIMARY KEY (id_carro_pk),
    FOREIGN KEY (motor_id_motor_fk) REFERENCES motor(id_motor_pk),
    FOREIGN KEY (desconto_id_desconto_pk) REFERENCES desconto(id_desconto_pk) ON DELETE SET NULL
);

-- 6. TABELA: pagamento
CREATE TABLE pagamento (
    id_pagamento_pk INT NOT NULL AUTO_INCREMENT,
    metodoDePagamento_pagamento ENUM('Cartão', 'Pix', 'Boleto', 'Dinheiro') NOT NULL,
    horarioDePagamento_pagamento TIME NOT NULL,
    dataDePagamento_pagamento DATE NOT NULL,
    valorTotal_pagamento DOUBLE NOT NULL,
    valorDeDesconto_pagamento DOUBLE DEFAULT 0,
    PRIMARY KEY (id_pagamento_pk)
);

-- 7. TABELA: parcela
CREATE TABLE parcela (
    id_parcela_pk INT NOT NULL AUTO_INCREMENT,
    numeroDeParcelas_pk INT NOT NULL,
    dataDeVencimento_parcela DATE NOT NULL,
    status_parcela ENUM('Pendente', 'Pago', 'Atrasado') NOT NULL,
    pagamento_id_pagamento_pk INT NOT NULL,
    PRIMARY KEY (id_parcela_pk),
    FOREIGN KEY (pagamento_id_pagamento_pk) REFERENCES pagamento(id_pagamento_pk) ON DELETE CASCADE
);

-- 8. TABELA: compra
CREATE TABLE compra (
    id_compra_pk INT NOT NULL AUTO_INCREMENT,
    dataAgendadaParaColeta_compra DATE NOT NULL,
    dataDeColeta_compra DATE DEFAULT NULL,
    horarioAgendadoParaColeta_compra TIME NOT NULL,
    horarioDeColeta_compra TIME DEFAULT NULL,
    cliente_id_cliente_fk INT NOT NULL,
    pagamento_id_pagamento_pk INT NOT NULL,
    carro_id_carro_pk INT NOT NULL,
    PRIMARY KEY (id_compra_pk),
    FOREIGN KEY (cliente_id_cliente_fk) REFERENCES cliente(id_cliente_pk),
    FOREIGN KEY (pagamento_id_pagamento_pk) REFERENCES pagamento(id_pagamento_pk),
    FOREIGN KEY (carro_id_carro_pk) REFERENCES carro(id_carro_pk)
);

-- 9. TABELA: locacao
CREATE TABLE locacao (
    id_locacao_pk INT NOT NULL AUTO_INCREMENT,
    dataAgendadaParaColeta_locacao DATE NOT NULL,
    dataDeColeta_locacao DATE DEFAULT NULL,
    horarioAgendadoParaColeta_locacao TIME NOT NULL,
    horarioDeColeta_locacao TIME DEFAULT NULL,
    periodo_locacao DOUBLE NOT NULL, -- Geralmente quantidade de dias ou horas
    cliente_id_cliente_fk INT NOT NULL,
    pagamento_id_pagamento_pk INT NOT NULL,
    carro_id_carro_pk INT NOT NULL,
    PRIMARY KEY (id_locacao_pk),
    FOREIGN KEY (cliente_id_cliente_fk) REFERENCES cliente(id_cliente_pk),
    FOREIGN KEY (pagamento_id_pagamento_pk) REFERENCES pagamento(id_pagamento_pk),
    FOREIGN KEY (carro_id_carro_pk) REFERENCES carro(id_carro_pk)
);

-- 10. TABELA: reembolso
CREATE TABLE reembolso (
    id_reembolso_pk INT NOT NULL AUTO_INCREMENT,
    valor_reembolso DOUBLE NOT NULL,
    dataSol_reembolso DATE NOT NULL,
    dataRes_reembolso DATE DEFAULT NULL,
    horarioAgendadoParaColeta_reembolso TIME NOT NULL,
    horarioDeColeta_reembolso TIME DEFAULT NULL,
    cliente_id_cliente_fk INT NOT NULL,
    pagamento_id_pagamento_pk INT NOT NULL,
    PRIMARY KEY (id_reembolso_pk),
    FOREIGN KEY (cliente_id_cliente_fk) REFERENCES cliente(id_cliente_pk),
    FOREIGN KEY (pagamento_id_pagamento_pk) REFERENCES pagamento(id_pagamento_pk)
);

SELECT VERSION();