package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Torre;
import Objeto.Agua;
import Objeto.Roca;
import PowerUp.AumentoVida;
import PowerUp.PowerUp;

public class VisitorPUvida extends Visitor{
	
	protected AumentoVida pu;
	
	public VisitorPUvida(AumentoVida pu) {
		this.pu = pu;
	}
	
	@Override
	public void visit(Enemigo e) {
	}

	@Override
	public void visit(Torre t) {
		t.setVida(100);
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
	}

	@Override
	public void visit(PowerUp p) {	
	}

}
