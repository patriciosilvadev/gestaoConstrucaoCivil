CREATE TABLE chamado.mensagem (
	id int8 NOT NULL,
	arquivo int2 NULL,
	data timestamp NULL,
	texto varchar(255) NULL,
	id_chamado int8 NULL,
	id_usuario int8 NULL,
	CONSTRAINT mensagem_pkey PRIMARY KEY (id)
	 
)