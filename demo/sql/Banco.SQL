CREATE DATABASE IF NOT EXISTS BancoBD;
USE BancoBD;

CREATE TABLE cliente (
    id_cliente_pk INT NOT NULL AUTO_INCREMENT,
    nome_cliente VARCHAR(150) NOT NULL,
    senha_cliente VARCHAR(100) NOT NULL,
    email_cliente VARCHAR(150) NOT NULL,
    cpf_cliente VARCHAR(11) NOT NULL,

    PRIMARY KEY (id_cliente_pk)
);

CREATE TABLE TelefoneCliente (
    id_TelefoneCliente_pk INT NOT NULL AUTO_INCREMENT,
    telefone_TelefoneCliente VARCHAR(15) NOT NULL,
    cliente_id_cliente_pk INT NOT NULL,

    PRIMARY KEY (id_TelefoneCliente_pk),

    FOREIGN KEY (cliente_id_cliente_pk)
        REFERENCES cliente(id_cliente_pk)
);

CREATE TABLE carro (
    id_carro_pk INT NOT NULL AUTO_INCREMENT,
    potenciaMotor_carro DOUBLE NOT NULL,
    tipoMotor_carro ENUM(
        'Flex',
        'Gasolina',
        'Diesel',
        'Elétrico',
        'Híbrido'
    ) NOT NULL,
    NumDeCilindrosMotor_carro INT NOT NULL,

    PRIMARY KEY (id_carro_pk)
);

CREATE TABLE desconto (
    id_desconto_pk INT NOT NULL AUTO_INCREMENT,
    data_inicio_desconto DATE NOT NULL,
    data_final_desconto DATE NOT NULL,
    porcentagem_desconto DOUBLE NOT NULL,

    PRIMARY KEY (id_desconto_pk)
);

CREATE TABLE Carro_Disponivel (
    id_carro_pk INT NOT NULL,
    ano_carroDisponivel INT NOT NULL,
    cor_carroDisponivel VARCHAR(50) NOT NULL,
    disponibilidade_carroDisponivel TINYINT NOT NULL,
    nota_carroDisponivel FLOAT NOT NULL,
    preco_carroDisponivel FLOAT NOT NULL,
    desconto_id_desconto_pk INT NULL,

    PRIMARY KEY (id_carro_pk),

    FOREIGN KEY (id_carro_pk)
        REFERENCES carro(id_carro_pk),

    FOREIGN KEY (desconto_id_desconto_pk)
        REFERENCES desconto(id_desconto_pk)
);

CREATE TABLE compra (
    id_compra_pk INT NOT NULL AUTO_INCREMENT,
    dataAgendadaParaColeta_compra DATE NOT NULL,
    dataDeColeta_compra DATE NULL,
    horarioAgendadoParaColeta_compra TIME NOT NULL,
    horaDeColeta_compra TIME NULL,
    cliente_id_cliente_pk INT NOT NULL,
    Carro_Disponivel_id_carro_pk INT NOT NULL,

    PRIMARY KEY (id_compra_pk),

    FOREIGN KEY (cliente_id_cliente_pk)
        REFERENCES cliente(id_cliente_pk),

    FOREIGN KEY (Carro_Disponivel_id_carro_pk)
        REFERENCES Carro_Disponivel(id_carro_pk)
);

CREATE TABLE locacao (
    id_locacao_pk INT NOT NULL AUTO_INCREMENT,
    dataAgendadaParaColeta_locacao DATE NOT NULL,
    dataDeColeta_locacao DATE NULL,
    horarioAgendadoParaColeta_locacao TIME NOT NULL,
    horaDeColeta_locacao TIME NULL,
    Periodo_locacao DOUBLE NOT NULL,
    cliente_id_cliente_pk INT NOT NULL,
    Carro_Disponivel_id_carro_pk INT NOT NULL,

    PRIMARY KEY (id_locacao_pk),

    FOREIGN KEY (cliente_id_cliente_pk)
        REFERENCES cliente(id_cliente_pk),

    FOREIGN KEY (Carro_Disponivel_id_carro_pk)
        REFERENCES Carro_Disponivel(id_carro_pk)
);

CREATE TABLE parcela (
    id_parcela_pk INT NOT NULL AUTO_INCREMENT,
    NumeroDeParcelas_pk INT NOT NULL,
    DataDeVencimento_parcela DATE NOT NULL,
    status_parcela ENUM(
        'Pendente',
        'Pago',
        'Atrasado',
        'Cancelado'
    ) NOT NULL,

    locacao_id_locacao_pk INT NULL,
    compra_id_compra_pk INT NULL,

    PRIMARY KEY (id_parcela_pk),

    FOREIGN KEY (locacao_id_locacao_pk)
        REFERENCES locacao(id_locacao_pk),

    FOREIGN KEY (compra_id_compra_pk)
        REFERENCES compra(id_compra_pk),

    CONSTRAINT chk_parcela_origem CHECK (
        (
            locacao_id_locacao_pk IS NOT NULL
            AND compra_id_compra_pk IS NULL
        )
        OR
        (
            locacao_id_locacao_pk IS NULL
            AND compra_id_compra_pk IS NOT NULL
        )
    )
);

CREATE TABLE Reembolso (
    id_Reembolso_pk INT NOT NULL AUTO_INCREMENT,
    valor_Reembolso DOUBLE NOT NULL,
    DataSoli_Reembolso DATE NOT NULL,
    HoraSoli_Reembolso TIME NOT NULL,
    Data_Reembolso DATE NULL,
    Hora_Reembolso TIME NULL,

    compra_id_compra_pk INT NULL,
    locacao_id_locacao_pk INT NULL,

    PRIMARY KEY (id_Reembolso_pk),

    FOREIGN KEY (compra_id_compra_pk)
        REFERENCES compra(id_compra_pk),

    FOREIGN KEY (locacao_id_locacao_pk)
        REFERENCES locacao(id_locacao_pk),

    CONSTRAINT chk_reembolso_origem CHECK (
        (
            compra_id_compra_pk IS NOT NULL
            AND locacao_id_locacao_pk IS NULL
        )
        OR
        (
            compra_id_compra_pk IS NULL
            AND locacao_id_locacao_pk IS NOT NULL
        )
    )
);