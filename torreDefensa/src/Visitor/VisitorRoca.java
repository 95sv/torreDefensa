package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Torre;
import Objeto.Agua;
import Objeto.Roca;

public class VisitorRoca extends Visitor{
	public VisitorRoca(Roca roca) {
		miEntidad = roca;
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
	
	@Override
	public boolean visit(Agua a) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean visit(Roca r) {
		// TODO Auto-generated method stub
		return false;
	}

}
