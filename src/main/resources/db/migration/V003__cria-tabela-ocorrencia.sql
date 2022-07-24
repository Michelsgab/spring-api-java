CREATE TABLE ocorrencia (
	id SERIAL NOT NULL PRIMARY KEY,
	entrega_id INT NOT NULL,
	descricao TEXT NOT NULL,
	data_registro DATE NOT NULL
);

ALTER TABLE ocorrencia ADD CONSTRAINT fk_ocorrencia_entrega
FOREIGN KEY (entrega_id) REFERENCES entrega (id);