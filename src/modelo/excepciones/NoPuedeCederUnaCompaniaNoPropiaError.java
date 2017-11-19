package modelo.excepciones;

public class NoPuedeCederUnaCompaniaNoPropiaError extends RuntimeException {

	public static final long serialVersionUID = 700L;
	
	public NoPuedeCederUnaCompaniaNoPropiaError(String msj) {
		
		super(msj);
		
	}
}
