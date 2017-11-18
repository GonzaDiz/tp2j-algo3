package modelo.excepciones;

public class SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError extends RuntimeException {

	
	public static final long serialVersionUID = 700L;
	
	public SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError(String msj) {
		
		super(msj);
		
	}	
}
