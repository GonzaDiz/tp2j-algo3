package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.excepciones.CapitalInsuficienteError;
import modelo.excepciones.NoEsUnCasilleroComprableError;
import vista.Botonera;

public class BotonComprarHandler implements EventHandler<ActionEvent>{


	private Algopoly algopoly;
	private Botonera botonera;

	public BotonComprarHandler(Algopoly algopoly, Botonera botonera) {
		this.algopoly = algopoly;
		this.botonera = botonera;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			this.algopoly.getJugadorConTurno().comprarCasilleroActual();
		}
		
		catch(CapitalInsuficienteError e) {
			this.botonera.mostrarAlerta("Saldo insuficiente", "No dispone del dinero suficiente para comprar este casillero.");
		}
		
		catch(NoEsUnCasilleroComprableError e) {
			this.botonera.mostrarAlerta("Casillero no comprable", "El casillero en el que se encuentra no puede ser comprado.");
		}
		this.botonera.actualizarInformacionJugadores();
		this.botonera.deshabilitarBotonComprar();
	}

}
