package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillero.compania.Compania;
import modelo.casillero.compania.CompaniaFactory;
import modelo.jugador.Jugador;

public class CompaniaTest {

	// TEST COMPANIA
	
		// Test de compra de las companias
		@Test
		public void testUnJugadorCaeEnEdesurYCompraLaCompaniaYSuCapitalDecrementaEn35000() {
			CompaniaFactory companiaFactory = new CompaniaFactory();
			Jugador j1 = new Jugador("Presidente");
			Compania c1 = companiaFactory.crearEdesur();
			Compania aysa = companiaFactory.crearAysa();
			c1.setCompaniaPareja(aysa);
			aysa.setCompaniaPareja(c1);
			j1.caerEnCasillero(c1);
			int capital = j1.capitalTotal();
			j1.comprarCompania(c1);
			Assert.assertEquals(capital - 35000, j1.capitalTotal());
		}
		
		@Test
		public void testUnJugadorCaeEnSubteYCompraLaCompaniaYSuCapitalDecrementaEn40000() {
			CompaniaFactory companiaFactory = new CompaniaFactory();
			Jugador j1 = new Jugador("Presidente");
			Compania c1 = companiaFactory.crearSubte();
			Compania tren = companiaFactory.crearTren();
			c1.setCompaniaPareja(tren);
			tren.setCompaniaPareja(c1);
			j1.caerEnCasillero(c1);
			int capital = j1.capitalTotal();
			j1.comprarCompania(c1);
			Assert.assertEquals(capital - 40000, j1.capitalTotal());
		}
		
		@Test
		public void testUnJugadorCaeEnAysaYCompraLaCompaniaYSuCapitalDecrementaEn30000() {
			CompaniaFactory companiaFactory = new CompaniaFactory();
			Jugador j1 = new Jugador("Presidente");
			Compania c1 = companiaFactory.crearAysa();
			Compania edesur = companiaFactory.crearEdesur();
			c1.setCompaniaPareja(edesur);
			edesur.setCompaniaPareja(c1);
			j1.caerEnCasillero(c1);
			int capital = j1.capitalTotal();
			j1.comprarCompania(c1);
			Assert.assertEquals(capital - 30000, j1.capitalTotal());
		}
		
		@Test
		public void testUnJugadorCaeEnTrenYCompraLaCompaniaYSuCapitalDecrementaEn38000() {
			CompaniaFactory companiaFactory = new CompaniaFactory();
			Jugador j1 = new Jugador("Presidente");
			Compania c1 = companiaFactory.crearTren();
			Compania subte = companiaFactory.crearSubte();
			c1.setCompaniaPareja(subte);
			subte.setCompaniaPareja(c1);
			j1.caerEnCasillero(c1);
			int capital = j1.capitalTotal();
			j1.comprarCompania(c1);
			Assert.assertEquals(capital - 38000, j1.capitalTotal());
		}
		//---------------------------------------------
		
		
		
		
		
		
		// Teste de las multas cobradas por las companias
		@Test
		public void testUnJugadorNoPropietarioCaeEnEdesurCuyoPropietarioNoTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor500() {
			CompaniaFactory companiaFactory = new CompaniaFactory();
			Jugador j1 = new Jugador("Presidente");
			Jugador j2 = new Jugador("Empleado");
			Compania c1 = companiaFactory.crearEdesur();
			Compania c2 = companiaFactory.crearAysa();
			c1.setCompaniaPareja(c2);
			c2.setCompaniaPareja(c1);
			j1.comprarCompania(c1);
			j2.obtuvo(10);
			int capital = j2.capitalTotal();
			j2.caerEnCasillero(c1);
			Assert.assertEquals(capital - 500*10, j2.capitalTotal());
		}
		
		@Test
		public void testUnJugadorNoPropietarioCaeEnEdesurCuyoPropietarioTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor1000() {
			CompaniaFactory companiaFactory = new CompaniaFactory();
			Jugador j1 = new Jugador("Presidente");
			Jugador j2 = new Jugador("Empleado");
			Compania c1 = companiaFactory.crearEdesur();
			Compania c2 = companiaFactory.crearAysa();
			c1.setCompaniaPareja(c2);
			c2.setCompaniaPareja(c1);
			j1.comprarCompania(c1);
			j1.comprarCompania(c2);
			j2.obtuvo(10);
			int capital = j2.capitalTotal();
			j2.caerEnCasillero(c1);
			Assert.assertEquals(capital - 1000*10, j2.capitalTotal());
		}
		
		@Test
		public void testUnJugadorNoPropietarioCaeEnAysaCuyoPropietarioNoTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor300() {
			CompaniaFactory companiaFactory = new CompaniaFactory();
			Jugador j1 = new Jugador("Presidente");
			Jugador j2 = new Jugador("Empleado");
			Compania c1 = companiaFactory.crearEdesur();
			Compania c2 = companiaFactory.crearAysa();
			c1.setCompaniaPareja(c2);
			c2.setCompaniaPareja(c1);
			j1.comprarCompania(c2);
			j2.obtuvo(10);
			int capital = j2.capitalTotal();
			j2.caerEnCasillero(c2);
			Assert.assertEquals(capital - 300*10, j2.capitalTotal());
		}
		
		@Test
		public void testUnJugadorNoPropietarioCaeEnAysaCuyoPropietarioTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor500() {
			CompaniaFactory companiaFactory = new CompaniaFactory();
			Jugador presidente = new Jugador("Presidente");
			Jugador j2 = new Jugador("Empleado");
			Compania c1 = companiaFactory.crearEdesur();
			Compania c2 = companiaFactory.crearAysa();
			c1.setCompaniaPareja(c2);
			c2.setCompaniaPareja(c1);
			presidente.comprarCompania(c1);
			presidente.comprarCompania(c2);
			Assert.assertEquals(c2.propietario().jugador(), presidente);
			j2.obtuvo(10);
			int capital = j2.capitalTotal();
			j2.caerEnCasillero(c2);
			Assert.assertEquals(capital - 500*10, j2.capitalTotal());
		}
		
		@Test
		public void testUnJugadorNoPropietarioCaeEnTrenCuyoPropietarioNoTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor450() {
			CompaniaFactory companiaFactory = new CompaniaFactory();
			Jugador j1 = new Jugador("Presidente");
			Jugador j2 = new Jugador("Empleado");
			Compania c1 = companiaFactory.crearTren();
			Compania c2 = companiaFactory.crearSubte();
			c1.setCompaniaPareja(c2);
			c2.setCompaniaPareja(c1);
			j1.comprarCompania(c1);
			j2.obtuvo(10);
			int capital = j2.capitalTotal();
			j2.caerEnCasillero(c1);
			Assert.assertEquals(capital - 450*10, j2.capitalTotal());
		}
		
		@Test
		public void testUnJugadorNoPropietarioCaeEnTrenCuyoPropietarioTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor800() {
			CompaniaFactory companiaFactory = new CompaniaFactory();
			Jugador j1 = new Jugador("Presidente");
			Jugador j2 = new Jugador("Empleado");
			Compania c1 = companiaFactory.crearTren();
			Compania c2 = companiaFactory.crearSubte();
			c1.setCompaniaPareja(c2);
			c2.setCompaniaPareja(c1);
			j1.comprarCompania(c1);
			j1.comprarCompania(c2);
			j2.obtuvo(10);
			int capital = j2.capitalTotal();
			j2.caerEnCasillero(c1);
			Assert.assertEquals(capital - 800*10, j2.capitalTotal());
		}
		
		@Test
		public void testUnJugadorNoPropietarioCaeEnSubteCuyoPropietarioNoTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor600() {
			CompaniaFactory companiaFactory = new CompaniaFactory();
			Jugador j1 = new Jugador("Presidente");
			Jugador j2 = new Jugador("Empleado");
			Compania c1 = companiaFactory.crearTren();
			Compania c2 = companiaFactory.crearSubte();
			c1.setCompaniaPareja(c2);
			c2.setCompaniaPareja(c1);
			j1.comprarCompania(c2);
			j2.obtuvo(10);
			int capital = j2.capitalTotal();
			j2.caerEnCasillero(c2);
			Assert.assertEquals(capital - 600*10, j2.capitalTotal());
		}
		
		@Test
		public void testUnJugadorNoPropietarioCaeEnSubteCuyoPropietarioTieneLaCompaniaParejaEntoncesSuCapitalDecrementaEnLoQueObtuvoPor1100() {
			CompaniaFactory companiaFactory = new CompaniaFactory();
			Jugador j1 = new Jugador("Presidente");
			Jugador j2 = new Jugador("Empleado");
			Compania c1 = companiaFactory.crearTren();
			Compania c2 = companiaFactory.crearSubte();
			c1.setCompaniaPareja(c2);
			c2.setCompaniaPareja(c1);
			j1.comprarCompania(c1);
			j1.comprarCompania(c2);
			j2.obtuvo(10);
			int capital = j2.capitalTotal();
			j2.caerEnCasillero(c2);
			Assert.assertEquals(capital - 1100*10, j2.capitalTotal());
		}
		
		
		@Test
		public void testUnJugador1IntercambiaUnaCompania1SuyaPorUnaCompania2DeOtroJugador2EntoncesElPropietarioDeLaCompania2AhoraEsJugador1() {
			CompaniaFactory companiaFactory = new CompaniaFactory();
			Jugador j1 = new Jugador("Propietario 1");
			Jugador j2 = new Jugador("Propietario 2");
			Compania c1 = companiaFactory.crearSubte();
			Compania c2 = companiaFactory.crearAysa();
			j1.comprarCompania(c1);
			j2.comprarCompania(c2);
			j1.intercambiarCompaniaConPor(c1,j2,c2);
			Assert.assertEquals(j1, c2.propietario().jugador());
		}
		
		@Test
		public void testUnJugador1IntercambiaUnaCompania1SuyaPorUnaCompania2DeOtroJugador2EntoncesSiUnJugadorCaeEnLaCompania1ElPagoDeLaMultaSeAcreditaEnJugador2() {
			CompaniaFactory companiaFactory = new CompaniaFactory();
			Jugador j1 = new Jugador("Propietario 1");
			Jugador j2 = new Jugador("Propietario 2");
			Jugador j3 = new Jugador("Paga la multa");
			Compania c1 = companiaFactory.crearSubte();
			Compania c2 = companiaFactory.crearAysa();
			Compania c3 = companiaFactory.crearTren();
			c1.setCompaniaPareja(c3);
			c3.setCompaniaPareja(c1);
			j1.comprarCompania(c1);
			j2.comprarCompania(c2);
			j1.intercambiarCompaniaConPor(c1,j2,c2);
			int capitalInicial = j2.capitalTotal();
			j3.obtuvo(10);
			j3.caerEnCasillero(c1);
			Assert.assertEquals(capitalInicial + 600*10, j2.capitalTotal());
		}
		
}
