package modelo;

import java.util.ArrayList;

import modelo.casillero.Casillero;
import modelo.casillero.compania.Aysa;
import modelo.casillero.compania.Edesur;
import modelo.casillero.compania.Subte;
import modelo.casillero.compania.Tren;
import modelo.casillero.especial.AvanceDinamico;
import modelo.casillero.especial.Carcel;
import modelo.casillero.especial.ImpuestoDeLujo;
import modelo.casillero.especial.Policia;
import modelo.casillero.especial.Quini6;
import modelo.casillero.especial.RetrocesoDinamico;
import modelo.casillero.terrenos.BuenosAiresNorte;
import modelo.casillero.terrenos.BuenosAiresSur;
import modelo.casillero.terrenos.CordobaNorte;
import modelo.casillero.terrenos.CordobaSur;
import modelo.casillero.terrenos.Neuquen;
import modelo.casillero.terrenos.SaltaNorte;
import modelo.casillero.terrenos.SaltaSur;
import modelo.casillero.terrenos.SantaFe;
import modelo.casillero.terrenos.Tucuman;

public class ArmadorDeTablero {
	
	public ArrayList<Casillero> casilleros;
	
	public void armarTablero(Tablero tablero) {
		tablero.agregarCasillero(new Salida());
		tablero.agregarCasillero(new Quini6()); 
		tablero.agregarCasillero(new BuenosAiresSur());
		tablero.agregarCasillero(new Edesur());
		tablero.agregarCasillero(new BuenosAiresNorte());
		Carcel carcel = new Carcel();
		tablero.agregarCasillero(carcel);
		tablero.agregarCasillero(new CordobaSur());
		tablero.agregarCasillero(new AvanceDinamico());
		tablero.agregarCasillero(new Subte());
		tablero.agregarCasillero(new CordobaNorte());
		tablero.agregarCasillero(new ImpuestoDeLujo());
		tablero.agregarCasillero(new SantaFe());
		tablero.agregarCasillero(new Aysa());
		tablero.agregarCasillero(new SaltaNorte());
		tablero.agregarCasillero(new SaltaSur());
		tablero.agregarCasillero(new Policia(carcel));
		tablero.agregarCasillero(new Tren());
		tablero.agregarCasillero(new Neuquen());
		tablero.agregarCasillero(new RetrocesoDinamico());
		tablero.agregarCasillero(new Tucuman());
	}

}
