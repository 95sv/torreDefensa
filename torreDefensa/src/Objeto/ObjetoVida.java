package Objeto;

import Mapa.Celda;
import Mapa.Mapa;

public abstract class ObjetoVida extends Objeto{
	protected int tiempoVida;
	public ObjetoVida(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
	}

}
