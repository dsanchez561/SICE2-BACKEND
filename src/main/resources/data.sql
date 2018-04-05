----------------------------------INSERTS USUARIO----------------------------------

INSERT INTO public.usuario_javeriana(	dtype, apellidos, estado_enum, nombre, password, username)VALUES ('Estudiante','Sánchez','NUEVO','Daniel','123456','daniel');
INSERT INTO public.usuario_javeriana(	dtype, apellidos, estado_enum, nombre, password, username)VALUES ('Administrador','Ortiz','NUEVO','Efrain','123456','efrain');

----------------------------------INSERTS UNIVERSIDAD NACIONALES----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Pontificia Universidad Javeriana', 'http://www.javeriana.edu.co/home',true, 'UniversidadJaveriana.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Los Andes', 'https://uniandes.edu.co/',true, 'UniversidadAndes.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad El Bosque', 'http://www.uelbosque.edu.co/',true, 'UniversidadBosque.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Nacional De Colombia', 'http://unal.edu.co/',true, 'UniversidadNacional.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Distrital Francisco José de Caldas', 'https://www.udistrital.edu.co/',false, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Rafael Landívar', 'http://principal.url.edu.gt/index.php/home/eventos-url',false, 'UniversidadRafaelLandivar.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Centroamericana José Simeón Cañas', 'http://www.uca.edu.sv/',false, 'UniversidadCentroamericana.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Pontificia Universidad Católica del Ecuador', 'https://www.puce.edu.ec/portal/content/Pontificia%20Universidad%20Cat%C3%B3lica%20del%20Ecuador/0?link=oln266n.redirect',false, 'UniversidadCatolicaEcuador.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Alberto Hurtado', 'http://www.uahurtado.cl/red-internacional/',false, 'UniversidadHurtado.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'La Universidad de Vale do Rio dos Sinos (Unisinos)', 'http://www.unisinos.br/portal-de-inovacao/',false, 'UniversidadDeVale.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Pontifícia Universidade Católica do Rio de Janeiro', 'http://www.puc-rio.br/english/#international_coop',false, 'UniversidadRioJaneiro.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Iberoamericana León', 'https://www.leon.uia.mx/index.cfm',false, 'UniversidadIberoamericana.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Loyola del Pacífico', 'https://ulpgro.mx/visitantes/95-portal-c/668-asi-se-vivio-la-ceremonia-de-egreso-de-prepa-loyola-portal',false, 'UniversidadLoyola.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Centroamericana UCA', 'http://www.uca.edu.ni/index.php?lang=es',false, 'UniversidadUCA.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Antonio Ruiz de Montoya', 'http://www.uca.edu.ni/index.php/comunicacion/agenda',false, 'UniversidadAntonio.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad del Pacífico (Perú)', 'http://emprendeup.pe/',false, 'UniversidadPacifico.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Católica de Uruguay', 'https://ucu.edu.uy/es/agenda',false, 'UniversidadCatolicaUruguay.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Católica Andrés Bello', 'https://www.ucab.edu.ve/estudios/',false, 'UniversidadCatolicaAndres.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Católica del Táchira', 'http://www.ucat.edu.ve/web/evento/',false, 'UniversidadTachira.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Jesuitas Centro Loyola', 'http://centroloyola.com.ar/agenda/',false, 'JesuitasCentroLoyola.png');




----------------------------------INSERTS UNIVERSIDAD INTERNACIONALES----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University of Utah', 'http://lassonde.utah.edu/calendar/',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University of Bristol', 'http://www.bristol.ac.uk/innovation/entrepreneurship/',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,' University of Cambridge', 'https://www.jbs.cam.ac.uk/entrepreneurship/',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,' University of Miami', 'https://www.bus.miami.edu/academic-programs/undergraduate-business-education/business-curriculum/majors/entrepreneurship/index.html',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,' University of Pekin', 'http://ostd.pku.edu.cn/Innovation_Entrepreneurship_Education_and_Research/index.htm',true, 'UniversidadDistrital.png');

----------------------------------INSERTS GOBIERNO NACIONAL----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('GOBIERNO',true,' Recon', 'https://www.reconcolombia.org/',true, 'UniversidadDistrital.png');


----------------------------------INSERTS SERVICIOS----------------------------------
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('ConsultaCursos', 'https://rhg.javeriana.edu.co/psc/HR9GUEST/EMPLOYEE/HR9GUEST/c/ESTABLISH_COURSES.UJ_CATALOGO_CONSUL.GBL', 1);
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('ConsultaClases', 'https://rhg.javeriana.edu.co/psc/HR9GUEST/EMPLOYEE/HR9GUEST/c/ESTABLISH_COURSES.CLASS_SEARCH.GBL', 1);
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('TalleresLiderazgo', 'http://www.javeriana.edu.co/medio-universitario/curso-taller-liderazgo', 1);
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('EventosJaveriana', 'http://www.javeriana.edu.co/medio-universitario/eventos', 1);
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('SalasReservadas', 'http://www.javeriana.edu.co/dir-tecnologias-de-informacion/salas-reservadas', 1);