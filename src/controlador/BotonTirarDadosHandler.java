package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.Turno;
import modelo.jugador.Jugador;
import vista.VistaJugadores;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {
	
	private VistaJugadores vista;
	private Jugador jugador;
	private Algopoly algopoly;
	private Turno turno;
	
	public BotonTirarDadosHandler(VistaJugadores vista, Algopoly algopoly) { 
		this.vista = vista;
		this.algopoly = algopoly;
		this.jugador = algopoly.getJugadorConTurno();
		this.turno = algopoly.getTurno();
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		this.jugador.arrojaDados(this.turno);
		this.vista.update();
		this.jugador.terminarTurno(this.turno);
		this.jugador = this.algopoly.getJugadorConTurno();
		this.turno = this.algopoly.getTurno();
	}

}
