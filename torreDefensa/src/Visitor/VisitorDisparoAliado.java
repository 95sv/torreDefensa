package Visitor;

import Disparo.DisparoAliado;

import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Torre;
import Objeto.Agua;
import Objeto.Objeto;
import Objeto.Roca;

public class VisitorDisparoAliado extends Visitor{
	
	public VisitorDisparoAliado(DisparoAliado miDisparo) {
		this.miEntidad = miDisparo;
	}
	@Override
	public boolean visit(Enemigo e) {
		e.morir();
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
	
	@Override
	public boolean visit(Agua a) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean visit(Roca r) {
		// TODO Auto-generated method stub
		return true;
	}
	

}
