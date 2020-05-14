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
ComboBox<String> cb, cb1;

    
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
scene1= new Scene(layout1, 300, 250);
               
//Scene 2
Set<String> setAut = service.mostrarAutores();
Label label2= new Label("Frases por autores");
cb= new ComboBox<String>();
cb.setOnAction(e -> cb.setVisible(true));
cb.setPromptText("Elija autor");
cb.getItems().addAll(setAut);
Button button2= new Button("volver");
button2.setOnAction(e -> primaryStage.setScene(scene1));
Button buttonSelAut = new Button("Ir a selección");
if(cb.getItems() != null){
	buttonSelAut.setOnAction(e -> primaryStage.setScene(sceneAutores));
}else{
	buttonSelAut.setOnAction(e -> primaryStage.setScene(scene2));
}
VBox layout2= new VBox(20);
cb= new ComboBox<String>();
cb.setOnAction(e -> cb.setVisible(true));
cb.setPromptText("Elija autor");
cb.getItems().addAll(setAut);
layout2.getChildren().addAll(label2, button2, cb, buttonSelAut);
scene2= new Scene(layout2,300,250);

			

//Scene Autores
Label frasesAutores= new Label("Frases por autores");
Button buttonA= new Button("volver a elegir autor");
buttonA.setOnAction(e -> primaryStage.setScene(scene2));
Button buttonI= new Button("volver al inicio");
buttonI.setOnAction(e -> primaryStage.setScene(scene1));
VBox layoutAutores= new VBox(20);
layoutAutores.getChildren().addAll(frasesAutores, buttonA, buttonI);
sceneAutores= new Scene(layoutAutores,300,250);


//Scene 3
Set<String> setCat = service.mostrarCategorias();
Label label3= new Label("Frases por categorias");
Button button3= new Button("volver");
button3.setOnAction(e -> primaryStage.setScene(scene1));
VBox layout3= new VBox(20);
cb1= new ComboBox<String>();
cb1.setOnAction(e -> cb.setVisible(true));
cb1.setPromptText("Elija autor");
cb1.getItems().addAll(setCat);
layout3.getChildren().addAll(label3, button3,cb1);
scene3= new Scene(layout3,300,250);

//Scene Categorias
Label frasesCategorias= new Label("Frases por categorias");
Button buttonC= new Button("volver a elegir Categoría");
buttonC.setOnAction(e -> primaryStage.setScene(scene3));
Button buttonI2= new Button("volver al inicio");
buttonI2.setOnAction(e -> primaryStage.setScene(scene1));
VBox layoutCategorias= new VBox(20);
layoutCategorias.getChildren().addAll(frasesCategorias, buttonC, buttonI2);
sceneCategorias= new Scene(layoutCategorias,300,250);
        
        
primaryStage.setScene(scene1);
primaryStage.show();
}

public static void main(String[] args) {
launch(args);

}
    
}
