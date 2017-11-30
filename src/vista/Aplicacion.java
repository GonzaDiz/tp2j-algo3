package vista;

import java.util.ArrayList;

import controlador.BotonIniciarHandler;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Algopoly;
import modelo.jugador.Jugador;

public class Aplicacion extends Application {

	@Override

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Registro de Jugadores");
		GridPane gridPane = crearFormulario();
		addUIControls(gridPane,primaryStage);
		Scene scene = new Scene(gridPane, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private GridPane crearFormulario() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(40, 40, 40, 40));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);
		ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);
		gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
		return gridPane;
	}

	private void addUIControls(GridPane gridPane, Stage primaryStage) {

		Label headerLabel = new Label("Formulario de registro de jugadores");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

		Label nombreJugador1 = new Label("Nombre jugador 1");
		nombreJugador1.setWrapText(true);
		gridPane.add(nombreJugador1, 0, 1);

		TextField nameField = new TextField();
		nameField.setPrefHeight(40);
		gridPane.add(nameField, 1, 1);

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

		Button botonDeEnvio = new Button("Empezar Juego");
		botonDeEnvio.setPrefHeight(40);
		botonDeEnvio.setDefaultButton(true);
		botonDeEnvio.setPrefWidth(200);
		gridPane.add(botonDeEnvio, 0, 4, 2, 1);
		GridPane.setHalignment(botonDeEnvio, HPos.CENTER);
		GridPane.setMargin(botonDeEnvio, new Insets(20, 0, 20, 0));
		
		BotonIniciarHandler botonIniciarHandler = new BotonIniciarHandler(nameField,gridPane,nameField2,nameField3,this,primaryStage);
		botonDeEnvio.setOnAction(botonIniciarHandler);

	}

	

	public void mostarContenedor2(ArrayList<Jugador> jugadores) {
		Stage stage = new Stage();
		stage.setTitle("Algopoly");
		Algopoly algopoly = new Algopoly(jugadores);

		ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, algopoly);
		Scene escenaJuego = new Scene(contenedorPrincipal);
		stage.setScene(escenaJuego);
		stage.setFullScreen(true);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}