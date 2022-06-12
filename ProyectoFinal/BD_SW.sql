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
insert into Ejercicios values("dominada prona con goma","principiante","dorsal","tiron",true,"dinamico"," dominada con las palmas de las manos hacia delante,haciendo un recorrido completo,usando una goma",0);
insert into Ejercicios values("dominada neutra con goma","principiante","dorsal","tiron",true,"dinamico","dominada usando dos barras paralelas a la altura de los hombros, las palmas de las manos estan una frente a la otra,haciendo un recorrido completo,usando una goma",0);
insert into Ejercicios values("dominada supina con goma ","principiante","biceps","tiron",true,"dinamico","dominada con las palmas de las manos hacia detras,haciendo un recorrido completo,usando una goma",0);
insert into Ejercicios values("dominada prona negativa","principiante","dorsal","tiron",false,"dinamico","dominada con las palmas de las manos hacia delante,aguantando la caida desde tener la barra debajo de la barbilla hasta tener los brazos bloqueados",0);
insert into Ejercicios values("dominada neutra negativa","principiante","dorsal","tiron",false,"dinamico","dominada usando dos barras paralelas a la altura de los hombros, las palmas de las manos estan una frente a la otra,aguantando la caida desde tener la barra debajo de la barbilla hasta tener los brazos bloqueados",0);
insert into Ejercicios values("dominada supina negativa","principiante","biceps","tiron",false,"dinamico","dominada con las palmas de las manos hacia detras,aguantando la caida desde tener la barra debajo de la barbilla hasta tener los brazos bloqueados",0);
insert into Ejercicios values("dominada prona negativa con goma","principiante","dorsal","tiron",true,"dinamico","dominada con las palmas de las manos hacia delante,aguantando la caida desde tener la barra debajo de la barbilla hasta tener los brazos bloqueados,usando una goma",0);
insert into Ejercicios values("dominada neutra negativa con goma","principiante","dorsal","tiron",true,"dinamico","dominada usando dos barras paralelas a la altura de los hombros, las palmas de las manos estan una frente a la otra,aguantando la caida desde tener la barra debajo de la barbilla hasta tener los brazos bloqueados,usando una goma",0);
insert into Ejercicios values("dominada supina negativa con goma","principiante","biceps","tiron",true,"dinamico","dominada con las palmas de las manos hacia detras,aguantando la caida desde tener la barra debajo de la barbilla hasta tener los brazos bloqueados,usando una goma",0);
insert into Ejercicios values("dominada prona positiva","principiante","dorsal","tiron",false,"dinamico","dominada con las palmas de las manos hacia delante,haciendo solo el recorrido de los brazos bloqueados hasta llegar a tener la barra debajo de la barbilla",0);
insert into Ejercicios values("dominada neutra positiva","principiante","dorsal","tiron",false,"dinamico","dominada usando dos barras paralelas a la altura de los hombros, las palmas de las manos estan una frente a la otra,haciendo solo el recorrido de los brazos bloqueados hasta llegar a tener la barra debajo de la barbilla",0);
insert into Ejercicios values("dominada supina positiva","principiante","biceps","tiron",false,"dinamico","dominada con las palmas de las manos hacia detras,haciendo solo el recorrido de los brazos bloqueados hasta llegar a tener la barra debajo de la barbilla",0);
-- Ejercicios dinamicos con dificultad principiante_intermedio de tiron:
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

-- Ejercicio dinamico de front lever con dificultad principiante:
insert into Ejercicios values("dominada en tuck con goma","principiante","dorsal","FRONTLEVER",true,"dinamico","dominada en posicion de tuck fron lever con una goma en la cadera",0);
insert into Ejercicios values("positiva en tuck","principiante","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde tuck en front lever,desplazar el cuerpo hasta tener los pies en la barra",0);
insert into Ejercicios values("negativa en tuck","principiante","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde pike en tuck aguantar el recorrido hasta llegar a tuck en front lever",0);
insert into Ejercicios values("de L a tuck","principiante","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde L-sit, llegar a estar en tuck de front lever",0);
insert into Ejercicios values("de barbilla a tuck","principiante","dorsal","FRONTLEVER",false,"dinamico","Partiendo desdetener la barra debajo de la barbilla, llegar a tuck de front lever",0);
insert into Ejercicios values("dominada en tuck","principiante","dorsal","FRONTLEVER",false,"dinamico","Partiendo de tener los brazos bloqueados en tuck, llegar a tenerlos en 90º",0);
insert into Ejercicios values("press de tuck","principiante","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde estar en tuck de front lever, llegar a tener los pies en la barra y volver a tuck",0);

-- Ejercicio dinamico de front lever con dificultad principiante_intermedia"
insert into Ejercicios values("dominada en tuck advance  con goma","principiante_intermedio","dorsal","FRONTLEVER",true,"dinamico","dominada en posicion de tuck advance con una goma en la cadera",0);
insert into Ejercicios values("positiva en tuck advance ","principiante_intermedio","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde tuck advance,desplazar el cuerpo hasta tener los pies en la barra",0);
insert into Ejercicios values("negativa en tuck advance ","principiante_intermedio","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde pike en tuck advance aguantar el recorrido hasta llegar a tuck advance",0);
insert into Ejercicios values("de L a tuck advance","principiante_intermedio","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde L-sit, llegar a estar en tuck advance",0);
insert into Ejercicios values("de barbilla a tuck advance","principiante_intermedio","dorsal","FRONTLEVER",false,"dinamico","Partiendo desdetener la barra debajo de la barbilla, llegar a tuck advance",0);
insert into Ejercicios values("dominada en tuck advance","principiante_intermedio","dorsal","FRONTLEVER",false,"dinamico","Partiendo de tener los brazos bloqueados en tuck advance, llegar a tenerlos en 90º",0);
insert into Ejercicios values("press de tuck advance","principiante_intermedio","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde estar en tuck advance, llegar a tener los pies en la barra y volver a tuck advance",0);
insert into Ejercicios values("de tuck a tuck advance","principiante_intermedio","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde tuck, estirar las piernas hasta llegar a advance",0);

-- Ejercicio dinamico de front lever con dificultad intermedia:
insert into Ejercicios values("dominada en half  con goma","intermedio","dorsal","FRONTLEVER",true,"dinamico","dominada en posicion de half con una goma en la cadera",0);
insert into Ejercicios values("positiva en half ","intermedio","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde half,desplazar el cuerpo hasta tener los pies en la barra",0);
insert into Ejercicios values("negativa en half ","intermedio","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde pike en half aguantar el recorrido hasta llegar a half",0);
insert into Ejercicios values("de L a half","intermedio","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde L-sit, llegar a estar en half",0);
insert into Ejercicios values("dominada en half","intermedio","dorsal","FRONTLEVER",false,"dinamico","Partiendo de tener los brazos bloqueados en half, llegar a tenerlos en 90º",0);
insert into Ejercicios values("de barbilla a half","intermedio","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde tener la barra debajo de la barbilla, llegar a half",0);
insert into Ejercicios values("press de half","intermedio","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde estar en half, llegar a tener los pies en la barra y volver a half",0);
insert into Ejercicios values("de half a front lever","intermedio","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde estar en half, estirar las piernas hasta llegar a frotn lever",0);

-- Ejercicio dinamico de front lever con dificultad intermedia_avanzada:
insert into Ejercicios values("dominada en front lever con goma","intermedio_avanzado","dorsal","FRONTLEVER",true,"dinamico","dominada en posicion de front lever con una goma en la cadera",0);
insert into Ejercicios values("positiva en front lever ","intermedio_avanzado","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde front lever,desplazar el cuerpo hasta tener los pies en la barra",0);
insert into Ejercicios values("negativa en front lever ","intermedio_avanzado","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde pike en front lever aguantar el recorrido hasta llegar a front lever",0);
insert into Ejercicios values("de L a front lever","intermedio_avanzado","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde L-sit, llegar a estar en front lever",0);
insert into Ejercicios values("de barbilla a front lever","intermedio_avanzado","dorsal","FRONTLEVER",false,"dinamico","Partiendo desdetener la barra debajo de la barbilla, llegar a front lever",0);
insert into Ejercicios values("dominada en front lever","intermedio_avanzado","dorsal","FRONTLEVER",false,"dinamico","Partiendo de tener los brazos bloqueados en front lever, llegar a tenerlos en 90º",0);
insert into Ejercicios values("press de front lever","intermedio_avanzado","dorsal","FRONTLEVER",false,"dinamico","Partiendo desde estar en front lever, llegar a tener los pies en la barra y volver a front lever",0);

-- Ejercicio dinamico de plancha con dificultad principiante_intermedio
insert into Ejercicios values("Flexiones en lean planche","principiante_intermedio","hombro","PLANCHA",false,"dinamico","flexion en posicion de lean planche(con las manos en el suelo inclinado hacia delante)",0);
insert into Ejercicios values("Flexiones tuck planche en paralelas","principiante_intermedio","hombro","PLANCHA",false,"dinamico","flexion en tuck con las manos en unas paraleas",0);
insert into Ejercicios values("Flexiones tuck planche en suelo","principiante_intermedio","hombro","PLANCHA",false,"dinamico","flexion en tuck con las manos en el suelo",0);
insert into Ejercicios values("Flexiones tuck planche en anillas","principiante_intermedio","hombro","PLANCHA",false,"dinamico","flexion en tuck con las manos en anillas",0);
insert into Ejercicios values("Positiva tuck a pino","principiante_intermedio","hombro","PLANCHA",false,"dinamico","partiendo de estar en tuck hacer el recorrido hasta llegar a pino",0);
insert into Ejercicios values("negativa pino a tuck","principiante_intermedio","hombro","PLANCHA",false,"dinamico","partiendo de estar en pino, hacer el recorrido hasta llegar a tuck",0);
insert into Ejercicios values("press de tuck planche","principiante_intermedio","hombro","PLANCHA",false,"dinamico","partiendo de estar en tuck hacer el recorrido hasta llegar a pino y volver a bajar a tuck",0);
insert into Ejercicios values("Flexiones de pino en pared","principiante_intermedio","hombro","PLANCHA",false,"dinamico","estando en pino con la pared,hacer una flexion de 90ª en los brazos",0);

-- Ejercicio dinamico de plancha con dificultad intermedio
insert into Ejercicios values("Flexiones en lean planche con rodillas","intermedio","hombro","PLANCHA",false,"dinamico","flexion en posicion de lean planche con las rodillas en el suelo aumentando su dificultad",0);
insert into Ejercicios values("Flexiones tuck advance  en paralelas","intermedio","hombro","PLANCHA",false,"dinamico","flexion en tuck advance con las manos en unas paraleas",0);
insert into Ejercicios values("Flexiones tuck advance  en suelo","intermedio","hombro","PLANCHA",false,"dinamico","flexion en tuck advance con las manos en el suelo",0);
insert into Ejercicios values("Flexiones tuck advance  en anillas","intermedio","hombro","PLANCHA",false,"dinamico","flexion en tuck advance con las manos en anillas",0);
insert into Ejercicios values("Positiva tuck advance a pino","intermedio","hombro","PLANCHA",false,"dinamico","partiendo de estar en tuck advance  hacer el recorrido hasta llegar a pino",0);
insert into Ejercicios values("negativa pino advance a tuck","intermedio","hombro","PLANCHA",false,"dinamico","partiendo de estar en pino, hacer el recorrido hasta llegar a tuck advance",0);
insert into Ejercicios values("press de tuck advance planche","intermedio","hombro","PLANCHA",false,"dinamico","partiendo de estar en tuck advance hacer el recorrido hasta llegar a pino y volver a bajar a tuck",0);
insert into Ejercicios values("Flexiones de pino libre","intermedio","hombro","PLANCHA",false,"dinamico","estando en pino libre,hacer una flexion de 90ª en los brazos",0);

-- Ejercicio dinamico de plancha con dificultad intermedio_avanzado
insert into Ejercicios values("Flexiones en straddle en paralelas","intermedio_avanzado","hombro","PLANCHA",false,"dinamico","flexion en straddle con las manos en unas paraleas",0);
insert into Ejercicios values("Flexiones en straddle en suelo","intermedio_avanzado","hombro","PLANCHA",false,"dinamico","flexion en straddle con las manos en el suelo",0);
insert into Ejercicios values("Flexiones en straddle en anillas","intermedio_avanzado","hombro","PLANCHA",false,"dinamico","flexion en straddle con las manos en anillas",0);
insert into Ejercicios values("Positiva ten straddle a pino","intermedio_avanzado","hombro","PLANCHA",false,"dinamico","partiendo de estar en straddle hacer el recorrido hasta llegar a pino",0);
insert into Ejercicios values("negativa en straddle a tuck","intermedio_avanzado","hombro","PLANCHA",false,"dinamico","partiendo de estar en pino, hacer el recorrido hasta llegar en straddle",0);
insert into Ejercicios values("press de straddle","intermedio_avanzado","hombro","PLANCHA",false,"dinamico","partiendo de estar en straddle hacer el recorrido hasta llegar a pino y volver a bajar a straddle",0);
insert into Ejercicios values("Flexiones de pino libre a 90º","intermedio_avanzado","hombro","PLANCHA",false,"dinamico","estando en pino con libre,hacer una flexion llegando a estar paralelos al suelo y volver a pino",0);

-- Ejercicio dinamico de plancha con dificultad avanzado
insert into Ejercicios values("Flexiones en full en paralelas","avanzado","hombro","PLANCHA",false,"dinamico","flexion en full con las manos en unas paraleas",0);
insert into Ejercicios values("Flexiones en full en suelo","avanzado","hombro","PLANCHA",false,"dinamico","flexion en full con las manos en el suelo",0);
insert into Ejercicios values("Flexiones en full en anillas","avanzado","hombro","PLANCHA",false,"dinamico","flexion en full con las manos en anillas",0);
insert into Ejercicios values("Positiva ten full a pino","avanzado","hombro","PLANCHA",false,"dinamico","partiendo de estar en full hacer el recorrido hasta llegar a pino",0);
insert into Ejercicios values("negativa en full a tuck","avanzado","hombro","PLANCHA",false,"dinamico","partiendo de estar en pino, hacer el recorrido hasta llegar en full",0);
insert into Ejercicios values("press de full","avanzado","hombro","PLANCHA",false,"dinamico","partiendo de estar en full hacer el recorrido hasta llegar a pino y volver a bajar a full",0);

insert into Ejercicios values("Aguante en barra","principiante","dorsal","tiron",false,"estatico","aguantar con las dos manos agarrado a la barra y el cuerpo sin tocar el suelo",0);
insert into Ejercicios values("Aguante arriba en barra","principiante","dorsal","tiron",false,"estatico","aguantar con las dos manos agarrado a la barra y la barra debajo de la barbilla",0);

insert into Ejercicios values("Aguante en paralelas","principiante","dorsal","tiron",false,"estatico","aguantar en las paralelas sin tocar el suelo, con las dos manos en las paralelas",0);

insert into Ejercicios values("Aguante en tuck con goma","principiante","dorsal","FRONTLEVER",true,"estatico","aguantar en tuck de front lever con una goma en la cadera",0);
insert into Ejercicios values("Aguante en tuck advance con goma","principiante_intermedio","FRONTLEVER","tiron",true,"estatico","aguantar en tuck advance con una goma en la cadera",0);
insert into Ejercicios values("Aguante en half con goma","principiante_intermedio","dorsal","FRONTLEVER",true,"estatico","aguantar en half con una goma en la cadera",0);
insert into Ejercicios values("Aguante en front con goma","intermedio","dorsal","FRONTLEVER",true,"estatico","aguantar en front con una goma en la cadera",0);

insert into Ejercicios values("Aguante en tuck","principiante","dorsal","FRONTLEVER",false,"estatico","aguantar en tuck de front lever",0);
insert into Ejercicios values("Aguante en tuck advance","principiante_intermedio","dorsal","FRONTLEVER",false,"estatico","aguantar en tuck advance de front lever",0);
insert into Ejercicios values("Aguante en half","intermedio","dorsal","FRONTLEVER",false,"estatico","aguantar en half",0);
insert into Ejercicios values("Aguante en front","intermedio_avanzado","dorsal","FRONTLEVER",false,"estatico","aguantar en front",0);

insert into Ejercicios values("Aguante en tuck touch con goma","principiante","dorsal","FRONTLEVER",true,"estatico","aguantar en tuck de front lever tocando la cadera con la barra con una goma en la cadera",0);
insert into Ejercicios values("Aguante en tuck advance touch con goma","principiante_intermedio","dorsal","FRONTLEVER",true,"estatico","aguantar en tuck advance tocando la cadera con la barra con una goma en la cadera",0);
insert into Ejercicios values("Aguante en half touch con goma","intermedio","dorsal","FRONTLEVER",true,"estatico","aguantar en half tocando la cadera con la barra con una goma en la cadera",0);
insert into Ejercicios values("Aguante en front touch con goma","intermedio_avanzado","dorsal","FRONTLEVER",true,"aguantar en front lever tocando la cadera con la barra con una goma en la cadera",0);

insert into Ejercicios values("Aguante en tuck touch","principiante_intermedio","dorsal","FRONTLEVER",false,"estatico","guantar en tuck de front lever tocando la cadera con la barra",0);
insert into Ejercicios values("Aguante en tuck advance touch","intermedio","dorsal","FRONTLEVER",false,"estatico","aguantar en tuck advance tocando la cadera con la barra con una goma en la cadera",0);
insert into Ejercicios values("Aguante en half touch","intermedio_avanzado","dorsal","FRONTLEVER",false,"estatico","aguantar en half tocando la cadera con la barra ",0);
insert into Ejercicios values("Aguante en front touch","avanzado","dorsal","FRONTLEVER",false,"estatico","aguantar en front lever tocando la cadera con la barra",0);


insert into Ejercicios values("Aguante de tuck en paralelas con goma","principiante","hombro","PLANCHA",true,"estatico","aguantar tuck planche en paralelas con una goma en la cadera",0);
insert into Ejercicios values("Aguante de tuck advance en paralelas con goma","principiante","hombro","PLANCHA",true,"estatico","aguantar tuck advance en paralelas con una goma en la cadera",0);
insert into Ejercicios values("Aguante de straddle en paralelas con goma","principiante","hombro","PLANCHA",true,"estatico","aguantar straddle en paralelas con una goma en la cadera",0);
insert into Ejercicios values("Aguante de full en paralelas con goma","principiante","hombro","PLANCHA",true,"estatico","aguantar full en paralelas con una goma en la cadera",0);

insert into Ejercicios values("Aguante de tuck en paralelas","principiante","hombro","PLANCHA",false,"estatico","aguantar tuck planche en paralelas",0);
insert into Ejercicios values("Aguante de tuck advance en paralelas","principiante","hombro","PLANCHA",false,"estatico","aguantar tuck advance en paralelas",0);
insert into Ejercicios values("Aguante de straddle en paralelas","principiante","hombro","PLANCHA",false,"estatico","aguantar straddle en paralelas",0);
insert into Ejercicios values("Aguante de full en paralelas","principiante","hombro","PLANCHA",false,"estatico","aguantar full en paralelas",0);

insert into Ejercicios values("Aguante de tuck en suelo con goma","principiante","hombro","PLANCHA",true,"estatico","aguantar tuck planche en suelo con una goma en la cadera",0);
insert into Ejercicios values("Aguante de tuck advance en suelo con goma","principiante","hombro","PLANCHA",true,"estatico","aguantar tuck advance en suelo con una goma en la cadera",0);
insert into Ejercicios values("Aguante de straddle en suelo con goma","principiante","hombro","PLANCHA",true,"estatico","aguantar straddle en suelo con una goma en la cadera",0);
insert into Ejercicios values("Aguante de full en suelo con goma","principiante","hombro","PLANCHA",true,"estatico","aguantar full en suelo con una goma en la cadera",0);


insert into Ejercicios values("Aguante de tuck en suelo","principiante","hombro","PLANCHA",false,"estatico","aguantar tuck planche en suelo ",0);
insert into Ejercicios values("Aguante de tuck advance en suelo","principiante","hombro","PLANCHA",false,"estatico","aguantar tuck advance en suelo",0);
insert into Ejercicios values("Aguante de straddle en suelo","principiante","hombro","PLANCHA",false,"estatico","aguantar straddle en suelo",0);
insert into Ejercicios values("Aguante de full en suelo","principiante","hombro","PLANCHA",false,"estatico","aguantar full en suelo ",0);



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



-- Ejercicio dinamico de front lever con dificultad principiante:
insert into Ejercicio_dinamico values("dominada en tuck con goma",0);
insert into Ejercicio_dinamico values("positiva en tuck",0);
insert into Ejercicio_dinamico values("negativa en tuck",0);
insert into Ejercicio_dinamico values("de L a tuck",0);
insert into Ejercicio_dinamico values("de barbilla a tuck",0);
insert into Ejercicio_dinamico values("dominada en tuck",0);
insert into Ejercicio_dinamico values("press de tuck",0);

-- Ejercicio dinamico de front lever con dificultad principiante_intermedia"
insert into Ejercicio_dinamico values("dominada en tuck advance  con goma",0);
insert into Ejercicio_dinamico values("positiva en tuck advance ",0);
insert into Ejercicio_dinamico values("negativa en tuck advance ",0);
insert into Ejercicio_dinamico values("de L a tuck advance",0);
insert into Ejercicio_dinamico values("de barbilla a tuck advance",0);
insert into Ejercicio_dinamico values("dominada en tuck advance",0);
insert into Ejercicio_dinamico values("press de tuck advance",0);
insert into Ejercicio_dinamico values("de tuck a tuck advance",0);

-- Ejercicio dinamico de front lever con dificultad intermedia:
insert into Ejercicio_dinamico values("dominada en half  con goma",0);
insert into Ejercicio_dinamico values("positiva en half ",0);
insert into Ejercicio_dinamico values("negativa en half ",0);
insert into Ejercicio_dinamico values("de L a half",0);
insert into Ejercicio_dinamico values("dominada en half",0);
insert into Ejercicio_dinamico values("de barbilla a half",0);
insert into Ejercicio_dinamico values("press de half",0);
insert into Ejercicio_dinamico values("de half a front lever",0);

-- Ejercicio dinamico de front lever con dificultad intermedia_avanzada:
insert into Ejercicio_dinamico values("dominada en front lever con goma",0);
insert into Ejercicio_dinamico values("positiva en front lever ",0);
insert into Ejercicio_dinamico values("negativa en front lever ",0);
insert into Ejercicio_dinamico values("de L a front lever",0);
insert into Ejercicio_dinamico values("de barbilla a front lever",0);
insert into Ejercicio_dinamico values("dominada en front lever",0);
insert into Ejercicio_dinamico values("press de front lever",0);

-- Ejercicio dinamico de plancha con dificultad principiante_intermedio
insert into Ejercicio_dinamico values("Flexiones en lean planche",0);
insert into Ejercicio_dinamico values("Flexiones tuck planche en paralelas",0);
insert into Ejercicio_dinamico values("Flexiones tuck planche en suelo",0);
insert into Ejercicio_dinamico values("Flexiones tuck planche en anillas",0);
insert into Ejercicio_dinamico values("Positiva tuck a pino",0);
insert into Ejercicio_dinamico values("negativa pino a tuck",0);
insert into Ejercicio_dinamico values("press de tuck planche",0);
insert into Ejercicio_dinamico values("Flexiones de pino en pared",0);

-- Ejercicio dinamico de plancha con dificultad intermedio
insert into Ejercicio_dinamico values("Flexiones en lean planche con rodillas",0);
insert into Ejercicio_dinamico values("Flexiones tuck advance  en paralelas",0);
insert into Ejercicio_dinamico values("Flexiones tuck advance  en suelo",0);
insert into Ejercicio_dinamico values("Flexiones tuck advance  en anillas",0);
insert into Ejercicio_dinamico values("Positiva tuck advance a pino",0);
insert into Ejercicio_dinamico values("negativa pino advance a tuck",0);
insert into Ejercicio_dinamico values("press de tuck advance planche",0);
insert into Ejercicio_dinamico values("Flexiones de pino libre",0);

-- Ejercicio dinamico de plancha con dificultad intermedio_avanzado
insert into Ejercicio_dinamico values("Flexiones en straddle en paralelas",0);
insert into Ejercicio_dinamico values("Flexiones en straddle en suelo",0);
insert into Ejercicio_dinamico values("Flexiones en straddle en anillas",0);
insert into Ejercicio_dinamico values("Positiva ten straddle a pino",0);
insert into Ejercicio_dinamico values("negativa en straddle a tuck",0);
insert into Ejercicio_dinamico values("press de straddle",0);
insert into Ejercicio_dinamico values("Flexiones de pino libre a 90º",0);

-- Ejercicio dinamico de plancha con dificultad avanzado
insert into Ejercicio_dinamico values("Flexiones en full en paralelas",0);
insert into Ejercicio_dinamico values("Flexiones en full en suelo",0);
insert into Ejercicio_dinamico values("Flexiones en full en anillas",0);
insert into Ejercicio_dinamico values("Positiva ten full a pino",0);
insert into Ejercicio_dinamico values("negativa en full a tuck",0);
insert into Ejercicio_dinamico values("press de full",0);

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
where  r.fecha="2022-06-12 07:17:48" , er.nombreEjercicio = e.nombre and ed.nombre=er.nombreEjercicio;

Select e.nombre,ed.repeticiones,e.series,e.estatico_o_dinamico from ejercicios e,rutina r,ejercicios_rutina er,ejercicio_dinamico ed where r.fecha ="2022-06-12 02:04:24" and ed.nombre=er.nombreEjercicio and ed.nombre=er.nombreEjercicio;
select usuario from rutina;
select * from ejercicios_rutina;
select r.usuario,er.nombreEjercicio,e.series
	from rutina r,ejercicios_rutina er,ejercicios e
    Where r.usuario="2" and er.nombreEjercicio = e.nombre;


select * from rutina;

create table ejercicio_estatico(
nombre VARCHAR(60)primary key,
aguanteSg numeric(2)not null
);
insert into Ejercicio_estatico values("Aguante en barra",0);
insert into Ejercicio_estatico values("Aguante arriba en barra",0);

insert into Ejercicio_estatico values("Aguante en paralelas",0);

insert into Ejercicio_estatico values("Aguante en tuck con goma",0);
insert into Ejercicio_estatico values("Aguante en tuck advance con goma",0);
insert into Ejercicio_estatico values("Aguante en half con goma",0);
insert into Ejercicio_estatico values("Aguante en front con goma",0);

insert into Ejercicio_estatico values("Aguante en tuck",0);
insert into Ejercicio_estatico values("Aguante en tuck advance",0);
insert into Ejercicio_estatico values("Aguante en half",0);
insert into Ejercicio_estatico values("Aguante en front",0);

insert into Ejercicio_estatico values("Aguante en tuck touch con goma",0);
insert into Ejercicio_estatico values("Aguante en tuck advance touch con goma",0);
insert into Ejercicio_estatico values("Aguante en half touch con goma",0);
insert into Ejercicio_estatico values("Aguante en front touch con goma",0);

insert into Ejercicio_estatico values("Aguante en tuck touch",0);
insert into Ejercicio_estatico values("Aguante en tuck advance touch",0);
insert into Ejercicio_estatico values("Aguante en half touch",0);
insert into Ejercicio_estatico values("Aguante en front touch",0);


insert into Ejercicio_estatico values("Aguante de tuck en paralelas con goma",0);
insert into Ejercicio_estatico values("Aguante de tuck advance en paralelas con goma",0);
insert into Ejercicio_estatico values("Aguante de straddle en paralelas con goma",0);
insert into Ejercicio_estatico values("Aguante de full en paralelas con goma",0);

insert into Ejercicio_estatico values("Aguante de tuck en paralelas",0);
insert into Ejercicio_estatico values("Aguante de tuck advance en paralelas",0);
insert into Ejercicio_estatico values("Aguante de straddle en paralelas",0);
insert into Ejercicio_estatico values("Aguante de full en paralelas",0);

insert into Ejercicio_estatico values("Aguante de tuck en suelo con goma",0);
insert into Ejercicio_estatico values("Aguante de tuck advance en suelo con goma",0);
insert into Ejercicio_estatico values("Aguante de straddle en suelo con goma",0);
insert into Ejercicio_estatico values("Aguante de full en suelo con goma",0);


insert into Ejercicio_estatico values("Aguante de tuck en suelo",0);
insert into Ejercicio_estatico values("Aguante de tuck advance en suelo",0);
insert into Ejercicio_estatico values("Aguante de straddle en suelo",0);
insert into Ejercicio_estatico values("Aguante de full en suelo",0);
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
