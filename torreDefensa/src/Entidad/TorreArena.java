package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class TorreArena extends Torre{

	public TorreArena(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado2.png")));
	}
	
	public void morir() {
	}

	public boolean mover() {
		return false;
	}
	
	public boolean aceptar(Visitor visitor) {
		return visitor.visit(this);
	}

	
}