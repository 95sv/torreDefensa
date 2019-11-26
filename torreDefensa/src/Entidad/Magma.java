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

	public void mover() {
		super.mover();
	}

	@Override
	public int getPuntos() {
		return puntos;
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

}