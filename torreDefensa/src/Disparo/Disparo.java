package Disparo;

import Entidad.Entidad;
import Mapa.Celda;

public abstract class Disparo extends Entidad {
	
	protected float da�o;
	protected int velocidad;
	protected Celda celda;
	

	public Disparo( Celda celda, float da�o, int velocidad) {
		this.da�o = da�o;
		this.velocidad = velocidad;
	}

	public float getDa�o() {
		return da�o;
	}
	
	public abstract void mover();
	
	
}
