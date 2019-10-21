package Disparo;

import Entidad.Entidad;
import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Disparo extends Entidad {

	protected float daño;
	protected int velocidad;

	public Disparo(Mapa miMapa, Celda miCelda, float daño, int velocidad) {
		super(miMapa, miCelda);
		this.daño = daño;
		this.velocidad = velocidad;
	}

	public float getDaño() {
		return daño;
	}

	public abstract boolean mover();
	
	public abstract Torre getTorre();

	
}