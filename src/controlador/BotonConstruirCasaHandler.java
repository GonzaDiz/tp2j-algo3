package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import vista.Botonera;

public class BotonConstruirCasaHandler implements EventHandler<ActionEvent>{

	private Algopoly algopoly;
	private Botonera botonera;

	public BotonConstruirCasaHandler(Algopoly algopoly, Botonera botonera) {
		this.algopoly = algopoly;
		this.botonera = botonera;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
		
	}

}
