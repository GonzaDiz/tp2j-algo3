package controlador;

import java.util.concurrent.ConcurrentHashMap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.jugador.Jugador;
import vista.Botonera;
import vista.VistaInformacionJugador;
import vista.VistaJugadores;

public class BotonTerminarTurnoHandler implements EventHandler<ActionEvent> {

	Botonera botonera;
	Algopoly algopoly;
	
	
	public BotonTerminarTurnoHandler(VistaJugadores vistaJugadores, Algopoly algopoly,
		ConcurrentHashMap<Jugador, VistaInformacionJugador> vistaInformacionJugadores, Botonera botonera) {
		this.algopoly = algopoly;
		this.botonera = botonera;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		this.algopoly.getJugadorConTurno().terminarTurno(algopoly.getTurno());
		this.algopoly.getJugadorConTurno().esTuTurno();
		this.botonera.update();
	}

}
