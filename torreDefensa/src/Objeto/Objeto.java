package Objeto;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Entidad;
import Mapa.Celda;

public class Objeto extends Entidad{
	
	public Objeto(Celda celda) {
		this.x = celda.getX();
		this.y = celda.getY();
	}

	@Override
	public boolean visit(DisparoAliado d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(DisparoEnemigo d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void visit() {
		// TODO Auto-generated method stub
		
	}

}