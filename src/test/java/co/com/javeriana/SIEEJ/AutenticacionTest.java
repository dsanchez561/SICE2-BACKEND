package co.com.javeriana.SIEEJ;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.com.javeriana.SIEEJ.excepciones.SeguridadException;
import co.com.javeriana.SIEEJ.main.SieejApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = SieejApplication.class)
@AutoConfigureMockMvc
public class AutenticacionTest {
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;

	@BeforeClass
	public static void inicio() {
		System.out.println("Prueba Autenticación corriendo.....");
	}
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}

	@Test
	public void paginapublica() throws Exception {
		mvc.perform(get("/public/test")).andExpect(status().isOk());
	}
	
	@Test
	public void authWrongUser() throws Exception {
		mvc.perform(post("/login").param("username", "wrongUser").param("password", "userPass"))
			.andExpect(status().isUnauthorized());
	}

	@Test
	public void authWrongPasswordr() throws Exception {
		mvc.perform(post("/login").param("username", "user").param("password", "wrongPass"))
			.andExpect(status().isUnauthorized());
	}
	
	@Test
	public void authSuccess() throws Exception {
		mvc.perform(post("/login").param("username", "daniel").param("password", "123456"))
			.andExpect(status().isOk());
		
	}
	
	@Test(expected = SeguridadException.class) 
	public void logoutSinSesion() throws Exception {
		mvc.perform(get("/logout"));
		mvc.perform(get("/api/test")).andExpect(status().isUnauthorized());
	}
	
	@Test
	@WithUserDetails("daniel") 
	public void authorizedAction() throws Exception {
		mvc.perform(get("/api/test")).andExpect(status().isOk());
	}
	
	@Test
	@WithUserDetails("daniel") 
	public void logout() throws Exception {
		mvc.perform(get("/logout")).andExpect(status().isOk());
		mvc.perform(get("/api/test")).andExpect(status().isUnauthorized());
	}
	
	@AfterClass
	public static void quitarContexto() throws Exception {
		SecurityContextHolder.clearContext();
	}
}