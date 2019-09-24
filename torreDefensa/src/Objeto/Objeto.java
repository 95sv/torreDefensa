package Objeto;

import Entidad.Entidad;
import Mapa.Celda;

public class Objeto extends Entidad{
	
	public Objeto(Celda celda) {
		this.x = celda.getX();
		this.y = celda.getY();
	}

}