package vista;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modelo.jugador.Jugador;

public class VistaInformacionJugadores {

	

	private ConcurrentHashMap<Jugador, VistaInformacionJugador> mapa;
	private VBox contenedorVerticalInfo;
	private ArrayList<Jugador> jugadores;
	
	public VistaInformacionJugadores(ArrayList<Jugador> jugadores, LinkedList<Color> colores) {

		this.mapa = new ConcurrentHashMap<>();
		this.jugadores = jugadores;
		VBox contenedorVerticalInfo = new VBox();
		for(Jugador j : jugadores) {
			VBox vbox = new VBox();
			Color color = colores.pop();
			this.mapa.put(j, new VistaInformacionJugador(j, vbox, color));
			contenedorVerticalInfo.getChildren().add(vbox);
			colores.addLast(color);
		}

		this.contenedorVerticalInfo = contenedorVerticalInfo;
	}

	public VBox getContenedorVerticalConInformacion() {
		return this.contenedorVerticalInfo;
	}

	public void update() {
		for (Jugador jugador : this.jugadores) {
			mapa.get(jugador).update();
		}
	}

	public void eliminar(Jugador jugadorRendido) {
		jugadores.remove(jugadorRendido);
		this.mapa.remove(jugadorRendido);
	}
}
