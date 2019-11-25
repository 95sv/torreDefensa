package Disparo;

import Entidad.Enemigo;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public abstract class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(Mapa miMapa, Celda miCelda, int golpe, int velocidad) {
		super(miMapa, miCelda, golpe, velocidad);
	}

	public void morir() {
		miMapa.getLogica().eliminarEntidad(this);
	}

	public void mover() {
		int x = miCelda.getX();
		int y = miCelda.getY();

		if (x < 9 && x >= 1) {
			x = x + 1;
			Celda nuevaCelda = miMapa.getCelda(x, y);
			if (nuevaCelda.getEntidad() != null) {
				miCelda.eliminarEntidad();
				setCelda(nuevaCelda);
				nuevaCelda.agregarEntidad(this);

			} else {
				miCelda.eliminarEntidad();
				setCelda(nuevaCelda);
				nuevaCelda.agregarEntidad(this);
			}
		} else {
			miCelda.eliminarEntidad();
			this.morir();
		}

	}

	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}
}