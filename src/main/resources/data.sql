----------------------------------INSERTS USUARIO----------------------------------

INSERT INTO public.usuario_javeriana(	dtype, apellidos, estado_enum, nombre, password, username)VALUES ('Estudiante','Sánchez','NUEVO','Daniel','123456','daniel');
INSERT INTO public.usuario_javeriana(	dtype, apellidos, estado_enum, nombre, password, username)VALUES ('Administrador','Ortiz','NUEVO','Efrain','123456','efrain');

----------------------------------INSERTS UNIVERSIDAD NACIONALES----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Pontificia Universidad Javeriana', 'http://www.javeriana.edu.co/noticias/eventos',true, 'UniversidadJaveriana.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Los Andes', 'https://uniandes.edu.co/es/eventos-destacados',true, 'UniversidadAndes.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad El Bosque', 'http://www.uelbosque.edu.co/centro-informacion/eventos',true, 'UniversidadBosque.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Nacional De Colombia', 'http://www.fce.unal.edu.co/directorio-administrativo/unidades-de-apoyo/unidad-de-emprendimiento-e-innovacion.html',true, 'UniversidadNacional.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Distrital Francisco José de Caldas', 'https://www.udistrital.edu.co/eventos-universitarios',false, 'UniversidadDistrital.png');
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
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad del Rosario', 'http://www.urosario.edu.co/Centro-de-Emprendimiento/Eventos/',false, 'UniversidadRosario.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'ECCI', 'https://www.ecci.edu.co/es/unidad-de-emprendimiento-192?language_content_entity=es',false, 'Ecci.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'EAN', 'https://universidadean.edu.co/es/eventos',false, 'Ean.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad de Antioquia', 'http://www.udea.edu.co/wps/portal/udea/web/inicio/extension-UdeA/gestion-tecnologica/emprendimiento',false, 'UdeA.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Industrial de Santander', 'http://www.uis.edu.co/webUIS/es/calendario/dia.jsp',false, 'UniversidadSantander.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad del Valle', 'http://extension.univalle.edu.co/index.php/programa-emprendedores-univalle',false, 'UniversidadValle.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad del Norte', 'https://www.uninorte.edu.co/web/centro-de-emprendimiento/concurso-emprende-uninorte',false, 'UniversidadNorte.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad del Cauca', 'http://oportunidadeslaborales.portal.unicauca.edu.co/detallecontenido/idnoticia/10307/',false, 'UniversidadCauca.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad tecnológica de pereira', 'https://comunicaciones.utp.edu.co/noticias/24814/utp-ofrece-ayuda-a-emprendedores',false, 'UniversidadTecPereira.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Pontificia Bolivariana', 'https://www.upb.edu.co/es/investigacion/emprendimiento',false, 'UniversidadBolivariana.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Antonio Nariño', 'http://investigacion.uan.edu.co/noticias?option=com_content&view=article&id=94:curso-de-emprendimiento&catid=26:noticias&Itemid=101',false, 'Uan.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad La Sabana', 'https://www.unisabana.edu.co/empresaysociedad/vision-otri/seis/emprendedores-con-sello-sabana/',false, 'UniSabana.png');






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