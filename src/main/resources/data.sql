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

CREATE TABLE saldo
(
    conta_id IDENTITY NOT NULL PRIMARY KEY,
    saldo NUMERIC NOT NULL,

        CONSTRAINT FK_CONTA_SALDo
        FOREIGN KEY (conta_id)
        REFERENCES conta(id_conta)
);



-- Acrescentado novos valores para popular o banco
INSERT INTO conta (id_conta, nome_responsavel) VALUES (1,'Fulano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (2,'Sicrano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (3,'Beltrano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (4,'Ronnyscley');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (5,'Padaria do vovo');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (6,'Posto Petro');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (7,'Fogao a lenha');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (8,'Perfumes boutique');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (9,'Roupas da moda');

INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (1, 27097, 302578);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (2, 25607, 653078);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (3, 28717, 456318);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (4, 23337, 441358);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (5, 28107, 597318);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (6, 21437, 322228);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (7, 25317, 321498);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (8, 25547, 312658);
INSERT INTO dados_bancario (conta_id, agencia, conta_corrente) VALUES (9, 26547, 344678);

INSERT INTO saldo (conta_id, saldo) VALUES (1, 808.54);
INSERT INTO saldo (conta_id, saldo) VALUES (2, 27154.83);
INSERT INTO saldo (conta_id, saldo) VALUES (3, 2494.45);
INSERT INTO saldo (conta_id, saldo) VALUES (4, 2416.06);
INSERT INTO saldo (conta_id, saldo) VALUES (5, 2324.72);
INSERT INTO saldo (conta_id, saldo) VALUES (6, 2324.86);
INSERT INTO saldo (conta_id, saldo) VALUES (7, 2464.49);
INSERT INTO saldo (conta_id, saldo) VALUES (8, -50.12);
INSERT INTO saldo (conta_id, saldo) VALUES (9, -28.51);

INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (1,'2022-07-01 12:00:00+03',6895.46,'DEPOSITO', 'IMPOSTO', 1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (2,'2022-08-03 09:53:27+03',12.24,'DEPOSITO', 'IMPOSTO', 2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (3,'2022-11-04 08:12:45+03',-500.50,'SAQUE', '-', 1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (4,'2022-08-07 08:12:45+03',-530.50,'SAQUE', '-', 2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (5,'2020-12-08 10:15:01+03',3241.23,'TRANSFERENCIA', 'Beltrano',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (6,'2021-10-01 12:12:04+03',25173.09,'TRANSFERENCIA', 'Ronnyscley',2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (7,'2022-07-05 12:10:01+03',-1500.00,'TRANSFERENCIA','Beltrano',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (8,'2022-08-05 12:22:03+03',-1500.00,'TRANSFERENCIA','Beltrano',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (9,'2022-09-06 11:55:08+03',-1500.00,'TRANSFERENCIA','Beltrano',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (10,'2022-10-04 12:10:01+03',-1500.00,'TRANSFERENCIA','Beltrano',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (11,'2022-11-05 12:12:22+03',-1500.00,'TRANSFERENCIA','Beltrano',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (12,'2022-12-06 12:38:11+03',-1500.00,'TRANSFERENCIA','Beltrano',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (13,'2022-07-06 08:01:05+03',-5.55,'CARTAO','Padaria do vovo',3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (14,'2022-07-07 08:02:15+03',-4.72,'CARTAO','Padaria do vovo',4);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (15,'2022-07-08 08:03:55+03',-9.99,'CARTAO','Padaria do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (16,'2022-07-09 08:12:13+03',-12.55,'CARTAO','Padaria do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (17,'2022-07-13 07:55:12+03',-13.91,'CARTAO','Padaria do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (18,'2022-07-14 08:12:07+03',-5.01,'CARTAO','Padaria do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (19,'2022-07-15 08:01:05+03',-15.91,'CARTAO','Padaria do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (20,'2022-07-16 08:01:08+03',-12.05,'CARTAO','Padaria do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (21,'2022-07-19 7:58:59+03',-11.15,'CARTAO','Padaria do vovo',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (22,'2022-07-15 8:25:59+03',-79.22,'PIX','Posto Petro',4);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (23,'2022-08-14 8:22:51+03',-153.77,'PIX','Posto Petro',5);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (24,'2022-09-15 8:28:09+03',-151.15,'PIX','Posto Petro',6);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (25,'2022-10-16 8:28:51+03',-148.55,'PIX','Posto Petro',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (26,'2022-07-06 12:01:05+03',-21.51,'CARTAO','Fogao a lenha',5);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (27,'2022-07-07 12:02:15+03',-23.99,'CARTAO','Fogao a lenha',6);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (28,'2022-07-08 12:03:55+03',-35.51,'CARTAO','Fogao a lenha',7);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (29,'2022-07-09 12:12:13+03',-28.97,'CARTAO','Fogao a lenha',8);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (30,'2022-07-13 12:55:12+03',-21.15,'CARTAO','Fogao a lenha',8);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (31,'2022-07-14 12:12:07+03',-28.51,'CARTAO','Fogao a lenha',9);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (32,'2022-07-15 12:01:05+03',-26.31,'CARTAO','Fogao a lenha',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (33,'2022-07-16 12:01:08+03',-21.55,'CARTAO','Fogao a lenha',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (34,'2022-07-19 12:58:59+03',-23.19,'CARTAO','Fogao a lenha',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (35,'2022-07-06 17:15:12+03',-301.5,'TRANSFERENCIA','Perfumes boutique',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (36,'2022-09-7 18:12:01+03',-325.99,'TRANSFERENCIA','Perfumes boutique',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (37,'2022-08-15 21:18:22+03',-399.99,'PIX','ROUPAS da moda',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (38,'2022-07-05 01:00:00+03',2500.00,'TRANSFERENCIA','Ronnyscley',1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (39,'2022-08-05 01:00:00+03',2500.00,'TRANSFERENCIA','Ronnyscley',2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (40,'2022-09-05 01:00:00+03',2500.00,'TRANSFERENCIA','Ronnyscley',3);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (41,'2022-10-05 01:00:00+03',2500.00,'TRANSFERENCIA','Ronnyscley',4);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (42,'2022-11-05 01:00:00+03',2500.00,'TRANSFERENCIA','Ronnyscley',5);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (43,'2022-12-05 01:00:00+03',2500.00,'TRANSFERENCIA','Ronnyscley',6);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (44,'2022-07-05 01:00:00+03',2500.00,'TRANSFERENCIA','Ronnyscley',7);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (45,'2022-07-08 12:22:23+03',-250.00,'SAQUE', '-', 1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (46,'2022-08-09 12:34:37+03',-250.00,'SAQUE', '-', 1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (47,'2022-09-08 12:41:51+03',-250.00,'SAQUE', '-', 1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (48,'2022-10-09 12:32:28+03',-250.00,'SAQUE', '-', 1);