package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.VisitorEnemigo;

public class Hielo extends Enemigo {

	public Hielo(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("Recursos/Enemigos/a_caminante1.gif")));
		miVisitor = new VisitorEnemigo(this);
		vida = 150;
		puntos = 75;
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
