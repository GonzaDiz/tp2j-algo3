package vista;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import javafx.scene.layout.VBox;
import modelo.jugador.Jugador;

public class VistaInformacionJugadores {

	

	private ConcurrentHashMap<Jugador, VistaInformacionJugador> mapa;
	private VBox contenedorVerticalInfo;
	private ArrayList<Jugador> jugadores;
	
	public VistaInformacionJugadores(ArrayList<Jugador> jugadores) {

		this.mapa = new ConcurrentHashMap<>();
		this.jugadores = jugadores;
		VBox contenedorVerticalInfo = new VBox();
		for(Jugador j : jugadores) {
			VBox vbox = new VBox();
			this.mapa.put(j, new VistaInformacionJugador(j, vbox));
			contenedorVerticalInfo.getChildren().add(vbox);
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
}
