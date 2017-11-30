package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.casillero.terrenos.Terreno;
import modelo.excepciones.NoPuedeCederUnTerrenoNoPropioError;
import vista.BarraDeMenu;
import vista.Botonera;

public class VenderTerrenoHandler implements EventHandler<ActionEvent> {
	private Algopoly algopoly;
	private Terreno terreno;
	private Botonera botonera;

	public VenderTerrenoHandler(Algopoly algopoly, Terreno terreno, Botonera botonera, BarraDeMenu barraDeMenu) {
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
			this.botonera.mostrarAlerta("No puede vender esta propiedad", "Para poder vender un terreno debe ser el propietario.");
		}
		
	}
}
