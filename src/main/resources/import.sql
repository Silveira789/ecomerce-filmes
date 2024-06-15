-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

INSERT INTO endereco(numero, cep, cidade, estado, logradouro, nome, bairro, complemento)
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
    ('111.111.111-11', 'André', 'andre@example.com', '{"1234567890", "9876543210"}'),
    ('222.222.222-22', 'Bene', 'bene@example.com', '{"1234567891", "9876543211"}'),
    ('333.333.333-33', 'Hirosh', 'hirosh@example.com', '{"1234567892", "9876543212"}'),
    ('444.444.444-44', 'Heitor', 'heitor@example.com', '{"1234567893", "9876543213"}'),
    ('555.555.555-55', 'Henrique', 'henrique@example.com', '{"1234567894", "9876543214"}'),
    ('666.666.666-66', 'Junin', 'junin@example.com', '{"1234567895", "9876543215"}'),
    ('777.777.777-77', 'Maria do Socorro', 'maria@example.com', '{"1234567896", "9876543216"}'),
    ('888.888.888-88', 'Aline', 'aline@example.com', '{"1234567897", "9876543217"}'),
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
    (1, 'cliente_andre', 'senha_cliente_andre');

-- INSERT INTO cliente_usuario (id_cliente, id_usuario)
-- VALUES 
--     -- Cliente André
--     (1, 1),
--     -- Cliente Bene
--     (2, 2),
--     -- Cliente Hirosh
--     (3, 3),
--     -- Cliente Heitor
--     (4, 4),
--     -- Cliente Henrique
--     (5, 5),
--     -- Cliente Junin
--     (6, 6),
--     -- Cliente Maria do Socorro
--     (7, 7),
--     -- Cliente Aline
--     (8, 8),
--     -- Cliente Fernanda
--     (9, 9);

-- INSERT INTO funcionario_usuario (id_funcionario, id_usuario)
-- VALUES 
--     -- Funcionário Daniel
--     (1, 10),
--     -- Funcionário Jacare
--     (2, 11);

-- INSERT INTO cliente_endereco (id_cliente, id_endereco)
-- VALUES 
--     -- Cliente André
--     (1, 1),
--     -- Cliente Bene
--     (2, 2),
--     -- Cliente Hirosh
--     (3, 3),
--     -- Cliente Heitor
--     (4, 4),
--     -- Cliente Henrique
--     (5, 5),
--     -- Cliente Junin
--     (6, 6),
--     -- Cliente Maria do Socorro
--     (7, 7),
--     -- Cliente Aline
--     (8, 8),
--     -- Cliente Fernanda
--     (9, 9);

-- INSERT INTO funcionario_endereco (id_endereco, id_funcionario)
-- VALUES 
--     -- Funcionário Daniel
--     (10, 1),
--     -- Funcionário Jacare
--     (11, 2);

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