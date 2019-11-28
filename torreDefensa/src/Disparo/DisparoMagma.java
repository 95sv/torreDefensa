package Disparo;

import Mapa.Celda;
import Mapa.Mapa;

public class DisparoMagma extends DisparoEnemigo{

	public DisparoMagma(Mapa miMapa, Celda miCelda, int golpe, int velocidad) {
		super(miMapa, miCelda, golpe, velocidad);
	}

	@Override
	public int getGolpe() {
		return 10;
	}

}
