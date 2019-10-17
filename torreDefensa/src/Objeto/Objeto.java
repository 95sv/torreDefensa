package Objeto;

import Entidad.Entidad;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class Objeto extends Entidad{
	
	public Objeto(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
	}

	
	public void morir() {}
	
	public boolean mover() {	
		return false;
	}


	@Override
	public boolean aceptar(Visitor visitor) {
		// TODO Auto-generated method stub
		return true;
	}


}