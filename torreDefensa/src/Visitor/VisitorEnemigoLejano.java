package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.EnemigoLejano;
import Entidad.Torre;
import Objeto.Agua;
import Objeto.Roca;
import PowerUp.PowerUp;

public class VisitorEnemigoLejano extends Visitor {

	protected EnemigoLejano e;

	public VisitorEnemigoLejano(EnemigoLejano miEnemigo) {
		this.e = miEnemigo;
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
	}

	@Override
	public void visit(PowerUp p) {
	
	}

}
