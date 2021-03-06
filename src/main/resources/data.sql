DROP TABLE IF EXISTS USUARIO;
DROP TABLE IF EXISTS TIPO_CAMBIO;

CREATE TABLE TIPO_CAMBIO(
  id INT AUTO_INCREMENT,
  moneda_origen VARCHAR(3) NOT NULL,
  moneda_destino VARCHAR(3) NOT NULL,
  tipo_cambio DOUBLE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE USUARIO(
  id INT AUTO_INCREMENT,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO TIPO_CAMBIO VALUES(1,'PEN','USD',4.0696);

INSERT INTO TIPO_CAMBIO VALUES(2,'USD','PEN',4.0746);

INSERT INTO TIPO_CAMBIO VALUES(3,'PEN','EUR',4.914);

INSERT INTO TIPO_CAMBIO VALUES(4,'EUR','PEN',4.796);

INSERT INTO TIPO_CAMBIO VALUES(5,'USD','EUR',0.85);

INSERT INTO TIPO_CAMBIO VALUES(6,'EUR','USD',1.18);