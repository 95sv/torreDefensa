package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoBasico;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Torre;
import Objeto.Objeto;

public class VisitorTorre extends Visitor{

	public VisitorTorre(Torre torre) {
		miEntidad = torre;
	}
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

	@Override
	protected boolean visit(Objeto objeto) {
		// TODO Auto-generated method stub
		return false;
	}

}
