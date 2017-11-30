package vista;

import controlador.BotonComprarHandler;
import controlador.BotonPagarFianzaHandler;
import controlador.BotonRendirseHandler;
import controlador.BotonTerminarTurnoHandler;
import controlador.BotonTirarDadosHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.Algopoly;
import modelo.jugador.Jugador;

public class Botonera {
	
	private Algopoly algopoly;
	private Jugador jugadorConTurno;

	private VistaJugadores vistaJugadores;
	private VistaInformacionJugadores vistaInformacionJugadores;
	
	Button botonTirarDados;
	Button botonTerminarTurno;
	Button botonPagarFianza;
	Button botonComprar;
	Button botonRendirse;
	
	public Botonera(Algopoly algopoly,VistaJugadores vistaJugadores,VistaInformacionJugadores vistaInformacionJugadores) {
		this.algopoly = algopoly;
		this.jugadorConTurno = algopoly.proximoJugador();
		this.vistaJugadores = vistaJugadores;
		this.vistaInformacionJugadores = vistaInformacionJugadores;
		
		this.crearBotonTirarDados();
		this.crearBotonTerminarTurno();
		this.crearBotonPagarFianza();
		this.crearBotonComprar();
		this.crearBotonRendirse();
	}

	private void crearBotonRendirse() {
		this.botonRendirse = new Button();
		this.botonRendirse.setText("Rendirse");
		BotonRendirseHandler botonRendirseHandler = new BotonRendirseHandler(this.algopoly, this);
		this.botonRendirse.setOnAction(botonRendirseHandler); 
	}

	private void crearBotonComprar() {
		this.botonComprar = new Button();
		this.botonComprar.setText("Comprar casillero");
		this.botonComprar.setDisable(true);
		BotonComprarHandler botonComprarHandler = new BotonComprarHandler(this.algopoly, this);
		this.botonComprar.setOnAction(botonComprarHandler);
	}

	private void crearBotonTirarDados() {
		this.botonTirarDados = new Button();
		this.botonTirarDados.setText("Tirar Dados");
		BotonTirarDadosHandler botonTirarDadosHandler = new BotonTirarDadosHandler(this.algopoly, this);
		this.botonTirarDados.setOnAction(botonTirarDadosHandler);
	}
	
	private void crearBotonTerminarTurno() {
		this.botonTerminarTurno = new Button();
		this.botonTerminarTurno.setText("Terminar Turno");
		this.botonTerminarTurno.setDisable(true);
		BotonTerminarTurnoHandler botonTerminarTurnoHandler = new BotonTerminarTurnoHandler(algopoly,this);
		this.botonTerminarTurno.setOnAction(botonTerminarTurnoHandler);
	}
	
	private void crearBotonPagarFianza() {
		this.botonPagarFianza = new Button();
		this.botonPagarFianza.setText("Pagar fianza");
//		this.botonPagarFianza.setDisable(true);
		BotonPagarFianzaHandler botonPagarFianzaHandler = new BotonPagarFianzaHandler(algopoly, this);
		this.botonPagarFianza.setOnAction(botonPagarFianzaHandler);
	}
	
	public VBox getContenedor() {
		VBox contenedorVertical = new VBox(
									this.botonTirarDados,
									this.botonTerminarTurno, 
									this.botonPagarFianza,
									this.botonComprar,
									this.botonRendirse);
		return contenedorVertical;
	}
	
	public void update() {
		this.jugadorConTurno = algopoly.proximoJugador(); // Aca le envia esTuTurno()
//		
//		if(this.jugadorConTurno.podesPagarFianza()) {
//			this.botonPagarFianza.setDisable(false);
//		}
		
		if(this.jugadorConTurno.noPuedeTirarDados()) {
			this.botonTirarDados.setDisable(true);
			this.botonTerminarTurno.setDisable(false);
		}
		
		this.actualizarBotonComprar();
	}

	public void deshabilitarBotonTirarDados() {
		this.botonTirarDados.setDisable(true);	
	}

	public void habilitarBotonTerminarTurno() {
		this.botonTerminarTurno.setDisable(false);
	}

	public void deshabilitarBotonTerminarTurno() {
		this.botonTerminarTurno.setDisable(true);
	}

	public void habilitarBotonTirarDados() {
		this.botonTirarDados.setDisable(false);
	}

	public void deshabilitarBotonPagarFianza() {
		this.botonPagarFianza.setDisable(true);		
	}

	public void actualizarInformacionJugadores() {
		this.vistaInformacionJugadores.update();	
	}

	public void deshabilitarBotonComprar() {
		this.botonComprar.setDisable(true);
		
	}

	public void actualizarBotonComprar() {
		if(this.algopoly.getJugadorConTurno().estasEnUnCasilleroComprable()) {
			this.botonComprar.setDisable(false);
		}
	}

	public void eliminarJugador(Jugador jugadorRendido) {
		this.vistaJugadores.eliminar(jugadorRendido);
		this.algopoly.eliminarJugador(jugadorRendido);
		this.vistaInformacionJugadores.eliminar(jugadorRendido);

	}

	public void actualizarVistaJugadores() {
		this.vistaJugadores.update();
	}
}
