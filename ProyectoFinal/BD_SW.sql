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
select * from usuario;	

create table ejercicio_dinamico(
nombre VARCHAR(60)primary key,
dificultad Varchar(40)not null,
gruposMusculares VARCHAR(40)not null,
tipoEjercicio VARCHAR(40)not null,
usaGoma boolean not null,
realizado boolean not null,
descripcion VARCHAR(200)not null,
repeticiones numeric(2)not null,
series numeric(2)

);
drop table ejercicio_dinamico;
update Ejercicio_Dinamico set repeticiones = 1 ,series = 2 where nombre = "dominada prona con goma" ;
select * from ejercicio_dinamico where nombre = "dominada prona con goma" ;
-- Ejercicios dinamicos con dificultad principiante de tiron:
insert into Ejercicio_Dinamico values("dominada prona con goma","principiante","dorsal","tiron",true,false," dominada con las palmas de las manos hacia delante,haciendo un recorrido completo,usando una goma",0,0);
insert into Ejercicio_Dinamico values("dominada neutra con goma","principiante","dorsal","tiron",true,false,"dominada usando dos barras paralelas a la altura de los hombros, las palmas de las manos estan una frente a la otra,haciendo un recorrido completo,usando una goma",0,0);
insert into Ejercicio_Dinamico values("dominada supina con goma ","principiante","biceps","tiron",true,false,"dominada con las palmas de las manos hacia detras,haciendo un recorrido completo,usando una goma",0,0);
insert into Ejercicio_Dinamico values("dominada prona negativa","principiante","dorsal","tiron",false,false,"dominada con las palmas de las manos hacia delante,aguantando la caida desde tener la barra debajo de la barbilla hasta tener los brazos bloqueados",0,0);
insert into Ejercicio_Dinamico values("dominada neutra negativa","principiante","dorsal","tiron",false,false,"dominada usando dos barras paralelas a la altura de los hombros, las palmas de las manos estan una frente a la otra,aguantando la caida desde tener la barra debajo de la barbilla hasta tener los brazos bloqueados",0,0);
insert into Ejercicio_Dinamico values("dominada supina negativa","principiante","biceps","tiron",false,false,"dominada con las palmas de las manos hacia detras,aguantando la caida desde tener la barra debajo de la barbilla hasta tener los brazos bloqueados",0,0);
insert into Ejercicio_Dinamico values("dominada prona negativa con goma","principiante","dorsal","tiron",true,false,"dominada con las palmas de las manos hacia delante,aguantando la caida desde tener la barra debajo de la barbilla hasta tener los brazos bloqueados,usando una goma",0,0);
insert into Ejercicio_Dinamico values("dominada neutra negativa con goma","principiante","dorsal","tiron",true,false,"dominada usando dos barras paralelas a la altura de los hombros, las palmas de las manos estan una frente a la otra,aguantando la caida desde tener la barra debajo de la barbilla hasta tener los brazos bloqueados,usando una goma",0,0);
insert into Ejercicio_Dinamico values("dominada supina negativa con goma","principiante","biceps","tiron",true,false,"dominada con las palmas de las manos hacia detras,aguantando la caida desde tener la barra debajo de la barbilla hasta tener los brazos bloqueados,usando una goma",0,0);
insert into Ejercicio_Dinamico values("dominada prona positiva","principiante","dorsal","tiron",false,false,"dominada con las palmas de las manos hacia delante,haciendo solo el recorrido de los brazos bloqueados hasta llegar a tener la barra debajo de la barbilla",0,0);
insert into Ejercicio_Dinamico values("dominada neutra positiva","principiante","dorsal","tiron",false,false,"dominada usando dos barras paralelas a la altura de los hombros, las palmas de las manos estan una frente a la otra,haciendo solo el recorrido de los brazos bloqueados hasta llegar a tener la barra debajo de la barbilla",0,0);
insert into Ejercicio_Dinamico values("dominada supina positiva","principiante","biceps","tiron",false,false,"dominada con las palmas de las manos hacia detras,haciendo solo el recorrido de los brazos bloqueados hasta llegar a tener la barra debajo de la barbilla",0,0);
-- Ejercicios dinamicos con dificultad principiante_intermedio de tiron
insert into Ejercicio_Dinamico values("dominada prona","principiante_intermedio","dorsal","tiron",false,false,"dominada con las palmas de las manos hacia delante,haciendo un recorrido completo",0,0);
insert into Ejercicio_Dinamico values("dominada neutra","principiante_intermedio","dorsal","tiron",false,false,"dominada usando dos barras paralelas a la altura de los hombros, las palmas de las manos estan una frente a la otra,haciendo un recorrido completo",0,0);
insert into Ejercicio_Dinamico values("dominada supina","principiante_intermedio","biceps","tiron",false,false,"dominada con las palmas de las manos hacia detras,haciendo un recorrido completo",0,0);
insert into Ejercicio_Dinamico values("dominada abierta","principiante_intermedio","dorsal","tiron",false,false,"dominada prona con una apertura mucho mayor a la altura de los hombros",0,0);
-- Ejercicios dinamicos con dificultad intermedio de tiron:
insert into Ejercicio_Dinamico values("slow dominada","intermedio","dorsal","tiron",false,false,"dominada prona, muy lenta",0,0);
insert into Ejercicio_Dinamico values("remo en barra","intermedio","dorsal","tiron",false,false,"Dominada con las canillas de los pies apolladas en la barra, tratando de llevar la cadera a la barra",0,0);
insert into Ejercicio_Dinamico values("dominada en L","intermedio","dorsal","tiron",false,false,"dominada prona, con una flexion en la cadera de 90º, formando una L con el cuerpo",0,0);
insert into Ejercicio_Dinamico values("dominada en con palmada","intermedio","dorsal","tiron",false,false,"dominada prona con una palmada al llevar la barra debajo de la barbilla",0,0);
insert into Ejercicio_Dinamico values("negativa de muscle up","intermedio","dorsal","tiron",false,false,"partiendo con la barra en la cadera, aguantar la caida hasta llegar a tener los brazos bloqueados",0,0);
insert into Ejercicio_Dinamico values("muscle up con goma","intermedio","dorsal","tiron",true,false,"muscle up, utilizando una goma en los pies para facilitar el ejercicio",0,0);

-- Ejercicios dinamicos con dificultad intermedio_avanzado de tiron
insert into Ejercicio_Dinamico values("dominada explosiva","intermedio_avanzado","dorsal","tiron",false,false,"dominada prona tratando de llegar con la barra a la cadera en lugar de a la barbilla",0,0);
insert into Ejercicio_Dinamico values("muscle up","intermedio_avanzado","dorsal","tiron",false,false,"partiendo de tener los brazos bloqueados, hacer una dominada explosiva, rotar las manos para hacer un fondo en barra y llegar a quedar arriba de la barra",0,0);
insert into Ejercicio_Dinamico values("muscle up en L","intermedio_avanzado","dorsal","tiron",false,false,"muscle up, con el cuerpo en forma de L",0,0);
insert into Ejercicio_Dinamico values("muscle up explosivo","intermedio_avanzado","dorsal","tiron",false,false,"muscle up separando las palmas de las manos de la barra al llegar arriba",0,0);
insert into Ejercicio_Dinamico values("muscle up con palmada","intermedio_avanzado","dorsal","tiron",false,false,"muscle up haciendo una palmada al llegar arriba de la barra",0,0);


-- Ejercicios dinamicos con dificultad principiante de empuje:
insert into Ejercicio_dinamico values("Flexion inclinada en barra","principiante","pecho","empuje",false,false,"flexion con las manos en una barra con una altura desde la cintura hasta el suelo, mientra mas alta la barra, mas facil el ejercicio",0,0);
insert into Ejercicio_dinamico values("Flexion con rodilla","principiante","pecho","empuje",false,false,"flexion con las rodillas apolladas en el suelo",0,0);
insert into Ejercicio_dinamico values("Fondo negativos","principiante","pecho","empuje",false,false,"Fondo en paralelas haciendo un rago solo desde tener los brazos bloqueados hasta llegar a tener un angulo de 90ª en los codos",0,0);
insert into Ejercicio_dinamico values("Fondo positivos","principiante","pecho","empuje",false,false,"Fondo en paralelas haciendo un rago solo desde tener los brazos con un angulo de 90º hasta tenerlos bloqueados",0,0);
insert into Ejercicio_dinamico values("Fondo con goma","principiante","pecho","empuje",true,false,"Fondo en paralelas haciendo con una goma en los pies para ayudar a la realizacion del ejercicio",0,0);


-- Ejercicios dinamicos con dificultad principiante_intermedio de empuje:
insert into Ejercicio_dinamico values("Flexion","principiante_intermedio","pecho","empuje",false,false,"flexione libres en suelo",0,0);
insert into Ejercicio_dinamico values("Flexion abierta","principiante_intermedio","deltoide","empuje",false,false,"flexion libres en suelo con una amplia apertura en las manos",0,0);
insert into Ejercicio_dinamico values("Flexion en diamante","principiante_intermedio","triceps","empuje",false,false,"flexiones libres en suelo ,con las manos juntas haciendo un triangulo con los dedos",0,0);
insert into Ejercicio_dinamico values("Flexion declinada","principiante_intermedio","pecho","empuje",false,false,"flexiones libres en suelo con los pies en una superficie mas alta, haciendo un desnivel en el cuerpo incrementando la dificultad del ejercicio",0,0);
insert into Ejercicio_dinamico values("Fondo","principiante_intermedio","pecho","empuje",false,false,"fondo libre en paralelas",0,0);
insert into Ejercicio_dinamico values("Fondo en barra","principiante_intermedio","triceps","empuje",false,false,"fondo libre en barra",0,0);
-- Ejercicios dinamicos con dificultad intermedio de empuje:

select * from ejercicio_dinamico;
insert into Ejercicio_dinamico values("Flexion explosiva","intermedio","pecho","empuje",false,false,"flexion libres en suelo levantando las manos al final de la subida",0,0);
insert into Ejercicio_dinamico values("Flexion con palmada","intermedio","pecho","empuje",false,false,"flexionelibres en suelo dando una palmada con las manos al final de la subida",0,0);
insert into Ejercicio_dinamico values("Flexion explosiva","intermedio","pecho","empuje",false,false,"flexionelibres en suelo levantando las manos al final de la subida",0,0);
insert into Ejercicio_dinamico values("Fondo explosivo","intermedio","pecho","empuje",false,false,"fondo libre en paralelas despegando las manos de las paralelas al ifnal de la subida",0,0);
insert into Ejercicio_dinamico values("Fondo en barra explosivo","intermedio","pecho","empuje",false,false,"fondo libre en barra despegando las manos de las barra al ifnal de la subida",0,0);
insert into Ejercicio_dinamico values("Fondo a codos","intermedio","triceps","empuje",false,false,"fondo en paralelas, apoyando los codos en la paralela una vez ba",0,0);
insert into Ejercicio_dinamico values("Fondo explosivo","intermedio","pecho","empuje",false,false,"fondo libre en paralelas despegando las manos de las paralelas al ifnal de la subida",0,0);
insert into Ejercicio_dinamico values("Fondo con palmada","intermedio","pecho","empuje",false,false,"fondo libre en paralelas haciendo una palmada al final de la subida",0,0);
insert into Ejercicio_dinamico values("Flexion a una mano","intermedio","pecho","empuje",false,false,"flexion libre a una mano",0,0);










create table ejercicio_estatico(
nombre VARCHAR(60)primary key,
dificultad Varchar(40)not null,
gruposMusculares VARCHAR(40)not null,
tipoEjercicio VARCHAR(40)not null,
usaGoma boolean not null,
realizado boolean not null,
descripcion VARCHAR(200)not null,
aguanteSg numeric(2)not null,
series numeric(2)
);

create table rutina(
usuario varchar(40)primary key,
descansoSg numeric(3),
fecha date,
foreign key (usuario) references usuario(nombre),
primary key(usuario,fecha)
);

create table ejercicios_rutina(
usuario varchar(40),
nombreEjercicio varchar(60),
foreign key (usuario) references usuario(nombre),
foreign key (nombreEjercicio) references ejercicios(nombre)
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
