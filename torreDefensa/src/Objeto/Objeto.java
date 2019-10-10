package Objeto;

import Disparo.DisparoBasico;
import Disparo.DisparoEnemigo;
import Entidad.Entidad;
import Mapa.Celda;
import Mapa.Mapa;

public class Objeto extends Entidad{
	
	public Objeto(Celda celda,Mapa mapa) {
		super(celda,mapa);
	}

	@Override
	public boolean visit(DisparoBasico d) {
		return false;
	}

	@Override
	public boolean visit(DisparoEnemigo d) {
		return false;
	}

	@Override
	public void visit() {
	}

	@Override
	public void mover() {		
	}

}