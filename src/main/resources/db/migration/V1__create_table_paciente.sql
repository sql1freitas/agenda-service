CREATE TABLE paciente (
	id serial PRIMARY KEY,
	nome varchar(50),
	sobrenome varchar(100),
	cpf varchar (15) unique,
	email varchar (100) unique
);