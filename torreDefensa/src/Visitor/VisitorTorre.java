package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Torre;
import Objeto.Agua;
import Objeto.Barricada;
import Objeto.Fuego;
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
		e.seguirMoviendo(false);
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

	@Override
	public void visit(Fuego f) {
	}

	@Override
	public void visit(Barricada b) {
	}

}