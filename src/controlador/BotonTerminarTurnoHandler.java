package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import vista.Botonera;

public class BotonTerminarTurnoHandler implements EventHandler<ActionEvent> {

	private Botonera botonera;
	private Algopoly algopoly;
	
	
	public BotonTerminarTurnoHandler(Algopoly algopoly, Botonera botonera) {
		this.algopoly = algopoly;
		this.botonera = botonera;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		this.algopoly.getJugadorConTurno().terminarTurno(algopoly.getTurno());
		//this.algopoly.getJugadorConTurno().esTuTurno();
		this.botonera.deshabilitarBotonTerminarTurno();
		this.botonera.habilitarBotonTirarDados();
		this.botonera.update();
	}

}
