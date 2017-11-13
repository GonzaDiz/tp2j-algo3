package modelo.excepciones;

public class CapitalInsuficienteError extends RuntimeException {

	public static final long serialVersionUID = 700L;
	
	public CapitalInsuficienteError(String msj) {
		
		super(msj);
		
	}
}