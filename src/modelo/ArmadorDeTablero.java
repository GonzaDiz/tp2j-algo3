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
		
		// Creamos casilleros
		Salida salida = new Salida();
		Quini6 quni6 = new Quini6();
		BuenosAiresSur baS = new BuenosAiresSur();
		Edesur edesur = new Edesur();
		BuenosAiresNorte baN = new BuenosAiresNorte();
		Carcel carcel = new Carcel();
		CordobaSur cordobaSur = new CordobaSur();
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Subte subte = new Subte();
		CordobaNorte cordobaNorte = new CordobaNorte();
		ImpuestoDeLujo impuestoDeLujo = new ImpuestoDeLujo();
		SantaFe santaFe = new SantaFe();
		Aysa aysa = new Aysa();
		SaltaNorte saltaNorte = new SaltaNorte();
		SaltaSur saltaSur = new SaltaSur();
		Policia policia = new Policia(carcel);
		Tren tren = new Tren();
		Neuquen neuquen = new Neuquen();
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		Tucuman tucuman = new Tucuman();
		
		// Agregamos las parejas
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		cordobaSur.setTerrenoPareja(cordobaNorte);
		cordobaNorte.setTerrenoPareja(cordobaSur);
		saltaNorte.setTerrenoPareja(saltaSur);
		saltaSur.setTerrenoPareja(saltaSur);
		aysa.setCompaniaPareja(edesur);
		edesur.setCompaniaPareja(aysa);
		subte.setCompaniaPareja(tren);
		tren.setCompaniaPareja(tren);
	
		// Agregamos las casilleros al tablero
 		tablero.agregarCasillero(salida);
		tablero.agregarCasillero(quni6); 
		tablero.agregarCasillero(baS);
		tablero.agregarCasillero(edesur);
		tablero.agregarCasillero(baN);
		tablero.agregarCasillero(carcel);
		tablero.agregarCasillero(cordobaSur);
		tablero.agregarCasillero(avanceDinamico);
		tablero.agregarCasillero(subte);
		tablero.agregarCasillero(cordobaNorte);
		tablero.agregarCasillero(impuestoDeLujo);
		tablero.agregarCasillero(santaFe);
		tablero.agregarCasillero(aysa);
		tablero.agregarCasillero(saltaNorte);
		tablero.agregarCasillero(saltaSur);
		tablero.agregarCasillero(policia);
		tablero.agregarCasillero(tren);
		tablero.agregarCasillero(neuquen);
		tablero.agregarCasillero(retrocesoDinamico);
		tablero.agregarCasillero(tucuman);
	}

}
