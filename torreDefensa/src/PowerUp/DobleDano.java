package PowerUp;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class DobleDano extends ObjetoPrecioso{

	public DobleDano(Mapa mapa, Celda celda) {
		super(mapa, celda);
	}

	@Override
	protected void activarPowerUp() {
		
	}

	@Override
	public boolean mover() {
		return false;
	}

	@Override
	public void morir() {
	}

	@Override
	public boolean aceptar(Visitor visitor) {
		return false;
	}

}
