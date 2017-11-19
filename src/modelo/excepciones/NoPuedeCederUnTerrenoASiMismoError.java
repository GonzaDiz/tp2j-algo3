package modelo.excepciones;

public class NoPuedeCederUnTerrenoASiMismoError extends RuntimeException {

	public static final long serialVersionUID = 700L;
	
	public NoPuedeCederUnTerrenoASiMismoError(String msj) {
		
		super(msj);
		
	}
}
