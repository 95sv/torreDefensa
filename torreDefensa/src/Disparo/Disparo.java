package Disparo;

import Entidad.Entidad;
import Mapa.Celda;

public abstract class Disparo extends Entidad {
	
	protected float daño;
	protected int velocidad;
	protected Celda celda;
	

	public Disparo( Celda celda, float daño, int velocidad) {
		this.daño = daño;
		this.velocidad = velocidad;
	}

	public float getDaño() {
		return daño;
	}
	
	public abstract void mover();
	
	
}
