drop database if exists proyectoFinal;
create database proyectoFinal;

use proyectoFinal;

create table Usuario(
	Nombre varchar(40) primary key,
    Contraseña varchar(40)not null,
	Nivel numeric(2)not null,
    UbicacionEntrenamiento varchar(100),
    entrenamiento varchar(40)
);
create table TipoEjercicio(
Nombre varchar(40)PRIMARY KEY);

create table ejercicios(
nombre varchar(40)PRIMARY KEY,
tipo varchar(40),
foreign key (tipo) references TipoEjercicio(Nombre) on delete cascade);

create table ejercicio(
nombre VARCHAR(60)primary key,
dificultad Varchar(40)not null,
gruposMusculares VARCHAR(40)not null,
tipoEjercicio VARCHAR(40)not null,
usaGoma boolean not null,
realizado boolean not null,
descripcion VARCHAR(200)not null
);
create table rutina(
descansoSg numeric(3),
fecha date,
USUARIO varchar(40),
foreign key (usuario) references usuario(nombre),
primary key(usuario,fecha)
);

create table ejercicios_rutina(

fechaRutina date,
usuario varchar(40),
nombreEjercicio varchar(40),
foreign key (usuario) references usuario(nombre),
foreign key (nombreEjercicio) references ejercicios(nombre)

);
