package vista;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

import controlador.BotonTirarDadosHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.Algopoly;
import modelo.Turno;
import modelo.jugador.Jugador;



public class ContenedorPrincipal extends BorderPane {
	
	VBox contenedorCentral;
	Canvas canvasCentral;
	LinkedList<Color> colores;
	VistaJugadores vistaJugadores;
	//ArrayList<VistaJugador> vistaJugadores;
//	ConcurrentHashMap<Jugador, VistaJugador> vistaJugadores;
	
	public ContenedorPrincipal(Stage stage, Algopoly algopoly) {
		//this.vistaJugadores = new ConcurrentHashMap<>();
		this.colores = new LinkedList<>();
		this.colores.push(Color.RED);
		this.colores.push(Color.BLUE);
		this.colores.push(Color.GREEN);
		this.setCentro(algopoly.getJugadores());
		this.setBotonera(algopoly);
	}
	
	private void setBotonera(Algopoly algopoly) {
		//Jugador jugador = algopoly.getJugadorConTurno();
		//Turno turno = algopoly.getTurno();
//		VistaJugador vistaJugadorConTurno = vistaJugadores.get(jugador);
		Button botonTirarDados = new Button();
		botonTirarDados.setText("Tirar dados");
//		BotonTirarDadosHandler botonTirarDadosHandler = new BotonTirarDadosHandler(vistaJugadores,jugador,turno,);
		BotonTirarDadosHandler botonTirarDadosHandler = new BotonTirarDadosHandler(vistaJugadores,algopoly);
		botonTirarDados.setOnAction(botonTirarDadosHandler);
		
		VBox contenedorVertical = new VBox(botonTirarDados);
		contenedorVertical.setSpacing(10);
		contenedorVertical.setPadding(new Insets(15));
		this.setLeft(contenedorVertical);
	}
	
	
	
	private void setCentro(ArrayList<Jugador> jugadores) {
		canvasCentral = new Canvas(871,871);
		
//		for (Jugador jugador : jugadores) {
//			vistaJugadores.put(jugador,new VistaJugador(jugador,canvasCentral,this.colores.pop()));
//			vistaJugadores.get(jugador).dibujar();
//		}	
		
		vistaJugadores = new VistaJugadores(jugadores,canvasCentral,this.colores);
		vistaJugadores.dibujar();
		
		contenedorCentral = new VBox(canvasCentral);
		contenedorCentral.setAlignment(Pos.CENTER);
		Image imagen_tablero = new Image("file:src/vista/imagenes/Tablero_Full_screen.jpg");
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen_tablero, BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		contenedorCentral.setBackground(new Background(imagenDeFondo));
		this.setCenter(contenedorCentral);
		
	}

}


