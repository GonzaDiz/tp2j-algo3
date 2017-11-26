package vista;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.jugador.Jugador;

public class VistaInformacionJugador  {
	
	private Jugador jugador;
	VBox vbox;
	
	
	public VistaInformacionJugador(Jugador jugador, VBox boxInfo) {		
		this.jugador = jugador;
		this.vbox = boxInfo;
		this.update();
	}


	public void update() {
		this.vbox.getChildren().clear();
		
		Text nombre = new Text();
		nombre.setText(this.jugador.tuNombreEs());
		
		Text capital = new Text();
		capital.setText("Capital total = " + String.valueOf(this.jugador.capitalTotal()));
		
		Text ultimaTirada = new Text();
		ultimaTirada.setText("Ultima tirada = " + String.valueOf(this.jugador.ultimaTirada()) );
		
		Text posicionActual = new Text();
		posicionActual.setText(" Casillero actual = " + this.jugador.casilleroActual().nombre());
		
		Text posX = new Text();
		posX.setText("Posicion en X = " + String.valueOf(this.jugador.getPosicion().getX()));
		
		Text posY = new Text();
		posY.setText("Posicion en Y = " + String.valueOf(this.jugador.getPosicion().getY()));

		this.vbox.getChildren().add(nombre);
		this.vbox.getChildren().add(capital);
		this.vbox.getChildren().add(posicionActual);
		this.vbox.getChildren().add(ultimaTirada);
		this.vbox.getChildren().add(posX);
		this.vbox.getChildren().add(posY);
	}
	
}