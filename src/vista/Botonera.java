package vista;

import controlador.BotonComprarHandler;
import controlador.BotonPagarDeudaHandler;
import controlador.BotonPagarFianzaHandler;
import controlador.BotonRendirseHandler;
import controlador.BotonTerminarJuegoHandler;
import controlador.BotonTerminarTurnoHandler;
import controlador.BotonTirarDadosHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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
	Button botonConstruirCasa;
	Button botonPagarDeuda;
	Button terminarJuego;
	private Stage stage;
	private Label consola;

	
	public Botonera(Algopoly algopoly,VistaJugadores vistaJugadores,VistaInformacionJugadores vistaInformacionJugadores, Stage stage, Label consola) {
		this.algopoly = algopoly;
		this.jugadorConTurno = algopoly.proximoJugador();
		this.vistaJugadores = vistaJugadores;
		this.vistaInformacionJugadores = vistaInformacionJugadores;
		this.stage = stage;
		this.consola = consola;
		this.consola.setText(jugadorConTurno.tuNombreEs() + " es tu turno. ");
		this.crearBotonTirarDados();
		this.crearBotonTerminarTurno();
		this.crearBotonPagarFianza();
		this.crearBotonComprar();
		this.crearBotonRendirse();
		this.crearBotonTermminarJuego();
		this.crearBotonPagarDeuda();
		
	}
	
	private void crearBotonPagarDeuda() {
		this.botonPagarDeuda = new Button();
		this.botonPagarDeuda.setText("Pagar deuda");
		this.botonPagarDeuda.setDisable(true);
		BotonPagarDeudaHandler botonPagarDeudaHandler = new BotonPagarDeudaHandler(this.algopoly, this);
		this.botonPagarDeuda.setOnAction(botonPagarDeudaHandler);
	}
	
	private void crearBotonTermminarJuego() {
		this.terminarJuego = new Button();
		this.terminarJuego.setText("Terminar Jueego");
		BotonTerminarJuegoHandler botonTerminarJuegoHandler = new BotonTerminarJuegoHandler(this.algopoly, this);
		this.terminarJuego.setOnAction(botonTerminarJuegoHandler);
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
									this.botonRendirse,
									this.botonPagarDeuda,
									this.terminarJuego);
		return contenedorVertical;
	}
	
	public void update() {
		this.jugadorConTurno = algopoly.proximoJugador(); // Aca le envia esTuTurno()
		this.consola.setText(jugadorConTurno.tuNombreEs() + " es tu turno. ");
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

	public void actualizarInformacionJugadores( Algopoly algopoly) {
		this.vistaInformacionJugadores.update(  algopoly);	
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
		if(this.algopoly.hayGanador()) {
			this.mostrarAlerta("GANADOR", this.algopoly.getJugadorConTurno().tuNombreEs());
			System.exit(0);
		}

	}

	public void actualizarVistaJugadores() {
		this.vistaJugadores.update();
	}
	
	public void mostrarAlerta(String titulo, String mensaje) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.setContentText(mensaje);
		alert.initOwner(this.stage);
		alert.showAndWait();
	}

	public void deshabilitarBotonPagarDeuda() {
		this.botonPagarDeuda.setDisable(true);
	}

	public void habilitarBotonPagarDeuda() {
		this.botonPagarDeuda.setDisable(false);
	}
}
