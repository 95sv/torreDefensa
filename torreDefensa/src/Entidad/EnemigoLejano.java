package Entidad;

import Disparo.DisparoEnemigo;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class EnemigoLejano extends Enemigo {

	int tiempo = 3;

	public EnemigoLejano(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
	}

	public void disparar() {
		logica.agregarEntidad(crearDisparo(), miCelda);
	}

	public abstract DisparoEnemigo crearDisparo();

	public void ejecutar() {

		Entidad e;
		if (tiempo == 3) {
			if (x < 9) {
				for (int i = 1; i < 9; i++) {
					e = miMapa.getCelda(9 - i, y).getEntidad();
					if (e != null) {
						e.aceptar(miVisitor);
					}
				}
			}
		}
		tiempo--;
		if (tiempo == 0) {
			tiempo = 3;
			super.mover();
		}

	}
}
