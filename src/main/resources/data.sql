----------------------------------INSERTS USUARIO----------------------------------
INSERT INTO public.usuario_javeriana(	dtype, apellidos, estado_enum, nombre, password, username)VALUES ('Estudiante','Sánchez','NUEVO','Daniel','123456','daniel');
INSERT INTO public.usuario_javeriana(	dtype, apellidos, estado_enum, nombre, password, username)VALUES ('Administrador','Ortiz','NUEVO','Efrain','123456','efrain');

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

----------------------------------INSERTS SERVICIOS----------------------------------
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('ConsultaCursos', 'https://rhg.javeriana.edu.co/psc/HR9GUEST/EMPLOYEE/HR9GUEST/c/ESTABLISH_COURSES.UJ_CATALOGO_CONSUL.GBL', 1);
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('ConsultaClases', 'https://rhg.javeriana.edu.co/psc/HR9GUEST/EMPLOYEE/HR9GUEST/c/ESTABLISH_COURSES.CLASS_SEARCH.GBL', 1);
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('TalleresLiderazgo', 'http://www.javeriana.edu.co/medio-universitario/curso-taller-liderazgo', 1);
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('EventosJaveriana', 'http://www.javeriana.edu.co/medio-universitario/eventos', 1);
INSERT INTO public.servicio(nombre, url, dominio_id) VALUES ('SalasReservadas', 'http://www.javeriana.edu.co/dir-tecnologias-de-informacion/salas-reservadas', 1);