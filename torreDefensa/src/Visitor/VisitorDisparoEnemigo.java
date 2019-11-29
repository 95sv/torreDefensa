package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Torre;
import Objeto.Agua;
import Objeto.Roca;
import PowerUp.PowerUp;

public class VisitorDisparoEnemigo extends Visitor {
	protected DisparoEnemigo miDisparo;

	public VisitorDisparoEnemigo(DisparoEnemigo miDisparo) {
		this.miDisparo = miDisparo;
	}

	public void visit(Enemigo e) {
	}

	@Override
	public void visit(Torre t) {
		t.recibirGolpe(miDisparo.getGolpe());
		miDisparo.morir();
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
		r.recibirGolpe(miDisparo.getGolpe());
		miDisparo.morir();
	}

	@Override
	public void visit(PowerUp p) {	
	}

}
