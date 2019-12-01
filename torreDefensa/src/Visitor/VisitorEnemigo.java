package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.EnemigoCombate;
import Entidad.Torre;
import Objeto.Agua;
import Objeto.Barricada;
import Objeto.Fuego;
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
		//System.out.println("entre al visitorEnemigo");
		e.seguirMoviendo(false);
	}

	@Override
	public void visit(DisparoAliado d) {
		e.recibirGolpe(d.getGolpe());
		d.morir();
		//System.out.println("entre al visitorEnemigo");
	}

	@Override
	public void visit(DisparoEnemigo e) {
	}

	@Override
	public void visit(Agua a) {
		e.seguirMoviendo(true);
	}

	@Override
	public void visit(Roca r) {
		e.seguirMoviendo(false);
		e.disparar(r);
	}

	@Override
	public void visit(PowerUp p) {
	
	}

	@Override
	public void visit(Fuego f) {
		e.recibirGolpe(f.getGolpe());
		f.morir();
	}

	@Override
	public void visit(Barricada b) {
		e.seguirMoviendo(false);
		e.disparar(b);
	}
}