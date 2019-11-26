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

	public void mover() {
		super.mover();
	}

	public int getPuntos() {
		return puntos;
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

}
