package modelo.excepciones;

public class CapitalInsuficienteError extends Exception {

	public static final long serialVersionUID = 700L;
	
	public CapitalInsuficienteError(String msj) {
		
		super(msj);
		
	}
}