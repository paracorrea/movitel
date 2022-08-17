package com.ceasacps.movitel.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;




@Service
public class MovitelService {
	
	
	static final Logger LOG = LogManager.getLogger(MovitelService.class.getName());
	
	
	int count =0;
	Duration total = Duration.ZERO;
	List<String> listaTempos = new ArrayList<String>();
	
	String duracaoTotal = "";
	
	String tempo = "";
	
	public void setTempo(String tempo) {
		
		
		String[] partes1 = tempo.split(":");
		
		long horas = Long.parseLong(partes1[0]);
		long horas1 = horas *60;
		
		long minutos = Long.parseLong(partes1[1]);
		
		long horasMaisMinutos=horas1+minutos;
		
		String horasFormatado = String.format("%04d",horasMaisMinutos);
		
		this.tempo=horasFormatado;
		
	}
	
	public String getTempo() {
		return tempo;
	}


	public String getDuracaoTotal() {
		
		return duracaoTotal;
	}

	public void setDuracaoTotal(String duracaoTotal) {
		
		
		this.duracaoTotal = duracaoTotal;
	}

	public void ObterHorasPorRegiao19() throws IOException {
		
		File file = new File("\\\\172.16.252.8\\Mestat$\\movitelFolder\\\\movitel.csv");
		if (file.exists()) {
			
		FileInputStream stream = new FileInputStream(file);
	       
		 // FileInputStream stream = new FileInputStream("\\\\172.16.252.8\\mestat$\\movitelFolder/teste.csv");
	      
		  InputStreamReader reader = new InputStreamReader(stream);
	       
	        try (BufferedReader br = new BufferedReader(reader)) {
				
	        	String linha = br.readLine();
			
				while(linha != null) {
				   // LOG.info("Linha capturada: "+linha);
				    linha = br.readLine();
				    
				    try {
				    	
				       	String[] textoSeparado = linha.split(";");
				       	String regiao = textoSeparado[4];
				       // LOG.info("TExto separado"+textoSeparado[4]);
				       	
				       	if (regiao.contains("Regiao 19"))  {
				       		
				       		
				       		String horaCompleta = textoSeparado[6];
				       		
				       		listaTempos.add(horaCompleta);
				       		
				       		
				       	} // fecha o if regiao.contains	
				       		
				       	
				    } catch (NullPointerException e) {
				    	 LOG.info("Linha vazia: "+e.getMessage());				 
				    }
				    
				    				       	
				} // fecha o while enquanto houver linha no arquivo
				
				calcularListadeHoras(listaTempos);
				
				
			} // fecha o try do bufferRead
		}
	       
	    } // fecha o metodo obterHoras por regiao 

	public void calcularListadeHoras(List<String> totalHoras) {
		String totalFormatado="";
		
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
			
			totalFormatado = String.format("%02d:%02d:%02d", totalHoras1, totalMinutos, totalSegundos);
			
			setDuracaoTotal(totalFormatado);
			setTempo(totalFormatado);
		} // fecha o for do metodo
		
			
			
	} // fecha o método
	
	} // fecha a classe MovitelService

