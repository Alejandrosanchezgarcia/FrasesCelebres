package com.aula114.bean;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;


import com.aula114.bean.ServiceFrase;
import com.aula114.model.FraseCelebre;

import java.util.Set;
import java.util.List;

public class MainFx extends Application{
	ServiceFrase service = new ServiceFrase();

	Scene scene1, scene2, scene3, sceneAutores, sceneCategorias;
	ComboBox<String> cbAut, cbCat;
	Label mostrarFrasesAut = new Label("");
	Label mostrarFrasesCat = new Label("");
    
	@Override
	public void start(Stage primaryStage) {
        
		primaryStage.setTitle("Frases Célebres");


		//Scene 1
		Label label1= new Label("Bienvenido/a al menú de Frases Célebres");
		Button autores= new Button("Frases por Autores");
		Button categorias= new Button("Frases por Categorias");
		autores.setOnAction(e -> primaryStage.setScene(scene2));
		categorias.setOnAction(e -> primaryStage.setScene(scene3));
		VBox layout1 = new VBox(20);     
		layout1.getChildren().addAll(label1, autores, categorias);
		scene1= new Scene(layout1, 300,250);
               

		//Scene 2
		Set<String> setAut = service.mostrarAutores();
		Label label2= new Label("Frases por autores");
		cbAut= new ComboBox<String>();
		cbAut.setOnAction(e -> cbAut.setVisible(true));
		cbAut.setPromptText("Elija autor");
		cbAut.getItems().addAll(setAut);
		Button button2= new Button("volver");		
		button2.setOnAction(e -> primaryStage.setScene(scene1));
		Button buttonSelAut = new Button("Ir a selección");

		buttonSelAut.setOnAction(e -> {
			List<FraseCelebre> listaAut = service.mostrarFrasesPorAutor(cbAut.getValue());
			String frases = "";
			for(FraseCelebre unaFrase : listaAut) {
				frases = frases + "\n- " + unaFrase.getFrase() + "\n";
			}
			mostrarFrasesAut.setText("Las frases de " + cbAut.getValue() + ":\n" + frases);
		});

		VBox layout2 = new VBox(20);
		layout2.getChildren().addAll(label2, button2, cbAut, buttonSelAut, mostrarFrasesAut);
		scene2 = new Scene(layout2,1100,500);


		//Scene 3
		Set<String> setCat = service.mostrarCategorias();
		Label label3= new Label("Frases por categorías");
		cbCat= new ComboBox<String>();
		cbCat.setOnAction(e -> cbCat.setVisible(true));
		cbCat.setPromptText("Elija categoría");
		cbCat.getItems().addAll(setCat);
		Button button3= new Button("volver");
		button3.setOnAction(e -> primaryStage.setScene(scene1));
		Button buttonSelCat = new Button("Ir a selección");

		buttonSelCat.setOnAction(e -> {
			List<FraseCelebre> listaCat = service.mostrarFrasesPorCategoria(cbCat.getValue());
			String frases1 = "";
			for(FraseCelebre unaFrase : listaCat) {
				frases1 = frases1 + "\n- " + unaFrase.getFrase() + "\n  - Autor: " + unaFrase.getAutor().getNombre() + "\n";
			}
			mostrarFrasesCat.setText("Las frases de " + cbCat.getValue() + ":\n" + frases1);
		});

		VBox layout3 = new VBox(20);
		layout3.getChildren().addAll(label3, button3, cbCat, buttonSelCat, mostrarFrasesCat);
		scene3 = new Scene(layout3,1100,500);
       
        
		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
    
}
