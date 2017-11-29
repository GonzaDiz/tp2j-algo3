package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.Algopoly;
import modelo.casillero.terrenos.TerrenoDoble;
import modelo.excepciones.LimiteDeEdificacionesExcedidoError;
import modelo.excepciones.NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesEnElTerrenoParejaError;
import modelo.excepciones.NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesError;
import modelo.excepciones.SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError;
import modelo.excepciones.SoloElPropietarioPuedeEdificarEnElTerrenoError;
import vista.VistaInformacionJugadores;

public class ConstruirHotelHandler  implements EventHandler<ActionEvent>{

	private Algopoly algopoly;
	private TerrenoDoble terreno;
	private VistaInformacionJugadores vistaInformacionJugadores;

	public ConstruirHotelHandler(Algopoly algopoly, TerrenoDoble terreno, VistaInformacionJugadores vistaInformacionJugadores) {
		this.algopoly = algopoly;
		this.terreno = terreno;
		this.vistaInformacionJugadores = vistaInformacionJugadores;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			this.algopoly.getJugadorConTurno().construirHotelEn(this.terreno);
			this.vistaInformacionJugadores.update();
		}
		
		catch(LimiteDeEdificacionesExcedidoError e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No puede construir hotel en este terreno");
			alert.setHeaderText(null);
			alert.setContentText("Este terreno tiene la capacidad maxima de hoteles permitidos.");
			alert.showAndWait();
		}
		
		catch(SoloElPropietarioPuedeEdificarEnElTerrenoError e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No puede construir hotel en este terreno");
			alert.setHeaderText(null);
			alert.setContentText("Debe ser el propietario del terreno para construir un hotel en el mismo.");
			alert.showAndWait();
		}
		
		catch(SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No puede construir hotel en este terreno");
			alert.setHeaderText(null);
			alert.setContentText("Para construir un hotel en un terreno doble debe ser propietario tambien del terreno pareja.");
			alert.showAndWait();
		}
		
		catch(NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesError e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No puede construir hotel en este terreno");
			alert.setHeaderText(null);
			alert.setContentText("Para construir un hotel debe primero construir todas las casas posibles en el mismo.");
			alert.showAndWait();
		}
		
		catch(NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesEnElTerrenoParejaError e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No puede construir hotel en este terreno");
			alert.setHeaderText(null);
			alert.setContentText("Para construir un hotel debe primero construir todas las casas posibles en el terreno pareja.");
			alert.showAndWait();
		}
	}
}
