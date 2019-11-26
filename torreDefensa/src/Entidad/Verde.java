package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.VisitorEnemigo;

public class Verde extends Enemigo {

	public Verde(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Enemigos/a_caminante5.gif")));
		miVisitor = new VisitorEnemigo(this);
		vida = 50;
		puntos = 100;
	}

	public void mover() {
		super.mover();
	}

	public int getPuntos() {
		return puntos;
	}

	@Override
	public void disparar() {
		
	}

}