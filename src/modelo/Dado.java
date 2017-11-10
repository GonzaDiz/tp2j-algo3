package modelo;

import java.util.Random;

public class Dado {
	
	public Dado() {
		
	}

	public int arrojar() {
		Random rand = new Random();
		return rand.nextInt(6) + 1;
	}
}
