package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.Edesur;
import modelo.Salida;
import modelo.Tablero;
import modelo.casillero.Casillero;
import modelo.casillero.compania.Aysa;
import modelo.casillero.compania.Subte;
import modelo.casillero.compania.Tren;
import modelo.casillero.especial.Quini6;
import modelo.casillero.especial.RetrocesoDinamico;
import modelo.casillero.terrenos.BuenosAiresNorte;
import modelo.casillero.terrenos.CordobaSur;
import modelo.casillero.terrenos.SaltaNorte;
import modelo.casillero.terrenos.Tucuman;

public class TableroTest {
	
	@Test
	public void testCrearTableroNoDevuelveNull() {
		Tablero tablero = Tablero.getTablero();
		Assert.assertNotNull(tablero);
	}
	
	@Test
	public void getCasilleroAPartirDeSalidaYConUnValorDeDados1DevuelveQuini6() {
		Tablero tablero = Tablero.getTablero();
		Casillero casilleroActual = Salida.getSalida();
		Casillero nuevoCasilleroActual = Quini6.getQuini6();
		int unValorDeDados = 1;
		Assert.assertEquals(nuevoCasilleroActual, tablero.getCasillero(casilleroActual, unValorDeDados));
	}
	
	@Test
	public void getCasilleroApartirDeQuini6YConUnValorDeDados5DevuelveCordobaSur() {
		Tablero tablero = Tablero.getTablero();
		Casillero casilleroActual = Quini6.getQuini6();
		Casillero nuevoCasilleroActual = CordobaSur.getCordobaSur();
		int unValorDeDados = 5;
		Assert.assertEquals(nuevoCasilleroActual, tablero.getCasillero(casilleroActual, unValorDeDados));
	}
	
	@Test
	public void getCasilleroActualAPartirDeAysaYConUnValorDeDados12DevuelveBuenosAiresZonaNorte() {
		Tablero tablero = Tablero.getTablero();
		Casillero casilleroActual = Aysa.getAysa();
		Casillero nuevoCasilleroActual = BuenosAiresNorte.getBuenosAiresNorte();
		int unValorDeDados = 12;
		Assert.assertEquals(nuevoCasilleroActual, tablero.getCasillero(casilleroActual, unValorDeDados));
	}
	
	@Test
	public void getCasilleroAPartirDeTrenYConUnValorDeDados7DevuelveEdesur() {
		Tablero tablero = Tablero.getTablero();
		Casillero casilleroActual = Tren.getTren();
		Casillero nuevoCasilleroActual = Edesur.getEdesur();
		int unValorDeDados = 7;
		Assert.assertEquals(nuevoCasilleroActual, tablero.getCasillero(casilleroActual, unValorDeDados));
	}
	
	@Test
	public void getCasilleroActualAPartirDeTucumanYConUnValorDeDados9DevuelveSubte() {
		Tablero tablero = Tablero.getTablero();
		Casillero casilleroActual = Tucuman.getTucuman();
		Casillero nuevoCasilleroActual = Subte.getSubte();
		int unValorDeDados = 9;
		Assert.assertEquals(nuevoCasilleroActual, tablero.getCasillero(casilleroActual, unValorDeDados));
	}
	
	@Test
	public void getCasilleroAPartirDeRetrocesoDinamicoRetrocediendo5DevuelveSaltaNorte() {
		Tablero tablero = Tablero.getTablero();
		Casillero casilleroActual = RetrocesoDinamico.getRetrocesoDinamico();
		Casillero nuevoCasilleroActual = SaltaNorte.getSaltaNorte();
		Assert.assertEquals(nuevoCasilleroActual, tablero.getCasillero(casilleroActual, -5));
	}
	
	@Test
	public void getCasilleroApartirDeRetrocesoDinamicoRetrocediendo10DevuelveSubte() {
		Tablero tablero = Tablero.getTablero();
		Casillero casilleroActual = RetrocesoDinamico.getRetrocesoDinamico();
		Casillero nuevoCasilleroActual = Subte.getSubte();
		Assert.assertEquals(nuevoCasilleroActual, tablero.getCasillero(casilleroActual, -10));
	}
}
