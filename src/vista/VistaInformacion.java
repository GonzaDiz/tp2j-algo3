package vista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import modelo.casillero.compania.Compania;
import modelo.casillero.terrenos.Terreno;
import modelo.jugador.Jugador;

public class VistaInformacion  {
	
	private Jugador jugador;
	VBox vbox;
	private Color color;
	
	
	public VistaInformacion(Jugador jugador, VBox boxInfo, Color color) {		
		this.jugador = jugador;
		this.vbox = boxInfo;
		//this.color = color;
		this.color= jugador.tuColorEs();
		this.update();
	}


	public void update() {
		this.vbox.getChildren().clear();
		Font fontDatos = new Font(15);	
		
		Text nombre = new Text();
		Font font = new Font(30);	  		
		
		//nombre.setFill(this.color);
		nombre.setFill(jugador.tuColorEs());
		nombre.setFont(font);
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
		
		this.vbox.getChildren().add(nombre);
		this.vbox.getChildren().add(capital);
		this.vbox.getChildren().add(posicionActual);
		this.vbox.getChildren().add(ultimaTirada);
		
		Text terrenos = new Text();
		terrenos.setFont(fontDatos);
		terrenos.setWrappingWidth(200);
		terrenos.setTextAlignment(TextAlignment.JUSTIFY);
		terrenos.setText("Terrenos comprados:");
		this.vbox.getChildren().add(terrenos);
		ObservableList<String> nombreTerrenos = FXCollections.observableArrayList();
		ComboBox<String> comboBoxTerreno = new ComboBox<>();
		for (Terreno terreno : jugador.getTerrenos()) {
			nombreTerrenos.add(terreno.nombre() + " Casas: " +terreno.cantidadDeCasas() + " Hoteles: " + terreno.cantidadDeHoteles());
		}
		comboBoxTerreno.setItems(nombreTerrenos);
		comboBoxTerreno.setPrefWidth(300);
		//comboBoxTerreno.getSelectionModel();
	
		
		this.vbox.getChildren().add(comboBoxTerreno);
		Text companias = new Text();
		companias.setFont(fontDatos);
		companias.setWrappingWidth(200);
		companias.setTextAlignment(TextAlignment.JUSTIFY);
		companias.setText("Companias:");
		this.vbox.getChildren().add(companias);
		ObservableList<String> nombreCompania = FXCollections.observableArrayList();
		ComboBox<String> comboBoxCompania = new ComboBox<>();
		
		for (Compania compania: jugador.getCompanias()) {
			nombreCompania.add(compania.nombre());
		}
		comboBoxCompania.setItems(nombreCompania);
		comboBoxCompania.setPrefWidth(300);
		this.vbox.getChildren().add(comboBoxCompania);
		
		this.vbox.setPadding(new Insets(15));
	}
	
}