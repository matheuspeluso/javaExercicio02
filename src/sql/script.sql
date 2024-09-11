-- SCRIPT PARA CRIAÇÃO DA TABELA DE ALUNO
CREATE TABLE aluno (
    idAluno     SERIAL          PRIMARY KEY,
    nome        VARCHAR(250)    NOT NULL,
    matricula   VARCHAR(50)     NOT NULL,
    cpf         VARCHAR(14)     NOT NULL
);
