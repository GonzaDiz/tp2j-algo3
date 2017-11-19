package modelo.excepciones;

public class ElTableroNoPoseeEseCasilleroError extends RuntimeException {

public static final long serialVersionUID = 700L;
	
	public ElTableroNoPoseeEseCasilleroError(String msj) {
		
		super(msj);
		
	}
}
