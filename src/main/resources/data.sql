-- Informacoes para popular o banco de dados
-- A estrutura inicial nao foi alterada, apenas foram acrescentadas novas tabelas e novos dados para popular o banco

CREATE TABLE conta
(
    id_conta IDENTITY NOT NULL PRIMARY KEY,
    nome_responsavel VARCHAR(50) NOT NULL
);


CREATE TABLE transferencia
(
    id IDENTITY NOT NULL PRIMARY KEY,
    data_transferencia TIMESTAMP WITH TIME ZONE NOT NULL,
    valor NUMERIC (20,2) NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    nome_operador_transacao VARCHAR (50),
    conta_id INT NOT NULL,

        CONSTRAINT FK_CONTA
        FOREIGN KEY (conta_id)
        REFERENCES conta(id_conta)
);


-- Acrescentado novas tabelas
CREATE TABLE dados_bancario
(
    conta_id IDENTITY NOT NULL PRIMARY KEY,
    agencia INT NOT NULL,
    conta_corrente INT NOT NULL,

        CONSTRAINT FK_CONTA_DADOS
        FOREIGN KEY (conta_id)
        REFERENCES conta(id_conta)
);



-- Acrescentado novos valores para popular o banco
INSERT INTO conta (id_conta, nome_responsavel) VALUES (1,'Fulano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (2,'Sicrano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (3,'Beltrano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (4,'Ronnyscley');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (5,'PADARIA do vovo');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (6,'POSTO de gasolina Petro');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (7,'RESTAURANTE Fogão a lenha');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (8,'PERFUMES boutique');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (9,'ROUPAS da moda');

INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (1, 27097, 302578);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (2, 25607, 653078);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (3, 28717, 456318);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (4, 23337, 441358);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (5, 28107, 597318);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (6, 21437, 322228);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (7, 25317, 321498);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (8, 25547, 312658);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (9, 26547, 344678);

INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (1,'2019-01-01 12:00:00+03',30895.46,'DEPOSITO', null, 1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (2,'2019-02-03 09:53:27+03',12.24,'DEPOSITO', null,2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (3,'2019-05-04 08:12:45+03',-500.50,'SAQUE', null,1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (4,'2019-08-07 08:12:45+03',-530.50,'SAQUE', null,2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (5,'2020-06-08 10:15:01+03',3241.23,'TRANSFERENCIA', 'Beltrano',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (6,'2021-04-01 12:12:04+03',25173.09,'TRANSFERENCIA', 'Ronnyscley',2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (7,'2019-01-05 12:10:01+03',-1500.00,'TRANSFERENCIA','Beltrano',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (8,'2019-02-05 12:22:03+03',-1500.00,'TRANSFERENCIA','Beltrano',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (9,'2019-03-06 11:55:08+03',-1500.00,'TRANSFERENCIA','Beltrano',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (10,'2019-04-04 12:10:01+03',-1500.00,'TRANSFERENCIA','Beltrano',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (11,'2019-05-05 12:12:22+03',-1500.00,'TRANSFERENCIA','Beltrano',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (12,'2019-06-06 12:38:11+03',-1500.00,'TRANSFERENCIA','Beltrano',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (13,'2019-01-06 08:01:05+03',-5.55,'CARTAO','PADARIA do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (14,'2019-01-07 08:02:15+03',-4.72,'CARTAO','PADARIA do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (15,'2019-01-08 08:03:55+03',-9.99,'CARTAO','PADARIA do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (16,'2019-01-09 08:12:13+03',-12.55,'CARTAO','PADARIA do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (17,'2019-01-13 07:55:12+03',-13.91,'CARTAO','PADARIA do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (18,'2019-01-14 08:12:07+03',-5.01,'CARTAO','PADARIA do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (19,'2019-01-15 08:01:05+03',-15.91,'CARTAO','PADARIA do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (20,'2019-01-16 08:01:08+03',-12.05,'CARTAO','PADARIA do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (21,'2019-01-19 7:58:59+03',-11.15,'CARTAO','PADARIA do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (22,'2019-01-15 8:25:59+03',-79.22,'PIX','POSTO de gasolina Petro',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (23,'2019-02-14 8:22:51+03',-153.77,'PIX','POSTO de gasolina Petro',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (24,'2019-03-15 8:28:09+03',-151.15,'PIX','POSTO de gasolina Petro',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (25,'2019-04-16 8:28:51+03',-148.55,'PIX','POSTO de gasolina Petro',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (26,'2019-01-06 12:01:05+03',-21.51,'CARTAO','RESTAURANTE Fogão a lenha',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (27,'2019-01-07 12:02:15+03',-23.99,'CARTAO','RESTAURANTE Fogão a lenha',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (28,'2019-01-08 12:03:55+03',-35.51,'CARTAO','RESTAURANTE Fogão a lenha',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (29,'2019-01-09 12:12:13+03',-28.97,'CARTAO','RESTAURANTE Fogão a lenha',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (30,'2019-01-13 12:55:12+03',-21.15,'CARTAO','RESTAURANTE Fogão a lenha',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (31,'2019-01-14 12:12:07+03',-28.51,'CARTAO','RESTAURANTE Fogão a lenha',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (32,'2019-01-15 12:01:05+03',-26.31,'CARTAO','RESTAURANTE Fogão a lenha',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (33,'2019-01-16 12:01:08+03',-21.55,'CARTAO','RESTAURANTE Fogão a lenha',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (34,'2019-01-19 12:58:59+03',-23.19,'CARTAO','RESTAURANTE Fogão a lenha',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (35,'2019-01-06 17:15:12+03',-301.5,'TRANSFERENCIA','PERFUMES boutique',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (36,'2019-03-7 18:12:01+03',-325.99,'TRANSFERENCIA','PERFUMES boutique',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (37,'2019-02-15 21:18:22+03',-399.99,'PIX','ROUPAS da moda',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (38,'2019-01-05 00:00:00+03',2500.00,'TRANSFERENCIA','Ronnyscley',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (39,'2019-02-05 00:00:00+03',2500.00,'TRANSFERENCIA','Ronnyscley',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (40,'2019-03-05 00:00:00+03',2500.00,'TRANSFERENCIA','Ronnyscley',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (41,'2019-04-05 00:00:00+03',2500.00,'TRANSFERENCIA','Ronnyscley',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (42,'2019-05-05 00:00:00+03',2500.00,'TRANSFERENCIA','Ronnyscley',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (43,'2019-06-05 00:00:00+03',2500.00,'TRANSFERENCIA','Ronnyscley',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (44,'2019-07-05 00:00:00+03',2500.00,'TRANSFERENCIA','Ronnyscley',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (45,'2019-01-08 12:22:23+03',-250.00,'SAQUE',null,1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (46,'2019-02-09 12:34:37+03',-250.00,'SAQUE',null,1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (47,'2019-03-08 12:41:51+03',-250.00,'SAQUE',null,1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (48,'2019-04-09 12:32:28+03',-250.00,'SAQUE',null,1);