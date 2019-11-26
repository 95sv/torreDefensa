package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.VisitorEnemigo;

public class Tierra extends Enemigo {

	public Tierra(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Enemigos/caminante2.gif")));
		miVisitor = new VisitorEnemigo(this);
		vida = 100;
		puntos = 100;
	}

	@Override
	public int getPuntos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void mover() {
		super.mover();
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

}
