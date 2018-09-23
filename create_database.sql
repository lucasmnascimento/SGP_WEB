-- Script de criação de Banco
-- ========== v0.2 ===========
-- * Adicionado novos índices (PK e FK obrigatório para todas tabelas)
-- * Criado sequenciais (SERIAL) para todas pks de tabelas

CREATE DATABASE SGP;

--
-- ========== Criação de ENUMs ==========
--

CREATE TYPE ambientevendas_cliente AS ENUM (
    'RUA',
    'SHOPPING',
    'VIRTUAL',
    'OUTROS'
);

CREATE TYPE canalvendas_cliente AS ENUM (
    'SAPATARIA',
    'ESPORTIVO',
    'MAGAZINE',
    'BOUTIQUE',
    'E-COMMERCE',
    'OUTROS'
);

CREATE TYPE fxclassificacao_produto AS ENUM (
    'P1',
	'P2',
	'P3',
	'P4',
	'P5'
);

CREATE TYPE cargo_representante AS ENUM (
    'REPRESENTANTE COMERCIAL',
    'ASSISTENTE DE VENDAS',
    'GERENTE COMERCIAL'
);

CREATE TYPE categoria_cliente AS ENUM (
    'DIAMANTE',
    'OURO',
    'PRATA',
    'BRONZE'
);

CREATE TYPE categoria_produto AS ENUM (
    'ACTIVE',
    'FITNESS',
    'RUNNING',
    'CLASSICO',
    'LIFESTYLE',
    'KIDS',
    'CASUAL',
    'TRAINING',
    'VESTUARIO',
    'ACESSORIO'
);

CREATE TYPE classificacaoabc_cliente AS ENUM (
    'TOP',
    'A',
    'B',
    'C'
);

CREATE TYPE cor_produto AS ENUM (
    'PRETO/LARANJA',
    'AZUL/VERDE',
    'PRETO/VERMELHO',
    'AZUL MARINHO',
    'PRETO',
    'BRANCO',
    'AZUL/ROSA',
    'ROSA',
    'VERDE/ROXO'
);

CREATE TYPE genero_produto AS ENUM (
    'MASCULINO',
    'FEMININO',
    'UNISSEX'
);

CREATE TYPE nivelacesso_representante AS ENUM (
    'admin',
    'readonly',
    'readwrite',
    'manager'
);

CREATE TYPE status_exclusao AS ENUM (
    'ATIVO',
    'INATIVO'
);

CREATE TYPE tipo_evento AS ENUM (
    'SHOWROOM',
    'REUNIAO',
    'ALMOÇO',
    'CONVENCAO',
    'FEIRA REGIONAL',
    'CAMPANHA DE VENDA',
    'ACAO DE MARKETING'
);

--
-- ========== Criação de Tabelas ==========
--

CREATE TABLE balanco (
    idbalanco SERIAL NOT NULL PRIMARY KEY,
    idcliente integer NOT NULL,
    periodo date,
    status status_exclusao,
	FOREIGN KEY (idcliente) REFERENCES Cliente(idcliente)
);

CREATE TABLE cliente (
    idcliente SERIAL NOT NULL PRIMARY KEY,
    idrepresentante integer,
    nomefantasia varchar(50) NOT NULL,
    classificacaoabc classificacaoabc_cliente,
    categoria categoria_cliente,
    ambientevendas ambientevendas_cliente,
    canalvendas canalvendas_cliente,
    logo varchar(50),
    razaosocial varchar(50) NOT NULL,
    cnpj integer NOT NULL,
    quantidadelojas integer NOT NULL,
    logradouro varchar(75),
    numero integer,
    complemento varchar(50),
    bairro varchar(25),
    cidade varchar(25),
    estado varchar(25),
    cep integer,
    outrasinformacoes varchar(200),
    status status_exclusao NOT NULL
);

CREATE TABLE contatocliente (
    idcontatocliente SERIAL NOT NULL PRIMARY KEY,
    idcliente integer,
    nome varchar(50) NOT NULL,
    cargo varchar(30) NOT NULL,
    email varchar(50),
    telefone integer,
    status status_exclusao NOT NULL,
	FOREIGN KEY (idcliente) references Cliente(idcliente)
);

CREATE TABLE evento (
    idevento SERIAL NOT NULL PRIMARY KEY,
    idrepresentante integer,
    idcliente integer,
    nomevento varchar(50) NOT NULL,
    tipo tipo_evento NOT NULL,
    datainicio date NOT NULL,
    datafim date NOT NULL,
    horainicio varchar(5) NOT NULL,
	horafim varchar(5) NOT NULL,
    investimento double precision,
    descricao varchar(250),
    vendarealizada integer,
    status status_exclusao NOT NULL,
	FOREIGN KEY (idrepresentante) references RepresentanteComercial(idrepresentante),
	FOREIGN KEY (idcliente) references Cliente(idcliente)
);

CREATE TABLE eventocliente (
    ideventocliente SERIAL NOT NULL PRIMARY KEY,
    idcliente integer NOT NULL,
    idevento integer NOT NULL,
	FOREIGN KEY (idevento) references Evento(idevento), 
	FOREIGN KEY (idcliente) references Cliente(idcliente)
);

CREATE TABLE eventorepresentante (
    ideventorepresentante SERIAL NOT NULL PRIMARY KEY,
    idrepresentante integer NOT NULL,
    idevento integer NOT NULL,
	FOREIGN KEY (idevento) references Evento(idevento), 
	FOREIGN KEY (idrepresentante) references RepresentanteComercial(idrepresentante)
);

CREATE TABLE itembalanco (
    iditembalanco SERIAL NOT NULL PRIMARY KEY,
    idbalanco integer NOT NULL,
    idproduto integer NOT NULL,
    quantidadevenda integer NOT NULL,
    quantidadeestoque integer NOT NULL,
	OREIGN KEY (idbalanco) REFERENCES Balanco(idbalanco),
	FOREIGN KEY (idproduto) REFERENCES Produto(idproduto)
);

CREATE TABLE produto (
    idproduto SERIAL NOT NULL PRIMARY KEY,
    nome varchar(40) NOT NULL,
    codigo varchar(8) NOT NULL,
    cor cor_produto NOT NULL,
    foto varchar(50),
    fxclassificacao fxclassificacao_produto NOT NULL,
    genero genero_produto NOT NULL,
    status status_exclusao NOT NULL,
    categoria categoria_produto,
    precovendo double precision
);

CREATE TABLE quadroswot (
    idquadro SERIAL NOT NULL PRIMARY KEY,
    idcliente integer NOT NULL,
    pontosfortes varchar(200),
    pontosfracos varchar(200),
    ameacas varchar(200),
    oportunidades varchar(200),
	FOREIGN KEY (idcliente) REFERENCES Cliente(idcliente)
);

CREATE TABLE representantecomercial (
    idrepresentante SERIAL NOT NULL PRIMARY KEY,
    nome varchar(50) NOT NULL,
    foto varchar(50),
    email varchar(50),
    cargo cargo_representante NOT NULL,
    nivelacesso nivelacesso_representante NOT NULL,
    login varchar(25) NOT NULL,
    senha varchar(50) NOT NULL,
    status status_exclusao NOT NULL
);


-- ========== Criação de Índices ==========

CREATE UNIQUE INDEX uniq_balanco ON balanco (idbalanco, idcliente);

CREATE UNIQUE INDEX uniq_contatocliente ON contatocliente (idcontatocliente, idcliente);

CREATE UNIQUE INDEX uniq_evento ON evento (idevento, idcliente, idrepresentante);

CREATE UNIQUE INDEX uniq_eventocliente ON cliente (ideventocliente, idevento, idcliente);

CREATE UNIQUE INDEX uniq_eventorepresentante ON cliente (ideventorepresentante, idevento, idrepresentante);

CREATE UNIQUE INDEX uniq_itembalanco ON cliente (iditembalanco, idbalanco, idproduto);

CREATE UNIQUE INDEX uniq_quadroswot ON cliente (idquadroswot, idcliente);

CREATE UNIQUE INDEX uniq_cliente ON cliente (idcliente);

CREATE UNIQUE INDEX uniq_produto ON produto (idproduto);

CREATE UNIQUE INDEX uniq_representantecomercial ON representantecomercial (idrepresentante);



