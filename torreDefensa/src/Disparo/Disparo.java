package Disparo;

import Entidad.Entidad;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Disparo extends Entidad {

	protected int velocidad;

	public Disparo(Mapa miMapa, Celda miCelda, int golpe, int velocidad) {
		super(miMapa, miCelda);
		this.golpe = golpe;
		this.velocidad = velocidad;
	}

}