package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Algopoly;
import modelo.casillero.terrenos.TerrenoDoble;
import modelo.excepciones.CapitalInsuficienteError;
import modelo.excepciones.LimiteDeEdificacionesExcedidoError;
import modelo.excepciones.NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesEnElTerrenoParejaError;
import modelo.excepciones.NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesError;
import modelo.excepciones.SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError;
import modelo.excepciones.SoloElPropietarioPuedeEdificarEnElTerrenoError;
import vista.BarraDeMenu;
import vista.VistaInformacionJugadores;

public class ConstruirHotelHandler  implements EventHandler<ActionEvent>{

	private Algopoly algopoly;
	private TerrenoDoble terreno;
	private VistaInformacionJugadores vistaInformacionJugadores;
	private BarraDeMenu barraDeMenu;

	public ConstruirHotelHandler(Algopoly algopoly, TerrenoDoble terreno, VistaInformacionJugadores vistaInformacionJugadores, BarraDeMenu barraDeMenu) {
		this.algopoly = algopoly;
		this.terreno = terreno;
		this.vistaInformacionJugadores = vistaInformacionJugadores;
		this.barraDeMenu = barraDeMenu;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			this.algopoly.getJugadorConTurno().construirHotelEn(this.terreno);
			this.vistaInformacionJugadores.update( algopoly);
		}
		
		catch(LimiteDeEdificacionesExcedidoError e) {
			this.barraDeMenu.mostrarAlerta("No puede construir hotel en este terreno", "Este terreno tiene la capacidad maxima de hoteles permitidos.");
		}
		
		catch(SoloElPropietarioPuedeEdificarEnElTerrenoError e) {
			this.barraDeMenu.mostrarAlerta("No puede construir hotel en este terreno", "Debe ser el propietario del terreno para construir un hotel en el mismo.");

		}
		
		catch(SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError e) {
			this.barraDeMenu.mostrarAlerta("No puede construir hotel en este terreno", "Para construir un hotel en un terreno doble debe ser propietario tambien del terreno pareja.");

		}
		
		catch(NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesError e) {
			this.barraDeMenu.mostrarAlerta("No puede construir hotel en este terreno", "Para construir un hotel debe primero construir todas las casas posibles en el mismo.");

		}
		
		catch(NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesEnElTerrenoParejaError e) {
			this.barraDeMenu.mostrarAlerta("No puede construir hotel en este terreno", "Para construir un hotel debe primero construir todas las casas posibles en el terreno pareja.");
		}
		
		catch(CapitalInsuficienteError e) {
			this.barraDeMenu.mostrarAlerta("No puede construir hotel en este terreno", "No dispone del capital necesario para construir un hotel aqui.");
		}
		
	}
}
