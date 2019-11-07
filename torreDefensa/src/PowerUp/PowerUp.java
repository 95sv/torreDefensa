package PowerUp;

import Entidad.Entidad;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class PowerUp extends Entidad{

	public PowerUp(Mapa mapa, Celda celda) {
		super(mapa, celda);
	}
	
	protected abstract void activarPowerUp();
}
