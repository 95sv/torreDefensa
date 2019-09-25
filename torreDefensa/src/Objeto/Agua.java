package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;

public class Agua extends Objeto {
	
	public Agua(Celda celda) {
		super(celda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Objetos/lake.png")));
	}
}
