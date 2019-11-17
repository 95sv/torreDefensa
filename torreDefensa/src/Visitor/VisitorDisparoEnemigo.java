package Visitor;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Torre;
import Objeto.Agua;
import Objeto.Roca;

public class VisitorDisparoEnemigo extends Visitor {
	

	public VisitorDisparoEnemigo(DisparoEnemigo miDisparo) {
		this.miEntidad = miDisparo;
	}
	
	
	public boolean visit(Enemigo e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Torre t) {
		System.out.println("ENTRE AL VISITOR DISPARO ENEMIGO, TORRE T");
	
		t.morir();   //ESTO ES PARA VER QUE EL ENEMIGO SE VUELVE A MOVER CUANDO SE ELIMINA LA TORRE QUE LO HIZO PARAR
		//miEntidad.morir();
		return true;
	}

	@Override
	public boolean visit(DisparoAliado d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(DisparoEnemigo e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Agua a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Roca r) {
		// TODO Auto-generated method stub
		return false;
	}

}
