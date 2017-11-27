package vista;

import java.util.concurrent.ConcurrentHashMap;

import controlador.BotonTerminarTurnoHandler;
import controlador.BotonTirarDadosHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.Algopoly;
import modelo.jugador.Jugador;

public class Botonera {
	
	private Algopoly algopoly;
	private Jugador jugador;

	private VistaJugadores vistaJugadores;
	private ConcurrentHashMap<Jugador, VistaInformacionJugador> vistaInformacionJugadores;
	
	Button botonTirarDados;
	Button botonTerminarTurno;
	
	public Botonera(Algopoly algopoly,VistaJugadores vistaJugadores,ConcurrentHashMap<Jugador, VistaInformacionJugador> vistaInformacionJugadores) {
		this.algopoly = algopoly;
		this.jugador = algopoly.getJugadorConTurno();
		this.vistaJugadores = vistaJugadores;
		this.vistaInformacionJugadores = vistaInformacionJugadores;
		
		this.crearBotonTirarDados();
		this.crearbotonTerminarTurno();
	}

	private void crearBotonTirarDados() {
		this.botonTirarDados = new Button();
		this.botonTirarDados.setText("Tirar Dados");
		BotonTirarDadosHandler botonTirarDadosHandler = new BotonTirarDadosHandler(vistaJugadores,algopoly,this.jugador,vistaInformacionJugadores);
		this.botonTirarDados.setOnAction(botonTirarDadosHandler);
	}
	
	private void crearbotonTerminarTurno() {
		this.botonTerminarTurno = new Button();
		this.botonTerminarTurno.setText("Terminar Turno");
		BotonTerminarTurnoHandler botonTerminarTurnoHandler = new BotonTerminarTurnoHandler(vistaJugadores,algopoly,vistaInformacionJugadores,this);
		botonTerminarTurno.setOnAction(botonTerminarTurnoHandler);
	}
	
	public VBox getContenedor() {
		VBox contenedorVertical = new VBox(this.botonTirarDados,this.botonTerminarTurno);
		return contenedorVertical;
	}
	
	public void update() {
		this.jugador = algopoly.getProximoJugadorConTurno();
		BotonTirarDadosHandler botonTirarDadosHandler = new BotonTirarDadosHandler(this.vistaJugadores,this.algopoly,this.jugador,this.vistaInformacionJugadores);
		this.botonTirarDados.setOnAction(botonTirarDadosHandler);
	}
}
