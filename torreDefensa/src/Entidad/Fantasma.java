package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.VisitorEnemigo;

public class Fantasma extends Enemigo {

	public Fantasma(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Enemigos/caminante6.gif")));
		miVisitor = new VisitorEnemigo(this);
		vida = 100;
		puntos = 50;
	}

		
	
	public boolean mover() {
		int x = miCelda.getX();
		int y = miCelda.getY();

		if (x >= 9) {
			logica.perder();
		} else {
			if ((x < 9 && x >= 0)) {
				x = x + 1;
				Celda nuevaCelda = miMapa.getCelda(x, y);
				if (nuevaCelda.getEntidad() != null && nuevaCelda.getEntidad().aceptar(miVisitor)) {
					return false;
				} else {
					miCelda.eliminarEntidad();
					setCelda(nuevaCelda);
					nuevaCelda.agregarEntidad(this);
					return true;
				}
			}
		}
		return false;
	}

	public int getPuntos() {
		return puntos;
	}

	public boolean estoyParado() {
		return false;
	}


	public void dispare(boolean b) {	}

	

	
}
