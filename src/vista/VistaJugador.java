package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.jugador.Jugador;

public class VistaJugador {
	
	private Jugador jugador;
	private Color colorJugador;
	Canvas canvas;
	
	public VistaJugador(Jugador jugador, Canvas canvas, Color colorJugador) {
		this.jugador = jugador;
		this.canvas = canvas;
		this.colorJugador = colorJugador;
	}
	
	public void dibujar() {
		this.dibujarFormas();
	}
	
	private void dibujarFormas() {
		this.clean();
		canvas.getGraphicsContext2D().setFill(this.colorJugador);
		canvas.getGraphicsContext2D().fillOval(jugador.getPosicion().getX(), jugador.getPosicion().getY(), 50, 50);
	}
	
	public void clean() {
		canvas.getGraphicsContext2D().clearRect(0, 0, 871, 871);
	}
	
	public void update() {
		this.dibujar();
	}
	

}
