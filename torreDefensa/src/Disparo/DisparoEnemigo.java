package Disparo;
import Entidad.Entidad;
import Mapa.Celda;
import Mapa.Mapa;


public abstract class DisparoEnemigo extends Disparo  {

	public DisparoEnemigo(Celda celda, float da�o, int velocidad) {
		super(celda, da�o, velocidad);
	}
	
	
	
}
