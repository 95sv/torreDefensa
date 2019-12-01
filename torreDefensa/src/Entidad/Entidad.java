package Entidad;

import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public abstract class Entidad {

	public static final int PIXEL = 64;
	protected Celda miCelda;
	protected JLabel imagen;
	protected Mapa miMapa;
	protected Visitor miVisitor;
	protected int x;
	protected int y;
	protected int golpe;
	protected int vida;

	public Entidad(Mapa mapa, Celda celda) {
		this.x = celda.getX();
		this.y = celda.getY();
		miCelda = celda;
		miMapa = mapa;
		vida = 1000;
	}

	public void recibirGolpe(int golpe) {
		vida = vida - golpe;
		if (vida <= 0) {
			morir();
		}
	}

	public void morir() {
		miMapa.getLogica().eliminarEntidad(this);
	}

	public abstract void aceptar(Visitor visitor);

	public abstract void ejecutar();

	public abstract void mover();

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

	public void setGolpe(int golpe) {
		this.golpe = golpe;
	}

	public int getGolpe() {
		return golpe;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

}