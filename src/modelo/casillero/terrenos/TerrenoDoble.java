package modelo.casillero.terrenos;

import modelo.edificaciones.RestriccionDeConstruccionPorFaltaDeCasasEnElTerreno;
import modelo.edificaciones.RestriccionDeConstruccionPorFaltaDeCasasEnElTerrenoPareja;
import modelo.edificaciones.RestriccionDeConstruccionPorLimiteDeCasas;
import modelo.edificaciones.RestriccionDeConstruccionPorLimiteDeHoteles;
import modelo.edificaciones.RestriccionDeConstruccionPorPropiedad;
import modelo.edificaciones.RestriccionDeConstruccionPorPropiedadDeTerrenoPareja;
import modelo.edificaciones.RestriccionDeConstruccionPorTenerHotelesEdificados;
import modelo.jugador.Jugador;

public class TerrenoDoble extends Terreno {

//	private ArrayList<Hotel> hoteles; // En principio es un hotel, pero en un futuro se podrian poner mas
	private int limiteHoteles;
	private int cantidadHoteles;
	private int costoHotel;
	private TerrenoDoble terrenoPareja;
	public AlquilerTerrenoDoble alquiler;
	
	
	public TerrenoDoble(int precioTerreno, int costoCasa, int costoHotel, String nombreCasillero, AlquilerTerrenoDoble alquiler) {
		super();
//		this.hoteles = new ArrayList<Hotel>();
		this.limiteHoteles = 1;
		this.cantidadHoteles = 0;
		this.limiteCasas = 2;
		
		this.precioTerreno = precioTerreno;
		this.costoCasa = costoCasa;
		this.costoHotel = costoHotel;
		this.nombreCasillero = nombreCasillero;
		this.alquiler = alquiler;
	}
	
	public TerrenoDoble(String nombreTerrenoDoble) {
		super();
		this.nombreCasillero = nombreTerrenoDoble;
	}

	public void cobrarAlquilerA(Jugador unJugador){
		
		// Se le cobra el alquiler a un jugador
		int precioAlquiler = alquiler.cobrarAlquilerA1(unJugador, this.cantidadDeCasas(), this.cantidadDeHoteles() );
		//int precioAlquiler = alquiler.costoAlquilerCon(this.cantidadCasas, this.cantidadHoteles);
		//unJugador.extraerDinero(precioAlquiler);
		//Se le entrega el dinero del alquiler cobrado al propietario del terreno
		this.propietario.entregarDinero(precioAlquiler);
	}
	
	@Override
	public int construcciones() {
		return this.cantidadDeCasas() + this.cantidadDeHoteles();
	}
	
	@Override
	public void construirCasaPor(Jugador jugador) {
		
		this.restricciones.add(new RestriccionDeConstruccionPorPropiedad(this, jugador));
		this.restricciones.add(new RestriccionDeConstruccionPorLimiteDeCasas(this, this.limiteCasas));
		this.restricciones.add(new RestriccionDeConstruccionPorPropiedadDeTerrenoPareja(this.terrenoPareja, jugador));
		this.restricciones.add(new RestriccionDeConstruccionPorTenerHotelesEdificados(this.cantidadDeHoteles()));
		this.verificarRestricciones();
		
		jugador.extraerDinero(this.costoCasa);
//		casas.add(new Casa());
		this.cantidadCasas++;
	}

	public void construirHotelPor(Jugador jugador) {
		this.restricciones.add(new RestriccionDeConstruccionPorPropiedad(this, jugador));
		this.restricciones.add(new RestriccionDeConstruccionPorPropiedadDeTerrenoPareja(this.terrenoPareja, jugador));
		this.restricciones.add(new RestriccionDeConstruccionPorFaltaDeCasasEnElTerreno(this, this.limiteCasas));
		this.restricciones.add(new RestriccionDeConstruccionPorFaltaDeCasasEnElTerrenoPareja(this, this.limiteCasas));
		this.restricciones.add(new RestriccionDeConstruccionPorLimiteDeHoteles(this,this.limiteHoteles));
		this.verificarRestricciones();
		
		this.demolerCasas();
		jugador.extraerDinero(this.costoHotel);
//		hoteles.add(new Hotel());
		this.cantidadHoteles++;
		
	}

	public void setTerrenoPareja(TerrenoDoble terreno) {
		this.terrenoPareja = terreno;
	}
	
	@Override
	public int cantidadDeHoteles() {
//		return this.hoteles.size();
		return this.cantidadHoteles;
	}

	@Override
	protected void demolerConstrucciones() {
		this.demolerCasas();
		this.demolerHoteles();
	}

	private void demolerHoteles() {
//		this.hoteles.clear();	
		this.cantidadHoteles = 0;
	}

	@Override
	protected int valorTotal() {
		return this.precioTerreno + (this.cantidadCasas * this.costoCasa) + (this.cantidadHoteles * this.costoHotel);
	}



}
