package modelo.excepciones;

public class AlquilerInexistenteError extends RuntimeException {

	public static final long serialVersionUID = 700L;
	
	public AlquilerInexistenteError(String msj) {
		
		super(msj);
		
	}	
}
