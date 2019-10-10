package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Torre;

public class VisitorTorre extends Visitor{

	@Override
	public boolean visit(Enemigo e) {
		// TODO Auto-generated method stub
		return false;
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
