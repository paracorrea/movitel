package com.ceasacps.movitel;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ceasacps.movitel.service.MovitelService;

@SpringBootApplication
public class MovitelApplication implements CommandLineRunner {

	@Autowired
	MovitelService movitelService;
	
	public static void main(String[] args) {
		SpringApplication.run(MovitelApplication.class, args);
	}

	@Override
	public void run(String... args) throws IOException {
		
		
		movitelService.read();
	}

	
	
}
