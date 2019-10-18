package Disparo;

import Entidad.Entidad;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Disparo extends Entidad {

	protected float da�o;
	protected int velocidad;

	public Disparo(Mapa miMapa, Celda miCelda, float da�o, int velocidad) {
		super(miMapa, miCelda);
		this.da�o = da�o;
		this.velocidad = velocidad;
	}

	public float getDa�o() {
		return da�o;
	}

	public boolean moverA() {
		return false;
	}

	public abstract void mover();

}