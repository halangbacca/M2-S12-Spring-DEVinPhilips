CREATE TABLE usuarios
(
    id              bigint       not null auto_increment,
    cpf             varchar(100) not null unique,
    data_nascimento date not null,
    email           varchar(100) not null,
    estado_civil    varchar(100) not null,
    genero          varchar(100) not null,
    naturalidade    varchar(100) not null,
    nome            varchar(100) not null,
    rg              varchar(100) not null,
    telefone        varchar(100) not null,
    crm             varchar(100)   not null,
    especialidade   varchar(100) not null,
    senha           varchar(100) not null,

    primary key (id)
);

CREATE TABLE enderecos
(
    id               bigint       not null auto_increment,
    bairro           varchar(100) not null,
    cep              varchar(100) not null,
    cidade           varchar(100) not null,
    complemento      varchar(100),
    estado           varchar(100) not null,
    logradouro       varchar(100) not null,
    numero           integer(10)  not null,
    ponto_referencia varchar(100),

    primary key (id)
);

CREATE TABLE pacientes
(
    id                    bigint       not null auto_increment,
    cpf                   varchar(100) not null unique,
    data_nascimento       date not null,
    email                 varchar(100) not null,
    estado_civil          varchar(100) not null,
    genero                varchar(100) not null,
    naturalidade          varchar(100) not null,
    nome                  varchar(100) not null,
    rg                    varchar(100) not null,
    telefone              varchar(100) not null,
    alergias              varchar(100),
    contato_de_emergencia varchar(100) not null,
    convenio              varchar(100),
    cuidados_especificos  varchar(100),
    numero_convenio       varchar(100),
    validade_convenio     date,
    endereco_id           bigint       not null,

    primary key (id),
    foreign key (endereco_id) REFERENCES enderecos (id)
);

CREATE TABLE consultas
(
    id          bigint       not null auto_increment,
    data_hora   datetime not null,
    descricao   varchar(100) not null,
    dosagem     varchar(100) not null,
    medicacao   varchar(100) not null,
    motivo      varchar(100) not null,
    usuario_id  bigint       not null,
    paciente_id bigint       not null,

    primary key (id),
    foreign key (usuario_id) REFERENCES usuarios (id),
    foreign key (paciente_id) REFERENCES pacientes (id)
);

CREATE TABLE exames
(
    id          bigint       not null auto_increment,
    data_hora   datetime not null,
    laboratorio varchar(100) not null,
    nome        varchar(100) not null,
    pdf         varchar(100),
    resultados  varchar(100) not null,
    tipo        varchar(100) not null,
    usuario_id  bigint       not null,
    paciente_id bigint       not null,

    primary key (id),
    foreign key (usuario_id) REFERENCES usuarios (id),
    foreign key (paciente_id) REFERENCES pacientes (id)
);