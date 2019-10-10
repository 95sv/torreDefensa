package Disparo;

import Entidad.Entidad;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Disparo extends Entidad {
	
	protected float da�o;
	protected int velocidad;
	protected Celda celda;
	protected Mapa mapa;
    	

	public Disparo( Celda celda, float da�o, int velocidad,Mapa mapa) {
		super(celda,mapa);
		this.da�o = da�o;
		this.velocidad = velocidad;
		this.mapa=mapa;
	}

	public float getDa�o() {
		return da�o;
	}
	
	public abstract void mover();
	
	
}
