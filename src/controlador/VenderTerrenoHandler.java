package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.Algopoly;
import modelo.casillero.terrenos.Terreno;
import modelo.excepciones.NoPuedeCederUnTerrenoNoPropioError;
import vista.Botonera;

public class VenderTerrenoHandler implements EventHandler<ActionEvent> {
	private Algopoly algopoly;
	private Terreno terreno;
	private Botonera botonera;

	public VenderTerrenoHandler(Algopoly algopoly, Terreno terreno, Botonera botonera) {
		this.algopoly = algopoly;
		this.terreno = terreno;
		this.botonera = botonera;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			this.algopoly.getJugadorConTurno().venderTerreno(this.terreno);
			this.botonera.actualizarInformacionJugadores();
			this.botonera.actualizarBotonComprar();
		}
		
		catch(NoPuedeCederUnTerrenoNoPropioError e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No puede vender esta propiedad");
			alert.setHeaderText(null);
			alert.setContentText("Para poder vender un terreno debe ser el propietario.");
			alert.showAndWait();
		}
		
	}
}
