package modelo;

public class Jugador {
	private String nombre;
	private int capital;
	private EstadoJugador estado;
	private Casillero casilleroActual;

	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.capital = 100000;
		this.estado = new Libre();
		
	}

	public String tuNombreEs() {
		return nombre;
	}

	public int capitalTotal() {
		return capital;
	}

	public void caerEnCasillero(Casillero unCasillero) {
		unCasillero.afectarJugador(this);
		
	}

	public void entregarDinero(int unMonto) {
		this.capital += unMonto;
	}
	
	public void extraerDinero(int unMonto) {
		this.capital -= unMonto;
	}

	// En principio devuelve boolean, pero habria que contemplar en que momento el jugador decide
	// por si o por no a comprar el terreno. Siempre y cuando tenga el capital suficiente.
	public boolean ofrecerTerrenoEn(Terreno unTerreno, int precio) {
		if(precio <= capital) {
			capital-= precio;
			return true;
		}
		return false;
	}

	public void encarcelar() {
		this.estado = new Encarcelado();
	}
	
	public void liberar() {
		this.estado = new Libre();	
	}
	
	// Devuelve true en caso de poder desplazarse, false en caso contrario.
	public boolean desplazar(int unValorDeDados) {
		return this.estado.desplazar(this, unValorDeDados);
	}




}
