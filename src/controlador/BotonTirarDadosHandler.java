package controlador;

import java.util.concurrent.ConcurrentHashMap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.Turno;
import modelo.jugador.Jugador;
import vista.VistaInformacionJugador;
import vista.VistaJugadores;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {
	
	private VistaJugadores vista;
	private ConcurrentHashMap<Jugador, VistaInformacionJugador> vistaInformacionJugadores;
	private Jugador jugador;
	private Algopoly algopoly;
	private Turno turno;
	
	public BotonTirarDadosHandler(VistaJugadores vista, Algopoly algopoly,ConcurrentHashMap<Jugador, VistaInformacionJugador> vistaInformacionJugadores) { 
		this.vista = vista;
		this.algopoly = algopoly;
		this.jugador = algopoly.getJugadorConTurno();
		this.turno = algopoly.getTurno();
		this.vistaInformacionJugadores = vistaInformacionJugadores;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		this.jugador.arrojaDados(this.turno);
		this.vista.update();
		for (Jugador jugador : this.algopoly.getJugadores()) {
			vistaInformacionJugadores.get(jugador).update();
		}
		this.jugador.terminarTurno(this.turno); //TODO crear boton terminarturno
		this.jugador = this.algopoly.getJugadorConTurno();
		this.turno = this.algopoly.getTurno();
	}

}
