package Entidad;

import Logica.Logica;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Jugador extends Entidad {

	protected int disparo;
	protected int alcance;
	protected Logica logica;
	protected Mapa mapa;

	public Jugador(Celda celda) {
		x = celda.getX();
		y = celda.getY();
	}

}
