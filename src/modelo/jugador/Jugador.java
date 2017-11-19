package modelo.jugador;

import java.util.ArrayList;

import modelo.casillero.Casillero;
import modelo.casillero.compania.Compania;
import modelo.casillero.especial.Carcel;
import modelo.casillero.terrenos.Terreno;
import modelo.casillero.terrenos.TerrenoDoble;
import modelo.excepciones.CapitalInsuficienteError;

public class Jugador {
	private String nombre;
	private int capital;
	private EstadoJugador estado;
	private int ultimaTirada;
	private ArrayList<Terreno> terrenosComprados;
	private ArrayList<Compania> companiasCompradas;
	private Casillero casilleroActual;
	
	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.capital = 100000;
		this.estado = new Libre();
		this.terrenosComprados = new ArrayList<Terreno>();
		this.companiasCompradas = new ArrayList<Compania>();
		
	}

	public Jugador(String unNombre, int unMontoInicial) {
		this.nombre = unNombre;
		this.capital = unMontoInicial;
		this.estado = new Libre();
		this.terrenosComprados = new ArrayList<Terreno>();
		this.companiasCompradas = new ArrayList<Compania>();
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

	public void pagarFianza(Carcel unaCarcel)  {
		this.estado.pagarFianza(this, unaCarcel);
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

	public void comprarTerreno(Terreno unTerreno) {
		this.terrenosComprados.add(unTerreno.venderTerrenoA(this));	
	}
	
	public void comprarCompania(Compania unaCompania) {
		this.companiasCompradas.add(unaCompania.venderCompaniaA(this));
	}

	public int ultimaTirada() {
		return ultimaTirada;
	}

	

	public boolean sos(Jugador jugador) {
		return this == jugador;
	}
	
	public void construirCasaEn(Terreno unTerreno) {
		unTerreno.construirCasaPor(this);
	}

	public void construirHotelEn(TerrenoDoble unTerrenoDoble) {
		unTerrenoDoble.construirHotelPor(this);
	}

}
