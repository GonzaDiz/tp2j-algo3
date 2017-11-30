package vista;

import controlador.ConstruirCasaHandler;
import controlador.ConstruirHotelHandler;
import controlador.VenderCompaniaHandler;
import controlador.VenderTerrenoHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import modelo.Algopoly;

public class BarraDeMenu extends MenuBar{
	
	public BarraDeMenu(Algopoly algopoly, VistaInformacionJugadores vistaInformacionJugadores, Botonera botonera) {
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
		
		ConstruirCasaHandler opcionCasaEnBuenosAiresSurHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoDoble("Buenos Aires Sur"), vistaInformacionJugadores);
		ConstruirCasaHandler opcionCasaEnBuenosAiresNorteHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoDoble("Buenos Aires Norte"), vistaInformacionJugadores);
		ConstruirCasaHandler opcionCasaEnCordobaSurHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoDoble("Cordoba Sur"), vistaInformacionJugadores);
		ConstruirCasaHandler opcionCasaEnCordobaNorteHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoDoble("Cordoba Norte"), vistaInformacionJugadores);
		ConstruirCasaHandler opcionCasaEnSantaFeHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoSimple("Santa Fe"), vistaInformacionJugadores);
		ConstruirCasaHandler opcionCasaEnSaltaNorteHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoDoble("Salta Norte"), vistaInformacionJugadores);
		ConstruirCasaHandler opcionCasaEnSaltaSurHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoDoble("Salta Sur"), vistaInformacionJugadores);
		ConstruirCasaHandler opcionCasaEnNeuquenHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoSimple("Neuquen"), vistaInformacionJugadores);
		ConstruirCasaHandler opcionCasaEnTucumanHandler = new ConstruirCasaHandler(algopoly, algopoly.getTerrenoSimple("Tucuman"), vistaInformacionJugadores);
		
		ConstruirHotelHandler opcionHotelEnBuenosAiresSurHandler = new ConstruirHotelHandler(algopoly, algopoly.getTerrenoDoble("Buenos Aires Sur"), vistaInformacionJugadores);
		ConstruirHotelHandler opcionHotelEnBuenosAiresNorteHandler = new ConstruirHotelHandler(algopoly, algopoly.getTerrenoDoble("Buenos Aires Norte"), vistaInformacionJugadores);
		ConstruirHotelHandler opcionHotelEnCordobaSurHandler = new ConstruirHotelHandler(algopoly, algopoly.getTerrenoDoble("Cordoba Sur"), vistaInformacionJugadores);
		ConstruirHotelHandler opcionHotelEnCordobaNorteHandler = new ConstruirHotelHandler(algopoly, algopoly.getTerrenoDoble("Cordoba Norte"), vistaInformacionJugadores);
		ConstruirHotelHandler opcionHotelEnSaltaNorteHandler = new ConstruirHotelHandler(algopoly, algopoly.getTerrenoDoble("Salta Norte"), vistaInformacionJugadores);
		ConstruirHotelHandler opcionHotelEnSaltaSurHandler = new ConstruirHotelHandler(algopoly, algopoly.getTerrenoDoble("Salta Sur"), vistaInformacionJugadores);

		VenderTerrenoHandler opcionPropiedadBuenosAiresSur = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoDoble("Buenos Aires Sur"), botonera);
		VenderTerrenoHandler opcionPropiedadBuenosAiresNorteHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoDoble("Buenos Aires Norte"), botonera);
		VenderTerrenoHandler opcionPropiedadCordobaSurHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoDoble("Cordoba Sur"), botonera);
		VenderTerrenoHandler opcionPropiedadCordobaNorteHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoDoble("Cordoba Norte"), botonera);
		VenderTerrenoHandler opcionPropiedadSantaFeHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoSimple("Santa Fe"), botonera);
		VenderTerrenoHandler opcionPropiedadSaltaNorteHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoDoble("Salta Norte"), botonera);
		VenderTerrenoHandler opcionPropiedadSaltaSurHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoDoble("Salta Sur"), botonera);
		VenderTerrenoHandler opcionPropiedadNeuquenHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoSimple("Neuquen"), botonera);
		VenderTerrenoHandler opcionPropiedadTucumanHandler = new VenderTerrenoHandler(algopoly, algopoly.getTerrenoSimple("Tucuman"), botonera);
		VenderCompaniaHandler opcionPropiedadEdesurHandler = new VenderCompaniaHandler(algopoly, algopoly.getCompania("Edesur"), botonera);
		VenderCompaniaHandler opcionPropiedadSubteHandler = new VenderCompaniaHandler(algopoly, algopoly.getCompania("Subte"), botonera);
		VenderCompaniaHandler opcionPropiedadAysaHandler = new VenderCompaniaHandler(algopoly, algopoly.getCompania("Aysa"), botonera);
		VenderCompaniaHandler opcionPropiedadTrenHandler = new VenderCompaniaHandler(algopoly, algopoly.getCompania("Tren"), botonera);
		
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

}
