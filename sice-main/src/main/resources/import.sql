----------------------------------INSERTS USUARIO----------------------------------
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador,email)VALUES ('Estudiante','Sánchez Andrade','NUEVO','Daniel Santiago','123456','daniel',false,'d-sancheza@javeriana.edu.co');
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador,email)VALUES ('Administrador','Ortiz Pabón','NUEVO','Efrain','123456','efrain',true,'d-sancheza@javeriana.edu.co');
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador,email)VALUES ('Estudiante','Acuña Garzón','NUEVO','David Alberto','123456','david',false,'david.acuna@javeriana.edu.co');
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador,email)VALUES ('Estudiante','Guerrero Danderino','NUEVO','Brayan','123456','brayan',false,'b.guerrero@javeriana.edu.co');
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador)VALUES ('Estudiante','Gaitan Bautista','NUEVO','Pablo','123456','pGaitan',false);
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador)VALUES ('Estudiante','Velasco Zambrano','NUEVO','David','123456','dVelazco',false);
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador)VALUES ('Estudiante','Mendoza Rincón','NUEVO','Maria Jose','123456','mMendoza',false);
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador)VALUES ('Estudiante','Moreno','NUEVO','Camilo Andres','123456','cMoreno',false);
INSERT INTO public.usuario_javeriana(dtype, apellidos, estado_enum, nombre, password, username, administrador)VALUES ('Estudiante','Suarez','NUEVO','Hernan Joaquin','123456','jSuarez',false);

----------------------------------INSERTS UNIVERSIDAD NACIONALES----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Los Andes', 'https://administracion.uniandes.edu.co/index.php/es/relaciones-corporativas/centro-de-emprendimiento',true, 'UniversidadAndes.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad El Bosque', 'http://www.uelbosque.edu.co/egresados/noticia/un-emprendimiento-que-fortalece-u',true, 'UniversidadBosque.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Nacional De Colombia', 'http://www.fce.unal.edu.co/directorio-administrativo/unidades-de-apoyo/unidad-de-emprendimiento-e-innovacion.html',true, 'UniversidadNacional.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Distrital Francisco José de Caldas', 'http://laud.udistrital.edu.co/noticias/universidad-distrital-le-apuesta-al-emprendimiento',true, 'UniversidadDistrital.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Loyola del Pacífico', 'https://ulpgro.mx/alumnos/administracion/102-portal-d-administracion/500-emprendimiento',true, 'UniversidadLoyola.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad del Rosario', 'http://www.urosario.edu.co/Centro-de-Emprendimiento/Inicio/',true, 'UniversidadRosario.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'ECCI', 'https://www.ecci.edu.co/es/unidad-de-emprendimiento-192?language_content_entity=es',true, 'Ecci.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'EAN', 'https://universidadean.edu.co/es/facultades/instituto-para-el-emprendimiento-sostenible',true, 'Ean.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad de Antioquia', 'http://www.udea.edu.co/wps/portal/udea/web/inicio/extension-UdeA/gestion-tecnologica/emprendimiento',true, 'UdeA.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Industrial de Santander', 'https://www.uis.edu.co/webUIS/es/investigacionExtension/convocatoriasProgramasApoyo/programasApoyoConvocatoriasInternas/emprendimientoVIE.html',true, 'UniversidadSantander.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad del Valle', 'http://extension.univalle.edu.co/index.php/programa-emprendedores-univalle',true, 'UniversidadValle.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad del Norte', 'https://www.uninorte.edu.co/web/centro-de-emprendimiento/concurso-emprende-uninorte',true, 'UniversidadNorte.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad del Cauca', 'http://oportunidadeslaborales.portal.unicauca.edu.co/detallecontenido/idnoticia/10307/',true, 'UniversidadCauca.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad tecnológica de pereira', 'http://blog.utp.edu.co/utpemprendedora/',true, 'UniversidadTecPereira.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Pontificia Bolivariana', 'https://www.upb.edu.co/es/investigacion/emprendimiento',true, 'UniversidadBolivariana.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad Antonio Nariño', 'http://investigacion.uan.edu.co/noticias?option=com_content&view=article&id=94:curso-de-emprendimiento&catid=26:noticias&Itemid=101',true, 'Uan.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',true,'Universidad La Sabana', 'https://www.unisabana.edu.co/empresaysociedad/vision-otri/seis/emprendedores-con-sello-sabana/',true, 'UniSabana.png');

----------------------------------INSERTS UNIVERSIDAD INTERNACIONAL----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University of Utah', 'http://eccles.utah.edu/faculty/department-entrepreneurship-strategy/',true, 'UniversityOfUtah.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University of Bristol', 'http://www.bristol.ac.uk/innovation/entrepreneurship/',true, 'UniversityOfBristol.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University of Cambridge', 'https://www.jbs.cam.ac.uk/entrepreneurship/',true, 'UniversityOfCambridge.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University of Miami', 'https://www.bus.miami.edu/academic-programs/undergraduate-business-education/business-curriculum/majors/entrepreneurship/index.html',true, 'UniversityOfMiami.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University of Pekin', 'http://ostd.pku.edu.cn/Innovation_Entrepreneurship_Education_and_Research/index.htm',true, 'UniversityPekin.png');

INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University of Stanford', 'https://www.gsb.stanford.edu/faculty-research/centers-initiatives/ces',true, 'UniversityStanford.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'BabsonCollege', 'http://www.babson.edu/executive-education/expanding-entrepreneurship/Pages/home.aspx',true, 'BabsonCollege.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'Gregoria Tech', 'http://www.gatech.edu/academics/entrepreneurship',true, 'GregoriaTech.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'Harvard University', 'https://www.hbs.edu/mba/the-hbs-difference/Pages/entrepreneurship-and-innovation.aspx',true, 'Harvard.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University of Oxford', 'https://www.sbs.ox.ac.uk/faculty-research/entrepreneurship',true, 'Oxford.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'MIT', 'http://entrepreneurship.mit.edu/',true, 'MIT.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'Yale University', 'https://som.yale.edu/faculty-research-centers/centers-initiatives/program-on-entrepreneurship',true, 'Yale.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University of Chicago', 'https://polsky.uchicago.edu/',true, 'UniversityChicago.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'Imperial College Business School', 'https://www.imperial.ac.uk/business-school/programmes/msc-innovation-entrepreneurship-management/',true, 'ImperialCollege.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University of California Berkeley', 'http://entrepreneurship.berkeley.edu/programs-overview/',true, 'UCBerkeley.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'UCLA', 'http://www.anderson.ucla.edu/centers/price',true, 'UCLA.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'Cornell University', 'http://eship.cornell.edu/',true, 'Cornell.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University College London', 'https://www.mgmt.ucl.ac.uk/msc-entrepreneurship',true, 'UCL.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University Of Pennsylvania', 'https://entrepreneurship.wharton.upenn.edu/',true, 'Penn.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('UNIVERSIDAD',false,'University Of Toronto', 'http://entrepreneurs.utoronto.ca/',true, 'Toronto.png');

----------------------------------INSERTS UNIVERSIDAD AUSJAL----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',true,'Pontificia Universidad Javeriana', 'http://www.javeriana.edu.co/vicerrectoria-academica/emprendimiento',true, 'UniversidadJaveriana.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',true,'Universidad Católica Andrés Bello', 'http://w2.ucab.edu.ve/emprendedores.html',true, 'UniversidadCatolicaAndres.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',true,'Jesuitas Centro Loyola', 'http://centroloyola.com.ar/agenda/',true, 'JesuitasCentroLoyola.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'Universidad Católica del Táchira', 'http://www.tachiranews.com/curso-de-creadores-de-empresas-ofrece-la-alcaldia-y-ucat/',true, 'UniversidadTachira.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'Universidad Católica de Uruguay', 'https://ucu.edu.uy/es/la-fuerza-de-la-innovacion-y-el-emprendimiento',true, 'UniversidadCatolicaUruguay.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'Pontificia Universidad Católica del Ecuador', 'http://repositorio.puce.edu.ec/handle/22000/9212',true, 'UniversidadCatolicaEcuador.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'La Universidad de Vale do Rio dos Sinos (Unisinos)', 'http://www.unisinos.br/portal-de-inovacao/',true, 'UniversidadDeVale.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'Pontifícia Universidade Católica do Rio de Janeiro', 'http://nupem.iag.puc-rio.br/',true, 'UniversidadRioJaneiro.png');

INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'Universidad Católica de Córdoba', 'https://www2.ucc.edu.ar/busquedas/?txt_palabra=emprendedores',true, 'UCC.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',true,'Pontificia Universidad Javeriana Cali', 'https://www.javerianacali.edu.co/category-question/oficina-de-emprendimiento',true, 'UniversidadJaverianaCali.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'Universidad Alberto Hurtado', 'http://www.uahurtado.cl/2009/09/emprendimiento-e-innovaci%E2%80%94n-en-la-uah/',true, 'UniversidadHurtado.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'Universidad Centroamericana José Simeón Cañas', 'http://www.uca.edu.sv/noticias/texto-222',true, 'UniversidadCentroamericana.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'Universidad Rafael Landívar', 'https://emprendedoresurl.wordpress.com/tag/universidad-rafael-landivar/',true, 'UniversidadRafaelLandivar.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'Universidad Iberoamericana León', 'https://www.leon.uia.mx/noticias/articulo.cfm?Liga=Ideas-de-negocio-Ibero-Emprende-2016',true, 'UniversidadIberoamericana.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'Universidad Iberoamericana Ciudad de México', 'http://ibero.mx/prensa/ibero-apoya-empresarios-con-su-programa-de-emprendimiento-social',true, 'UniversidadIberoamericanaMexico.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'Universidad Iberoamericana Puebla', 'https://www.iberopuebla.mx/oferta-academica/cursos-y-diplomados/diplomados/diplomado-habilidades-para-el-emprendimiento',true, 'UniversidadIberoamericanaPuebla.jpg');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'ITESO Universidad Jesuita de Guadalajara', 'https://universidadempresa.iteso.mx/emprendimiento',true, 'ITESO.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'Universidad Centroamericana, UCA Nicaragua', 'http://www.uca.edu.ni/2/index.php/programa-emprende',true, 'UCA.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'Universidad del Pacífico (Perú)', 'http://emprendeup.pe/',true, 'UniversidadPacifico.png');
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('AUSJAL',false,'Universidad Antonio Ruiz de Montoya', 'https://www.uarm.edu.pe/Agenda/I-coloquio-estudiantes-administracion-emprendimiento-innovacion-tecnologica#.Wsrh7IhubIU',true, 'UniversidadAntonio.jpg');

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

----------------------------------INSERTS ACELERADORAS INTERNACIONAL----------------------------------
INSERT INTO public.dominio(tipo,nacional,nombre, url, activo, nombre_archivo)VALUES ('RED_ACELERADORAS',false,'REDEMPRENDIA', 'https://www.redemprendia.org/es/content/red-de-aceleradoras-de-empresas-del-tecnologico-de-monterrey',true, 'UniversidadDistrital.png');

----------------------------------INSERTS EVENTOS ----------------------------------
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id,capacidad_maxima) VALUES ('Actividad', 'Evento que pone a prueba tus habilidades de programador, ¡anímate a participar!','2018-04-04', '2018-04-04', 'Esta actividad no tiene ningún requisito', 'Maratón de Programación', 2,-1);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id,capacidad_maxima) VALUES ('Actividad', 'Evento que pone a prueba tus habilidades de trabajo en equipo y de programación, ¡anímate a participar!','2018-04-10', '2018-04-08', 'Esta actividad no tiene ningún requisito', 'HACKATON 2018', 2,-1);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id,capacidad_maxima) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','2018-04-11', '2018-04-08', 'Esta actividad no tiene ningún requisito', 'Charla motivacional de emprendedores 2018', 2,-1);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id,capacidad_maxima) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','2018-04-14', '2018-04-14', 'Esta actividad no tiene ningún requisito', 'Conferencia Emprende Más', 2,-1);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id,capacidad_maxima) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','2018-04-17', '2018-04-15', 'Esta actividad no tiene ningún requisito', 'Google Conference', 2,-1);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id,capacidad_maxima) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','2018-04-22', '2018-04-20', 'Esta actividad no tiene ningún requisito', 'Microsoft en la Javeriana', 2,-1);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id,capacidad_maxima) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','2018-04-28', '2018-04-28', 'Esta actividad no tiene ningún requisito', 'Inovatón', 2,-1);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id,capacidad_maxima) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','2018-05-01', '2018-05-01', 'Esta actividad no tiene ningún requisito', 'Emprendetón', 2,-1);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id,capacidad_maxima) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','2018-05-20', '2018-05-20', 'Esta actividad no tiene ningún requisito', 'Emprendetón Vol. 2', 2,-1);
INSERT INTO public.evento( dtype, descripcion, fin, inicio, requisitos, titulo, creador_id,capacidad_maxima) VALUES ('Actividad', 'Evento de prueba, ¡anímate a participar!','2018-05-28', '2018-05-25', 'Esta actividad no tiene ningún requisito', 'Cambiatón', 2,-1);
	
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