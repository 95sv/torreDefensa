package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Torre;
import Objeto.Objeto;

public class VisitorObjeto extends Visitor{
	
	public VisitorObjeto(Objeto objeto) {
		miEntidad = objeto;
	}
	
	@Override
	public boolean visit(Enemigo e) {
		// Si un enemigo se choca con un objeto, el enemigo debe quedarse en el lugar.
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
	protected boolean visit(Objeto objeto) {
		// TODO Auto-generated method stub
		return false;
	}


}
