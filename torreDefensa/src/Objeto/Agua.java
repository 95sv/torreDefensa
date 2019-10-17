package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorAgua;

public class Agua extends Objeto {
	
	public Agua(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Objetos/lake.png")));
		miVisitor = new VisitorAgua(this);
	}
	
	public boolean aceptar(Visitor visitor) {
		return visitor.visit(this);
	}
}
