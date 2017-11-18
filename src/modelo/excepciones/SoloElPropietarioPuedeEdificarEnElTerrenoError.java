package modelo.excepciones;

public class SoloElPropietarioPuedeEdificarEnElTerrenoError extends RuntimeException {
	
	public static final long serialVersionUID = 700L;
	
	public SoloElPropietarioPuedeEdificarEnElTerrenoError(String msj) {
		
		super(msj);
		
	}
}
