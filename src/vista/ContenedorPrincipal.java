package vista;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Algopoly;
import modelo.jugador.Jugador;



public class ContenedorPrincipal extends BorderPane {
	
	VBox contenedorCentral;
	Canvas canvasCentral;
	LinkedList<Color> colores;
	VistaJugadores vistaJugadores;
	VistaInformacionJugadores vistaInformacionJugadores;
	BarraDeMenu menuBar;
	Botonera botonera;

	
	public ContenedorPrincipal(Stage stage, Algopoly algopoly) {
		this.colores = new LinkedList<>();
		this.colores.push(Color.RED);
		this.colores.push(Color.BLUE);
		this.colores.push(Color.GREEN);
		this.setInformacionJugadores(algopoly.getJugadores());
		this.setCentro(algopoly.getJugadores());
		this.setBotonera(algopoly);
		this.setConsola();
		this.setMenu(algopoly);
		stage.setHeight(800);
		stage.setWidth(800);
		
		
	}
	
	private void setMenu(Algopoly algopoly) {
        this.menuBar = new BarraDeMenu(algopoly, this.vistaInformacionJugadores, this.botonera);
        this.setTop(menuBar);
    }
	
	private void setConsola() {
		 Label etiqueta = new Label();
	     etiqueta.setText("Consola");
	     etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
	     etiqueta.setTextFill(Color.WHITE);
	     VBox contenedorConsola = new VBox(etiqueta);
	     contenedorConsola.setSpacing(10);
	     contenedorConsola.setPadding(new Insets(15));
	     contenedorConsola.setStyle("-fx-background-color: black;");
	     this.setBottom(contenedorConsola);
		
	}

	private void setBotonera(Algopoly algopoly) {
		
		this.botonera = new Botonera(algopoly,vistaJugadores,vistaInformacionJugadores);
		VBox contenedorVertical = this.botonera.getContenedor();
		//Button botonTirarDados = new Button();
		//botonTirarDados.setText("Tirar dados");
		//BotonTirarDadosHandler botonTirarDadosHandler = new BotonTirarDadosHandler(vistaJugadores,algopoly,vistaInformacionJugadores);
		//botonTirarDados.setOnAction(botonTirarDadosHandler);
		//VBox contenedorVertical = new VBox(botonTirarDados);
		contenedorVertical.setSpacing(10);
		contenedorVertical.setPadding(new Insets(15));
		this.setLeft(contenedorVertical);
	}
	
	
	
	private void setCentro(ArrayList<Jugador> jugadores) {
		canvasCentral = new Canvas(871,871);
		
		vistaJugadores = new VistaJugadores(jugadores,canvasCentral,this.colores);
		vistaJugadores.dibujar();
		
		contenedorCentral = new VBox(canvasCentral);
		contenedorCentral.setAlignment(Pos.CENTER);
		Image imagen_tablero = new Image("file:src/vista/imagenes/Tablero_Full_screen.jpg");
		
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen_tablero, BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

		contenedorCentral.setBackground(new Background(imagenDeFondo));
		this.setCenter(contenedorCentral);
	
		
	}

	private void setInformacionJugadores(ArrayList<Jugador> jugadores) {
		this.vistaInformacionJugadores = new VistaInformacionJugadores(jugadores, this.colores);
		VBox contendeorVertical = this.vistaInformacionJugadores.getContenedorVerticalConInformacion();
		this.setRight(contendeorVertical);
//		this.vistaInformacionJugadores = new ConcurrentHashMap<>();
//
//		VBox contenedorVerticalInfo = new VBox();
//		for(Jugador j : jugadores) {
//			VBox vbox = new VBox();
//			this.vistaInformacionJugadores.put(j, new VistaInformacionJugador(j, vbox));
//			contenedorVerticalInfo.getChildren().add(vbox);
//		}
//
//		this.setRight(contenedorVerticalInfo);
	}
}


