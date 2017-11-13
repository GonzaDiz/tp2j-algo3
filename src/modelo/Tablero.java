package modelo;

import java.util.ArrayList;

import modelo.casillero.Casillero;
import modelo.casillero.compania.Aysa;
import modelo.casillero.compania.Subte;
import modelo.casillero.compania.Tren;
import modelo.casillero.especial.AvanceDinamico;
import modelo.casillero.especial.Carcel;
import modelo.casillero.especial.ImpuestoDeLujo;
import modelo.casillero.especial.Policia;
import modelo.casillero.especial.Quini6;
import modelo.casillero.especial.RetrocesoDinamico;
import modelo.casillero.terrenos.BuenosAiresSur;
import modelo.casillero.terrenos.CordobaNorte;
import modelo.casillero.terrenos.Neuquen;
import modelo.casillero.terrenos.SaltaNorte;
import modelo.casillero.terrenos.SaltaSur;
import modelo.casillero.terrenos.SantaFe;
import modelo.casillero.terrenos.Tucuman;

public class Tablero {
	
	private static Tablero TABLERO = null;
	private ArrayList<Casillero> casilleros;

	private Tablero() {
		this.casilleros = new ArrayList<>();
		casilleros.add(Salida.getSalida());
	    casilleros.add(Quini6.getQuini6());
		casilleros.add(BuenosAiresSur.getBuenosAiresSur());
		casilleros.add(Edesur.getEdesur());
		casilleros.add(BuenosAiresNorte.getBuenosAiresNorte());
		casilleros.add(Carcel.getCarcel());
		casilleros.add(CordobaSur.getCordobaSur());
		casilleros.add(AvanceDinamico.getAvanceDinamico());
		casilleros.add(Subte.getSubte());
		casilleros.add(CordobaNorte.getCordobaNorte());
		casilleros.add(ImpuestoDeLujo.getImpuestoDeLujo());
		casilleros.add(SantaFe.getSantaFe());
		casilleros.add(Aysa.getAysa());
		casilleros.add(SaltaNorte.getSaltaNorte());
		casilleros.add(SaltaSur.getSaltaSur());
		casilleros.add(Policia.getPolicia());
		casilleros.add(Tren.getTren());
		casilleros.add(Neuquen.getNeuquen());
		casilleros.add(RetrocesoDinamico.getRetrocesoDinamico());
		casilleros.add(Tucuman.getTucuman());
	}
	
	private synchronized static void crearTablero() {
		if (TABLERO == null) {
			TABLERO = new Tablero();
		}	
	}
	
	public static Tablero getTablero() {
		if (TABLERO == null) crearTablero();
		return TABLERO;
	}

	// Una posible mejora para evitar estos ifs es implementar una estructura de datos Lista Circular
	public Casillero getCasillero(Casillero casilleroActual, int unValorDeDados) {
		int posicionActual = casilleros.indexOf(casilleroActual);
		
		if(posicionActual + unValorDeDados > casilleros.size()){
			return casilleros.get(unValorDeDados - (casilleros.size() - posicionActual));
		}
		return casilleros.get(posicionActual + unValorDeDados);
	}

}
