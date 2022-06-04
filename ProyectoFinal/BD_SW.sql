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
select * from ejercicio_dinamico;
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
-- Ejercicios dinamicos con dificultad principiante de empuje:
insert into Ejercicio_dinamico values("Flexion inclinada en barra","principiante","pecho","empuje",false,false,"flexion con las manos en una barra con una altura desde la cintura hasta el suelo, mientra mas alta la barra, mas facil el ejercicio",0,0);
insert into Ejercicio_dinamico values("Flexion con rodilla","principiante","pecho","empuje",false,false,"flexion con las rodillas apolladas en el suelo",0,0);


-- Ejercicios dinamicos con dificultad principiante_intermedio de tiron
insert into Ejercicio_Dinamico values("dominada prona","principiante_intermedio","dorsal","tiron",false,false,"dominada con las palmas de las manos hacia delante,haciendo un recorrido completo",0,0);
insert into Ejercicio_Dinamico values("dominada neutra","principiante_intermedio","dorsal","tiron",false,false,"dominada usando dos barras paralelas a la altura de los hombros, las palmas de las manos estan una frente a la otra,haciendo un recorrido completo",0,0);
insert into Ejercicio_Dinamico values("dominada supina","principiante_intermedio","biceps","tiron",false,false,"dominada con las palmas de las manos hacia detras,haciendo un recorrido completo",0,0);
insert into Ejercicio_Dinamico values("dominada prona","principiante_intermedio","dorsal","tiron",false,false,"dominada prona con una apertura mucho mayor a la altura de los hombros",0,0);

















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
foreign key (usuario) references usuario(nombre)
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
foreign key (usuario) references usuario(nombre)
);
create table entrenamiento_rutina(
Usuariorutina varchar(40)
);
