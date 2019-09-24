package Objeto;

import javax.swing.ImageIcon;

import Mapa.Celda;

public class Agua extends Objeto {
	
	public Agua(Celda celda) {
		super(celda);
		imagen = new ImageIcon(getClass().getResource("/Recursos/Objetos/lake.png"));
	}
}
