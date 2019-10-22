package Disparo;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class DisparoEnemigo extends Disparo  {

	public DisparoEnemigo(Mapa miMapa,Celda miCelda, int da�o, int velocidad) {
		super(miMapa,miCelda, da�o, velocidad);
	}
	
	public void morir() {
		miMapa.getLogica().eliminarEntidad(this);
	}
	
}
