package testUnitarios;

import org.junit.Assert;
import org.junit.Test;

import modelo.casillero.terrenos.Terreno;
import modelo.casillero.terrenos.TerrenoDoble;
import modelo.casillero.terrenos.TerrenosFactory;
import modelo.excepciones.LimiteDeEdificacionesExcedidoError;
import modelo.excepciones.NoPuedeConstruirCasasEnUnTerrenoConHotelesError;
import modelo.excepciones.NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesEnElTerrenoParejaError;
import modelo.excepciones.NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesError;
import modelo.excepciones.SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError;
import modelo.excepciones.SoloElPropietarioPuedeEdificarEnElTerrenoError;
import modelo.jugador.Jugador;

public class TerrenoTest {
	// Test de pago de alquileres con una casa
	@Test
	public void testUnJugadorCaeEnBuenosAiresNorteQueTieneUnaCasaYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe3500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble baS = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble baN = terrenosFactory.crearBuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j1.comprarTerreno(baS); // -25000
		j1.comprarTerreno(baN); // -20000
		j1.construirCasaEn(baN); // -5500
		j2.caerEnCasillero(baN);
		Assert.assertEquals(96500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnCordobaSurQueTieneUnaCasaYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe1500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble c1 = terrenosFactory.crearCordobaSur();
		TerrenoDoble  c2 = terrenosFactory.crearCordobaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j2.caerEnCasillero(c1);
		Assert.assertEquals(98500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnCordobaNoQueTieneDosCasasYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe2500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble c1 = terrenosFactory.crearCordobaSur();
		TerrenoDoble  c2 = terrenosFactory.crearCordobaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j2.caerEnCasillero(c1);
		Assert.assertEquals(97500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnCordobaNorteQueTieneUnaCasaYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe1800() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble c1 = terrenosFactory.crearCordobaSur();
		TerrenoDoble  c2 = terrenosFactory.crearCordobaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c2);
		j2.caerEnCasillero(c2);
		Assert.assertEquals(98200, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnCordobaNorteQueTieneUnaCasaYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe2900() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble c1 = terrenosFactory.crearCordobaSur();
		TerrenoDoble  c2 = terrenosFactory.crearCordobaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j2.caerEnCasillero(c2);
		Assert.assertEquals(97100, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnTerrenoDobleQueTieneUnaCasaYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe3250() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble c1 = terrenosFactory.crearSaltaSur(); 
		TerrenoDoble c2 = terrenosFactory.crearSaltaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j2.caerEnCasillero(c1);
		Assert.assertEquals(96750, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnTerrenoDobleQueTieneDosCasasYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe3850() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble c1 = terrenosFactory.crearSaltaSur(); 
		TerrenoDoble c2 = terrenosFactory.crearSaltaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j2.caerEnCasillero(c1);
		Assert.assertEquals(96150, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSaltaNorteQueTieneUnaCasaYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe3250() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble c1 = terrenosFactory.crearSaltaSur(); 
		TerrenoDoble c2 = terrenosFactory.crearSaltaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c2);
		j2.caerEnCasillero(c2);
		Assert.assertEquals(96750, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSaltaNorteQueTieneDosCasasYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe3850() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble c1 = terrenosFactory.crearSaltaSur(); 
		TerrenoDoble c2 = terrenosFactory.crearSaltaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j2.caerEnCasillero(c2);
		Assert.assertEquals(96150, j2.capitalTotal());
	}
	//-------------------------------
	
	
	
	
	
	
	
	// Test de restricciones de construccion de hoteles
	@Test
	public void testUnJugadorConstruyeUnHotelEnBuenosAiresSurSinTenerLaCapacidadMaximaDeCasasEntoncesSuCapitalNoSeDecrementa() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Martin");
		TerrenoDoble baS = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble baN = terrenosFactory.crearBuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j1.comprarTerreno(baS);
		j1.comprarTerreno(baN);
		j1.construirCasaEn(baN);
		j1.construirCasaEn(baN);
		int capital = j1.capitalTotal();
		try{
			j1.construirHotelEn(baS);
		}
		
		catch(NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesError e) {
			Assert.assertEquals(capital, j1.capitalTotal());
		}
	}
	
	@Test
	public void testUnJugadorConstruyeUnHotelEnBuenosAiresSurSinTenerLaCapacidadMaximaDeCasasEnSuTerrenoParejaEntoncesSuCapitalNoSeDecrementa() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Gerardo");
		TerrenoDoble c1 = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble c2 = terrenosFactory.crearBuenosAiresNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		int capital = j1.capitalTotal();
		try{
			j1.construirHotelEn(c1);
		}
		
		catch(NoSePuedeConstruirUnHotelEnUnTerrenoSinConstruirPrimeroTodasLasCasasPosiblesEnElTerrenoParejaError e) {
			Assert.assertEquals(capital, j1.capitalTotal());
		}
	}
	//----------------------------
	
	
	
	
	
	// Test de construcciones de hoteles
	@Test
	public void testUnJugadorConstruyeUnHotelEnBuenosAiresSurTeniendoLaCapacidadMaximaDeCasasEnAmbosTerrenosEntoncesSuCapitalSeDecrementaEn8000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Rochi");
		TerrenoDoble c1 = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble c2 = terrenosFactory.crearBuenosAiresNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		int capital = j1.capitalTotal();
		j1.construirHotelEn(c1);
		Assert.assertEquals(capital-8000, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorConstruyeUnHotelEnBuenosAiresNorteTeniendoLaCapacidadMaximaDeCasasEnAmbosTerrenosEntoncesSuCapitalSeDecrementaEn9000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("El Uro");
		TerrenoDoble c1 = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble c2 = terrenosFactory.crearBuenosAiresNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		int capital = j1.capitalTotal();
		j1.construirHotelEn(c2);
		Assert.assertEquals(capital-9000, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorConstruyeUnHotelEnCordobaSurTeniendoLaCapacidadMaximaDeCasasEnAmbosTerrenosEntoncesSuCapitalSeDecrementaEn3000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Bianca");
		TerrenoDoble c1 = terrenosFactory.crearCordobaSur();
		TerrenoDoble  c2 = terrenosFactory.crearCordobaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		int capital = j1.capitalTotal();
		j1.construirHotelEn(c1);
		Assert.assertEquals(capital-3000, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorConstruyeUnHotelEnCordobaNorteTeniendoLaCapacidadMaximaDeCasasEnAmbosTerrenosEntoncesSuCapitalSeDecrementaEn3500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Bianca");
		TerrenoDoble c1 = terrenosFactory.crearCordobaSur();
		TerrenoDoble  c2 = terrenosFactory.crearCordobaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		int capital = j1.capitalTotal();
		j1.construirHotelEn(c2);
		Assert.assertEquals(capital-3500, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorConstruyeUnHotelEnTerrenoDobleTeniendoLaCapacidadMaximaDeCasasEnAmbosTerrenosEntoncesSuCapitalSeDecrementaEn7500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Mica");
		TerrenoDoble c1 = terrenosFactory.crearSaltaSur(); 
		TerrenoDoble c2 = terrenosFactory.crearSaltaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		int capital = j1.capitalTotal();
		j1.construirHotelEn(c1);
		Assert.assertEquals(capital-7500, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorConstruyeUnHotelEnSaltaNorteTeniendoLaCapacidadMaximaDeCasasEnAmbosTerrenosEntoncesSuCapitalSeDecrementaEn7500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Lila Peralta");
		TerrenoDoble c1 = terrenosFactory.crearSaltaSur(); 
		TerrenoDoble c2 = terrenosFactory.crearSaltaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		int capital = j1.capitalTotal();
		j1.construirHotelEn(c2);
		Assert.assertEquals(capital-7500, j1.capitalTotal());
	}
	//-----------------------------------
	
	
	
	
	
	
	// Test de pago de alquileres en terrenos con hoteles
	@Test
	public void testUnJugadorNoPropietarioCaeEnBuenosAiresSurQueTieneUnHotelEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn5000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble c1 = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble c2 = terrenosFactory.crearBuenosAiresNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j1.construirHotelEn(c1);
		j2.caerEnCasillero(c1);
		Assert.assertEquals(95000, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnBuenosAiresNorteQueTieneUnHotelEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn6000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble c1 = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble c2 = terrenosFactory.crearBuenosAiresNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j1.construirHotelEn(c2);
		j2.caerEnCasillero(c2);
		Assert.assertEquals(94000, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnCordobaSurQueTieneUnHotelEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn3000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble c1 = terrenosFactory.crearCordobaSur();
		TerrenoDoble  c2 = terrenosFactory.crearCordobaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j1.construirHotelEn(c1);
		j2.caerEnCasillero(c1);
		Assert.assertEquals(97000, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnCordobaNorteQueTieneUnHotelEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn3500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble c1 = terrenosFactory.crearCordobaSur();
		TerrenoDoble  c2 = terrenosFactory.crearCordobaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j1.construirHotelEn(c2);
		j2.caerEnCasillero(c2);
		Assert.assertEquals(96500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnTerrenoDobleQueTieneUnHotelEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn5500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble c1 = terrenosFactory.crearSaltaSur(); 
		TerrenoDoble c2 = terrenosFactory.crearSaltaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j1.construirHotelEn(c1);
		j2.caerEnCasillero(c1);
		Assert.assertEquals(94500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnSaltaNorteQueTieneUnHotelEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn5500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble c1 = terrenosFactory.crearSaltaSur(); 
		TerrenoDoble c2 = terrenosFactory.crearSaltaNorte(); 
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j1.construirHotelEn(c2);
		j2.caerEnCasillero(c2);
		Assert.assertEquals(94500, j2.capitalTotal());
	}
	//------------------------------
	
	// TEST TERRENOS SIMPLES
	// Test de construcciones de casas en terrenos simples
	@Test
	public void testUnJugadorCuentaConSantaFeYConstruyeUnaCasaEntoncesSuCapitalDecrementaEn4000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Me canse de pensar nombres");
		Terreno c1 = terrenosFactory.crearSantaFe();
		j1.comprarTerreno(c1);
		int capital = j1.capitalTotal();
		j1.construirCasaEn(c1);
		Assert.assertEquals(capital - 4000, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCuentaConNeuquenYConstruyeUnaCasaEntoncesSuCapitalDecrementaEn4800() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Me canse de pensar nombres");
		Terreno c1 = terrenosFactory.crearNeuquen();
		j1.comprarTerreno(c1);
		int capital = j1.capitalTotal();
		j1.construirCasaEn(c1);
		Assert.assertEquals(capital - 4800, j1.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCuentaConTucumanYConstruyeUnaCasaEntoncesSuCapitalDecrementaEn7000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Me canse de pensar nombres");
		Terreno c1 = terrenosFactory.crearTucuman();
		j1.comprarTerreno(c1);
		int capital = j1.capitalTotal();
		j1.construirCasaEn(c1);
		Assert.assertEquals(capital - 7000, j1.capitalTotal());
	}
	//----------------------------------
	
	@Test
	public void testUnJugadorCaeEnBuenosAiresSurCompraElTerrenoYSuCapitalSeDecrementaEn20000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Guillermo");
		TerrenoDoble bsasSur = terrenosFactory.crearBuenosAiresSur();
		j.caerEnCasillero(bsasSur);
		j.comprarTerreno(bsasSur);
		Assert.assertEquals(80000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnBuenosAiresNorteCompraElTerrenoYSuCapitalSeDecrementaEn25000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Nico");
		TerrenoDoble baN = terrenosFactory.crearBuenosAiresNorte();
		j.caerEnCasillero(baN);
		j.comprarTerreno(baN);
		Assert.assertEquals(75000, j.capitalTotal());
	}

	@Test
	public void testUnJugadorCaeEnCordobaSurCompraElTerrenoYSuCapitalSeDecrementaEn18000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Katheryn");
		TerrenoDoble cs = terrenosFactory.crearCordobaSur();
		j.caerEnCasillero(cs);
		j.comprarTerreno(cs);
		Assert.assertEquals(82000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnCordobaNorteCompraElTerrenoYSuCapitalSeDecrementaEn20000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Jonathan");
		TerrenoDoble  cn = terrenosFactory.crearCordobaNorte(); 
		j.caerEnCasillero(cn);
		j.comprarTerreno(cn);
		Assert.assertEquals(80000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSantaFeCompraElTerrenoYSuCapitalSeDecrementaEn15000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Esteban");
		Terreno sf = terrenosFactory.crearSantaFe();
		j.caerEnCasillero(sf);
		j.comprarTerreno(sf);
		Assert.assertEquals(85000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnSaltaNorteCompraElTerrenoYSuCapitalSeDecrementaEn23000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Luciano");
		TerrenoDoble sn = terrenosFactory.crearSaltaNorte(); 
		j.caerEnCasillero(sn);
		j.comprarTerreno(sn);
		Assert.assertEquals(77000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnTerrenoDobleCompraElTerrenoYSuCapitalSeDecrementaEn23000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Diego");
		TerrenoDoble ss = terrenosFactory.crearSaltaSur(); 
		j.caerEnCasillero(ss);
		j.comprarTerreno(ss);
		Assert.assertEquals(77000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnNeuquenCompraElTerrenoYSuCapitalSeDecrementaEn17000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Manfred");
		Terreno n = terrenosFactory.crearNeuquen();
		j.caerEnCasillero(n);
		j.comprarTerreno(n);
		Assert.assertEquals(83000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnTucumanCompraElTerrenoYSuCapitalSeDecrementaEn25000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Sid");
		Terreno t = terrenosFactory.crearTucuman();
		j.caerEnCasillero(t);
		j.comprarTerreno(t);
		Assert.assertEquals(75000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCuentaConBsAsSurYBsAsNorteYConstruyeUnaCasaEnBsAsSurEntoncesSuDineroDecrementaEn5000() {
		Jugador j = new Jugador("Shrek");
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		TerrenoDoble baS = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble baN = terrenosFactory.crearBuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j.comprarTerreno(baS); // -25000
		j.comprarTerreno(baN); // -20000
		j.construirCasaEn(baS); // -5000
		Assert.assertEquals(50000, j.capitalTotal());
	}
	
	@Test  (expected = LimiteDeEdificacionesExcedidoError.class)
	public void testUnJugadorNoPuedeConstruirMasDeDosCasasEnUnTerrenoDoble() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Shrek");
		TerrenoDoble baS = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble baN = terrenosFactory.crearBuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j.comprarTerreno(baS); // -25000
		j.comprarTerreno(baN); // -20000
		j.construirCasaEn(baS); // -5000
		j.construirCasaEn(baS); // -5000
		j.construirCasaEn(baS); // Lanza excepcion
	}
	
	@Test  (expected = SoloElPropietarioPuedeEdificarEnElTerrenoError.class)
	public void testUnJugadorNoPuedeConstruirEnUnTerrenoQueNoEsPropietario() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Shrek");
		Jugador j2 = new Jugador("Principe Encantador");
		TerrenoDoble baS = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble baN = terrenosFactory.crearBuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j1.comprarTerreno(baN); // -20000
		j1.comprarTerreno(baS);
		j2.construirCasaEn(baS); // Lanza excepcion
	}
	
	@Test  (expected = SeNecesitanAmbosTerrenosParaEdificarEnUnTerrenoDobleError.class)
	public void testUnJugadorNecesitaAmbosTerrenosParaConstruirEnUnTerrenoDoble() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Mili De Mayolas");
		Jugador j2 = new Jugador("Magui Ilari");
		TerrenoDoble baS = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble baN = terrenosFactory.crearBuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j1.comprarTerreno(baS);
		j2.comprarTerreno(baN);
		j1.construirCasaEn(baS); // Lanza excepcion
	}
	
	@Test
	public void testUnJugadorCuentaConBsAsSurYBsAsNorteYConstruyeUnaCasaEnBsAsNortEntoncesSuDineroDecrementaEn5500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Pedro");
		TerrenoDoble baS = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble baN = terrenosFactory.crearBuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j.comprarTerreno(baS); // -25000
		j.comprarTerreno(baN); // -20000
		j.construirCasaEn(baN); // -5500
		Assert.assertEquals(49500, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCuentaConCordobaSurYCordobaNorteYConstruyeUnaCasaEnCordobaSurEntoncesSuDineroDecrementaEn2000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Diego");
		TerrenoDoble cS = terrenosFactory.crearCordobaSur();
		TerrenoDoble  cN = terrenosFactory.crearCordobaNorte(); 
		cS.setTerrenoPareja(cN);
		cN.setTerrenoPareja(cS);
		j.comprarTerreno(cS); // -18000
		j.comprarTerreno(cN); // -20000
		j.construirCasaEn(cS); // -2000
		Assert.assertEquals(60000, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCuentaConCordobaSurYCordobaNorteYConstruyeUnaCasaEnCordobaNorteEntoncesSuDineroDecrementaEn2200() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Migu");
		TerrenoDoble cS = terrenosFactory.crearCordobaSur();
		TerrenoDoble  cN = terrenosFactory.crearCordobaNorte(); 
		cS.setTerrenoPareja(cN);
		cN.setTerrenoPareja(cS);
		j.comprarTerreno(cS); // -18000
		j.comprarTerreno(cN); // -20000
		j.construirCasaEn(cN); // -2200
		Assert.assertEquals(59800, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCuentaConTerrenoDobleYSaltaNorteYConstruyeUnaCasaEnTerrenoDobleEntoncesSuDineroDecrementaEn4500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Diego");
		TerrenoDoble ss = terrenosFactory.crearSaltaSur(); 
		TerrenoDoble sn = terrenosFactory.crearSaltaNorte(); 
		ss.setTerrenoPareja(sn);
		sn.setTerrenoPareja(ss);
		j.comprarTerreno(ss); // -23000
		j.comprarTerreno(sn); // -23000
		j.construirCasaEn(ss); // -4500
		Assert.assertEquals(49500, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCuentaConTerrenoDobleYSaltaNorteYConstruyeUnaCasaEnSaltaNorteEntoncesSuDineroDecrementaEn4500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j = new Jugador("Diego");
		TerrenoDoble ss = terrenosFactory.crearSaltaSur(); 
		TerrenoDoble sn = terrenosFactory.crearSaltaNorte(); 
		ss.setTerrenoPareja(sn);
		sn.setTerrenoPareja(ss);
		j.comprarTerreno(ss); // -23000
		j.comprarTerreno(sn); // -23000
		j.construirCasaEn(ss); // -4500
		Assert.assertEquals(49500, j.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnBuenosAiresSurQueTieneUnaCasaYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe3000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble baS = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble baN = terrenosFactory.crearBuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j1.comprarTerreno(baS); // -25000
		j1.comprarTerreno(baN); // -20000
		j1.construirCasaEn(baS); // -5000
		j2.caerEnCasillero(baS);
		Assert.assertEquals(97000, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnBuenosAiresSurQueTieneDosCasasYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe3500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble baS = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble baN = terrenosFactory.crearBuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j1.comprarTerreno(baS); // -25000
		j1.comprarTerreno(baN); // -20000
		j1.construirCasaEn(baS); // -5000
		j1.construirCasaEn(baS); // -5000
		j2.caerEnCasillero(baS);
		Assert.assertEquals(96500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorCaeEnBuenosAiresNorteQueTieneDosCasasYEsDeOtroJugadorEntoncesDebePagarUnAlquilerDe4000() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		TerrenoDoble baS = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble baN = terrenosFactory.crearBuenosAiresNorte();
		baS.setTerrenoPareja(baN);
		baN.setTerrenoPareja(baS);
		j1.comprarTerreno(baS); // -25000
		j1.comprarTerreno(baN); // -20000
		j1.construirCasaEn(baN); // -5500
		j1.construirCasaEn(baN); // -5500
		j2.caerEnCasillero(baN);
		Assert.assertEquals(96000, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugador1IntercambiaUnTerreno1SuyoPorUnTerreno2DeOtroJugador2EntoncesElPropietarioDelTerreno2AhoraEsJugador1() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Propietario 1");
		Jugador j2 = new Jugador("Propietario 2");
		Terreno c1 = terrenosFactory.crearTucuman();
		Terreno c2 = terrenosFactory.crearSantaFe();
		j1.comprarTerreno(c1);
		j2.comprarTerreno(c2);
		j1.intercambiarTerrenoConPor(c1, j2, c2);
		Assert.assertEquals(j1, c2.propietario().jugador());
	}
	
	@Test
	public void testUnJugador1IntercambiaUnTerreno1SuyoPorUnTerreno2DeOtroJugador2EntoncesElPropietarioDelTerreno1AhoraEsJugador2() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Propietario 1");
		Jugador j2 = new Jugador("Propietario 2");
		Terreno c1 = terrenosFactory.crearTucuman();
		Terreno c2 = terrenosFactory.crearSantaFe();
		j1.comprarTerreno(c1);
		j2.comprarTerreno(c2);
		j1.intercambiarTerrenoConPor(c1, j2, c2);
		Assert.assertEquals(j2, c1.propietario().jugador());
	}
	
	@Test
	public void testUnJugador1IntercambiaUnTerreno1SuyoPorUnTerreno2DeOtroJugador2EntoncesSiUnJugador3CaeEnTerreno1ElPagoDelAlquilerSeAcreditaAJugador2() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Propietario 1");
		Jugador j2 = new Jugador("Propietario 2");
		Jugador j3 = new Jugador("El que paga el alquiler");
		Terreno c1 = terrenosFactory.crearTucuman();
		Terreno c2 = terrenosFactory.crearSantaFe();
		j1.comprarTerreno(c1);
		j2.comprarTerreno(c2);
		j1.intercambiarTerrenoConPor(c1, j2, c2);
		int capital = j2.capitalTotal();
		j3.caerEnCasillero(c1);
		Assert.assertNotEquals(capital, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugador1IntercambiaUnTerreno1SuyoPorUnTerreno2DeOtroJugador2EntoncesSiUnJugador3CaeEnTerreno1ElPagoDelAlquilerSeAcreditaAJugador2YElMontoEsElEquivalenteAlAlquilerSinConstrucciones() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Propietario 1");
		Jugador j2 = new Jugador("Propietario 2");
		Jugador j3 = new Jugador("El que paga el alquiler");
		Terreno c1 = terrenosFactory.crearTucuman();
		Terreno c2 = terrenosFactory.crearSantaFe();
		j1.comprarTerreno(c1);
		j1.construirCasaEn(c1);
		j2.comprarTerreno(c2);
		j1.intercambiarTerrenoConPor(c1, j2, c2);
		int capital = j2.capitalTotal();
		int alquilerDeTucumanSinConstrucciones = 2500;
		j3.caerEnCasillero(c1);
		Assert.assertEquals(capital+alquilerDeTucumanSinConstrucciones, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugador1IntercambiaUnTerreno1DobleConHotelSuyoPorUnTerreno2DeOtroJugador2EntoncesSiUnJugador3CaeEnTerreno1ElPagoDelAlquilerSeAcreditaAJugador2YElMontoEsElEquivalenteAlAlquilerSinConstrucciones() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Propietario 1");
		Jugador j2 = new Jugador("Propietario 2");
		Jugador j3 = new Jugador("El que paga el alquiler");
		TerrenoDoble c1 = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble c3 = terrenosFactory.crearBuenosAiresNorte();
		c1.setTerrenoPareja(c3);
		c3.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c3);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c3);
		j1.construirCasaEn(c3);
		j1.construirHotelEn(c1);
		Terreno c2 = terrenosFactory.crearSantaFe();
		j2.comprarTerreno(c2);
		j1.intercambiarTerrenoConPor(c1, j2, c2);
		int capital = j2.capitalTotal();
		int alquilerDeBASurSinConstrucciones = 2000;
		j3.caerEnCasillero(c1);
		Assert.assertEquals(capital+alquilerDeBASurSinConstrucciones, j2.capitalTotal());
	}
	
	// Test de pago de alquileres en terrenos simples
	@Test
	public void testUnJugadorNoPropietarioCaeEnSantaFeQueNoTieneCasasEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn1500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		Terreno c1 = terrenosFactory.crearSantaFe();
		j1.comprarTerreno(c1);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 1500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnNeuquenQueNoTieneCasasEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn1800() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		Terreno c1 = terrenosFactory.crearNeuquen();
		j1.comprarTerreno(c1);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 1800, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnTucumanQueNoTieneCasasEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn2500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		Terreno c1 = terrenosFactory.crearTucuman();
		j1.comprarTerreno(c1);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 2500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnSantaFeQueTieneUnaCasaEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn3500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		Terreno c1 = terrenosFactory.crearSantaFe();
		j1.comprarTerreno(c1);
		j1.construirCasaEn(c1);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 3500, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnSantaFeQueTieneUnaCasaEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn3800() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		Terreno c1 = terrenosFactory.crearNeuquen();
		j1.comprarTerreno(c1);
		j1.construirCasaEn(c1);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 3800, j2.capitalTotal());
	}
	
	@Test
	public void testUnJugadorNoPropietarioCaeEnSantaFeQueTieneUnaCasaEntoncesDebePagarElAlquilerYSuCapitalSeDecrementaEn4500() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Senior Barriga");
		Jugador j2 = new Jugador("Don Ramon");
		Terreno c1 = terrenosFactory.crearTucuman();
		j1.comprarTerreno(c1);
		j1.construirCasaEn(c1);
		int capital = j2.capitalTotal();
		j2.caerEnCasillero(c1);
		Assert.assertEquals(capital - 4500, j2.capitalTotal());
	}
	
	@Test(expected = NoPuedeConstruirCasasEnUnTerrenoConHotelesError.class)
	public void testUnJugadorConstruyeUnHotelEnBuenosAiresSurYLuegoIntentaConstruirUnaCasaEntoncesSeLanzaUnaExcepcion() {
		TerrenosFactory terrenosFactory = new TerrenosFactory();
		Jugador j1 = new Jugador("Rochi");
		TerrenoDoble c1 = terrenosFactory.crearBuenosAiresSur();
		TerrenoDoble c2 = terrenosFactory.crearBuenosAiresNorte();
		c1.setTerrenoPareja(c2);
		c2.setTerrenoPareja(c1);
		j1.comprarTerreno(c1);
		j1.comprarTerreno(c2);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c1);
		j1.construirCasaEn(c2);
		j1.construirCasaEn(c2);
		j1.construirHotelEn(c1);
		j1.construirCasaEn(c1);
	}

}
