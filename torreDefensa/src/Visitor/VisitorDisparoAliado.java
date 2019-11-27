package Visitor;

import Disparo.Disparo;
import Disparo.DisparoAliado;

import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Torre;
import Objeto.Agua;
import Objeto.Roca;

public class VisitorDisparoAliado extends Visitor {

	public VisitorDisparoAliado(DisparoAliado miDisparo) {
		this.miEntidad = miDisparo;
	}

	@Override
	public void visit(Enemigo e) {
		e.recibirDano(((Disparo) miEntidad).getGolpe());
	}

	@Override
	public void visit(Torre t) {}

	@Override
	public void visit(DisparoAliado d) {}

	@Override
	public void visit(DisparoEnemigo e) {}

	@Override
	public void visit(Agua a) {
		System.out.println("Entre Visitor DisparoAliado");
	}

	@Override
	public void visit(Roca r) {
		miEntidad.morir();
	//aca se elimina el disparo una vez llegado a la torre
	}

}