package Entidad;

import Logica.Logica;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Enemigo extends Entidad {
	
	protected int disparo;
	protected int alcance;
	protected Logica logica;
	protected Mapa mapa;
	
	public Enemigo(Celda celda) {
		x = celda.getX();
		y = celda.getY();
	}
}