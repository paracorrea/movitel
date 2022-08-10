package com.ceasacps.movitel.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;


@Service
public class MovitelService {
	
	
	int count =0;
	Duration total = Duration.ZERO;
	List<String> listaTempos = new ArrayList<String>();
	
	String duracaoTotal = "";
	
	
	public String getDuracaoTotal() {
		return duracaoTotal;
	}

	public void setDuracaoTotal(String duracaoTotal) {
		this.duracaoTotal = duracaoTotal;
	}

	public void ObterHorasPorRegiao19() throws IOException {
		
		  FileInputStream stream = new FileInputStream("C:\\Users\\fernando.correa\\Documents\\GitHub\\novos\\folder\\movitel/teste.csv");
	        InputStreamReader reader = new InputStreamReader(stream);
	       
	        try (BufferedReader br = new BufferedReader(reader)) {
				
	        	String linha = br.readLine();
			
				while(linha != null) {
				    System.out.println(linha);
				    linha = br.readLine();
				    
				    try {
				    	
				       	String[] textoSeparado = linha.split(";");
				       	String regiao = textoSeparado[4];
				       	System.out.println(textoSeparado[4]);
				       	
				       	if (regiao.contains("Regiao 19"))  {
				       		
				       		
				       		String horaCompleta = textoSeparado[6];
				       		
				       		listaTempos.add(horaCompleta);
				       		
				       		
				       	} // fecha o if regiao.contains	
				       		
				       	
				    } catch (NullPointerException e) {
				    	System.out.println("Linha vazia: "+e.getMessage());				 
				    }
				    
				    				       	
				} // fecha o while enquanto houver linha no arquivo
				
				calcularListadeHoras(listaTempos);
				
				
			} // fecha o try do bufferRead
	       
	    } // fecha o metodo obterHoras por regiao 

	public void calcularListadeHoras(List<String> totalHoras) {
		
		for (String tempo : totalHoras) {
			
			String[] partes = tempo.split(":");
			total=total
					// somar horas
					.plusHours(Long.parseLong(partes[0]))
					.plusMinutes(Long.parseLong(partes[1]))
					.plusSeconds(Long.parseLong(partes[2]));
		
			long totalSegundos = total.getSeconds();
			// daqui pra baixo é igual ao código anterior
			
			long totalHoras1 = totalSegundos / 3600;
			
			totalSegundos %= 3600;
			
			long totalMinutos = totalSegundos / 60;
			
			totalSegundos %= 60;
			
			String totalFormatado = String.format("%02d:%02d:%02d", totalHoras1, totalMinutos, totalSegundos);
			System.out.println(totalFormatado); // 36:00:00
			
			setDuracaoTotal(totalFormatado);
		} // fecha o for do metodo
		
		
	} // fecha o método
	
	} // fecha a classe MovitelService

