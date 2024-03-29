package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.EnemigoLejano;
import Entidad.Torre;
import Objeto.Agua;
import Objeto.Barricada;
import Objeto.Fuego;
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
		e.seguirMoviendo(false);
	}

	@Override
	public void visit(DisparoAliado d) {
		if(d.getCelda()==e.getCelda()) {
		e.recibirGolpe(d.getGolpe());
		d.morir();
		d.setSeguirMoviendo(false);
	   }
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

	@Override
	public void visit(Fuego f) {
		if(f.getCelda()==e.getCelda()) {
		e.recibirGolpe(f.getGolpe());
		f.morir();
		}
	}

	@Override
	public void visit(Barricada b) {
	e.seguirMoviendo(false);
	}

}
