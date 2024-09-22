-- Creación de la base de datos
create database restaurant_management;
   use restaurant_management;

-- Creación de la tabla Plato
create table Plato (
       id int auto_increment primary key,
       nombre varchar(100) not null ,
       precio decimal(10, 2) not null ,
       disponibilidad boolean not null 
   );

-- Creación de la tabla Mesa
create table Mesa (
       id int auto_increment primary key,
       numero_mesa int not null unique,
       ocupada boolean not null 
   );