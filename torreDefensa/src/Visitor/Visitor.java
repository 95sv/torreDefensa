package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Entidad;
import Entidad.Torre;
import Objeto.Agua;
import Objeto.Roca;

public abstract class Visitor {
	protected Entidad miEntidad;

	public abstract void visit(Enemigo e);

	public abstract void visit(Torre t);

	public abstract void visit(DisparoAliado d);

	public abstract void visit(DisparoEnemigo e);

	public abstract void visit(Agua a);
	
	public abstract void visit(Roca r);
	
}