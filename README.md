# TrabalhoPOO

> Script's:

```
CREATE SCHEMA TRABALHOPOO;

CREATE TABLE FUNCIONARIOS (
                 ID INT AUTO_INCREMENT PRIMARY KEY,
                 NOME VARCHAR(50),
                 IDADE INT,
                 SALARIO DECIMAL(10,2),
                 CARGO VARCHAR(30)
                 );
```

> Insert

```
INSERT INTO funcionarios (NOME, IDADE, SALARIO, CARGO)
VALUES ('Funcionario1', 20, 1200.00, 'Desenvolvedor'),
       ('Funcionario2', 21, 1300.00, 'Desenvolvedor'),
       ('Funcionario3', 22, 1400.00, 'Gerente'),
       ('Funcionario4', 23, 1500.00, 'Estagiário'),
       ('Funcionario5', 24, 1600.00, 'Estagiário');
```
