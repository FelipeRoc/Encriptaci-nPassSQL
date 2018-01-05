# Crear base de datos.
CREATE DATABASE Ejercicios character set utf8
collate utf8_general_ci;

# Crear tabla.
CREATE TABLE usuario_ejercicio(
	Usuario varchar(100) not null,
	Contrasena blob not null
);

#Insetar datos usuario y contraseña encriptada.
INSERT INTO `usuario_ejercicio`(Usuario, Contrasena) VALUES ("Falsin", AES_ENCRYPT("pass1234",'clave1')); #AES_ENCRYPT para encriptar dato, 'clave1' password necesario para encriptar.
INSERT INTO `usuario_ejercicio`(Usuario, Contrasena) VALUES ("pames", AES_ENCRYPT("pass1234",'clave1'));

#Desencriptación del dato.
SELECT AES_DECRYPT(Contrasena,'clave1') AS pass FROM `usuario_ejercicio`;

SELECT *FROM `usuario_ejercicio`;

TRUNCATE `usuario_ejercicio`;