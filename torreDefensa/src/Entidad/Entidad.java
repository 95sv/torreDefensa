package Entidad;

import javax.swing.JLabel;

import Disparo.DisparoEnemigo;
import Disparo.DisparoAliado;
import Mapa.Celda;

public abstract class Entidad {

	protected Celda miCelda;
	protected int x;
	protected int y;
	protected JLabel imagen;
	//protected EntidadGrafica miGrafica
	
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
	
	public abstract void visit();
	
	public abstract boolean visit(DisparoAliado d);
	
	public abstract boolean visit(DisparoEnemigo d);
	


}
