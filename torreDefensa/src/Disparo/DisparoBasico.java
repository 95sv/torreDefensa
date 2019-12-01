package Disparo;

import Mapa.Celda;
import Mapa.Mapa;

public class DisparoBasico extends DisparoAliado {

	public DisparoBasico(Mapa miMapa, Celda miCelda,int golpe,int velocidad) {
		super(miMapa, miCelda, golpe, velocidad);
	}

	public int getGolpe() {
		return 50;
	}

}