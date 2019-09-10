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
	protected Celda celdaAnterior;
	
	public Jugador(int x, int y) {
		this.x = x;
		this.y = y;
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
