package modelo;

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
import modelo.casillero.especial.Salida;
import modelo.casillero.terrenos.Terreno;
import modelo.casillero.terrenos.TerrenoDoble;
import modelo.casillero.terrenos.TerrenosFactory;

public class ArmadorDeTablero {
	
	public void armarTablero(Tablero tablero) {
		
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		
		// Creamos casilleros
		Salida salida = new Salida();
		Quini6 quni6 = new Quini6();
		TerrenoDoble baS = terrenosFactory.crearBuenosAiresSur();
		Edesur edesur = new Edesur();
		TerrenoDoble baN = terrenosFactory.crearBuenosAiresNorte();
		Carcel carcel = new Carcel();
		TerrenoDoble cordobaSur = terrenosFactory.crearCordobaSur();
		AvanceDinamico avanceDinamico = new AvanceDinamico();
		Subte subte = new Subte();
		TerrenoDoble cordobaNorte = terrenosFactory.crearCordobaNorte();
		ImpuestoDeLujo impuestoDeLujo = new ImpuestoDeLujo();
		Terreno santaFe = terrenosFactory.crearSantaFe();
		Aysa aysa = new Aysa();
		TerrenoDoble saltaNorte = terrenosFactory.crearSaltaNorte();
		TerrenoDoble saltaSur = terrenosFactory.crearSaltaSur();
		Policia policia = new Policia(carcel);
		Tren tren = new Tren();
		Terreno neuquen = terrenosFactory.crearNeuquen();
		RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();
		//Tucuman tucuman = new Tucuman();
		Terreno tucuman = terrenosFactory.crearTucuman();
		
		
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
