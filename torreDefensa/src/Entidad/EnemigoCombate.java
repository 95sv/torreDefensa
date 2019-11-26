package Entidad;

import Mapa.Celda;
import Mapa.Mapa;

public abstract class EnemigoCombate extends Enemigo {

	public EnemigoCombate(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
	}

}
