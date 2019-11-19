package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.VisitorEnemigo;

public class Magma extends Enemigo {

	public Magma(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Enemigos/caminante3.gif")));
		miVisitor = new VisitorEnemigo(this);
		vida = 250;
		puntos = 200;
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

	@Override
	public int getPuntos() {
		return puntos;
	}

	@Override
	public boolean estoyParado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dispare(boolean b) { }

	
	
	
}
