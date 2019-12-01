package Objeto;

import Mapa.Celda;
import Mapa.Mapa;

public abstract class ObjetoTemporal extends Objeto{
	protected int tiempoVida;
	public ObjetoTemporal(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		tiempoVida = 50;
	}
	
	public void ejecutar() {
		tiempoVida--;
		if(tiempoVida == 0) {
			morir();
		}
	}
}
