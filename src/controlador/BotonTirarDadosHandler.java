package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.jugador.Jugador;
import vista.Botonera;
import vista.VistaJugadores;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {
	

	private Algopoly algopoly;
	private Botonera botonera;

	public BotonTirarDadosHandler(Algopoly algopoly, Botonera botonera) { 
		this.algopoly = algopoly;
		this.botonera = botonera;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		this.algopoly.getJugadorConTurno().arrojaDados(algopoly.getTurno());
		this.botonera.deshabilitarBotonTirarDados();
		this.botonera.habilitarBotonTerminarTurno();
		this.botonera.actualizarVistaJugadores();
		this.botonera.actualizarInformacionJugadores();
		this.botonera.actualizarBotonComprar();

	}

}
