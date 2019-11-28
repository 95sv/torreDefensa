package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Torre;
import Objeto.Agua;
import Objeto.Roca;
import PowerUp.PowerUp;

public class VisitorTorre extends Visitor {
	protected Torre miTorre;

	public VisitorTorre(Torre torre) {
		miTorre = torre;
	}

	@Override
	public void visit(Enemigo e) {
		e.disparar(miTorre);
	}

	@Override
	public void visit(Torre t) {
	}

	@Override
	public void visit(DisparoAliado d) {
	}

	@Override
	public void visit(DisparoEnemigo e) {
	}

	@Override
	public void visit(Agua a) {
	}

	@Override
	public void visit(Roca r) {
	}

	@Override
	public void visit(PowerUp p) {
		p.activarPowerUp();
	}

}