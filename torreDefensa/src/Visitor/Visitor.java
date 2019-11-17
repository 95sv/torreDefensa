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

	public abstract boolean visit(Enemigo e);

	public abstract boolean visit(Torre t);

	public abstract boolean visit(DisparoAliado d);

	public abstract boolean visit(DisparoEnemigo e);

	public abstract boolean visit(Agua a);
	
	public abstract boolean visit(Roca r);
	
}
//