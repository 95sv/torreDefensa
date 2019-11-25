package Objeto;

import Entidad.Entidad;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class Objeto extends Entidad {

	public Objeto(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
	}

	public void morir() {
	}

	public void mover() {}

	@Override
	public void aceptar(Visitor visitor) {
	}

}