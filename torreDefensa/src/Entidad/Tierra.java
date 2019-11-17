package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.VisitorEnemigo;

public class Tierra extends Enemigo {

	protected boolean estoyParado;
	protected boolean dispare;

	public Tierra(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Enemigos/caminante2.gif")));
		miVisitor = new VisitorEnemigo(this);
		vida = 100;
		dispare = false;
	}

	public boolean mover() {
		int x = miCelda.getX();
		int y = miCelda.getY();

		if (x >= 9) {
			logica.perder();
		} else {

			if (x < 9 && x >= 0) {
				if (!hayTorre(x + 4, y)) {
					dispare = false;
					setEstoyParado(false);
					System.out.println("estoy parado? " + estoyParado);
					x = x + 1;
					this.setX(x);
					// System.out.println("SETIE AL TIERRA EN "+this.getX());
					Celda nuevaCelda = miMapa.getCelda(x, y);

					if (nuevaCelda.getEntidad() != null && nuevaCelda.getEntidad().aceptar(miVisitor)) {
						return false;
					} else {
						miCelda.eliminarEntidad();
						setCelda(nuevaCelda);
						nuevaCelda.agregarEntidad(this);
						return true;
					}

				} else {// si hay una torre hago:
					setEstoyParado(true);
					System.out.println("Estoy Parado(moverTierra) " + estoyParado);
					System.out.println("Dispare 1 " + dispare);

					if (estoyParado == true) {// dispara unicamente cuando esta parado
						if (!dispare) {// pregunto si dispare porque solo puede haber un disparo por enemigo tierra,
										// hasta que no se elimine no puede volver a disparar.
							logica.agregarDisparoEnemigo(this);
							System.out.println("estoy disparando");
							dispare = true;
							System.out.println("Dispare " + dispare);
						}

					}
				} // cierre del else
			}
			return false;
		}
		return false;
	}

	public boolean estoyParado() {
		return estoyParado;
	}

	public void setEstoyParado(boolean b) {
		estoyParado = b;
	}

	public void dispare(boolean b) {
		dispare = b;
	}

	public boolean dispare() {
		return dispare;
	}

	private boolean hayTorre(int x, int y) {
		if (x <= 9) {
			for (Torre t : logica.getMisTorres()) {
				if (t.equals(logica.getEntidad(x, y)))
					return true;
			}
		}
		return false;
	}

}
