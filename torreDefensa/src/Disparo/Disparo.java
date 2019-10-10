package Disparo;

import Entidad.Entidad;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Disparo extends Entidad {
	
	protected float daño;
	protected int velocidad;
	protected Celda celda;
	protected Mapa mapa;
    	

	public Disparo( Celda celda, float daño, int velocidad,Mapa mapa) {
		super(celda,mapa);
		this.daño = daño;
		this.velocidad = velocidad;
		this.mapa=mapa;
	}

	public float getDaño() {
		return daño;
	}
	
	public abstract void mover();
	
	
}
