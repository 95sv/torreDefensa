package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Torre;
import Objeto.Agua;
import Objeto.Roca;

public class VisitorAgua extends Visitor {

	public VisitorAgua(Agua agua) {
		miEntidad = agua;
	}

	@Override
	public void visit(Enemigo e) {}

	@Override
	public void visit(Torre t) {}

	@Override
	public void visit(DisparoAliado d) {}

	@Override
	public void visit(DisparoEnemigo e) {}

	@Override
	public void visit(Agua a) {}

	@Override
	public void visit(Roca r) {}

}