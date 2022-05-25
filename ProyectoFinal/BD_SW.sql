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
SELECT * FROM Usuario;
Delete FROM USUARIO where UbicacionEntrenamiento = 'Malaga';
create table TipoEjercicio(
Nombre varchar(40)PRIMARY KEY);

INSERT into TipoEjercicio values('FRONT_LEVER');
INSERT into TipoEjercicio values('PLANCHA');
INSERT into TIpoEjercicio values('FREESTYLE');
INSERT into TipoEjercicio values('TIRON');
INSERT into TipoEjercicio values('EMPUJE');
INSERT into TipoEjercicio values('MOVILIDAD');
INSERT into TipoEjercicio values('HANDSTAND');
INSERT into TipoEjercicio values('FLAG');

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
realizado boolean default(false)not null
);
create table rutina(
id_rutina numeric(3)primary key,
descansoSg numeric(3),
fecha date
);
drop table ejercicio;

create table ejercicios_rutina(
id_rutina numeric(3)primary key,
nombre varchar(60),
CONSTRAINT rutina_ejercicio_fk   FOREIGN key  (id_rutina)references rutina(id_rutina)ON DELETE CASCADE,
CONSTRAINT nombre_ejercicio_fk   FOREIGN key  (nombre)references ejercicio(nombre)ON DELETE CASCADE
);
