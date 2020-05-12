package com.aula114.bean;

import java.util.Scanner;
import java.util.Set;
import java.util.List;

import com.aula114.bean.ServiceFrase;
import com.aula114.model.FraseCelebre;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ServiceFrase service = new ServiceFrase();
		Set<String> set = service.mostrarCategorias();
		System.out.println("Bienvenido al registro de frases celebres\nElija entre las siguientes categorias:\n" + set);
		String tipo = sc.nextLine().toLowerCase();

		if (set.contains(tipo)) {
			List<FraseCelebre> lista = service.mostrarFrasesPorCategoria(tipo);
			for(FraseCelebre unafrase : lista) {
				System.out.println("*** " + unafrase.getFrase());
			}
		} else {
			System.out.println("Lo siento, la categoría indicada no existe");
		}
	}	
}