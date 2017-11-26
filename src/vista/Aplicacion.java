package vista;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Algopoly;
import modelo.jugador.Jugador;

public class Aplicacion extends Application {
	
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void start(final Stage stage) throws Exception {
		
		stage.setTitle("Algopoly");
		
		Algopoly algopoly = crearModelo();
		
		ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage,algopoly);
		Scene escenaJuego = new Scene(contenedorPrincipal);
		stage.setScene(escenaJuego);
		stage.setFullScreen(true);
		stage.show();
	}
	
	private Algopoly crearModelo() {
		ArrayList<Jugador> jugadores = new ArrayList<>();
		Jugador jugador1 = new Jugador("Ariel");
		Jugador jugador2 = new Jugador("Gonzalo");
		Jugador jugador3 = new Jugador("Uriel");
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		
		Algopoly algopoly = new Algopoly(jugadores);
		
		return algopoly;
	}

	
}
