package vista;

import java.util.ArrayList;
import java.util.LinkedList;


import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Algopoly;
import modelo.jugador.Jugador;



public class ContenedorPrincipal extends BorderPane {
	
	private VBox contenedorCentral;
	private Canvas canvasCentral;
	private LinkedList<Color> colores;
	private VistaJugadores vistaJugadores;
	private VistaInformacionJugadores vistaInformacionJugadores;
	private BarraDeMenu menuBar;
	private Botonera botonera;
	private Stage stage;
	private Label etiqueta;


	
	public ContenedorPrincipal(Stage stage, Algopoly algopoly) {
		this.stage = stage;
		this.colores = new LinkedList<>();
		this.colores.push(Color.RED);
		this.colores.push(Color.BLUE);
		this.colores.push(Color.GREEN);
		this.setConsola();
		this.setInformacionJugadores(algopoly.getJugadores(),algopoly);
		//setInformacionJugadores2(algopoly);
		
		this.setCentro(algopoly.getJugadores());
		this.setBotonera(algopoly);
		this.setMenu(algopoly);
		stage.setHeight(800);
		stage.setWidth(800);
		
		
		
	}
	
	private void setMenu(Algopoly algopoly) {
        this.menuBar = new BarraDeMenu(algopoly, this.vistaInformacionJugadores, this.botonera,this.stage);
        this.setTop(menuBar);
    }
	
	private void setConsola() {
		 this.etiqueta = new Label();
	     etiqueta.setText("Consola");
	     etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
	     etiqueta.setTextFill(Color.WHITE);
	     VBox contenedorConsola = new VBox(etiqueta);
	     contenedorConsola.setSpacing(10);
	     contenedorConsola.setPadding(new Insets(15));
	     contenedorConsola.setStyle("-fx-background-color: black;");
	     this.setBottom(contenedorConsola);
	     
	     
		
	}

	private void setBotonera(Algopoly algopoly) {
		
		this.botonera = new Botonera(algopoly,this.vistaJugadores,this.vistaInformacionJugadores,this.stage, this.etiqueta);
		VBox contenedorVertical = this.botonera.getContenedor();
		contenedorVertical.setSpacing(10);
		contenedorVertical.setPadding(new Insets(15));
		this.setLeft(contenedorVertical);
	}
	
	
	
	private void setCentro(ArrayList<Jugador> jugadores) {
		canvasCentral = new Canvas(600,600);
		
		vistaJugadores = new VistaJugadores(jugadores,canvasCentral,this.colores);
		vistaJugadores.dibujar();
		
		contenedorCentral = new VBox(canvasCentral);
		contenedorCentral.setAlignment(Pos.CENTER);
		Image imagen_tablero = new Image("file:src/vista/imagenes/Tablero_Full_screen.jpg");
		
	
		
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen_tablero, BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		

		
		contenedorCentral.setBackground(new Background(imagenDeFondo));
		
		this.setCenter(contenedorCentral);
		
		
	}

	private void setInformacionJugadores(ArrayList<Jugador> jugadores, Algopoly algopoly) {
		this.vistaInformacionJugadores = new VistaInformacionJugadores(jugadores, this.colores,algopoly);
		VBox contendeorVertical = this.vistaInformacionJugadores.getContenedorVerticalConInformacion();
		this.setRight(contendeorVertical);
	}

	private void setJugadorQueSeMueves(ArrayList<Jugador> jugadores ,Algopoly algopoly) {
		this.vistaInformacionJugadores = new VistaInformacionJugadores(jugadores, this.colores,  algopoly);
		VBox contendeorVertical = this.vistaInformacionJugadores.getContenedorVerticalConInformacion();
		this.setRight(contendeorVertical);
	}
	
	
}


