package Disparo;

import Entidad.Entidad;
import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Disparo extends Entidad {

	protected int da�o;
	protected int velocidad;

	public Disparo(Mapa miMapa, Celda miCelda, int da�o, int velocidad) {
		super(miMapa, miCelda);
		this.da�o = da�o;
		this.velocidad = velocidad;
	}

	public abstract int getDa�o();

	public abstract boolean mover();
	
	public abstract Torre getTorre();

	
}