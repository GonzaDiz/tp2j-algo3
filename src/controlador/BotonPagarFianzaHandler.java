package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No puede pagar la fianza");
			alert.setHeaderText(null);
			alert.setContentText("No se encuentra encarcelado, no puede pagar la fianza.");
			alert.showAndWait();
		}
		
		catch(NoPuedePagarFianzaException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No puede pagar la fianza");
			alert.setHeaderText(null);
			alert.setContentText("Recien a partir del segundo turno en la carcel puede pagar la fianza.");
			alert.showAndWait();
		}
		
		catch(CapitalInsuficienteError e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Saldo insuficiente");
			alert.setHeaderText(null);
			alert.setContentText("No dispone del dinero suficiente para comprar este casillero.");
			alert.showAndWait();
		}
//		this.botonera.deshabilitarBotonPagarFianza();
		
		this.botonera.actualizarInformacionJugadores();
		
	}
	
	
	
}
