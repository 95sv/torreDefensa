package Entidad;

import Logica.Logica;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Jugador extends Entidad{
	
	protected int disparo;
	protected int alcance;
	protected int x;
	protected int y;
	protected Logica logica;
	protected Mapa mapa;
	
	public Jugador(Celda celda) {
		this.x = celda.getX();
		this.y = celda.getY();
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
