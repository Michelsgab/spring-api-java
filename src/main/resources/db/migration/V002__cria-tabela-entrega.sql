CREATE TABLE entrega (
	id SERIAL PRIMARY KEY NOT NULL,
	cliente_id INT NOT NULL,
	taxa DECIMAL NOT NULL,
	status VARCHAR(20) NOT NULL,
	data_pedido DATE NOT NULL,
	data_finalizacao DATE,
	
	destinatario_nome VARCHAR(60) NOT NULL,
	destinatario_logradouro VARCHAR(255) NOT NULL,
	destinatario_numero VARCHAR(30) NOT NULL,
	destinatario_complemento VARCHAR(60) NOT NULL,
	destinatario_bairro VARCHAR(30) NOT NULL
);


ALTER TABLE entrega ADD CONSTRAINT fk_entrega_cliente
FOREIGN KEY (cliente_id) REFERENCES cliente (id);