package modelo.excepciones;

public class NoPuedeConstruirCasasEnUnTerrenoConHotelesError extends RuntimeException {

	public static final long serialVersionUID = 700L;
	
	public NoPuedeConstruirCasasEnUnTerrenoConHotelesError(String msj) {
		
		super(msj);
		
	}	
}
