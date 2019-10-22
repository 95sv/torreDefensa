package Disparo;

import Entidad.Entidad;
import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Disparo extends Entidad {

	protected int daño;
	protected int velocidad;

	public Disparo(Mapa miMapa, Celda miCelda, int daño, int velocidad) {
		super(miMapa, miCelda);
		this.daño = daño;
		this.velocidad = velocidad;
	}

	public abstract int getDaño();

	public abstract boolean mover();
	
	public abstract Torre getTorre();

	
}