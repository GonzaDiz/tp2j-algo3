package modelo;

public class ParDeDados {
	
	Dado dado1;
	Dado dado2;
	
	public ParDeDados() {
		this.dado1 = new Dado();
		this.dado2 = new Dado();
	}

	public TiroDeDados arrojar() {
		int valor1 = dado1.arrojar();
		int valor2 = dado2.arrojar(); 
		return (valor1==valor2)? new TiroDoble(valor1+valor2) : new TiroSimple(valor1+valor2);
	}
}
