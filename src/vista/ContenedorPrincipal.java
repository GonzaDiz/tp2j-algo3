package vista;

import java.util.ArrayList;
import java.util.LinkedList;
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
import modelo.jugador.Jugador;



public class ContenedorPrincipal extends BorderPane {
	
	VBox contenedorCentral;
	Canvas canvasCentral;
	LinkedList<Color> colores;
	VistaJugadores vistaJugadores;
	ConcurrentHashMap<Jugador, VistaInformacionJugador> vistaInformacionJugadores;
//	VistaInformacionJugador infoJugador1;
//	VistaInformacionJugador infoJugador2;
//	VistaInformacionJugador infoJugador3;

	
	public ContenedorPrincipal(Stage stage, Algopoly algopoly) {
		this.colores = new LinkedList<>();
		this.colores.push(Color.RED);
		this.colores.push(Color.BLUE);
		this.colores.push(Color.GREEN);
		this.setInformacionJugadores(algopoly.getJugadores());
		this.setCentro(algopoly.getJugadores());
		this.setBotonera(algopoly);		
	}
	
	private void setBotonera(Algopoly algopoly) {
		Button botonTirarDados = new Button();
		botonTirarDados.setText("Tirar dados");
		BotonTirarDadosHandler botonTirarDadosHandler = new BotonTirarDadosHandler(vistaJugadores,algopoly,vistaInformacionJugadores);
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

	private void setInformacionJugadores(ArrayList<Jugador> jugadores) {
		this.vistaInformacionJugadores = new ConcurrentHashMap<>();
//		VBox boxInformacionJugador1 = new VBox();
//		VBox boxInformacionJugador2 = new VBox();
//		VBox boxInformacionJugador3 = new VBox();
		VBox contenedorVerticalInfo = new VBox();
		for(Jugador j : jugadores) {
			VBox vbox = new VBox();
			this.vistaInformacionJugadores.put(j, new VistaInformacionJugador(j, vbox));
			contenedorVerticalInfo.getChildren().add(vbox);
		}
//		
//		this.infoJugador1 = new VistaInformacionJugador(jugadores.get(0), boxInformacionJugador1);
//		this.infoJugador2 = new VistaInformacionJugador(jugadores.get(1), boxInformacionJugador2);
//		this.infoJugador3 = new VistaInformacionJugador(jugadores.get(2), boxInformacionJugador3);
//		
//		
//		VBox contenedorVerticalInfo = new VBox(boxInformacionJugador1,boxInformacionJugador2,boxInformacionJugador3);
		this.setRight(contenedorVerticalInfo);
	}
}


