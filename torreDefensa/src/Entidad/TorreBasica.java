package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class TorreBasica extends Torre {

	public TorreBasica(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado1.png")));
	}

	public void crearDisparo() {
		miMapa.getLogica().crearHiloDisparo();
	}
	
	public boolean mover() {
		return false;
	}

	public void morir() {
	}

	public boolean aceptar(Visitor visitor) {
		return visitor.visit(this);
	}
	
	
}
