package com.ceasacps.movitel.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceasacps.movitel.model.MovitelModel;

@Service
public class MovitelService {
	
//	@Autowired
//	MovitelModel movitelModel;
	
	int count =0;
	Double total = 0.0;
	Double doubleValue = 0.0;
	
	public void read() throws IOException {
		
		  FileInputStream stream = new FileInputStream("C:\\Users\\fernando.correa\\Documents\\GitHub\\novos\\folder\\movitel/movitel.csv");
	        InputStreamReader reader = new InputStreamReader(stream);
	        try (BufferedReader br = new BufferedReader(reader)) {
				String linha = br.readLine();
				while(linha != null) {
				    System.out.println(linha);
				    linha = br.readLine();
				    
				    try {
				    	
				       	String[] textoSeparado = linha.split(";");
				       	System.out.println(textoSeparado[4]);
				       	
				       	if (textoSeparado[4].contains("Regiao 19"))  {
				       		System.out.println(textoSeparado[6]);
				       		String textoTransformado = textoSeparado[6].substring(3);
				       		String textoFinalemNumero = textoTransformado.replace(":", ".");
				       		System.out.println("Final: "+textoFinalemNumero);
				       	
				       		Double doubleValue = Double.parseDouble(textoFinalemNumero);
				       		System.out.println("Double: "+doubleValue);
				       		total += doubleValue;
				       		count ++;
				       		
				       	}	
				       		
				    	
				    } catch (NullPointerException e) {
				    	System.out.println("Linha vazia: "+e.getMessage());				    }
				    
				    finally {
				       	
				       	
				       	
				       	System.out.println("O Total encontrado para a Região 19 foi de: "+total);
				       	System.out.println("Contador: "+count);
					/*
					 * for (int i=0; i<textoSeparado.length; i++) {
					 * System.out.println(textoSeparado[i]);
					 * 
					 * }
					 */}
				    
					System.out.println("O Total de minutos encontrado para a Região 19 foi de: "+total);
				}
			}
	    }

	}

