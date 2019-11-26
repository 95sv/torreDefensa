package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.VisitorEnemigo;

public class Corona extends EnemigoCombate {

	public Corona(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Enemigos/caminante4.gif")));
		miVisitor = new VisitorEnemigo(this);
		vida = 100;
		puntos = 50;
	}


	public int getPuntos() {
		return puntos;
	}

	@Override
	public void disparar() {
	}

}
