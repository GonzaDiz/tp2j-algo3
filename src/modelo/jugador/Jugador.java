package modelo.jugador;

import java.util.ArrayList;

import modelo.Salida;
import modelo.casillero.Casillero;
import modelo.casillero.terrenos.Terreno;
import modelo.excepciones.CapitalInsuficienteError;

public class Jugador {
	private String nombre;
	private int capital;
	private EstadoJugador estado;
	private int ultimaTirada;
	private ArrayList<Terreno> terrenosComprados;
	private Casillero casilleroActual;
	
	public Jugador(String unNombre) {
		this.casilleroActual = Salida.getSalida();
		this.nombre = unNombre;
		this.capital = 100000;
		this.estado = new Libre();
		this.terrenosComprados = new ArrayList<Terreno>();
		
	}

	public Jugador(String unNombre, int unMontoInicial) {
		this.nombre = unNombre;
		this.capital = unMontoInicial;
		this.estado = new Libre();
		this.terrenosComprados = new ArrayList<Terreno>();
	}

	public String tuNombreEs() {
		return nombre;
	}

	public int capitalTotal() {
		return capital;
	}

	public void caerEnCasillero(Casillero unCasillero) {
		this.casilleroActual = unCasillero;
		unCasillero.afectarJugador(this);	
	}

	public void entregarDinero(int unMonto) {
		this.capital += unMonto;
	}
	
	public void extraerDinero(int unMonto) {
		if(unMonto > this.capital) {
			throw new CapitalInsuficienteError("No dispone del capital necesario para realizar esa accion.");
		}
		this.capital -= unMonto;
	}

	// En principio devuelve boolean, pero habria que contemplar en que momento el jugador decide
	// por si o por no a comprar el terreno. Siempre y cuando tenga el capital suficiente.
	/*public boolean ofrecerTerrenoEn(Terreno unTerreno, int precio) {
		if(precio <= capital) {
			capital-= precio;
			return true;
		}
		return false;
	}*/
	// Este metodo en principio lo sacamos, ya que los conceptos de 'ofrecer cosas al jugador' como las opciones, estaran contempladas en la vista

	public void encarcelar() {
		this.estado = new Encarcelado();
	}
	
	public void liberar() {
		this.estado = new Libre();	
	}
	
	public void cambiarEstado(EstadoJugador nuevoEstado) {
		this.estado = nuevoEstado;
	}
	
	// Devuelve true en caso de poder desplazarse, false en caso contrario.
	public void desplazar(int unValorDeDados) {
		this.estado.desplazar(this, unValorDeDados);
	}

	public void esTuTurno() {
		this.estado.actualizarEstado(this);	
	}

	public void pagarFianza()  {
		this.estado.pagarFianza(this);
	}

	public int cantidadDePropiedades() {
		
		int sum = 0;
		for(Terreno t : terrenosComprados) {
			sum += t.construcciones();
		}
		return sum+terrenosComprados.size();
	}

	public void obtuvo(int unValorDeDados) {
		this.ultimaTirada = unValorDeDados;		
	}

	public Casillero casilleroActual() {
		return casilleroActual;
	}

	public void comprar(Terreno unTerreno) {
		this.terrenosComprados.add(unTerreno.venderTerrenoA(this));	
	}

	public int ultimaTirada() {
		return ultimaTirada;
	}

}
