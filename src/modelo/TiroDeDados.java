package modelo;

import modelo.jugador.Jugador;

public interface TiroDeDados {

	int valor();
	void actualizarEstado(Jugador jugador, TiroDeDados tiroDados);
	boolean sosDoble();

}
