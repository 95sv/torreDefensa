package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorRoca;

public class Roca extends Objeto{

	public Roca(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Objetos/rock.png")));
		miVisitor = new VisitorRoca(this);
	}
	
	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}
}
