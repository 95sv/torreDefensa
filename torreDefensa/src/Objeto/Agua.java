package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorAgua;

public class Agua extends ObjetoTemporal {
	
	public Agua(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
		precio = 0;
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Objetos/lake.png")));
		miVisitor = new VisitorAgua(this);
	}
	
	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}
}
