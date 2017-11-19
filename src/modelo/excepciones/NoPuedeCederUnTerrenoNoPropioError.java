package modelo.excepciones;

public class NoPuedeCederUnTerrenoNoPropioError extends RuntimeException {

	public static final long serialVersionUID = 700L;
	
	public NoPuedeCederUnTerrenoNoPropioError(String msj) {
		
		super(msj);
		
	}	
}
