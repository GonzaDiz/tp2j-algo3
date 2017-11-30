package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.casillero.terrenos.Terreno;
import modelo.excepciones.LimiteDeEdificacionesExcedidoError;
import modelo.excepciones.NoPuedeConstruirCasasEnUnTerrenoConHotelesError;
import modelo.excepciones.SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError;
import modelo.excepciones.SoloElPropietarioPuedeEdificarEnElTerrenoError;
import vista.BarraDeMenu;
import vista.VistaInformacionJugadores;

public class ConstruirCasaHandler implements EventHandler<ActionEvent>{

	private Algopoly algopoly;
	private Terreno terreno;
	private VistaInformacionJugadores vistaInformacionJugadores;
	private BarraDeMenu barraDeMenu;

	public ConstruirCasaHandler(Algopoly algopoly, Terreno terreno, VistaInformacionJugadores vistaInformacionJugadores, BarraDeMenu barraDeMenu) {
		this.algopoly = algopoly;
		this.terreno = terreno;
		this.vistaInformacionJugadores = vistaInformacionJugadores;
		this.barraDeMenu = barraDeMenu;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			this.algopoly.getJugadorConTurno().construirCasaEn(this.terreno);
			this.vistaInformacionJugadores.update();
		}
		
		catch(LimiteDeEdificacionesExcedidoError e) {
			this.barraDeMenu.mostrarAlerta("No puede construir casa en este terreno", "Este terreno tiene la capacidad maxima de casas permitida.");
		}
		
		catch(SoloElPropietarioPuedeEdificarEnElTerrenoError e) {
			this.barraDeMenu.mostrarAlerta("No puede construir casa en este terreno", "Debe ser el propietario del terreno para construir una casa en el mismo.");
		}
		
		catch(SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError e) {
			this.barraDeMenu.mostrarAlerta("No puede contruir casa en este terreno", "Para construir una casa en un terreno doble debe ser propietario tambien del terreno pareja.");
		}
		
		catch(NoPuedeConstruirCasasEnUnTerrenoConHotelesError e) {
			this.barraDeMenu.mostrarAlerta("No puede contruir casa en este terreno", "No puede construir una casa en un terreno que tiene edificados hoteles.");
		}
		
	}

}
