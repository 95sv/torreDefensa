package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorFuego;

public class Fuego extends ObjetoTemporal{

	public Fuego(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		golpe = 50;
		precio = 40;
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Objetos/fire.gif")));
		miVisitor = new VisitorFuego(this);
	}
	
	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}

}
