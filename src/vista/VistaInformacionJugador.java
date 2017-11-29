package vista;



import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import modelo.jugador.Jugador;
import javafx.geometry.Insets;

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
		Font fontDatos = new Font(15);	
		Text nombre = new Text();
		
        Font font = new Font(30);	  		
		nombre.setFill(jugador.getColor());
		nombre.setFont(font);
		nombre.setWrappingWidth(200);
		nombre.setTextAlignment(TextAlignment.JUSTIFY);
		nombre.setText(this.jugador.tuNombreEs());
		
		
		Text capital = new Text();
		capital.setFont(fontDatos);
		capital.setWrappingWidth(200);
		capital.setTextAlignment(TextAlignment.JUSTIFY);
		capital.setText("Capital total = " + String.valueOf(this.jugador.capitalTotal()));
		
		Text ultimaTirada = new Text();
		ultimaTirada.setFont(fontDatos);
		ultimaTirada.setWrappingWidth(200);
		ultimaTirada.setTextAlignment(TextAlignment.JUSTIFY);
		ultimaTirada.setText("Ultima tirada = " + String.valueOf(this.jugador.ultimaTirada()) );
		
		Text posicionActual = new Text();
		posicionActual.setFont(fontDatos);
		posicionActual.setWrappingWidth(200);
		posicionActual.setTextAlignment(TextAlignment.JUSTIFY);
		posicionActual.setText("Casillero actual = " + this.jugador.casilleroActual().nombre());
		
		Text posX = new Text();
		posX.setFont(fontDatos);
		posX.setWrappingWidth(200);
		posX.setTextAlignment(TextAlignment.JUSTIFY);		
		posX.setText("Posicion en X = " + String.valueOf(this.jugador.getPosicion().getX()));
		
		Text posY = new Text();
		posY.setFont(fontDatos);
		posY.setWrappingWidth(200);
		posY.setTextAlignment(TextAlignment.JUSTIFY);
		posY.setText("Posicion en Y = " + String.valueOf(this.jugador.getPosicion().getY()));

		this.vbox.getChildren().add(nombre);
		this.vbox.getChildren().add(capital);
		this.vbox.getChildren().add(posicionActual);
		this.vbox.getChildren().add(ultimaTirada);
		this.vbox.getChildren().add(posX);
		this.vbox.getChildren().add(posY);
		
	}
	
}