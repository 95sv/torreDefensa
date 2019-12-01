package Disparo;

import Mapa.Celda;
import Mapa.Mapa;

public class DisparoVerde extends DisparoEnemigo {

	public DisparoVerde(Mapa miMapa, Celda miCelda, int golpe, int velocidad) {
		super(miMapa, miCelda, golpe, velocidad);
	}

	@Override
	public int getGolpe() {
		return 50;
	}


}