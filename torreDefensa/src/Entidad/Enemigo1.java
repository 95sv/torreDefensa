package Entidad;

import javax.swing.ImageIcon;

import Mapa.Celda;

public class Enemigo1 extends Enemigo {

	public Enemigo1(Celda celda) {
		super(celda);
		imagen = new ImageIcon(getClass().getResource("/Recursos/Enemigos/Enemigo2/Attack__004.png"));
	}	
}