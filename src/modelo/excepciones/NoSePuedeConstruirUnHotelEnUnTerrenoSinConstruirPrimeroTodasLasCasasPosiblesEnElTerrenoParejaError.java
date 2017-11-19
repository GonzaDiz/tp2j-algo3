package modelo.excepciones;

public class NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesEnElTerrenoParejaError extends RuntimeException {

	public static final long serialVersionUID = 700L;
	
	public NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesEnElTerrenoParejaError(String msj) {
		
		super(msj);
		
	}	
}
