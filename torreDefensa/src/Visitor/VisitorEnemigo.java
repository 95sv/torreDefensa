package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.EnemigoCombate;
import Entidad.Torre;
import Objeto.Agua;
import Objeto.Roca;
import PowerUp.PowerUp;

public class VisitorEnemigo extends Visitor {
	protected EnemigoCombate e;

	public VisitorEnemigo(EnemigoCombate e) {
		this.e = e;
	}

	@Override
	public void visit(Enemigo e) {
	}

	@Override
	public void visit(Torre t) {
		e.disparar(t);
	}

	@Override
	public void visit(DisparoAliado d) {
		e.recibirGolpe(d.getGolpe());
		d.morir();
	}

	@Override
	public void visit(DisparoEnemigo e) {
	}

	@Override
	public void visit(Agua a) {
	}

	@Override
	public void visit(Roca r) {
		e.disparar(r);
		e.seguirMoviendo(false);
		
	}

	@Override
	public void visit(PowerUp p) {
	
	}
}