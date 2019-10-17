package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.VisitorEnemigo;

public class Enemigo1 extends Enemigo {

	public Enemigo1(Celda miCelda, Mapa miMapa) {
		super(miCelda, miMapa);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosLosSimpson/bart64.png")));
		miVisitor = new VisitorEnemigo(this);
	}

	public void mover() {
		int x = miCelda.getX();
		int y = miCelda.getY();

		if ((x < 9 && x >= 0)) {
			x = x + 1;
			Celda nuevaCelda = miMapa.getCelda(x, y);
			if(nuevaCelda.getEntidad() != null && nuevaCelda.getEntidad().aceptar(miVisitor)) {
				
			}
			else {
				miCelda.eliminarEntidad();
				setCelda(nuevaCelda);
				nuevaCelda.agregarEntidad(this);
			}
		}
	}

	

}