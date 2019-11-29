package PowerUp;

import Entidad.Entidad;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class PowerUp extends Entidad {
	protected PowerUp miPowerUp;

	public PowerUp(Mapa mapa, Celda celda) {
		super(mapa, celda);
	}

	public void ejecutar() {
	}

	public abstract void activarPowerUp();
}
