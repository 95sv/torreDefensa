package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparo.DisparoEnemigo;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.VisitorEnemigo;

public class Magma extends EnemigoLejano{

	public Magma(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Enemigos/caminante3.gif")));
		miVisitor = new VisitorEnemigo(this);
		vida = 250;
		puntos = 200;
	}


	@Override
	public int getPuntos() {
		return puntos;
	}

	@Override
	public void disparar() {
		
	}

	@Override
	public DisparoEnemigo crearDisparo() {
		return null;
	}

}