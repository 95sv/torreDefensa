package Disparo;

import Mapa.Celda;
import Mapa.Mapa;

public class DisparoFantasma extends DisparoEnemigo {
	
	
	public DisparoFantasma(Mapa miMapa, Celda miCelda, int golpe, int velocidad) {
		super(miMapa, miCelda, golpe, velocidad);
	}

	@Override
	public int getGolpe() {
		return 75;
	}
}
