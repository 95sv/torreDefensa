package Disparo;


import Mapa.Celda;
import Mapa.Mapa;



public abstract class DisparoAliado extends Disparo {

	
	public DisparoAliado(Celda celda, float da�o, int velocidad, Mapa mapa) {
		super(celda, da�o, velocidad,mapa);
	}
	
	public void mover() {
		int x = miCelda.getX();
		int y = miCelda.getY();
		
			if(x<9 && x>=1) {
		     x = x-1;
			 miCelda.eliminarEntidad();
			 Celda nuevaCelda = mapa.getCelda(x, y);
			 setCelda(nuevaCelda);
			 nuevaCelda.agregarEntidad(this);
		  }
	   }
		
}
