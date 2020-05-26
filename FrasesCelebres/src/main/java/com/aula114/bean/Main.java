package com.aula114.bean;

import java.util.Scanner;
import java.util.Set;
import java.util.List;

import com.aula114.bean.ServiceFrase;
import com.aula114.model.FraseCelebre;


public class Main {
	public static void main(String[] args) {
		ServiceFrase service = new ServiceFrase();
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime que deseas buscar, autores o categorias. Para Salir EOF");
		String buscar = sc.nextLine();
		while(true){
		if(buscar.equalsIgnoreCase("categorias")){
			Set<String> setCat = service.mostrarCategorias();
			System.out.println("Bienvenido al registro de frases celebres\nElija entre las siguientes categorias:\n" + setCat);
			String tipo = sc.nextLine().toLowerCase();
			if (setCat.contains(tipo)) {
				List<FraseCelebre> listaCat = service.mostrarFrasesPorCategoria(tipo);
				for(FraseCelebre unaFrase : listaCat) {
					System.out.println("*** " + unaFrase.getFrase() + "\n   ***    " + unaFrase.getAutor().getNombre());
				}
			} else {
				System.out.println("Lo siento, la categoría indicada no existe");
			}
		} else if(buscar.equalsIgnoreCase("autores")){
			Set<String> setAut = service.mostrarAutores();
			System.out.println("Bienvenido al registro de frases celebres\nElija entre las siguientes Autores:\n" + setAut);
			String autor = sc.nextLine().toLowerCase();

			char[] convertir = autor.toCharArray();
			autor = "";
       		for(int i = 0; i < convertir.length; i++) {
       			if(convertir[i] == convertir[0]){
    		      convertir[i] = Character.toUpperCase(convertir[i]);
           		}
	           if(convertir[i] == ' '){
    		      convertir[i+1] = Character.toUpperCase(convertir[i+1]);
           		}
           		autor = autor + convertir[i];
       		}

			if (setAut.contains(autor)) {
				List<FraseCelebre> listaAut = service.mostrarFrasesPorAutor(autor);
				for(FraseCelebre unaFrase : listaAut) {
					System.out.println("*** " + unaFrase.getFrase() + "\n    *** " + unaFrase.getAutor().getNombre());
				}
			} else {
				System.out.println("Lo siento, el autor indicado no existe");
			}

		}
		System.out.println("Dime que deseas buscar, autores o categorias. Para Salir EOF");
		buscar = sc.nextLine();
	}
		
	}	
}