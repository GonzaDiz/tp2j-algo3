package vista;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modelo.Algopoly;
import modelo.jugador.Jugador;

public class VistaInformacionJugadores {

	

	private ConcurrentHashMap<Jugador, VistaInformacion> mapa;
	private VBox contenedorVerticalInfo;
	private ArrayList<Jugador> jugadores;
	
	public VistaInformacionJugadores(ArrayList<Jugador> jugadores, LinkedList<Color> colores, Algopoly algopoly) {

		this.mapa = new ConcurrentHashMap<>();
		this.jugadores = jugadores;
		VBox contenedorVerticalInfo = new VBox();
		for(Jugador j : jugadores) {
			VBox vbox = new VBox();
			Color color = colores.pop();
			this.mapa.put(j, new VistaInformacion(j, vbox, color,algopoly));
			contenedorVerticalInfo.getChildren().add(vbox);
			colores.addLast(color);
		}

		this.contenedorVerticalInfo = contenedorVerticalInfo;
	}


	
	
	
	
	public VBox getContenedorVerticalConInformacion() {
		return this.contenedorVerticalInfo;
	}

	public void update( Algopoly algopoly) {
		for (Jugador jugador : this.jugadores) {
			mapa.get(jugador).update(  algopoly);
		}
	}

	public void eliminar(Jugador jugadorRendido) {
		jugadores.remove(jugadorRendido);
		this.mapa.remove(jugadorRendido);
	}
}
