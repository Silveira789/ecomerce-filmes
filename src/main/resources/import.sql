-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

INSERT INTO endereco(
    numero, cep, cidade, estado, logradouro, nome, bairro, complemento
)
VALUES 
    (123, '77000-000', 'Palmas', 'TO', 'Rua das Flores', 'Casa Azul', 'Centro', 'kitnet 4'),
    (259, '77001-001', 'Gurupi', 'TO', 'Avenida dos Bandeirantes', 'Casa Verde', 'Jardim Bela Vista', 'Esquina com a Rua Principal'),
    (958, '77002-002', 'Araguaína', 'TO', 'Travessa das Oliveiras', 'Casa Amarela', 'Setor Norte', 'Ao lado da praça'),
    (202, '77003-003', 'Porto Nacional', 'TO', 'Rua das Águias', 'Casa Vermelha', 'Centro', 'Próximo à Escola Municipal'),
    (144, '77004-004', 'Paraíso do Tocantins', 'TO', 'Avenida das Rosas', 'Casa Rosa', 'Jardim Primavera', 'Próximo ao Supermercado'),
    (303, '77005-005', 'Colinas do Tocantins', 'TO', 'Alameda dos Ipês', 'Casa Lilás', 'Centro', 'Ao lado do Banco do Brasil'),
    (125, '77006-006', 'Palmas', 'TO', 'Rua das Flores', 'Casa Azul', 'Centro', 'kitnet 4'),
    (457, '77007-007', 'Gurupi', 'TO', 'Avenida dos Bandeirantes', 'Casa Verde', 'Jardim Bela Vista', 'Esquina com a Rua Principal'),
    (557, '77008-008', 'Araguaína', 'TO', 'Travessa das Oliveiras', 'Casa Amarela', 'Setor Norte', 'Ao lado da praça'),
    (106, '77009-009', 'Porto Nacional', 'TO', 'Rua das Águias', 'Casa Vermelha', 'Centro', 'Próximo à Escola Municipal'),
    (720, '77010-010', 'Paraíso do Tocantins', 'TO', 'Avenida das Rosas', 'Casa Rosa', 'Jardim Primavera', 'Próximo ao Supermercado'),
    (408, '77011-011', 'Colinas do Tocantins', 'TO', 'Alameda dos Ipês', 'Casa Lilás', 'Centro', 'Ao lado do Banco do Brasil');


INSERT INTO cliente (
    cpf, nome, email, listatelefones
)
VALUES
    ('111.111.111-11', 'Guilherme', 'guilherme@example.com', '{"1234567890", "9876543210"}'),
    ('222.222.222-22', 'Joao', 'bene@example.com', '{"1234567891", "9876543211"}'),
    ('333.333.333-33', 'Mauro', 'mauro@example.com', '{"1234567892", "9876543212"}'),
    ('444.444.444-44', 'Heitor', 'heitor@example.com', '{"1234567893", "9876543213"}'),
    ('555.555.555-55', 'Henrique', 'henrique@example.com', '{"1234567894", "9876543214"}'),
    ('666.666.666-66', 'Tales', 'tales@example.com', '{"1234567895", "9876543215"}'),
    ('777.777.777-77', 'Juliana', 'juliana@example.com', '{"1234567896", "9876543216"}'),
    ('888.888.888-88', 'Caroline', 'caroline@example.com', '{"1234567897", "9876543217"}'),
    ('999.999.999-99', 'Fernanda', 'fernanda@example.com', '{"1234567898", "9876543218"}');

INSERT INTO filme(
	preco, qtdNoestoque, nome, descricao, genero, duracao, AnoLancamento, direcao, TituloOriginal)
VALUES
    (15,3,'teste','descrição','t',2,1999,'Scot','Título Original');


INSERT INTO funcionario (matricula, cpf, telefone, nome, email)
VALUES
    ('123456', '111.111.111-11', '123456789', 'Guilherme', 'guilherme@example.com'),
    ('789012', '222.222.222-22', '987654321', 'Fernanda', 'fernanda@example.com');

INSERT INTO usuario (perfil, login, senha)
VALUES
    (1, 'cliente_guilherme', 'senha_cliente_guilherme'),
    (1, 'cliente_joao', 'senha_cliente_joao');

INSERT INTO usuario (perfil, login, senha)
VALUES 
(1, 'cliente_Guilherme', 'iI7lNRDd2XHaEHJdEqWfv/+Yg11T/nMHREEPt9ID2Bf3U9xYqq2Vfedyz+YZsTfXIfV13Sl4khIsP9kSF5JXIg=='),
(1, 'cliente_joao', '0CCUdVl6aTfE5XJzGrP2OAKnoXFJUBUQVouCYz1ebLjNIK4CHbXOHEgpnePX/FBbXmIeWPkQcSbn1hH0g8zqmg=='),
(1, 'cliente_mauro', 'MDJWphtfdXwlTa9XBXWObkLFpsB2X6bBgzJfdHxR527PdntyvQr34OkxsqTJyCOST5+p6UoGW5VK1YlcEpL2yA=='),
(1, 'cliente_heitor', 'bbkoG72xCIeM+5TONI15VERApwynQf256JHHvX6bkAve00r43+cXaOOVLBYk/Q3xnnjce/7/jsvSaTOHB8RadQ=='),
(1, 'cliente_henrique', 'VobPCVa6t0EWSzXmvjNz/1iyKtcnISau1orzafq2UZEflPtvY9IjE/XCSg4Eccw/ifM14KsdoqWy+ag1r0OWFg=='),
(1, 'cliente_tales', 'p8ItX6rwwJidND1MpqD3NKUf9RhkTfpPdm1wDSmRo7OCwriDXagTf6l31P7quFczVAyF10e0brn2GTmxkeOHpw=='),
(1, 'cliente_juliana', 'eXDI83GFbZNX/T98eh7z6w61WBm1j4q4kUvukIaQ0DNf1XOvlrJ8M6H9Fjhc5kMHmfPEe1wg7lFJiucWFf5xZg=='),
(1, 'cliente_caroline', 'JDc7L22Z7ln94hliWWH0N/mEA99zc7KattFbbr3+IZj6ZNgRQO5BqFtwxiv49oicjPgdH0cqAPnepACgjLqTMg=='),
(1, 'cliente_fernanda', 'GJT+Wolwvp3TaibJtfTCixQ6mXbWOH6Y5M3FWOYCN0Twh+kdjIn5wSD0eVKjqQbhdiue9w8mRPRgbquvOBp3fw==');

-- senha_funcionario_danilo
--    (2, 'funcionario_danilo', 'gz92jkTcveMCL5phxX4m8vcDbE7IwdfMYLEbCFjsd55e89YZ8XlOte2oYZKk9l+UgIR94tyzIt1wyI22/K1sdg=='),
-- senha_funcionario_david
--    (2, 'funcionario_david', '/1TvZJJL/8eyuJ8ktCm35K2ShjAQYM9dPzdDUwU8Fk2S5UMQlZ+AJI6ruk/VRwEB+6LISFzdAOVVQvhl0Owc3w==');

INSERT INTO cliente_usuario (id_cliente, id_usuario)
VALUES 
    -- Cliente Guilherme
    (1, 1),
    -- Cliente joao
    (2, 2),
    -- Cliente mauro
    (3, 3),
    -- Cliente Heitor
    (4, 4),
    -- Cliente Henrique
    (5, 5),
    -- Cliente tales
    (6, 6),
    -- Cliente juliana
    (7, 7),
    -- Cliente caroline
    (8, 8),
    -- Cliente Fernanda
    (9, 9);

--INSERT INTO funcionario_usuario (id_funcionario, id_usuario)
--VALUES
--    -- Funcionário Guilherme
--    (1, 10),
--    -- Funcionário Joao
--    (2, 11);

INSERT INTO cliente_endereco (id_cliente, id_endereco)
VALUES 
   -- Cliente Guilherme
    (1, 1),
    -- Cliente joao
    (2, 2),
    -- Cliente mauro
    (3, 3),
    -- Cliente Heitor
    (4, 4),
    -- Cliente Henrique
    (5, 5),
    -- Cliente tales
    (6, 6),
    -- Cliente juliana
    (7, 7),
    -- Cliente caroline
    (8, 8),
    -- Cliente Fernanda
    (9, 9);

--INSERT INTO funcionario_endereco (id_endereco, id_funcionario)
--VALUES
--    -- Funcionário Guilherme
--    (10, 1),
--    -- Funcionário João
--    (11, 2);

-- INSERT INTO cartao(
--     bandeira_cartao, data_vencimento, tipo_cartao, banco, cod_verificacao, nome_titular, numero)
-- VALUES 
--     (1, '2028-04-01', 1, 'Banco do Brasil', '123', 'João Silva', '1234567890123456'),
--     (2, '2028-05-01', 1, 'Bradesco', '456', 'Maria Souza', '2345678901234567'),
--     (3, '2029-06-01', 1, 'Caixa Econômica Federal', '789', 'José Santos', '3456789012345678'),
--     (1, '2030-07-01', 1, 'Itaú', '012', 'Ana Oliveira', '4567890123456789'),
--     (2, '2031-08-01', 1, 'Santander', '345', 'Carlos Lima', '5678901234567890'),
--     (3, '2032-09-01', 1, 'Nubank', '678', 'Amanda Costa', '6789012345678901'),
--     (1, '2033-10-01', 1, 'Inter', '901', 'Marcos Pereira', '7890123456789012'),
--     (2, '2034-11-01', 1, 'PicPay', '234', 'Laura Fernandes', '8901234567890123'),
--     (3, '2035-12-01', 1, 'Banco do Nordeste', '567', 'Fernando Oliveira', '9012345678901234'),
--     (1, '2036-01-01', 1, 'Banrisul', '890', 'Carla Rodrigues', '0123456789012345'),
--     (2, '2037-02-01', 1, 'HSBC', '123', 'Mariana Silva', '1234567890123456'),
--     (3, '2038-03-01', 1, 'BNDES', '456', 'Rafael Souza', '2345678901234567'),
--     (1, '2039-04-01', 1, 'Banestes', '789', 'Camila Santos', '3456789012345678'),
--     (2, '2040-05-01', 1, 'Banpará', '012', 'Guilherme Oliveira', '4567890123456789'),
--     (3, '2041-06-01', 1, 'Banco Central do Brasil', '345', 'Ana Paula Lima', '5678901234567890');

-- INSERT INTO cliente_cartao (id_cartao, id_cliente)
-- VALUES 
--     (1, 1),
--     (2, 2),
--     (3, 3),
--     (4, 4),
--     (5, 5),
--     (6, 6),
--     (7, 7),
--     (8, 8),
--     (9, 9),
--     (10, 1),
--     (11, 2),
--     (12, 3),
--     (13, 4),
--     (14, 5),
--     (15, 6);