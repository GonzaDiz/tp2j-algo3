package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.excepciones.CapitalInsuficienteError;
import vista.Botonera;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {
	

	private Algopoly algopoly;
	private Botonera botonera;

	public BotonTirarDadosHandler(Algopoly algopoly, Botonera botonera) { 
		this.algopoly = algopoly;
		this.botonera = botonera;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		try {
			this.algopoly.getJugadorConTurno().arrojaDados(algopoly.getTurno());
			this.botonera.deshabilitarBotonTirarDados();
			this.botonera.habilitarBotonTerminarTurno();
			this.botonera.actualizarVistaJugadores();
			this.botonera.actualizarInformacionJugadores(  algopoly);
			this.botonera.actualizarBotonComprar();
		}
		catch(CapitalInsuficienteError e) {
			this.botonera.deshabilitarBotonTirarDados();
			this.botonera.deshabilitarBotonTerminarTurno();
			this.botonera.habilitarBotonPagarDeuda();
			this.botonera.actualizarVistaJugadores();
			this.botonera.actualizarInformacionJugadores(  algopoly);
			this.botonera.actualizarBotonComprar();
		}
		

	}

}
