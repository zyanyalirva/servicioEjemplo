package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.dto.Walmart;
import hello.service.Service;
import hello.service.impl.ServiceImpl;

@SpringBootApplication
@RestController
public class Application extends SpringBootServletInitializer{

	private Service service;
	
	@RequestMapping("/")
	public ResponseEntity<Walmart> home() {
		service = new ServiceImpl();
		Walmart walmart = service.getInformacion();
		ResponseEntity<Walmart> result = new ResponseEntity<Walmart>(walmart,HttpStatus.OK);
		return result;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return builder.sources(Application.class);
	}

}
