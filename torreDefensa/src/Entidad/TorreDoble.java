package Entidad;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class TorreDoble extends Torre{

	public TorreDoble(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean mover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean aceptar(Visitor visitor) {
		// TODO Auto-generated method stub
		return false;
	}

}
