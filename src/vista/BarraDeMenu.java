package vista;

import controlador.ConstruirCasaHandler;
import controlador.ConstruirHotelHandler;
import controlador.VenderCompaniaHandler;
import controlador.VenderTerrenoHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import modelo.Algopoly;

public class BarraDeMenu extends MenuBar{
	
	private Stage stage;

	public BarraDeMenu(Algopoly algopoly, VistaInformacionJugadores vistaInformacionJugadores, Botonera botonera, Stage stage) {
		this.stage = stage;
		Menu menuConstruirCasa = new Menu("Construir casa en...");
		Menu menuConstruirHotel = new Menu("Construir hotel en...");
		Menu menuVenderPropiedad = new Menu("Vender propiedad...");
		
		MenuItem casaEnBuenosAiresSur = new MenuItem("Buenos Aires Sur");
		MenuItem casaEnBuenosAiresNorte = new MenuItem("Buenos Aires Norte");
		MenuItem casaEnCordobaSur = new MenuItem("Cordoba Sur");
		MenuItem casaEnCordobaNorte = new MenuItem("Cordoba Norte");
		MenuItem casaEnSantaFe = new MenuItem("Santa Fe");
		MenuItem casaEnSaltaNorte = new MenuItem("Salta Norte");
		MenuItem casaEnSaltaSur = new MenuItem("Salta Sur");
		MenuItem casaEnNeuquen = new MenuItem("Neuquen");
		MenuItem casaEnTucuman = new MenuItem("Tucuman");
		
		MenuItem hotelEnBuenosAiresSur = new MenuItem("Buenos Aires Sur");
		MenuItem hotelEnBuenosAiresNorte = new MenuItem("Buenos Aires Norte");
		MenuItem hotelEnCordobaSur = new MenuItem("Cordoba Sur");
		MenuItem hotelEnCordobaNorte = new MenuItem("Cordoba Norte");
		MenuItem hotelEnSaltaNorte = new MenuItem("Salta Norte");
		MenuItem hotelEnSaltaSur = new MenuItem("Salta Sur");
		
		MenuItem propiedadBuenosAiresSur = new MenuItem("Buenos Aires Sur");
		MenuItem propiedadBuenosAiresNorte = new MenuItem("Buenos Aires Norte");
		MenuItem propiedadCordobaSur = new MenuItem("Cordoba Sur");
		MenuItem propiedadCordobaNorte = new MenuItem("Cordoba Norte");
		MenuItem propiedadSantaFe = new MenuItem("Santa Fe");
		MenuItem propiedadSaltaNorte = new MenuItem("Salta Norte");
		MenuItem propiedadSaltaSur = new MenuItem("Salta Sur");
		MenuItem propiedadNeuquen = new MenuItem("Neuquen");
		MenuItem propiedadTucuman = new MenuItem("Tucuman");
		MenuItem propiedadEdesur = new MenuItem("Edesur");
		MenuItem propiedadSubte = new MenuItem("Subte");
		MenuItem propiedadAysa = new MenuItem("Aysa");
		MenuItem propiedadTren = new MenuItem("Tren");
		
		ConstruirCasaHandler opcionCasaEnBuenosAiresSurHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoDoble("Buenos Aires Sur"), vistaInformacionJugadores,this);
		ConstruirCasaHandler opcionCasaEnBuenosAiresNorteHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoDoble("Buenos Aires Norte"), vistaInformacionJugadores,this);
		ConstruirCasaHandler opcionCasaEnCordobaSurHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoDoble("Cordoba Sur"), vistaInformacionJugadores,this);
		ConstruirCasaHandler opcionCasaEnCordobaNorteHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoDoble("Cordoba Norte"), vistaInformacionJugadores,this);
		ConstruirCasaHandler opcionCasaEnSantaFeHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoSimple("Santa Fe"), vistaInformacionJugadores, this);
		ConstruirCasaHandler opcionCasaEnSaltaNorteHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoDoble("Salta Norte"), vistaInformacionJugadores,this);
		ConstruirCasaHandler opcionCasaEnSaltaSurHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoDoble("Salta Sur"), vistaInformacionJugadores,this);
		ConstruirCasaHandler opcionCasaEnNeuquenHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoSimple("Neuquen"), vistaInformacionJugadores,this);
		ConstruirCasaHandler opcionCasaEnTucumanHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoSimple("Tucuman"), vistaInformacionJugadores,this);
		
		ConstruirHotelHandler opcionHotelEnBuenosAiresSurHandler = new ConstruirHotelHandler(algopoly, algopoly.getTerrenoDoble("Buenos Aires Sur"), vistaInformacionJugadores,this);
		ConstruirHotelHandler opcionHotelEnBuenosAiresNorteHandler = new ConstruirHotelHandler(algopoly, algopoly.getTerrenoDoble("Buenos Aires Norte"), vistaInformacionJugadores,this);
		ConstruirHotelHandler opcionHotelEnCordobaSurHandler = new ConstruirHotelHandler(algopoly, algopoly.getTerrenoDoble("Cordoba Sur"), vistaInformacionJugadores,this);
		ConstruirHotelHandler opcionHotelEnCordobaNorteHandler = new ConstruirHotelHandler(algopoly, algopoly.getTerrenoDoble("Cordoba Norte"), vistaInformacionJugadores,this);
		ConstruirHotelHandler opcionHotelEnSaltaNorteHandler = new ConstruirHotelHandler(algopoly, algopoly.getTerrenoDoble("Salta Norte"), vistaInformacionJugadores,this);
		ConstruirHotelHandler opcionHotelEnSaltaSurHandler = new ConstruirHotelHandler(algopoly, algopoly.getTerrenoDoble("Salta Sur"), vistaInformacionJugadores,this);

		VenderTerrenoHandler opcionPropiedadBuenosAiresSur = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoDoble("Buenos Aires Sur"), botonera,this);
		VenderTerrenoHandler opcionPropiedadBuenosAiresNorteHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoDoble("Buenos Aires Norte"), botonera, this);
		VenderTerrenoHandler opcionPropiedadCordobaSurHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoDoble("Cordoba Sur"), botonera, this);
		VenderTerrenoHandler opcionPropiedadCordobaNorteHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoDoble("Cordoba Norte"), botonera, this);
		VenderTerrenoHandler opcionPropiedadSantaFeHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoSimple("Santa Fe"), botonera, this);
		VenderTerrenoHandler opcionPropiedadSaltaNorteHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoDoble("Salta Norte"), botonera, this);
		VenderTerrenoHandler opcionPropiedadSaltaSurHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoDoble("Salta Sur"), botonera, this);
		VenderTerrenoHandler opcionPropiedadNeuquenHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoSimple("Neuquen"), botonera, this);
		VenderTerrenoHandler opcionPropiedadTucumanHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoSimple("Tucuman"), botonera, this);
		VenderCompaniaHandler opcionPropiedadEdesurHandler = new VenderCompaniaHandler(algopoly, algopoly.getCompania("Edesur"), botonera,this);
		VenderCompaniaHandler opcionPropiedadSubteHandler = new VenderCompaniaHandler(algopoly, algopoly.getCompania("Subte"), botonera,this);
		VenderCompaniaHandler opcionPropiedadAysaHandler = new VenderCompaniaHandler(algopoly, algopoly.getCompania("Aysa"), botonera,this);
		VenderCompaniaHandler opcionPropiedadTrenHandler = new VenderCompaniaHandler(algopoly, algopoly.getCompania("Tren"), botonera,this);
		
		casaEnBuenosAiresSur.setOnAction(opcionCasaEnBuenosAiresSurHandler);
		casaEnBuenosAiresNorte.setOnAction(opcionCasaEnBuenosAiresNorteHandler);
		casaEnCordobaSur.setOnAction(opcionCasaEnCordobaSurHandler);
		casaEnCordobaNorte.setOnAction(opcionCasaEnCordobaNorteHandler);
		casaEnSantaFe.setOnAction(opcionCasaEnSantaFeHandler);
		casaEnSaltaNorte.setOnAction(opcionCasaEnSaltaNorteHandler);
		casaEnSaltaSur.setOnAction(opcionCasaEnSaltaSurHandler);
		casaEnNeuquen.setOnAction(opcionCasaEnNeuquenHandler);
		casaEnTucuman.setOnAction(opcionCasaEnTucumanHandler);
		
		hotelEnBuenosAiresSur.setOnAction(opcionHotelEnBuenosAiresSurHandler);
		hotelEnBuenosAiresNorte.setOnAction(opcionHotelEnBuenosAiresNorteHandler);
		hotelEnCordobaSur.setOnAction(opcionHotelEnCordobaSurHandler);
		hotelEnCordobaNorte.setOnAction(opcionHotelEnCordobaNorteHandler);
		hotelEnSaltaNorte.setOnAction(opcionHotelEnSaltaNorteHandler);
		hotelEnSaltaSur.setOnAction(opcionHotelEnSaltaSurHandler);
		
		propiedadBuenosAiresSur.setOnAction(opcionPropiedadBuenosAiresSur);
		propiedadBuenosAiresNorte.setOnAction(opcionPropiedadBuenosAiresNorteHandler);
		propiedadCordobaSur.setOnAction(opcionPropiedadCordobaSurHandler);
		propiedadCordobaNorte.setOnAction(opcionPropiedadCordobaNorteHandler);
		propiedadSantaFe.setOnAction(opcionPropiedadSantaFeHandler);
		propiedadSaltaNorte.setOnAction(opcionPropiedadSaltaNorteHandler);
		propiedadSaltaSur.setOnAction(opcionPropiedadSaltaSurHandler);
		propiedadNeuquen.setOnAction(opcionPropiedadNeuquenHandler);
		propiedadTucuman.setOnAction(opcionPropiedadTucumanHandler);
		propiedadEdesur.setOnAction(opcionPropiedadEdesurHandler);
		propiedadSubte.setOnAction(opcionPropiedadSubteHandler);
		propiedadAysa.setOnAction(opcionPropiedadAysaHandler);
		propiedadTren.setOnAction(opcionPropiedadTrenHandler);
		
		menuConstruirCasa.getItems().addAll(
				casaEnBuenosAiresSur,
				casaEnBuenosAiresNorte,
				casaEnCordobaSur,
				casaEnCordobaNorte,
				casaEnSantaFe,
				casaEnSaltaNorte,
				casaEnSaltaSur,
				casaEnNeuquen,
				casaEnTucuman);
		
		menuConstruirHotel.getItems().addAll(
				hotelEnBuenosAiresSur,
				hotelEnBuenosAiresNorte,
				hotelEnCordobaSur,
				hotelEnCordobaNorte,
				hotelEnSaltaNorte,
				hotelEnSaltaSur);
		
		menuVenderPropiedad.getItems().addAll(
				propiedadBuenosAiresSur,
				propiedadBuenosAiresNorte,
				propiedadCordobaSur,
				propiedadCordobaNorte,
				propiedadSantaFe,
				propiedadSaltaNorte,
				propiedadSaltaSur,
				propiedadNeuquen,
				propiedadTucuman,
				propiedadEdesur,
				propiedadSubte,
				propiedadAysa,
				propiedadTren);
		
		this.getMenus().addAll(menuConstruirCasa, menuConstruirHotel, menuVenderPropiedad);
		
		
		
		
	}
	
	public void mostrarAlerta(String titulo, String mensaje) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.setContentText(mensaje);
		alert.initOwner(this.stage);
		alert.showAndWait();
	}

}
