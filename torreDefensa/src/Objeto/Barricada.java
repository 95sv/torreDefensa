package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorBarricada;

public class Barricada extends ObjetoVida {

	public Barricada(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		precio = 20;
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Objetos/barricada.png")));
		miVisitor = new VisitorBarricada(this);
	}
	
	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}

}
