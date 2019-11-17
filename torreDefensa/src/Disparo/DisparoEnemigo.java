package Disparo;

import Entidad.Enemigo;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public abstract class DisparoEnemigo extends Disparo {

	protected Enemigo miEnemigo;

	public DisparoEnemigo(Mapa miMapa, Celda miCelda, Enemigo miEnemigo, int dano, int velocidad) {
		super(miMapa, miCelda, dano, velocidad);
		this.miEnemigo = miEnemigo;
	}

	public void morir() {
		miMapa.getLogica().eliminarDisparo(this);
		System.out.println("Entre al eliminar disparo");
	}

	public boolean mover() {
		int x = miCelda.getX();
		int y = miCelda.getY();

		if ((x < 9 && x >= 1) && miEnemigo.estoyParado()) {
			x = x + 1;
			// System.out.println("DISPARO MOVIO : " + x);
			Celda nuevaCelda = miMapa.getCelda(x, y);
			if (nuevaCelda.getEntidad() != null && nuevaCelda.getEntidad().aceptar(miVisitor)) {
				miCelda.eliminarEntidad();
				nuevaCelda = miMapa.getCelda(miEnemigo.getX() + 1, miEnemigo.getY());// esta es la linea del reinicio
																						// una vez que entro al visitor
				setCelda(nuevaCelda);
				nuevaCelda.agregarEntidad(this);
				return true;
				// ACA NO TENDRIA QUE SETERALO TENDRIA QUE ELIMINARLO NOMAS PERO CUADNO LO HAGO
				// SE QUEDA EL DISPARO EN EL ULTIMO LUGAR QUE ESTUVO

			} else {

				miCelda.eliminarEntidad();
				setCelda(nuevaCelda);
				nuevaCelda.agregarEntidad(this);
				return true;

			}
		} else {
			miCelda.eliminarEntidad();
			this.morir();
			System.out.println("ELIMINE EL DISPARO");
			/*
			 * if(miEnemigo.estoyParado()) {//si estoy parado sigo disparando sino no Celda
			 * celdaReinicio = miMapa.getCelda(miEnemigo.getX()+1,miEnemigo.getY());
			 * setCelda(celdaReinicio); celdaReinicio.agregarEntidad(this); }
			 */
			return true;
		}

	}

	public boolean aceptar(Visitor visitor) {
		return visitor.visit(this);
	}

	public void dispareMiEnemigo(boolean b) {
		miEnemigo.dispare(false);
	}

}
