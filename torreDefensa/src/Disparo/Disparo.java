package Disparo;

import Entidad.Entidad;
import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Disparo extends Entidad {

	protected int dano;
	protected int velocidad;

	public Disparo(Mapa miMapa, Celda miCelda, int dano, int velocidad) {
		super(miMapa, miCelda);
		this.dano = dano;
		this.velocidad = velocidad;
	}

	public abstract int getDano();

	public abstract boolean mover();
	
	public abstract Torre getTorre();

	
}