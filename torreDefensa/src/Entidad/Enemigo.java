package Entidad;

import Disparo.DisparoAliado;
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
		x = celda.getX();
		y = celda.getY();
		this.mapa = mapa;
		this.logica = mapa.getLogica();
	}
	
	public abstract void mover();

	
	
	public void morir() {
		logica.eliminarEnemigo();
		
	}
	
	@Override
	public boolean visit(DisparoBasico d) {
		
		//recibirDaño(d.getDaño());
		//return true;
     logica.eliminarEnemigo();
		
		return true;
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
