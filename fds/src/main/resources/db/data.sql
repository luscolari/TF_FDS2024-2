INSERT INTO clientebd (codigo,email,nome) VALUES (1,'lusa@dell','Lusa');
INSERT INTO clientebd (codigo,email,nome) VALUES (2,'altemir@yahoo','Altemir');

INSERT INTO aplicativobd (codigo,nome,custo_mensal) VALUES (1,'Zap-Zap','1999.00');
INSERT INTO aplicativobd (codigo,nome,custo_mensal) VALUES (2,'Zop-Zop','1000.00');

INSERT INTO assinaturabd (aplicativo_codigo,cliente_codigo,codigo,fim_vigencia,inicio_vigencia) VALUES (1, 1, 1, '24/11/2025', '24/11/2024');
INSERT INTO assinaturabd (aplicativo_codigo,cliente_codigo,codigo,fim_vigencia,inicio_vigencia) VALUES (1, 2, 2, '24/11/2025', '24/11/2024');
