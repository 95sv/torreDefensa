package Entidad;

import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public abstract class Entidad {

	protected Celda miCelda;
	protected JLabel imagen;
	protected Mapa miMapa;
	protected Visitor miVisitor;
	protected int x;
	protected int y;
	protected int precio;
	protected int golpe;

	public Entidad(Mapa mapa, Celda celda) {
		this.x = celda.getX();
		this.y = celda.getY();
		miCelda = celda;
		miMapa = mapa;
	}

	public void setCelda(Celda c) {
		miCelda = c;
	}

	public Celda getCelda() {
		return miCelda;
	}

	public JLabel getImagen() {
		return imagen;
	}

	public void setImagen(JLabel i) {
		imagen = i;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Visitor getVisitor() {
		return miVisitor;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public int getGolpe() {
		return golpe;
	}
	
	public abstract boolean mover();

	public abstract void morir();

	public abstract boolean aceptar(Visitor visitor);

}