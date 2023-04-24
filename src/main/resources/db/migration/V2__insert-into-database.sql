# USUÁRIOS
INSERT INTO usuarios(cpf, data_nascimento, email, estado_civil, genero, naturalidade, nome, rg, telefone, crm,
                     especialidade, senha)
VALUES ("548.430.980-86", "1994-09-05", "pamela@outlook.com", "CASADO", "Feminino", "Blumenauense", "Pâmela Fraga",
        "27.618.316-2", "(11) 62384-2885", "555/SP", "ORTOPEDIA", "qwe12345");

INSERT INTO usuarios(cpf, data_nascimento, email, estado_civil, genero, naturalidade, nome, rg, telefone, crm,
                     especialidade, senha)
VALUES ("313.624.040-55", "1990-05-10", "carlos@outlook.com", "SOLTEIRO", "Masculino", "Itajaiense", "Carlos Alberto",
        "28.301.432-5", "(11) 47465-7258", "777/SC", "NEUROLOGIA", "carlos54321");

# ENDEREÇOS
INSERT INTO enderecos (bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia)
VALUES ("São Vicente", "88309-000", "Itajaí", "Casa", "SC", "Rua São Joaquim", 137, "Em frente a panificadora");

INSERT INTO enderecos (bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia)
VALUES ("São Vicente", "88309-010", "Itajaí", "Casa", "SC", "Rua Abelardo Luz", 163, "Em frente ao mercado");

INSERT INTO enderecos (bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia)
VALUES ("Fazenda", "88302-520", "Itajaí", "Casa", "SC", "Rua Lúcio Correia de Mendonça", 439, "Próximo a igreja");

INSERT INTO enderecos (bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia)
VALUES ("Centro", "88302-201", "Itajaí", "Apartamento", "SC", "Rua Uruguai", 456, "Próximo a universidade");

# PACIENTES
INSERT INTO pacientes (cpf, data_nascimento, email, estado_civil, genero, naturalidade, nome, rg, telefone, alergias,
                       contato_de_emergencia, convenio, cuidados_especificos, numero_convenio, validade_convenio,
                       endereco_id)
VALUES ("047.648.760-94", "1963-12-05", "guilherme@outlook.com", "SOLTEIRO", "Masculino", "Tubaronense",
        "Guilherme Souza", "16.275.413-9", "(11) 73166-9289", "AAS", "(48) 41577-2751", "SUS", "Dieta especial", "5463",
        "2030-07-21", 1);

INSERT INTO pacientes (cpf, data_nascimento, email, estado_civil, genero, naturalidade, nome, rg, telefone, alergias,
                       contato_de_emergencia, convenio, cuidados_especificos, numero_convenio, validade_convenio,
                       endereco_id)
VALUES ("709.761.510-90", "1981-04-02", "daniel@outlook.com", "SOLTEIRO", "Masculino", "Balneocamboriuense",
        "Daniel Almeida", "48.808.201-8", "(48) 86053-5102", "Dipirona", "(48) 43306-4455", "UNIMED", "DPOC", "6532",
        "2025-03-10", 2);


# CONSULTAS
INSERT INTO consultas (data_hora, descricao, dosagem, medicacao, motivo, usuario_id, paciente_id)
VALUES ("2023-04-20 09:11:10", "Paciente teve contato com animais contaminados", "100mg/dia", "Itraconazol",
        "Suspeita de esporotricose humana", 1, 1);

INSERT INTO consultas (data_hora, descricao, dosagem, medicacao, motivo, usuario_id, paciente_id)
VALUES ("2023-04-21 10:11:10", "Paciente apresentava-se extremamente ansioso", "10mg/dia", "Oxalato de Escitalopram",
        "Transtorno de ansiedade", 1, 1);


INSERT INTO consultas (data_hora, descricao, dosagem, medicacao, motivo, usuario_id, paciente_id)
VALUES ("2023-04-15 15:11:10", "Paciente apresentava tosse e desconforto abdominal", "15 mg/kg/dia", "Albendazol",
        "Síndrome de Loeffler causado por Ascaris lumbricoides", 2, 2);


INSERT INTO consultas (data_hora, descricao, dosagem, medicacao, motivo, usuario_id, paciente_id)
VALUES ("2023-03-14 17:11:10", "Paciente com mialgia, febre e manchas no corpo", "Não se aplica",
        "Reposição volêmica",
        "Suspeita de dengue", 2, 2);

# EXAMES
INSERT INTO exames (data_hora, laboratorio, nome, pdf, resultados, tipo, usuario_id, paciente_id)
VALUES ("2023-04-20 09:11:10", "UNIMED", "Urocultura", "www.google.com", "Crescimento de Escherichia coli",
        "Microbiologia", 1, 1);

INSERT INTO exames (data_hora, laboratorio, nome, pdf, resultados, tipo, usuario_id, paciente_id)
VALUES ("2023-04-21 14:11:10", "São Lucas", "Hemograma", "www.facebook.com", "Microcitose++",
        "Hematologia", 1, 1);

INSERT INTO exames (data_hora, laboratorio, nome, pdf, resultados, tipo, usuario_id, paciente_id)
VALUES ("2023-04-19 17:15:00", "SUS", "RT-qPCR", "www.instagram.com", "Presença de material genético de SARS-CoV-2",
        "Biologia Molecular", 2, 2);

INSERT INTO exames (data_hora, laboratorio, nome, pdf, resultados, tipo, usuario_id, paciente_id)
VALUES ("2023-03-18 13:30:45", "SUS", "Parasitológico de fezes", "www.twitter.com",
        "Presença de cistos de Giardia lamblia",
        "Parasitologia", 2, 2);

