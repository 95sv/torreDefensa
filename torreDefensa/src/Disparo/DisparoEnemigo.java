package Disparo;
import Entidad.Entidad;
import Mapa.Celda;
import Mapa.Mapa;


public abstract class DisparoEnemigo extends Disparo  {

	public DisparoEnemigo(Celda celda, float daño, int velocidad) {
		super(celda, daño, velocidad);
	}
	
	
	
}
