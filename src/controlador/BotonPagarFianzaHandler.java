package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.jugador.Jugador;
import vista.Botonera;

public class BotonPagarFianzaHandler implements EventHandler<ActionEvent>{

	private Botonera botonera;
	private Algopoly algopoly;
	
	public BotonPagarFianzaHandler(Algopoly algopoly, Botonera botonera) {
		this.algopoly = algopoly;
		this.botonera = botonera;
	}

	@Override
	public void handle(ActionEvent event) {
		Jugador jugadorConTurno = this.algopoly.getJugadorConTurno();
		jugadorConTurno.pagarFianza(this.algopoly.getCarcel());
		this.botonera.deshabilitarBotonPagarFianza();
		this.botonera.habilitarBotonTirarDados();
		this.botonera.actualizarInformacionJugadores();
		
	}
	
	
	
}
