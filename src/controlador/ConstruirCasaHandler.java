package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.Algopoly;
import modelo.casillero.terrenos.Terreno;
import modelo.excepciones.LimiteDeEdificacionesExcedidoError;
import modelo.excepciones.NoPuedeConstruirCasasEnUnTerrenoConHotelesError;
import modelo.excepciones.SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError;
import modelo.excepciones.SoloElPropietarioPuedeEdificarEnElTerrenoError;
import vista.VistaInformacionJugadores;

public class ConstruirCasaHandler implements EventHandler<ActionEvent>{

	private Algopoly algopoly;
	private Terreno terreno;
	private VistaInformacionJugadores vistaInformacionJugadores;

	public ConstruirCasaHandler(Algopoly algopoly, Terreno terreno, VistaInformacionJugadores vistaInformacionJugadores) {
		this.algopoly = algopoly;
		this.terreno = terreno;
		this.vistaInformacionJugadores = vistaInformacionJugadores;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			this.algopoly.getJugadorConTurno().construirCasaEn(this.terreno);
			this.vistaInformacionJugadores.update();
		}
		
		catch(LimiteDeEdificacionesExcedidoError e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No puede construir casa en este terreno");
			alert.setHeaderText(null);
			alert.setContentText("Este terreno tiene la capacidad maxima de casas permitida.");
			alert.showAndWait();
		}
		
		catch(SoloElPropietarioPuedeEdificarEnElTerrenoError e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No puede construir casa en este terreno");
			alert.setHeaderText(null);
			alert.setContentText("Debe ser el propietario del terreno para construir una casa en el mismo.");
			alert.showAndWait();
		}
		
		catch(SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No puede construir casa en este terreno");
			alert.setHeaderText(null);
			alert.setContentText("Para construir una casa en un terreno doble debe ser propietario tambien del terreno pareja.");
			alert.showAndWait();
		}
		
		catch(NoPuedeConstruirCasasEnUnTerrenoConHotelesError e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No puede construir una casa en este terreno");
			alert.setHeaderText(null);
			alert.setContentText("No puede construir una casa en un terreno que tiene edificados hoteles.");
			alert.showAndWait();
		}
		
	}

}
