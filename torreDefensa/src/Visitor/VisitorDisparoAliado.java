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

public class VisitorDisparoAliado extends Visitor {
	protected DisparoAliado miDisparo;
	public VisitorDisparoAliado(DisparoAliado miDisparo) {
		this.miDisparo = miDisparo;
	}

	@Override
	public void visit(Enemigo e) {
		e.recibirGolpe(miDisparo.getGolpe());
		miDisparo.morir();
		miDisparo.setSeguirMoviendo(false);
	}

	@Override
	public void visit(Torre t) {}

	@Override
	public void visit(DisparoAliado d) {}

	@Override
	public void visit(DisparoEnemigo e) {}

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

	@Override
	public void visit(Fuego f) {	
	}

	@Override
	public void visit(Barricada b) {
	}

}