package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.Algopoly;
import modelo.casillero.compania.Compania;
import modelo.excepciones.NoPuedeCederUnaCompaniaNoPropiaError;
import vista.Botonera;

public class VenderCompaniaHandler implements EventHandler<ActionEvent> {

	private Algopoly algopoly;
	private Compania compania;
	private Botonera botonera;

	public VenderCompaniaHandler(Algopoly algopoly, Compania compania, Botonera botonera) {
		this.algopoly = algopoly;
		this.compania = compania;
		this.botonera = botonera;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			this.algopoly.getJugadorConTurno().venderCompania(this.compania);
			this.botonera.actualizarInformacionJugadores();
			this.botonera.actualizarBotonComprar();
		}
		
		catch(NoPuedeCederUnaCompaniaNoPropiaError e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No puede vender esta propiedad");
			alert.setHeaderText(null);
			alert.setContentText("Para poder vender una compania debe ser el propietario.");
			alert.showAndWait();
		}
	}
}
