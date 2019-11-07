package PowerUp;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class AumentoMoneda extends MagiaTemporal{

	public AumentoMoneda(Mapa mapa, Celda celda) {
		super(mapa, celda);
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

	@Override
	protected void activarPowerUp() {
	}

}
