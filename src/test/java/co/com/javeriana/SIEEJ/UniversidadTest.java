/**
 * 
 */
package co.com.javeriana.SIEEJ;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONArray;
import org.junit.Before;
import org.junit.BeforeClass;
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

import co.com.javeriana.SIEEJ.main.SieejApplication;
import co.com.javeriana.SIEEJ.repositories.UniversidadRepository;

/**
 * @author Javeriana
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = SieejApplication.class)
@AutoConfigureMockMvc
public class UniversidadTest {
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private UniversidadRepository universidadRepository;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}
	
	@Test
	public void listarUniversidadesExito() throws Exception {
		MvcResult result=mvc.perform(get("/universidad/listarUniversidades")).andExpect(status().isOk()).andReturn();
		String json = result.getResponse().getContentAsString();
		JSONArray mensaje = new JSONArray(json);
		assertEquals(universidadRepository.count(), mensaje.length());
	}
	

}
