package vista;

import java.util.ArrayList;
import java.util.Stack;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
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
	Stack<Color> colores;
	ArrayList<VistaJugador> vistaJugadores;
	
	
	public ContenedorPrincipal(Stage stage, Algopoly algopoly) {
		this.vistaJugadores = new ArrayList<>();
		this.colores = new Stack<>();
		colores.push(Color.RED);
		colores.push(Color.BLUE);
		colores.push(Color.GREEN);
		this.setCentro(algopoly.getJugadores());
	}
	
	private void setBotonera(Algopoly algopoly) {
		//Button boton
	}
	
	private void setCentro(ArrayList<Jugador> jugadores) {
		canvasCentral = new Canvas(871,871);
		
		for (Jugador jugador : jugadores) {
			vistaJugadores.add(new VistaJugador(jugador,canvasCentral,this.colores.pop()));
		}
		
		for (VistaJugador vistaJugador : this.vistaJugadores) {
			vistaJugador.dibujar();
		}
		
		
		contenedorCentral = new VBox(canvasCentral);
		contenedorCentral.setAlignment(Pos.CENTER);
		Image imagen_tablero = new Image("file:src/vista/imagenes/Tablero_Full_screen.jpg");
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen_tablero, BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		contenedorCentral.setBackground(new Background(imagenDeFondo));
		this.setCenter(contenedorCentral);
		
	}

}


