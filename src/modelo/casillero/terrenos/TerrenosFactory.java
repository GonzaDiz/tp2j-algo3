package modelo.casillero.terrenos;

public class TerrenosFactory {
	
	public Terreno crearTucuman() {
		AlquilerTerrenoSimple alquiler = new AlquilerTerrenoSimple(2500,4500);
		Terreno tucuman = new TerrenoSimple(25000,null,"Tucuman",7000,alquiler);
		return tucuman;
		
	}
	
	public Terreno crearNeuquen() {
		AlquilerTerrenoSimple alquiler = new AlquilerTerrenoSimple(1800,3800);
		Terreno neuquen = new TerrenoSimple(17000,null,"Neuquen",4800,alquiler);
		return neuquen;
	}
	
	public Terreno crearSantaFe() {
		AlquilerTerrenoSimple alquiler = new AlquilerTerrenoSimple(1500,3500);
		Terreno santaFe = new TerrenoSimple(15000,null,"Santa Fe",4000,alquiler);
		return santaFe;
	}
	
	public TerrenoDoble crearBuenosAiresNorte() {
		AlquilerTerrenoDoble alquiler = new AlquilerTerrenoDoble(2500,3500,4000,6000);
		TerrenoDoble buenosAiresNorte = new TerrenoDoble(25000,null,5500,9000,"Buenos Aires Norte",alquiler);
		return buenosAiresNorte;
	}
	
	public TerrenoDoble crearBuenosAiresSur() {
		AlquilerTerrenoDoble alquiler = new AlquilerTerrenoDoble(2000,3000,3500,5000);
		TerrenoDoble buenosAiresNorte = new TerrenoDoble(20000,null,5000,8000,"Buenos Aires Sur",alquiler);
		return buenosAiresNorte;
	}
	
	public TerrenoDoble crearCordobaNorte() {
		AlquilerTerrenoDoble alquiler = new AlquilerTerrenoDoble(1300,1800,2900,3500);
		TerrenoDoble buenosAiresNorte = new TerrenoDoble(20000,null,2200,3500,"Cordoba Norte", alquiler);
		return buenosAiresNorte;
	}
	
	public TerrenoDoble crearCordobaSur() {
		AlquilerTerrenoDoble alquiler = new AlquilerTerrenoDoble(1000,1500,2500,3000);
		TerrenoDoble buenosAiresNorte = new TerrenoDoble(18000,null,2000,3000,"Cordoba Sur",alquiler);
		return buenosAiresNorte;
	}
	
	public TerrenoDoble crearSaltaNorte() {
		AlquilerTerrenoDoble alquiler = new AlquilerTerrenoDoble(2000,3250,3850,5500);
		TerrenoDoble buenosAiresNorte = new TerrenoDoble(23000,null,4500,7500,"Salta Norte",alquiler);
		return buenosAiresNorte;
	}
	
	public TerrenoDoble crearSaltaSur() {
		AlquilerTerrenoDoble alquiler = new AlquilerTerrenoDoble(2000,3250,3850,5500);
		TerrenoDoble buenosAiresNorte = new TerrenoDoble(23000,null,4500,7500,"Salta Sur",alquiler);
		return buenosAiresNorte;
	}

}
