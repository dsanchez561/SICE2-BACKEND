/**
 * 
 */
package co.com.javeriana.SICE2;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.com.javeriana.SICE2.main.Sice2Application;
import co.com.javeriana.SICE2.repositories.DominioRepository;

/**
 * @author Javeriana
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Sice2Application.class)
@AutoConfigureMockMvc
public class UniversidadTest {
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private DominioRepository dominioRepository;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}
	
	@Test
	@WithUserDetails("daniel") 
	public void listarUniversidadesExito() throws Exception {
		MvcResult result=mvc.perform(get("/listarDominio")).andExpect(status().isOk()).andReturn();
		String json = result.getResponse().getContentAsString();
		JSONArray mensaje = new JSONArray(json);
		assertEquals(dominioRepository.count(), mensaje.length());
	}
	
	@Test
	@WithUserDetails("daniel") 
	public void editarUniversidadExito() throws Exception {
		String mensaje = "[\r\n" + 
				"	{	\"accion\":\"editarUniversidad\",\r\n" + 
				"		\"valor\":false,\r\n" + 
				"		\"id\":4,\r\n" + 
				"		\"atributo\":\"activo\",\r\n" + 
				"		\"tipoDato\":\"BOOLEAN\",\r\n" + 
				"		\"prioridad\":false\r\n" + 
				"	}\r\n" + 
				"]";
		mvc.perform(post("/mensaje").content(mensaje).contentType("text/plain")).andExpect(status().isOk());
		assertEquals(false, dominioRepository.findOne(4L).getActivo());
	}
	
	@Test
	@WithUserDetails("daniel") 
	public void consultarURLExito() throws Exception {
		MvcResult result=mvc.perform(get("/obtenerURL/1/SalasReservadas")).andExpect(status().isOk()).andReturn();
		String json = result.getResponse().getContentAsString();
		assertEquals("http://www.javeriana.edu.co/dir-tecnologias-de-informacion/salas-reservadas", json);
	}

}
