package com.api.ornithology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class OrnithologyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrnithologyApplication.class, args);
	}
	@GetMapping("/")
	public String index(){
		return "Olá Mundo!";
	}
}
