CREATE SCHEMA gerenciadorcertificadodigital;

CREATE TABLE gerenciadorcertificadodigital.agentes (
    id serial NOT NULL,
    nomefantasia character varying(300),
    nome character varying(300),
    cpfcnpj character varying(20),
    logradouro character varying(100),
    complemento character varying(100),
    numero character varying(10),
    cep character varying(10),
    idmunicipio integer
);

CREATE TABLE gerenciadorcertificadodigital.certificados (
    id serial NOT NULL,
    validade date,
    emissao date,
    senha character varying(30),
    idagente integer,
    nomearquivo character varying(50),
    arquivo bytea
);

CREATE TABLE gerenciadorcertificadodigital.contatos (
    id serial NOT NULL,
    nome character varying(50),
    email character varying(70),
    telefone character varying(20),
    idagente integer
);

CREATE TABLE gerenciadorcertificadodigital.municipios (
    id serial NOT NULL,
    nome character varying(200),
    uf character varying(2)
);

CREATE TABLE gerenciadorcertificadodigital.teste (
    validade character varying(10),
    emissao character varying(10)
);