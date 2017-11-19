package modelo.excepciones;

public class PorcentajeInvalidoError extends RuntimeException {

	public static final long serialVersionUID = 700L;
	
	public PorcentajeInvalidoError(String msj) {
		
		super(msj);
		
	}
}
