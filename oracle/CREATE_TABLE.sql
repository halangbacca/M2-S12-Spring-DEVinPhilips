CREATE TABLE usuarios
(
    id              NUMBER GENERATED BY DEFAULT AS IDENTITY,
    cpf             VARCHAR2(128) NOT NULL UNIQUE,
    data_nascimento DATE          NOT NULL,
    email           VARCHAR2(128) NOT NULL,
    estado_civil    VARCHAR2(128) NOT NULL,
    genero          VARCHAR2(128) NOT NULL,
    naturalidade    VARCHAR2(128) NOT NULL,
    nome            VARCHAR2(128) NOT NULL,
    rg              VARCHAR2(128) NOT NULL,
    telefone        VARCHAR2(128) NOT NULL,
    crm             VARCHAR2(128) NOT NULL,
    especialidade   VARCHAR2(128) NOT NULL,
    senha           VARCHAR2(128) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE enderecos
(
    id               NUMBER GENERATED BY DEFAULT AS IDENTITY,
    bairro           VARCHAR2(128) NOT NULL,
    cep              VARCHAR2(128) NOT NULL,
    cidade           VARCHAR2(128) NOT NULL,
    complemento      VARCHAR2(128),
    estado           VARCHAR2(128) NOT NULL,
    logradouro       VARCHAR2(128) NOT NULL,
    numero           NUMBER        NOT NULL,
    ponto_referencia VARCHAR2(128),

    PRIMARY KEY (id)
);

CREATE TABLE pacientes
(
    id                    NUMBER GENERATED BY DEFAULT AS IDENTITY,
    cpf                   VARCHAR2(128) NOT NULL UNIQUE,
    data_nascimento       DATE          NOT NULL,
    email                 VARCHAR2(128) NOT NULL,
    estado_civil          VARCHAR2(128) NOT NULL,
    genero                VARCHAR2(128) NOT NULL,
    naturalidade          VARCHAR2(128) NOT NULL,
    nome                  VARCHAR2(128) NOT NULL,
    rg                    VARCHAR2(128) NOT NULL,
    telefone              VARCHAR2(128) NOT NULL,
    alergias              VARCHAR2(128),
    contato_de_emergencia VARCHAR2(128) NOT NULL,
    convenio              VARCHAR2(128),
    cuidados_especificos  VARCHAR2(128),
    numero_convenio       VARCHAR2(128),
    validade_convenio     DATE,
    endereco_id           NUMBER        NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (endereco_id) REFERENCES enderecos (id)
);

CREATE TABLE consultas
(
    id          NUMBER GENERATED BY DEFAULT AS IDENTITY,
    data_hora   TIMESTAMP     NOT NULL,
    descricao   VARCHAR2(128) NOT NULL,
    dosagem     VARCHAR2(128) NOT NULL,
    medicacao   VARCHAR2(128) NOT NULL,
    motivo      VARCHAR2(128) NOT NULL,
    usuario_id  NUMBER        NOT NULL,
    paciente_id NUMBER        NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
    FOREIGN KEY (paciente_id) REFERENCES pacientes (id)
);

CREATE TABLE exames
(
    id          NUMBER GENERATED BY DEFAULT AS IDENTITY,
    data_hora   TIMESTAMP     NOT NULL,
    laboratorio VARCHAR2(128) NOT NULL,
    nome        VARCHAR2(128) NOT NULL,
    pdf         VARCHAR2(128),
    resultados  VARCHAR2(128) NOT NULL,
    tipo        VARCHAR2(128) NOT NULL,
    usuario_id  NUMBER        NOT NULL,
    paciente_id NUMBER        NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
    FOREIGN KEY (paciente_id) REFERENCES pacientes (id)
);