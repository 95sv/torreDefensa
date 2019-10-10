package Entidad;

import javax.swing.JLabel;

import Disparo.DisparoEnemigo;
import Disparo.DisparoBasico;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Entidad {

	protected Celda miCelda;
	protected JLabel imagen;
	protected int x;
	protected int y;
	protected Mapa miMapa;

	public Entidad(Celda celda, Mapa mapa) {
		this.x = celda.getX();
		this.y = celda.getY();
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
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}


	public abstract void mover();
	
	public abstract void visit();

	public abstract boolean visit(DisparoBasico d);

	public abstract boolean visit(DisparoEnemigo d);

}
