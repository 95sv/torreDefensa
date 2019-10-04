package Disparo;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class DisparoEnemigo extends Disparo  {

	public DisparoEnemigo(Celda celda, float daño, int velocidad,Mapa mapa) {
		super(celda, daño, velocidad,mapa);
	}
	
	
	
}
