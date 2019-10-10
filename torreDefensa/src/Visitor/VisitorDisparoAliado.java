package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Torre;

public class VisitorDisparoAliado extends Visitor{
	protected DisparoAliado miDisparo;
	
	public VisitorDisparoAliado(DisparoAliado miDisparo) {
		this.miDisparo = miDisparo;
	}
	@Override
	public boolean visit(Enemigo e) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visit(Torre t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(DisparoAliado d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(DisparoEnemigo e) {
		// TODO Auto-generated method stub
		return false;
	}

}
