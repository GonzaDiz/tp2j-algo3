package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.casillero.compania.Compania;
import modelo.excepciones.NoPuedeCederUnaCompaniaNoPropiaError;
import vista.BarraDeMenu;
import vista.Botonera;

public class VenderCompaniaHandler implements EventHandler<ActionEvent> {

	private Algopoly algopoly;
	private Compania compania;
	private Botonera botonera;
	private BarraDeMenu barraDeMenu;

	public VenderCompaniaHandler(Algopoly algopoly, Compania compania, Botonera botonera, BarraDeMenu barraDeMenu) {
		this.algopoly = algopoly;
		this.compania = compania;
		this.botonera = botonera;
		this.barraDeMenu = barraDeMenu;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			this.algopoly.getJugadorConTurno().venderCompania(this.compania);
			this.botonera.actualizarInformacionJugadores(  algopoly);
			this.botonera.actualizarBotonComprar();
		}
		
		catch(NoPuedeCederUnaCompaniaNoPropiaError e) {
			this.barraDeMenu.mostrarAlerta("No puede vender esta propiedad", "Para poder vender una compania debe ser el propietario");
		}
	}
}
