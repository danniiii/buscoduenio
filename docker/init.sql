GRANT ALL PRIVILEGES ON DATABASE mascotas TO dani;

create table mascota
(
	id_mascota serial 
		constraint id_mascota
			primary key,
	nombre varchar(15) not null,
	fecha_desaparicion timestamp not null,
	id_tipo_mascota int not null,
	n_tipo_mascota varchar(50) not null,
	id_color_1 int null,
	n_color_1 varchar(50) null,
	id_color_2 int null,
	n_color_2 varchar(50) null,
	tamanio varchar(10) not null,
	id_raza int null,
	n_raza varchar(50) null,
	id_partido int not null,
	n_partido varchar(50) not null,
	id_localidad int not null,
	n_localidad varchar(50) not null,
	comentario varchar(500) null,	
	fecha_publicacion timestamp not null,
	continua_perdido char not null	
);

create table partidos
(
	id_partido serial 
		constraint id_partido
			primary key,
	nombre varchar(50) not null
);

create table localidades
(
	id_localidad serial 
		constraint id_localidad
			primary key,
	id_partido int,
	nombre varchar(50) not null,
	constraint id_partido_fk
		foreign key (id_partido) references partidos (id_partido)
);


create table colores
(
	id_color serial 
		constraint id_color
			primary key,
	nombre varchar(50) not null
);


create table tipo_mascota
(
	id_tipo_mascota serial 
		constraint id_tipo_mascota
			primary key,
	nombre varchar(50) not null
);

create table razas
(
	id_raza serial 
		constraint id_raza
			primary key,
	id_tipo_mascota int,
	nombre varchar(50) not null,
	constraint id_partido_fk
		foreign key (id_tipo_mascota) references tipo_mascota (id_tipo_mascota)
);

/*INSERT INTO mascota(nombre, fecha_desaparicion, tipo_mascota, color_1, tamanio, id_localidad, comentario, fecha_publicacion, continua_perdido)
			 VALUES('RUMA','05/05/2020', 1, 2, '25', 13, 'nada', current_timestamp, 'N');
INSERT INTO mascota(nombre, fecha_desaparicion, tipo_mascota, color_1, tamanio, id_localidad, comentario, fecha_publicacion, continua_perdido)
			 VALUES('CLEO','03/08/2020', 1, 3, '63', 13, 'color atigrado', current_timestamp, 'N');
INSERT INTO mascota(nombre, fecha_desaparicion, tipo_mascota, color_1, tamanio, id_localidad, comentario, fecha_publicacion, continua_perdido)
			 VALUES('BOLT','04/03/2020', 1, 4, '53', 13, 'perro peludo', current_timestamp, 'N');*/

INSERT INTO partidos (nombre) values ('LA MATANZA');
INSERT INTO partidos (nombre) values ('TRES DE FEBRERO');
INSERT INTO partidos (nombre) values ('HURLINGHAM');
INSERT INTO partidos (nombre) values ('MORON');
INSERT INTO partidos (nombre) values ('ITUZAINGO');
INSERT INTO partidos (nombre) values ('MERLO');
INSERT INTO partidos (nombre) values ('MORENO');
INSERT INTO partidos (nombre) values ('GENERAL RODRIGUEZ');
INSERT INTO partidos (nombre) values ('MARCOS PAZ');



INSERT INTO localidades (id_partido, nombre) values ('1', 'SAN JUSTO');
INSERT INTO localidades (id_partido, nombre) values ('1', '20 DE JUNIO');
INSERT INTO localidades (id_partido, nombre) values ('1', 'ALDO BONZI');
INSERT INTO localidades (id_partido, nombre) values ('1', 'CIUDAD EVITA');
INSERT INTO localidades (id_partido, nombre) values ('1', 'GONZALEZ CATAN');
INSERT INTO localidades (id_partido, nombre) values ('1', 'GREGORIO DE LAFERRERE');
INSERT INTO localidades (id_partido, nombre) values ('1', 'ISIDRO CASANOVA');
INSERT INTO localidades (id_partido, nombre) values ('1', 'LA TABLADA');
INSERT INTO localidades (id_partido, nombre) values ('1', 'LOMAS DEL MIRADOR');
INSERT INTO localidades (id_partido, nombre) values ('1', 'RAFAEL CASTILLO');
INSERT INTO localidades (id_partido, nombre) values ('1', 'RAMOS MEJIA');
INSERT INTO localidades (id_partido, nombre) values ('1', 'TAPIALES');
INSERT INTO localidades (id_partido, nombre) values ('1', 'VILLA LUZURIAGA');
INSERT INTO localidades (id_partido, nombre) values ('1', 'VILLA MADERO');
INSERT INTO localidades (id_partido, nombre) values ('1', 'VIRREY DEL PINO');
INSERT INTO localidades (id_partido, nombre) values ('4', 'MORON');
INSERT INTO localidades (id_partido, nombre) values ('4', 'CASTELAR');
INSERT INTO localidades (id_partido, nombre) values ('4', 'HAEDO');
INSERT INTO localidades (id_partido, nombre) values ('4', 'EL PALOMAR');
INSERT INTO localidades (id_partido, nombre) values ('4', 'VILLA SARMIENTO');
INSERT INTO localidades (id_partido, nombre) values ('2', 'CASEROS');
INSERT INTO localidades (id_partido, nombre) values ('2', 'CHURRUCA');
INSERT INTO localidades (id_partido, nombre) values ('2', 'CIUDAD JARDIN LOMAS DEL PALOMAR');
INSERT INTO localidades (id_partido, nombre) values ('2', 'CIUDADELA');
INSERT INTO localidades (id_partido, nombre) values ('2', 'EL LIBERTADOR');
INSERT INTO localidades (id_partido, nombre) values ('2', 'JOSE INGENIEROS');
INSERT INTO localidades (id_partido, nombre) values ('2', 'LOMA HERMOSA');
INSERT INTO localidades (id_partido, nombre) values ('2', 'MARTIN CORONADO');
INSERT INTO localidades (id_partido, nombre) values ('2', 'ONCE DE SEPTIEMBRE');
INSERT INTO localidades (id_partido, nombre) values ('2', 'PABLO PODESTA');
INSERT INTO localidades (id_partido, nombre) values ('2', 'SAENZ PEÑA');
INSERT INTO localidades (id_partido, nombre) values ('2', 'SANTOS LUGARES');
INSERT INTO localidades (id_partido, nombre) values ('2', 'VILLA BOSCH');
INSERT INTO localidades (id_partido, nombre) values ('2', 'VILLA RAFFO');
INSERT INTO localidades (id_partido, nombre) values ('3', 'HURLINGHAM');
INSERT INTO localidades (id_partido, nombre) values ('3', 'VILLA TESEI');
INSERT INTO localidades (id_partido, nombre) values ('3', 'WILLIAM C. MORRIS');
INSERT INTO localidades (id_partido, nombre) values ('5', 'ITUZAINGO');
INSERT INTO localidades (id_partido, nombre) values ('5', 'VILLA UDAONDO');
INSERT INTO localidades (id_partido, nombre) values ('6', 'MERLO');
INSERT INTO localidades (id_partido, nombre) values ('6', 'SAN ANTONIO DE PADUA');
INSERT INTO localidades (id_partido, nombre) values ('6', 'LIBERTAD');
INSERT INTO localidades (id_partido, nombre) values ('6', 'MARIANO ACOSTA');
INSERT INTO localidades (id_partido, nombre) values ('6', 'PARQUE SAN MARTIN');
INSERT INTO localidades (id_partido, nombre) values ('6', 'PONTEVEDRA');
INSERT INTO localidades (id_partido, nombre) values ('7', 'MORENO');
INSERT INTO localidades (id_partido, nombre) values ('7', 'LA REJA');
INSERT INTO localidades (id_partido, nombre) values ('7', 'FRANCISCO ALVAREZ');
INSERT INTO localidades (id_partido, nombre) values ('7', 'CUARTEL V');
INSERT INTO localidades (id_partido, nombre) values ('7', 'TRUJUI');
INSERT INTO localidades (id_partido, nombre) values ('7', 'PASO DEL REY');
INSERT INTO localidades (id_partido, nombre) values ('8', 'GENERAL RODRIGUEZ');
INSERT INTO localidades (id_partido, nombre) values ('9', 'MARCOS PAZ');
INSERT INTO localidades (id_partido, nombre) values ('9', 'ELIAS ROMERO');
INSERT INTO localidades (id_partido, nombre) values ('9', 'SANTA ROSA');
INSERT INTO localidades (id_partido, nombre) values ('9', 'LISANDRO DE LA TORRE');
INSERT INTO localidades (id_partido, nombre) values ('9', 'SANTA MARTA');


INSERT INTO colores (nombre) values ('BLANCO');
INSERT INTO colores (nombre) values ('NEGRO');
INSERT INTO colores (nombre) values ('MARRON OSCURO');
INSERT INTO colores (nombre) values ('MARRON CLARO');
INSERT INTO colores (nombre) values ('BEIGE');
INSERT INTO colores (nombre) values ('GRIS CLARO');
INSERT INTO colores (nombre) values ('GRIS OSCURO');
INSERT INTO colores (nombre) values ('ARENA');
INSERT INTO colores (nombre) values ('VERDE');
INSERT INTO colores (nombre) values ('AMARILLO');


INSERT INTO tipo_mascota (nombre) values ('PERRO');
INSERT INTO tipo_mascota (nombre) values ('GATO');
INSERT INTO tipo_mascota (nombre) values ('PALOMA');
INSERT INTO tipo_mascota (nombre) values ('LORO');
INSERT INTO tipo_mascota (nombre) values ('COTORRA');
INSERT INTO tipo_mascota (nombre) values ('HAMSTER');
INSERT INTO tipo_mascota (nombre) values ('HURON');
INSERT INTO tipo_mascota (nombre) values ('PAJARO');


INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'AFFENPINSCHER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'AIREDALE TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'AÏDI');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'AKITA INU');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'AKITA AMERICANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'ALANO ESPAÑOL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'ALASKAN MALAMUTE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'ALASKAN KLEE KAI');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'AMERICAN HAIRLESS TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'AMERICAN STAFFORDSHIRE TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'ANTIGUO PERRO PASTOR INGLÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'APPENZELLER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'AUSTRALIAN CATTLE DOG');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'AUSTRALIAN TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'AUSTRALIAN SILKY TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'AZAWAKH');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BARDINO (PERRO MAJORERO)');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BANDOG');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BASENJI');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BASSET AZUL DE GASCUÑA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BASSET HOUND');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BEAGLE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BEAUCERON');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BEDLINGTON TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BERGAMASCO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BICHON FRISÉ');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BICHÓN MALTÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BICHÓN HABANERO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BOBTAIL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BLOODHOUND');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BORDER COLLIE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BORZOI');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BOSTON TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BÓXER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BOYERO DE BERNA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BOYERO DE FLANDES');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BRACO ALEMÁN DE PELO CORTO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BRACO ALEMÁN DE PELO DURO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BRACO DE AUVERNIA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BRACO FRANCÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BRACO HÚNGARO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BRACO ITALIANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BRACO TIROLÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BRACO DE SAINT GERMAIN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BRACO DE WEIMAR');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BULL TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BULLDOG AMERICANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BULLDOG FRANCÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BULLDOG INGLÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BULLMASTIFF');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BUHUND NORUEGO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CALUPOH');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CAN DE PALLEIRO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CANICHE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CÃO DA SERRA DA ESTRELA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CÃO DA SERRA DE AIRES');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CÃO DE AGUA PORTUGUÊS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CÃO DE CASTRO LABOREIRO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CÃO DE FILA DE SÃO MIGUEL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CAVALIER KING CHARLES SPANIEL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CAZADOR DE ALCES NORUEGO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CHESAPEAKE BAY RETRIEVER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CHIHUAHUEÑO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CRESTADO CHINO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CIMARRÓN URUGUAYO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CIRNECO DEL ETNA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CHOW CHOW');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CLUMBER SPANIEL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'COBRADOR DE PELO LISO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'COCKER SPANIEL AMERICANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'COCKER SPANIEL INGLÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'COLLIE DE PELO CORTO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'COLLIE DE PELO LARGO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'BEARDED COLLIE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'CORGI GALÉS DE CARDIGAN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'DACHSHUND');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'DÁLMATA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'DANDIE DINMONT TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'DEERHOUND');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'DOBERMANN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'DOGO ALEMÁN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'DOGO ARGENTINO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'DOGO DE BURDEOS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'DOGO DEL TÍBET');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'DOGO GUATEMALTECO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'ENGLISH SPRINGER SPANIEL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'ENTLEBUCHER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'ÉPAGNEUL BRETÓN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'ÉPAGNEUL FRANÇAIS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'EPAGNEUL PAPILLÓN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'EURASIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'FILA BRASILEIRO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'FLAT-COATED RETRIEVER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'FOX TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'FOXHOUND AMERICANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'GALGO ESPAÑOL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'GALGO HÚNGARO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'GALGO INGLÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'GALGO ITALIANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'GOLDEN RETRIEVER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'GLEN OF IMAAL TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'GRAN DANÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'GEGAR COLOMBIANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'GREYHOUND');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'GRIFÓN BELGA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'HOVAWART');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'HUSKY SIBERIANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'JACK RUSSELL TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'KEESHOND');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'KERRY BLUE TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'KOMONDOR');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'KUVASZ');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'LABRADOR');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'LAKELAND TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'LAEKENOIS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'LANDSEER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'LEBREL AFGANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'LEBREL POLACO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'LEONBERGER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'LOBERO IRLANDÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'LUNDEHUND');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERRO LOBO DE SAARLOOS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'LHASA APSO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'LÖWCHEN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'MALTÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'MALINOIS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'MANCHESTER TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'MASTÍN AFGANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'MASTÍN DEL PIRINEO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'MASTÍN ESPAÑOL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'MASTÍN INGLÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'MASTÍN ITALIANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'MASTÍN NAPOLITANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'MASTÍN TIBETANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'MUCUCHIES');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'MUDI');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'MÜNSTERLÄNDER GRANDE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'MÜNSTERLÄNDER PEQUEÑO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'NOVA SCOTIA DUCK TOLLING RETRIEVER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'OVEJERO MAGALLÁNICO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR ALEMÁN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR BELGA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR BLANCO SUIZO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR CATALÁN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR CROATA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR GARAFIANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR HOLANDÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR PERUANO CHIRIBAYA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR DE BRIE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR DE LOS PIRINEOS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR LEONÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR MALLORQUÍN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR MAREMMANO-ABRUCÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR DE VALÉE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PASTOR VASCO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PEKINÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PEMBROKE WELSH CORGI');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PEQUEÑO LEBREL ITALIANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERDIGUERO FRANCÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERDIGUERO PORTUGUÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERRO CIMARRÓN URUGUAYO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERRO DE AGUA AMERICANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERRO DE AGUA ESPAÑOL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERRO DE AGUA IRLANDÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERRO DE AGUA PORTUGUÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERRO DE GROENLANDIA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERRO DE OSOS DE CARELIA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERRO DOGO MALLORQUÍN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERRO ESQUIMAL CANADIENSE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERRO DE MONTAÑA DE LOS PIRINEOS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERRO FINO COLOMBIANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERRO PASTOR DE LAS ISLAS SHETLAND');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PERRO PERUANO SIN PELO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PHALÈNE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PINSCHER ALEMÁN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PINSCHER MINIATURA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PITBULL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PODENCO CANARIO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PODENCO IBICENCO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PODENCO PORTUGUÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'POINTER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'POMERANIA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PRESA CANARIO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PUDELPOINTER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PUG');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PULI');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'PUMI');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'RAFEIRO DO ALENTEJO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'RATONERO BODEGUERO ANDALUZ');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'RATONERO MALLORQUÍN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'RATONERO VALENCIANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'RHODESIAN RIDGEBACK');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'ROTTWEILER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SALUKI');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SAMOYEDO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SAN BERNARDO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SCHAPENDOES');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SCHNAUZER ESTÁNDAR');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SCHNAUZER GIGANTE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SCHNAUZER MINIATURA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'STAFFORDSHIRE BULL TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SABUESO BOSNIO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SCHIPPERKE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SEALYHAM TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SETTER INGLÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SETTER IRLANDÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SHAR PEI');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SHIBA INU');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SHIH TZU');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SHIKOKU INU');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SIBERIAN HUSKY');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SKYE TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SPANIEL JAPONÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SPANIEL TIBETANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SPITZ ENANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SPITZ GRANDE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SPITZ MEDIANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SPITZ JAPONÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'SUSSEX SPANIEL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TECKEL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TERRANOVA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TERRIER ALEMÁN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TERRIER BRASILEÑO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TERRIER CHECO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TERRIER CHILENO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TERRIER DE NORFOLK');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TERRIER DE NORWICH');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TERRIER ESCOCÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TERRIER GALÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TERRIER IRLANDÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TERRIER RUSO NEGRO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TERRIER TIBETANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TOY SPANIEL INGLÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'TERVUEREN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'VALLHUND SUECO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'VOLPINO ITALIANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'WEIMARANER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'WEST HIGHLAND WHITE TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'WHIPPET');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'WOLFSSPITZ');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'XOLOITZCUINTLE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('1', 'YORKSHIRE TERRIER');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'ABISINIO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'AMERICAN CURL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'AZUL RUSO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'AMERICAN SHORTHAIR');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'AMERICAN WIREHAIR');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'ANGORA TURCO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'AFRICANO DOMÉSTICO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'BENGALA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'BOBTAIL JAPONÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'BOMBAY');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'BOSQUE DE NORUEGA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'BRAZILIAN SHORTHAIR');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'BRIVON DE PELO CORTO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'BRIVON DE PELO LARGO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'BRITISH SHORTHAIR');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'BURMÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'BURMILLA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'CORNISH REX');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'CALIFORNIA SPANGLED');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'CYMRIC');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'CHARTREUX');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'CAREX');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'GATO CAREY');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'DEUTSCH LANGHAAR');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'DEVON REX');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'DORADO AFRICANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'DON SPHYNX');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'DRAGON LI');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'EUROPEO COMÚN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'EXÓTICO DE PELO CORTO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'GATO EUROPEO BICOLOR');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'FOLDEX');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'GERMAN REX');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'HABANA BROWN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'HIMALAYO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'KORAT');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'KHAO MANEE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'MAINE COON');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'MANX');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'MAU EGIPCIO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'MUNCHKIN');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'OCICAT');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'ORIENTAL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'ORIENTAL DE PELO LARGO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'PERFOLD1​');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'PERSA AMERICANO O MODERNO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'PERSA CLÁSICO O TRADICIONAL2​');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'PETERBALD');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'PIXIE BOB');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'RAGDOLL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'SAGRADO DE BIRMANIA');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'SAVANNAH');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'SCOTTISH FOLD');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'SELKIRK REX');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'SERENGETI');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'SEYCHELLOIS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'SIAMÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'SIAMÉS MODERNO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'SIAMÉS TRADICIONAL');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'SIBERIANO');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'SNOWSHOE');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'SPHYNX');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'TONKINÉS');
INSERT INTO razas (id_tipo_mascota, nombre) values ('2', 'VAN TURCO');



