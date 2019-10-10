package Entidad;

import Logica.Logica;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Enemigo extends Entidad {
	
	protected int disparo;
	protected int alcance;
	protected Logica logica;
	protected Mapa mapa;
	
	public Enemigo(Celda celda, Mapa mapa) {
		super(celda,mapa);
		this.logica = mapa.getLogica();
	}
	
	public abstract void mover();

	public void morir() {
		logica.eliminarEntidad(this);
	}
	
	
}