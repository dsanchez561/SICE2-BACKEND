package co.com.javeriana.SICE2.rest.test;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PrivateTestService {
	
	@RequestMapping(value = "/test", produces = "application/json")
	public String test() {
		return "{\"value\": \"Tiene permisos!!\"}";
	}
	
}
