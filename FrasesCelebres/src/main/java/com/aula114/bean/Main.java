package com.aula114.bean;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al registro de frases celebres\nElija entre las siguientes categorias:\n" + ViewManager.getListaCategorias());
		String tipo = sc.nextLine().toLowerCase();

		switch(tipo) {
			case "perdonar":
				ServiceFrase.mostrarFrasesPorCategoria(tipo);
			case "perseverancia":
				ServiceFrase.mostrarFrasesPorCategoria(tipo);
			case "ilusiones":
				ServiceFrase.mostrarFrasesPorCategoria(tipo);
			case "risas":
				ServiceFrase.mostrarFrasesPorCategoria(tipo);
			case "entusiasmo":
				ServiceFrase.mostrarFrasesPorCategoria(tipo);
			case "destino":
				ServiceFrase.mostrarFrasesPorCategoria(tipo);
			case "bondad":
				ServiceFrase.mostrarFrasesPorCategoria(tipo);
			case "sufrimiento":

		}
	}	
}