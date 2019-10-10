package Entidad;

import Disparo.DisparoBasico;
import Disparo.DisparoEnemigo;
import Logica.Logica;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Enemigo extends Entidad {
	
	protected int disparo;
	protected int alcance;
	protected Logica logica;
	protected Mapa mapa;
	
	public Enemigo(Celda celda, Mapa mapa) {
		super(celda,mapa);
		this.logica = mapa.getLogica();
	}
	
	public abstract void mover();

	public void morir() {
	}
	
	@Override
	public boolean visit(DisparoBasico d) {
		return true;
	}

	@Override
	public boolean visit(DisparoEnemigo d) {
		return false;
	}

	@Override
	public void visit() {	
	}	
}