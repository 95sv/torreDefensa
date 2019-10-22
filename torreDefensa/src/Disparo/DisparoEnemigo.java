package Disparo;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class DisparoEnemigo extends Disparo  {

	public DisparoEnemigo(Mapa miMapa,Celda miCelda, int daño, int velocidad) {
		super(miMapa,miCelda, daño, velocidad);
	}
	
	public void morir() {
		miMapa.getLogica().eliminarEntidad(this);
	}
	
}
