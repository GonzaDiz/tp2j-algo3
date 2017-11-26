package modelo.jugador;

import java.util.ArrayList;

import modelo.SinTiro;
import modelo.TiroDeDados;
import modelo.Turno;
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
	private TiroDeDados ultimaTirada;
	private ArrayList<Terreno> terrenosComprados;
	private ArrayList<Compania> companiasCompradas;
	private Casillero casilleroActual;
	private ArrayList<RestriccionDeIntercambio> restriccionesDeIntercambio;;
	
	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.capital = 100000;
		this.estado = new Libre();
		this.terrenosComprados = new ArrayList<Terreno>();
		this.companiasCompradas = new ArrayList<Compania>();
		this.restriccionesDeIntercambio = new ArrayList<RestriccionDeIntercambio>();
		this.ultimaTirada = new SinTiro();
		
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

	public void obtuvo(TiroDeDados tiroDeDados) {
		//this.ultimaTirada.actualizarEstado(this,tiroDeDados);
		tiroDeDados.actualizarEstado(this,this.ultimaTirada);
		this.ultimaTirada = tiroDeDados;		
	}

	public Casillero casilleroActual() {
		return casilleroActual;
	}

	public void comprarTerreno(Terreno unTerreno) {
		unTerreno.venderTerrenoA(this);	
	}
	
	public void comprarCompania(Compania unaCompania) {
		unaCompania.venderCompaniaA(this);
	}

	public int ultimaTirada() {
		return ultimaTirada.valor();
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

	public void intercambiarTerrenoConPor(Terreno unTerrenoPropio, Jugador jugadorRival, Terreno unTerrenoDelRival) {
		this.cederTerrenoA(unTerrenoPropio, jugadorRival);
		jugadorRival.cederTerrenoA(unTerrenoDelRival, this);
		
	}
	
	public void intercambiarCompaniaConPor(Compania unaCompaniaPropia, Jugador jugadorRival, Compania unaCompaniaDelRival) {
		this.cederCompaniaA(unaCompaniaPropia, jugadorRival);
		jugadorRival.cederCompaniaA(unaCompaniaDelRival, this);
		
	}
	
	public void adquirirPropiedadDe(Terreno terreno) {
		this.terrenosComprados.add(terreno);
	}

	public void adquirirPropiedadDe(Compania compania) {
		this.companiasCompradas.add(compania);	
	}

	private void cederCompaniaA(Compania unaCompaniaPropia, Jugador jugadorRival) {
		this.restriccionesDeIntercambio.add(new RestriccionDeIntercambioDeCompaniaPorNoSerPropietario(this.companiasCompradas, unaCompaniaPropia));
		this.restriccionesDeIntercambio.add(new RestriccionDeIntercambioPorSerElMismoJugador(this, jugadorRival));
		this.verificarRestriccionesDeIntercambio();
		
		this.companiasCompradas.remove(unaCompaniaPropia);
		unaCompaniaPropia.cambiarPropietarioA(jugadorRival);
		
	}

	private void cederTerrenoA(Terreno unTerrenoPropio, Jugador jugadorRival) {
		this.restriccionesDeIntercambio.add(new RestriccionDeIntercambioDeTerrenoPorNoSerPropietario(this.terrenosComprados, unTerrenoPropio));
		this.restriccionesDeIntercambio.add(new RestriccionDeIntercambioPorSerElMismoJugador(this, jugadorRival));
		this.verificarRestriccionesDeIntercambio();
		
		this.terrenosComprados.remove(unTerrenoPropio);
		unTerrenoPropio.cambiarPropietarioA(jugadorRival);	
	}

	private void verificarRestriccionesDeIntercambio() {
		for(RestriccionDeIntercambio r : this.restriccionesDeIntercambio) {
			r.verificar();
		}
		
		this.restriccionesDeIntercambio.clear(); // Eliminamos las restricciones ya verificadas.
		
	}

	public void terminarTurno(Turno turno) {
		this.estado.terminarTurno(turno,this);
	}

	public void venderTerreno(Terreno unTerreno) {
		unTerreno.vender(this);
		this.terrenosComprados.remove(unTerreno);
	}

}
