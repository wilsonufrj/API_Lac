/**
 * Author:  wilsonramos
 * Created: 14 de jan. de 2024
 */

CREATE TABLE market_list(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    description VARCHAR(100)
);

CREATE TABLE cart(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    id_market_list INT,

    FOREIGN KEY (id_market_list) REFERENCES market_list(id)
);

CREATE TABLE item(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    quantity FLOAT,
    unit_measurement VARCHAR(50),
    price FLOAT,
    id_cart INT,

    FOREIGN KEY (id_cart) REFERENCES cart(id)
);


INSERT INTO market_list(id,name,description) VALUES
(1,'pattern','list pattern of criation');

INSERT INTO cart(id,name,id_market_list) VALUES
(1,'Cesta básica',1),
(2,'Limpeza',1),
(3,'Proteínas',1),
(4,'Não essenciais',1);

INSERT INTO item(id,name,quantity,unit_measurement,price,id_cart) VALUES
(1,'arroz',5.0,'Kg',26.95,1),
(2,'feijão',4.0,'Kg',6.99,1),
(3,'óleo',3.0,'L',5.99,1),

(4,'sabonete',15.0,'unidade',1.09,2),
(5,'detergente',500.0,'mL',1.87,2),
(6,'pasta de dente',180.5,'g',5.98,2),

(7,'linguiça calabresa',0.712,'g',14.23,3),
(8,'contra file',3.202,'Kg',121.61,3),
(9,'coxa de frango',4.286,'Kg',25.59,3),

(10,'mostarda picante',220.0,'g',16.91,4),
(11,'mostarda com mel',220.0,'g',16.91,4),
(12,'ketchup',1.028,'Kg',13.39,4);