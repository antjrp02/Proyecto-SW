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


create table ejercicios(
nombre VARCHAR(60)primary key,
dificultad Varchar(40)not null,
gruposMusculares VARCHAR(40)not null,
tipoEjercicio VARCHAR(40)not null,
usaGoma boolean not null,
estatico_o_dinamico VARCHAR(40),
descripcion VARCHAR(200)not null,
series numeric(2)not null
);

insert into Ejercicios values("dominada prona","principiante_intermedio","dorsal","tiron",false,"dinamico","dominada con las palmas de las manos hacia delante,haciendo un recorrido completo",0);
insert into Ejercicios values("dominada neutra","principiante_intermedio","dorsal","tiron",false,"dinamico","dominada usando dos barras paralelas a la altura de los hombros, las palmas de las manos estan una frente a la otra,haciendo un recorrido completo",0);
insert into Ejercicios values("dominada supina","principiante_intermedio","biceps","tiron",false,"dinamico","dominada con las palmas de las manos hacia detras,haciendo un recorrido completo",0);
insert into Ejercicios values("dominada abierta","principiante_intermedio","dorsal","tiron",false,"dinamico","dominada prona con una apertura mucho mayor a la altura de los hombros",0);
-- Ejercicios dinamicos con dificultad intermedio de tiron:
insert into Ejercicios values("slow dominada","intermedio","dorsal","tiron",false,"dinamico","dominada prona, muy lenta",0);
insert into Ejercicios values("remo en barra","intermedio","dorsal","tiron",false,"dinamico","Dominada con las canillas de los pies apolladas en la barra, tratando de llevar la cadera a la barra",0);
insert into Ejercicios values("dominada en L","intermedio","dorsal","tiron",false,"dinamico","dominada prona, con una flexion en la cadera de 90º, formando una L con el cuerpo",0);
insert into Ejercicios values("dominada en con palmada","intermedio","dorsal","tiron",false,"dinamico","dominada prona con una palmada al llevar la barra debajo de la barbilla",0);
insert into Ejercicios values("negativa de muscle up","intermedio","dorsal","tiron",false,"dinamico","partiendo con la barra en la cadera, aguantar la caida hasta llegar a tener los brazos bloqueados",0);
insert into Ejercicios values("muscle up con goma","intermedio","dorsal","tiron",true,"dinamico","muscle up, utilizando una goma en los pies para facilitar el ejercicio",0);

-- Ejercicios dinamicos con dificultad intermedio_avanzado de tiron
insert into Ejercicios values("dominada explosiva","intermedio_avanzado","dorsal","tiron",false,"dinamico","dominada prona tratando de llegar con la barra a la cadera en lugar de a la barbilla",0);
insert into Ejercicios values("muscle up","intermedio_avanzado","dorsal","tiron",false,"dinamico","partiendo de tener los brazos bloqueados, hacer una dominada explosiva, rotar las manos para hacer un fondo en barra y llegar a quedar arriba de la barra",0);
insert into Ejercicios values("muscle up en L","intermedio_avanzado","dorsal","tiron",false,"dinamico","muscle up, con el cuerpo en forma de L",0);
insert into Ejercicios values("muscle up explosivo","intermedio_avanzado","dorsal","tiron",false,"dinamico","muscle up separando las palmas de las manos de la barra al llegar arriba",0);
insert into Ejercicios values("muscle up con palmada","intermedio_avanzado","dorsal","tiron",false,"dinamico","muscle up haciendo una palmada al llegar arriba de la barra",0);


-- Ejercicios dinamicos con dificultad principiante de empuje:
insert into Ejercicios values("Flexion inclinada en barra","principiante","pecho","empuje",false,"dinamico","flexion con las manos en una barra con una altura desde la cintura hasta el suelo, mientra mas alta la barra, mas facil el ejercicio",0);
insert into Ejercicios values("Flexion con rodilla","principiante","pecho","empuje",false,"dinamico","flexion con las rodillas apolladas en el suelo",0);
insert into Ejercicios values("Fondo negativos","principiante","pecho","empuje",false,"dinamico","Fondo en paralelas haciendo un rago solo desde tener los brazos bloqueados hasta llegar a tener un angulo de 90ª en los codos",0);
insert into Ejercicios values("Fondo positivos","principiante","pecho","empuje",false,"dinamico","Fondo en paralelas haciendo un rago solo desde tener los brazos con un angulo de 90º hasta tenerlos bloqueados",0);
insert into Ejercicios values("Fondo con goma","principiante","pecho","empuje",true,"dinamico","Fondo en paralelas haciendo con una goma en los pies para ayudar a la realizacion del ejercicio",0);


-- Ejercicios dinamicos con dificultad principiante_intermedio de empuje:
insert into Ejercicios values("Flexion","principiante_intermedio","pecho","empuje",false,"dinamico","flexione libres en suelo",0);
insert into Ejercicios values("Flexion abierta","principiante_intermedio","deltoide","empuje",false,"dinamico","flexion libres en suelo con una amplia apertura en las manos",0);
insert into Ejercicios values("Flexion en diamante","principiante_intermedio","triceps","empuje",false,"dinamico","flexiones libres en suelo ,con las manos juntas haciendo un triangulo con los dedos",0);
insert into Ejercicios values("Flexion declinada","principiante_intermedio","pecho","empuje",false,"dinamico","flexiones libres en suelo con los pies en una superficie mas alta, haciendo un desnivel en el cuerpo incrementando la dificultad del ejercicio",0);
insert into Ejercicios values("Fondo","principiante_intermedio","pecho","empuje",false,"dinamico","fondo libre en paralelas",0);
insert into Ejercicios values("Fondo en barra","principiante_intermedio","triceps","empuje",false,"dinamico","fondo libre en barra",0);
-- Ejercicios dinamicos con dificultad intermedio de empuje:

insert into Ejercicios values("Flexion explosiva","intermedio","pecho","empuje",false,"dinamico","flexion libres en suelo levantando las manos al final de la subida",0);
insert into Ejercicios values("Flexion con palmada","intermedio","pecho","empuje",false,"dinamico","flexionelibres en suelo dando una palmada con las manos al final de la subida",0);
insert into Ejercicios values("Fondo explosivo","intermedio","pecho","empuje",false,"dinamico","fondo libre en paralelas despegando las manos de las paralelas al ifnal de la subida",0);
insert into Ejercicios values("Fondo en barra explosivo","intermedio","pecho","empuje",false,"dinamico","fondo libre en barra despegando las manos de las barra al ifnal de la subida",0);
insert into Ejercicios values("Fondo a codos","intermedio","triceps","empuje",false,"dinamico","fondo en paralelas, apoyando los codos en la paralela una vez ba",0);
insert into Ejercicios values("Fondo con palmada","intermedio","pecho","empuje",false,"dinamico","fondo libre en paralelas haciendo una palmada al final de la subida",0);
insert into Ejercicios values("Flexion a una mano","intermedio","pecho","empuje",false,"dinamico","flexion libre a una mano",0);


create table ejercicio_dinamico(
nombre VARCHAR(60)primary key,
repeticiones numeric(2)
);



-- Ejercicios dinamicos con dificultad principiante de tiron:
insert into Ejercicio_dinamico values("dominada prona con goma",0);
insert into Ejercicio_dinamico values("dominada neutra con goma",0);
insert into Ejercicio_dinamico values("dominada supina con goma ",0);
insert into Ejercicio_dinamico values("dominada prona negativa",0);
insert into Ejercicio_dinamico values("dominada neutra negativa",0);
insert into Ejercicio_dinamico values("dominada supina negativa",0);
insert into Ejercicio_dinamico values("dominada prona negativa con goma",0);
insert into Ejercicio_dinamico values("dominada neutra negativa con goma",0);
insert into Ejercicio_dinamico values("dominada supina negativa con goma",0);
insert into Ejercicio_dinamico values("dominada prona positiva",0);
insert into Ejercicio_dinamico values("dominada neutra positiva",0);
insert into Ejercicio_dinamico values("dominada supina positiva",0);
-- Ejercicios dinamicos con dificultad principiante_intermedio de tiron
insert into Ejercicio_dinamico values("dominada prona",0);
insert into Ejercicio_dinamico values("dominada neutra",0);
insert into Ejercicio_dinamico values("dominada supina",0);
insert into Ejercicio_dinamico values("dominada abierta",0);
-- Ejercicios dinamicos con dificultad intermedio de tiron:
insert into Ejercicio_dinamico values("slow dominada",0);
insert into Ejercicio_dinamico values("remo en barra",0);
insert into Ejercicio_dinamico values("dominada en L",0);
insert into Ejercicio_dinamico values("dominada en con palmada",0);
insert into Ejercicio_dinamico values("negativa de muscle up",0);
insert into Ejercicio_dinamico values("muscle up con goma",0);

-- Ejercicios dinamicos con dificultad intermedio_avanzado de tiron
insert into Ejercicio_dinamico values("dominada explosiva",0);
insert into Ejercicio_dinamico values("muscle up",0);
insert into Ejercicio_dinamico values("muscle up en L",0);
insert into Ejercicio_dinamico values("muscle up explosivo",0);
insert into Ejercicio_dinamico values("muscle up con palmada",0);


-- Ejercicios dinamicos con dificultad principiante de empuje:
insert into Ejercicio_dinamico values("Flexion inclinada en barra",0);
insert into Ejercicio_dinamico values("Flexion con rodilla",0);
insert into Ejercicio_dinamico values("Fondo negativos",0);
insert into Ejercicio_dinamico values("Fondo positivos",0);
insert into Ejercicio_dinamico values("Fondo con goma",0);


-- Ejercicios dinamicos con dificultad principiante_intermedio de empuje:
insert into Ejercicio_dinamico values("Flexion",0);
insert into Ejercicio_dinamico values("Flexion abierta",0);
insert into Ejercicio_dinamico values("Flexion en diamante",0);
insert into Ejercicio_dinamico values("Flexion declinada",0);
insert into Ejercicio_dinamico values("Fondo",0);
insert into Ejercicio_dinamico values("Fondo en barra",0);
-- Ejercicios dinamicos con dificultad intermedio de empuje:

insert into Ejercicio_dinamico values("Flexion explosiva",0);
insert into Ejercicio_dinamico values("Flexion con palmada",0);
insert into Ejercicio_dinamico values("Fondo explosivo",0);
insert into Ejercicio_dinamico values("Fondo en barra explosivo",0);
insert into Ejercicio_dinamico values("Fondo a codos",0);
insert into Ejercicio_dinamico values("Fondo con palmada",0);
insert into Ejercicio_dinamico values("Flexion a una mano",0);

select er.nombreEjercicio,r.fecha
 from ejercicios_rutina er,ejercicios e,rutina r
 where er.nombreEjercicio = e.nombre and r.fecha="2022-06-11 23:08:32";
 
select * from Rutina where usuario="1";
select * from ejercicio_dinamico;
select er.nombreEjercicio,e.series, ed.repeticiones 
from ejercicios_rutina er,ejercicios e,ejercicio_Dinamico ed,rutina r  
where  r.fecha="2022-06-12 01:34:29";

Select e.nombre,ed.repeticiones,e.series,e.estatico_o_dinamico from ejercicios e,rutina r,ejercicios_rutina er,ejercicio_dinamico ed where r.fecha ="2022-06-12 02:04:24" and ed.nombre=er.nombreEjercicio and ed.nombre=er.nombreEjercicio;

select * from ejercicios_rutina;
select r.usuario,er.nombreEjercicio,e.series
	from rutina r,ejercicios_rutina er,ejercicios e
    Where r.usuario="2" and er.nombreEjercicio = e.nombre;


select * from rutina;

create table ejercicio_estatico(
nombre VARCHAR(60)primary key,
aguanteSg numeric(2)not null
);

create table rutina(
usuario varchar(40),
descansoSg numeric(3),
fecha timeStamp,
foreign key (usuario) references usuario(nombre)on delete cascade,
primary key(usuario,fecha)
);

create table ejercicios_rutina(
usuario varchar(40),
nombreEjercicio varchar(60),
foreign key (usuario) references usuario(nombre),
Foreign key (nombreEjercicio) references ejercicios(nombre) on delete cascade
);

create table entrenamiento(
Usuario varchar(40)primary key,
tipoEntrenamiento Varchar(40),
foreign key (usuario) references usuario(nombre),
primary key(usuario,tipoEntrenamiento)
);

create table entrenamiento_rutina(
Usuariorutina varchar(40)
);
