package Entidad;

import Disparo.DisparoAliado;
import Disparo.DisparoBasico;
import Disparo.DisparoEnemigo;
import Logica.Logica;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Torre extends Entidad {

	protected int disparo;
	protected int alcance;
	protected Logica logica;
	protected Mapa mapa;

	public Torre(Celda celda) {
		x = celda.getX();
		y = celda.getY();
	}

	@Override
	public boolean visit(DisparoBasico d) {
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
