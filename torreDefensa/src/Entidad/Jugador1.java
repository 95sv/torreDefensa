package Entidad;

import javax.swing.ImageIcon;

import Mapa.Celda;

public class Jugador1 extends Jugador{

	public Jugador1(Celda celda) {
		super(celda);
		imagen = new ImageIcon(getClass().getResource("/Recursos/Enemigos/Enemigo1/Walk (2).png"));
	}

}
