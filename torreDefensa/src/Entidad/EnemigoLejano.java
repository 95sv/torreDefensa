package Entidad;

import Disparo.DisparoEnemigo;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.VisitorEnemigoLejano;

public abstract class EnemigoLejano extends Enemigo {

	int tiempo = 3;

	public EnemigoLejano(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		miVisitor = new VisitorEnemigoLejano(this);
	}

	public void disparar(Entidad e) {
		imagen.setIcon(imagenAtacar);
		logica.agregarEntidad(crearDisparo(), miCelda);
	}

	public abstract DisparoEnemigo crearDisparo();

	public void mover() {	
		imagen.setIcon(imagenMover);
		if (x == 9) {
			logica.perder();
		} else if (miMapa.getCelda(x + 1, y).getEntidad() == null) {
			miMapa.getCelda(x, y).eliminarEntidad();
			x = x + 1;
			miMapa.getCelda(x, y).agregarEntidad(this);
			miCelda = miMapa.getCelda(x, y);
			imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
		} else {
			miMapa.getCelda(x + 1, y).getEntidad().aceptar(miVisitor);
			miMapa.getCelda(x, y).eliminarEntidad();
		}

	}

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
			mover();
		}
	}
}
