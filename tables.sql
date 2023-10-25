--Crear tablas
CREATE TABLE usuarios(
	id int not null,
	nombre VARCHAR(50) not null,
	email VARCHAR(50) not null,
	clave VARCHAR(15) not null,
	rol VARCHAR(20) not null
);

CREATE TABLE equipos(
	idEquipo INT not null,
	nombre VARCHAR(50) not null,
	descripcion VARCHAR(50) not null,
	disponible BOOLEAN not null,
	dar_baja BOOLEAN not NULL
);


CREATE TABLE novedades(
	id INT not null,
	fecha TIME not null,
	titulo VARCHAR(20) not null,	
	carnet INT not null,
	detalle VARCHAR(100) not null,
	idEquipo INT,
	idElemento INT 
);

CREATE TABLE elementos(
	idElemento INT not null,
	nombre VARCHAR(50) not null,
	descripcion VARCHAR(50) not null,
	disponible BOOLEAN not null,
	dar_baja BOOLEAN not null,
	eqps int
);

CREATE TABLE elementosPorEquipo(
	idEquipo INT not null,
	idElemento INT not NULL
);

CREATE TABLE laboratorios(
	nombre VARCHAR(10) not null
);


--Primarias
ALTER TABLE usuarios ADD CONSTRAINT USUARIOS_PK primary key(id);
ALTER TABLE elementos ADD CONSTRAINT ELEMENTOS_PK primary key(idElemento);
ALTER TABLE equipos ADD CONSTRAINT EQUIPOS_PK primary key(idEquipo);
ALTER TABLE novedades ADD CONSTRAINT NOVEDADES_PK primary key(id);
ALTER TABLE elementosPorEquipo ADD CONSTRAINT ELE_EQ_PK primary key(idElemento);

--Foraneas
ALTER TABLE novedades ADD CONSTRAINT NOV_EQU_FK foreign key (idEquipo) references equipos(idEquipo);
ALTER TABLE novedades ADD CONSTRAINT NOV_ELE_FK foreign key (idElemento) references elementos(idElemento);
ALTER TABLE elementos ADD CONSTRAINT ELE_EQU_FK foreign key (eqps) references equipos(idEquipo);

--Poblar
