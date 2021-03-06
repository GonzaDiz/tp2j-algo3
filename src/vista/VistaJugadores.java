package vista;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.jugador.Jugador;

public class VistaJugadores {
	//un comentario
	private ArrayList<Jugador> jugadores;
	private Canvas canvas;
	private LinkedList<Color> colores;
	
	
	public VistaJugadores(ArrayList<Jugador> jugadores, Canvas canvasCentral, LinkedList<Color> colores) {
		this.jugadores = jugadores;
		this.canvas = canvasCentral;
		this.colores = colores;
	}
	
	public void dibujar() {
		this.dibujarFormas();
	}
	
	
	private void dibujarFormas() {
		this.clean();
		
		int x;
		int y;
		//Color color;
		
		for (Jugador jugador : this.jugadores) {
			x = jugador.getPosicion().getX();
			y = jugador.getPosicion().getY();
			//color = colores.pop();
			canvas.getGraphicsContext2D().setFill(jugador.tuColorEs());
			if (jugador.tuColorEs() == Color.RED)
				canvas.getGraphicsContext2D().fillOval(x, y, 50, 50);
			
			if (jugador.tuColorEs() == Color.BLUE)
				canvas.getGraphicsContext2D().fillOval(x + 10, y + 10, 50, 50);
			
			if (jugador.tuColorEs() == Color.GREEN)
				canvas.getGraphicsContext2D().fillOval(x - 10, y - 10, 50, 50);
	
			//colores.addLast(color);
		}
		
	}
	
	public void clean() {
		canvas.getGraphicsContext2D().clearRect(0, 0, 871, 871);
	}
	
	public void update() {
		this.dibujar();
	}

	public void eliminar(Jugador jugadorRendido) {
		int index = this.jugadores.indexOf(jugadorRendido);
		this.jugadores.remove(jugadorRendido);
		this.colores.remove(index);
	}

}
