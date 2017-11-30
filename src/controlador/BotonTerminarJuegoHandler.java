package controlador;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import vista.Botonera;

public class BotonTerminarJuegoHandler implements EventHandler<ActionEvent> {

	private Botonera botonera;
	private Algopoly algopoly;
	
	
	public BotonTerminarJuegoHandler(Algopoly algopoly, Botonera botonera) {
		this.algopoly = algopoly;
		this.botonera = botonera;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		 Platform.exit();
	}

}