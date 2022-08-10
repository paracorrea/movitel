package com.ceasacps.movitel.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.ceasacps.movitel.service.MovitelService;

@Controller
public class MovitelController extends MovitelService {

	@Autowired
	private MovitelService movitelService;
	
	
	@GetMapping("/home")
	public String home() {
		
		return "Home";
	}
	
	@GetMapping("/lerArquivos")
	
	public String lerArquivos() throws IOException {
		
		movitelService.ObterHorasPorRegiao19();
		//String numeroObtido = movitelService.getDuracaoTotal();
		
		
		
		return "home";
	}
}
