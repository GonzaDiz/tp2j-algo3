package modelo.excepciones;

public class LimiteDeEdificacionesExcedidoError extends RuntimeException {

	public static final long serialVersionUID = 700L;
	
	public LimiteDeEdificacionesExcedidoError(String msj) {
		
		super(msj);
		
	}
}
