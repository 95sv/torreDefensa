package Disparo;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class DisparoEnemigo extends Disparo  {

	public DisparoEnemigo(Celda celda, float da�o, int velocidad,Mapa mapa) {
		super(celda, da�o, velocidad,mapa);
	}
	
	
	
}
