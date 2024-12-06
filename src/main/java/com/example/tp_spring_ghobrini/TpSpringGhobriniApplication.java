package com.example.tp_spring_ghobrini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class TpSpringGhobriniApplication {
	//TP2
	public static void main(String[] args) {
		SpringApplication.run(TpSpringGhobriniApplication.class, args);
	}
	//TP1
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "Le monde") String name) {
		return String.format("Bonjour %s!", name);
	}
}
