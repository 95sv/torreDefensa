package Disparo;

import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class DisparoDoble extends Disparo {

	protected Torre miTorre;
	
	public DisparoDoble(Mapa miMapa, Celda miCelda, Torre miTorre,int da�o, int velocidad) {
		super(miMapa, miCelda, da�o, velocidad);
		this.miTorre = miTorre;
		
	}

	@Override
	public int getDa�o() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean mover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Torre getTorre() {
		// TODO Auto-generated method stub
		return null;
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
