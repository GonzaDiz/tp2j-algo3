package vista;


import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

import modelo.Algopoly;
import modelo.jugador.Jugador;

public class FormularioJugadores extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registro de Jugadores");

        // Create the registration form grid pane
        GridPane gridPane = crearFormulario();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage	
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }


    private GridPane crearFormulario() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Formulario de registro de jugadores");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // agrega etiqueta nombre jugador
        Label nombreJugador1 = new Label("Nombre jugador 1");
        nombreJugador1.setWrapText(true);
        gridPane.add(nombreJugador1, 0,1);

        
        // agrega campo de texto
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);


        
        Label nombreJugador2 = new Label("Nombre jugador 2");
        nombreJugador2.setWrapText(true);
        gridPane.add(nombreJugador2, 0, 2);

        
        TextField nameField2 = new TextField();
        nameField2.setPrefHeight(40);
        gridPane.add(nameField2, 1, 2);

        
        Label nombreJugador3 = new Label("Nombre jugador 3");
        nombreJugador3.setWrapText(true);
        gridPane.add(nombreJugador3, 0, 3);
       
        TextField nameField3 = new TextField();
        nameField3.setPrefHeight(40);
        gridPane.add(nameField3, 1, 3);
   
        

        // agregar boton de envio
        Button botonDeEnvio = new Button("Empezar Juego");
        botonDeEnvio.setPrefHeight(40);
        botonDeEnvio.setDefaultButton(true);
        botonDeEnvio.setPrefWidth(200);
        gridPane.add(botonDeEnvio, 0, 4, 2, 1);
        GridPane.setHalignment(botonDeEnvio, HPos.CENTER);
        GridPane.setMargin(botonDeEnvio, new Insets(20, 0,20,0));

        botonDeEnvio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Error!", "Por favor ingresar nombre de jugador 1");
                    return;
                }
                

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registro Exitoso", "Bienvenidos " + nameField.getText()+ "   " + nameField2.getText() + "    " + nameField3.getText() );
              
                ArrayList<Jugador> jugadores = new ArrayList<>();
                if(!nameField.getText().isEmpty()) {
                    
                	Jugador jugador1 = new Jugador(nameField.getText());
                	jugadores.add(jugador1);
                }
if(!nameField2.getText().isEmpty()) {
                    
                	Jugador jugador2 = new Jugador(nameField2.getText());
                	jugadores.add(jugador2);
                }
if(!nameField3.getText().isEmpty()) {
    
	Jugador jugador3 = new Jugador(nameField3.getText());
	jugadores.add(jugador3);
}
             
				
                mostarContenedor2(jugadores);
               
				
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
   
    private void mostarContenedor2(	ArrayList<Jugador> jugadores) {
    	Stage stage= new Stage();
        stage.setTitle("Algopoly");
        Algopoly algopoly = new Algopoly(jugadores);
		
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage,algopoly);
        Scene escenaJuego = new Scene(contenedorPrincipal);
		stage.setScene(escenaJuego);
		stage.setFullScreen(true);
		stage.show();
    }
    
    private Algopoly crearModelo() {
		ArrayList<Jugador> jugadores = new ArrayList<>();
		Jugador jugador1 = new Jugador("Ariel");
		Jugador jugador2 = new Jugador("Gonzalo");
		Jugador jugador3 = new Jugador("Uriel");
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		
		Algopoly algopoly = new Algopoly(jugadores);
		
		return algopoly;
	}
   

    

    public static void main(String[] args) {
        launch(args);
    }
}