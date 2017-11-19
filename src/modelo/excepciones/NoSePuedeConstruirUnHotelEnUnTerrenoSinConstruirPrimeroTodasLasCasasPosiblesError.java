package modelo.excepciones;

public class NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesError extends RuntimeException {

	public static final long serialVersionUID = 700L;
	
	public NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesError(String msj) {
		
		super(msj);
		
	}	
}
