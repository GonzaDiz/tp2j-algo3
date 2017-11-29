package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.jugador.Jugador;
import vista.Botonera;

public class BotonRendirseHandler implements EventHandler<ActionEvent>{

	private Algopoly algopoly;
	private Botonera botonera;

	public BotonRendirseHandler(Algopoly algopoly, Botonera botonera) {
		this.algopoly = algopoly;
		this.botonera = botonera;
	}

	@Override
	public void handle(ActionEvent event) {
		Jugador jugadorRendido = this.algopoly.getJugadorConTurno();
		jugadorRendido.terminarTurno(algopoly.getTurno());
		this.botonera.deshabilitarBotonTerminarTurno();
		this.botonera.habilitarBotonTirarDados();
		jugadorRendido.rendirse();
		this.botonera.eliminarJugador(jugadorRendido);
		this.botonera.actualizarVistaJugadores();
		this.botonera.update();
	}

}
