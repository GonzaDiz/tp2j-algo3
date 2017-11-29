package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Saldo insuficiente");
			alert.setHeaderText(null);
			alert.setContentText("No dispone del dinero suficiente para comprar este casillero.");
			alert.showAndWait();
		}
		
		catch(NoEsUnCasilleroComprableError e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Casillero no comprable");
			alert.setHeaderText(null);
			alert.setContentText("El casillero en el que se encuentra no puede ser comprado.");
			alert.showAndWait();
		}
		this.botonera.actualizarInformacionJugadores();
		this.botonera.deshabilitarBotonComprar();
	}

}
