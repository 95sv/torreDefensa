package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Entidad;
import Entidad.Torre;

public abstract class Visitor {
	protected Entidad miEntidad;

	public abstract boolean visit(Enemigo e);

	public abstract boolean visit(Torre t);

	public abstract boolean visit(DisparoAliado d);

	public abstract boolean visit(DisparoEnemigo e);
}
