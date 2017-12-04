package vista;



import modelo.Posicion;
import modelo.Tablero;
import modelo.casillero.Casillero;


public class VistaCasilleros {
	
	
	
	
	public void setPosicionesTablero(Tablero unTablero)
	
	{
		Casillero unCasillero;
		 for(int i=0; i<unTablero.getNumCasilleros(); i++){
			 
				unCasillero=unTablero.getCasillero(i);
				setPosiciones(unCasillero, i);
		
		 }
	}
	
	
	
	
	public void setPosiciones(Casillero unCasillero, int i) {
	
	  
  
  if (i==0)
						
	unCasillero.setPosicion(new Posicion(520,520));
  
  if (i==1)
  unCasillero.setPosicion(new Posicion(420,520));
  if (i==2)
	
  unCasillero.setPosicion(new Posicion(320,520));
  if (i==3)
	
  unCasillero.setPosicion(new Posicion(220,520));
  if (i==4)
  
  unCasillero.setPosicion(new Posicion(120,520));
  if (i==5)
	
  unCasillero.setPosicion(new Posicion(20,520));
   if (i==6)
	
  unCasillero.setPosicion(new Posicion(20,420));
   if (i==7)
	
  unCasillero.setPosicion(new Posicion(20,320));
   if (i==8)
	
  unCasillero.setPosicion(new Posicion(20,220));
   if (i==9)
	
  unCasillero.setPosicion(new Posicion(20,120));
   if (i==10)
	
  unCasillero.setPosicion(new Posicion(20,20));
   if (i==11)
	
  unCasillero.setPosicion(new Posicion(120,20));
   if (i==12)
	

   unCasillero.setPosicion(new Posicion(220,20));
   if (i==13)
	
   unCasillero.setPosicion(new Posicion(320,20));
   if (i==14)
	
   unCasillero.setPosicion(new Posicion(420,20));
   if (i==15)
	
   unCasillero.setPosicion(new Posicion(520,20));
   if (i==16)
	
   unCasillero.setPosicion(new Posicion(520,120));
   if (i==17)
	
	unCasillero.setPosicion(new Posicion(520,220));
   if (i==18)
	
	 unCasillero.setPosicion(new Posicion(520,320));
   if (i==19)
	
	 unCasillero.setPosicion(new Posicion(520,420));
	
	}
	
	

}
