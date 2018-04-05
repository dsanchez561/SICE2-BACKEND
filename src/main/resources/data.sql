----------------------------------INSERTS USUARIO----------------------------------
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador)VALUES ('Estudiante','Sánchez Andrade','NUEVO','Daniel Santiago','123456','daniel',false);
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador)VALUES ('Administrador','Ortiz Pabón','NUEVO','Efrain','123456','efrain',true);
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador)VALUES ('Estudiante','Acuña Garzón','NUEVO','David Alberto','123456','david',false);
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador)VALUES ('Estudiante','Guerrero Danderino','NUEVO','Brayan','123456','brayan',false);
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador)VALUES ('Estudiante','Gaitan Bautista','NUEVO','Pablo','123456','pGaitan',false);
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador)VALUES ('Estudiante','Velasco Zambrano','NUEVO','David','123456','dVelazco',false);
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador)VALUES ('Estudiante','Mendoza Rincón','NUEVO','Maria Jose','123456','mMendoza',false);
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador)VALUES ('Estudiante','Moreno','NUEVO','Camilo Andres','123456','cMoreno',false);
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador)VALUES ('Estudiante','Suarez','NUEVO','Hernan Joaquin','123456','jSuarez',false);

----------------------------------INSERTS UNIVERSIDAD NACIONALES----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Pontificia Universidad Javeriana', 'http://www.javeriana.edu.co/home',true, 'UniversidadJaveriana.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Los Andes', 'https://uniandes.edu.co/',true, 'UniversidadAndes.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad El Bosque', 'http://www.uelbosque.edu.co/',true, 'UniversidadBosque.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Nacional De Colombia', 'http://unal.edu.co/',true, 'UniversidadNacional.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Distrital Francisco José de Caldas', 'https://www.udistrital.edu.co/',false, 'UniversidadDistrital.png');

----------------------------------INSERTS GOBIERNO NACIONAL----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('GOBIERNO',true,'Recon', 'https://www.reconcolombia.org/',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('GOBIERNO',true,'Ministerio de Tecnologías y las Comunicaciones de Colombia', 'http://www.mintic.gov.co/portal/604/w3-propertyvalue-1057.html',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('GOBIERNO',true,'iNNpulsa Colombia', 'https://www.innpulsacolombia.com/es/',true, 'UniversidadDistrital.png');

----------------------------------INSERTS MENTORES NACIONAL----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('RED_MENTORES',true,'Endeavor Colombia', 'https://www.endeavor.org.co/mentores-endeavor/',true, 'UniversidadDistrital.png');

----------------------------------INSERTS ACELERADORAS NACIONAL----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('RED_ACELERADORAS',true,'Wayra', 'https://www.openfuture.org/es/space/wayra-bogota',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('RED_ACELERADORAS',true,'Rockstart', 'https://www.rockstart.com/blog/rockstart-announces-web-mobile-accelerator-colombia/',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('RED_ACELERADORAS',false,'Socialab', 'http://co.socialab.com/',true, 'UniversidadDistrital.png');

----------------------------------INSERTS ONG NACIONAL----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('ONG',true,'Acción emprendedora', 'http://www.accionemprendedora.org/',true, 'UniversidadDistrital.png');

----------------------------------INSERTS FINANCIADORES NACIONAL----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('RED_FINANCIADORES',true,'RED iNNvest', 'http://www.redinnvest.com/que-es-la-red-cleantech-innvest/',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('RED_FINANCIADORES',true,'Fondo Emprender', 'http://www.fondoemprender.com/SitePages/Home.aspx',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('RED_FINANCIADORES',true,'Red emprendeverde', 'http://www.redemprendeverde.es/pg/pages/view/165/Inversi%C3%B3n/',true, 'UniversidadDistrital.png');

----------------------------------INSERTS UNIVERSIDAD INTERNACIONAL----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University of Utah', 'http://lassonde.utah.edu/calendar/',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University of Bristol', 'http://www.bristol.ac.uk/innovation/entrepreneurship/',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,' University of Cambridge', 'https://www.jbs.cam.ac.uk/entrepreneurship/',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,' University of Miami', 'https://www.bus.miami.edu/academic-programs/undergraduate-business-education/business-curriculum/majors/entrepreneurship/index.html',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,' University of Pekin', 'http://ostd.pku.edu.cn/Innovation_Entrepreneurship_Education_and_Research/index.htm',true, 'UniversidadDistrital.png');

----------------------------------INSERTS ACELERADORAS INTERNACIONAL----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('RED_ACELERADORAS',false,'REDEMPRENDIA', 'https://www.redemprendia.org/es/content/red-de-aceleradoras-de-empresas-del-tecnologico-de-monterrey',true, 'UniversidadDistrital.png');
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','28/04/2018', '25/04/2018', 'Esta actividad no tiene ningún requisito', 'Cambiatón', 2);

----------------------------------INSERTS EVENTOS ----------------------------------
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id) VALUES ('Actividad', 'Evento que pone a prueba tus habilidades de programador, ¡anímate a participar!','04/04/2018', '04/04/2018', 'Esta actividad no tiene ningún requisito', 'Maratón de Programación', 2);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id) VALUES ('Actividad', 'Evento que pone a prueba tus habilidades de trabajo en equipo y de programación, ¡anímate a participar!','10/04/2018', '08/04/2018', 'Esta actividad no tiene ningún requisito', 'HACKATON 2018', 2);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','11/04/2018', '08/04/2018', 'Esta actividad no tiene ningún requisito', 'Charla motivacional de emprendedores 2018', 2);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','14/04/2018', '14/04/2018', 'Esta actividad no tiene ningún requisito', 'Conferencia Emprende Más', 2);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','17/04/2018', '15/04/2018', 'Esta actividad no tiene ningún requisito', 'Google Conference', 2);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','22/04/2018', '20/04/2018', 'Esta actividad no tiene ningún requisito', 'Microsoft en la Javeriana', 2);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','28/04/2018', '28/04/2018', 'Esta actividad no tiene ningún requisito', 'Inovatón', 2);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','01/05/2018', '01/05/2018', 'Esta actividad no tiene ningún requisito', 'Emprendetón', 2);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','20/05/2018', '20/05/2018', 'Esta actividad no tiene ningún requisito', 'Emprendetón Vol. 2', 2);
			
----------------------------------INSERTS EVENTOS_INSCRITOS ----------------------------------
INSERT INTO public.evento_inscritos(eventos_suscritos_id, inscritos_id) VALUES (1, 1);
INSERT INTO public.evento_inscritos(eventos_suscritos_id, inscritos_id) VALUES (1, 3);
INSERT INTO public.evento_inscritos(eventos_suscritos_id, inscritos_id) VALUES (1, 4);
INSERT INTO public.evento_inscritos(eventos_suscritos_id, inscritos_id) VALUES (2, 5);
INSERT INTO public.evento_inscritos(eventos_suscritos_id, inscritos_id) VALUES (2, 6);
INSERT INTO public.evento_inscritos(eventos_suscritos_id, inscritos_id) VALUES (2, 7);

----------------------------------INSERTS SERVICIOS----------------------------------
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('ConsultaCursos', 'https://rhg.javeriana.edu.co/psc/HR9GUEST/EMPLOYEE/HR9GUEST/c/ESTABLISH_COURSES.UJ_CATALOGO_CONSUL.GBL', 1);
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('ConsultaClases', 'https://rhg.javeriana.edu.co/psc/HR9GUEST/EMPLOYEE/HR9GUEST/c/ESTABLISH_COURSES.CLASS_SEARCH.GBL', 1);
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('TalleresLiderazgo', 'http://www.javeriana.edu.co/medio-universitario/curso-taller-liderazgo', 1);
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('EventosJaveriana', 'http://www.javeriana.edu.co/medio-universitario/eventos', 1);
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('SalasReservadas', 'http://www.javeriana.edu.co/dir-tecnologias-de-informacion/salas-reservadas', 1);