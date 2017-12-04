package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.excepciones.CapitalInsuficienteError;
import modelo.excepciones.NoEstasEncarceladoException;
import modelo.excepciones.NoPuedePagarFianzaException;
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
		try {
			jugadorConTurno.pagarFianza(this.algopoly.getCarcel());
			this.botonera.habilitarBotonTirarDados();
		}
		
		catch(NoEstasEncarceladoException e) {
			this.botonera.mostrarAlerta("No puede pagar la fianza", "No se encuentra encarcelado, no puede pagar la fianza.");
		}
		
		catch(NoPuedePagarFianzaException e) {
			this.botonera.mostrarAlerta("No puede pagar la fianza", "Recien a partir del segundo turno en la carcel puede pagar la fianza.");
		}
		catch(CapitalInsuficienteError e) {
			this.botonera.mostrarAlerta("Saldo insuficiente","No dispone del dinero suficiente para comprar este casillero.");
		}
		
		this.botonera.actualizarInformacionJugadores( algopoly);
		
	}
	
	
	
}
