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
		System.out.println("Dime que deseas buscar, autores o categorias.");
		String buscar = sc.nextLine();
		if(buscar.equalsIgnoreCase("categorias")){

		Set<String> set = service.mostrarCategorias();
		System.out.println("Bienvenido al registro de frases celebres\nElija entre las siguientes categorias:\n" + set);
		String tipo = sc.nextLine().toLowerCase();
		if (set.contains(tipo)) {
			List<FraseCelebre> lista = service.mostrarFrasesPorCategoria(tipo);
			for(FraseCelebre unafrase : lista) {
				System.out.println("*** " + unafrase.getFrase() + "\n   ***    " + unafrase.getAutor().getNombre());
			}
		} else {
			System.out.println("Lo siento, la categoría indicada no existe");
		}

		}else if(buscar.equalsIgnoreCase("autores")){
			Set<String> set1 = service.mostrarAutores();
		System.out.println("Bienvenido al registro de frases celebres\nElija entre las siguientes Autores:\n" + set1);
		String autor = sc.nextLine().toLowerCase();
		if (set1.contains(autor)) {
			List<FraseCelebre> lista1 = service.mostrarFrasesPorAutor(autor);
			for(FraseCelebre unafrase : lista1) {
				System.out.println("*** " + unafrase.getFrase() + "\n   ***    " + unafrase.getAutor().getNombre());
			}
		} else {
			System.out.println("Lo siento, el autor indicado no existe");
		}

		}
		
	}	
}