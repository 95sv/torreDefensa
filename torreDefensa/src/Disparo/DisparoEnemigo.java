package Disparo;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class DisparoEnemigo extends Disparo  {

	public DisparoEnemigo(Mapa miMapa,Celda miCelda, int dano, int velocidad) {
		super(miMapa,miCelda, dano, velocidad);
	}
	
	public void morir() {
		miMapa.getLogica().eliminarEntidad(this);
	//comentando
	}
	
}
