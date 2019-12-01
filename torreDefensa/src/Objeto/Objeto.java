package Objeto;

import Entidad.Entidad;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class Objeto extends Entidad {
	protected int precio;
	public Objeto(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public int getPrecio() {
		return precio;
	}

	public void mover() {
	}

	public void ejecutar() {
	}

	public void aceptar(Visitor visitor) {
	}

}