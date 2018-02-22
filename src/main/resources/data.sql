----------------------------------INSERTS USUARIO----------------------------------

INSERT INTO public.usuario_javeriana(	dtype, apellidos, estado_enum, nombre, password, username)VALUES ('Estudiante','Sánchez','NUEVO','Daniel','123456','daniel');

----------------------------------INSERTS UNIVERSIDAD----------------------------------
INSERT INTO public.dominio(dtype,nombre, url, activo, nombre_archivo)VALUES ('Universidad','Pontificia Universidad Javeriana', 'http://www.javeriana.edu.co/home',true, 'UniversidadJaveriana.png');
INSERT INTO public.dominio(dtype,nombre, url, activo, nombre_archivo)VALUES ('Universidad','Universidad Los Andes', 'https://uniandes.edu.co/',true, 'UniversidadAndes.png');
INSERT INTO public.dominio(dtype,nombre, url, activo, nombre_archivo)VALUES ('Universidad','Universidad El Bosque', 'http://www.uelbosque.edu.co/',true, 'UniversidadBosque.png');
INSERT INTO public.dominio(dtype,nombre, url, activo, nombre_archivo)VALUES ('Universidad','Universidad Nacional De Colombia', 'http://unal.edu.co/',true, 'UniversidadNacional.png');
INSERT INTO public.dominio(dtype,nombre, url, activo, nombre_archivo)VALUES ('Universidad','Universidad Distrital Francisco José de Caldas', 'https://www.udistrital.edu.co/',false, 'UniversidadDistrital.png');
