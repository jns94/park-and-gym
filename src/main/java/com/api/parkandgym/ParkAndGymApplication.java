package com.api.parkandgym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParkAndGymApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkAndGymApplication.class, args);
	}
	@GetMapping("/")
	public String index(){
		return "Aplicação no ar.";
	}
}
