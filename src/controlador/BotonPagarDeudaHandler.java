package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.excepciones.CapitalInsuficienteError;
import modelo.jugador.Jugador;
import vista.Botonera;

public class BotonPagarDeudaHandler implements EventHandler<ActionEvent>{

	private Botonera botonera;
	private Algopoly algopoly;
	
	public BotonPagarDeudaHandler(Algopoly algopoly, Botonera botonera) {
		this.algopoly = algopoly;
		this.botonera = botonera;
	}

	@Override
	public void handle(ActionEvent event) {
		Jugador jugadorConTurno = this.algopoly.getJugadorConTurno();
		try {
			jugadorConTurno.caerEnCasillero(jugadorConTurno.casilleroActual());
			this.botonera.deshabilitarBotonPagarDeuda();
			this.botonera.deshabilitarBotonTerminarTurno();
			this.botonera.actualizarInformacionJugadores(  algopoly);
			this.botonera.actualizarVistaJugadores();
		}
		catch(CapitalInsuficienteError e) {
			this.botonera.mostrarAlerta("Estas endeudado", "Debes vender alguna propiedad para pagar tu deuda.");
		}
	}

}
