package Entidad;

import javax.swing.ImageIcon;
import Mapa.Celda;

public abstract class Entidad {

	protected Celda miCelda;
	protected int x;
	protected int y;
	//protected EntidadGrafica miGrafica
	/*
	 * 	tiene ImageIcon =../Enemigo1..
	 * 
	 * getSprite(): ImageIcon
	 * 
	 * mover() // lo hace graficamente.
	 * **/
	protected ImageIcon imagen;

	public void setCelda(Celda c) {
		miCelda = c;
	}

	public Celda getCelda() {
		return miCelda;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon i) {
		imagen = i;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

}
