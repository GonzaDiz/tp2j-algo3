package controlador;

import java.util.concurrent.ConcurrentHashMap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.jugador.Jugador;
import vista.VistaInformacionJugador;
import vista.VistaJugadores;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {
	
	private VistaJugadores vista;
	private ConcurrentHashMap<Jugador, VistaInformacionJugador> vistaInformacionJugadores;
	private Jugador jugador;
	private Algopoly algopoly;
//	private Turno turno;
	
	public BotonTirarDadosHandler(VistaJugadores vista,Algopoly algopoly, Jugador jugador,ConcurrentHashMap<Jugador, VistaInformacionJugador> vistaInformacionJugadores) { 
//		this.vista = vista;
//		this.algopoly = algopoly;
		//this.jugador = algopoly.getProximoJugadorConTurno();
//		this.jugador = algopoly.getJugadorConTurno();
//		this.turno = algopoly.getTurno();
//		this.vistaInformacionJugadores = vistaInformacionJugadores;
		this.jugador = jugador;
		this.algopoly = algopoly;
		this.vista = vista;
		this.vistaInformacionJugadores = vistaInformacionJugadores;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		this.algopoly.getJugadorConTurno().arrojaDados(algopoly.getTurno());
		
		//this.jugador.arrojaDados(algopoly.getTurno());
		this.vista.update();
		for (Jugador jugador : this.algopoly.getJugadores()) {
			vistaInformacionJugadores.get(jugador).update();
		}
		//this.jugador.terminarTurno(this.turno); //TODO crear boton terminarturno
		
		//this.jugador = this.algopoly.getProximoJugadorConTurno();
		//this.turno = this.algopoly.getTurno();
	}

}
