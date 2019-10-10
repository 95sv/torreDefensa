package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Celda;
import Mapa.Mapa;

public class Enemigo1 extends Enemigo {

	public Enemigo1(Celda celda, Mapa mapa) {
		super(celda, mapa);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosLosSimpson/bart64.png")));
	}

	public void mover() {
		int x = miCelda.getX();
		int y = miCelda.getY();

		if ((x < 9 && x >= 0)) {
			x = x + 1;
			miCelda.eliminarEntidad();
			Celda nuevaCelda = miMapa.getCelda(x, y);
			setCelda(nuevaCelda);
			nuevaCelda.agregarEntidad(this);
		}
	}
}