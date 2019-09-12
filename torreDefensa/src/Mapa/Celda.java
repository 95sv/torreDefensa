package Mapa;

import Entidad.Entidad;

public class Celda {
	protected int x;
	protected int y;
	protected Mapa mapa;
	protected Entidad entidad;
	
	public Celda(Mapa mapa,int x, int y) {
		this.mapa = mapa;
		entidad = null;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void agregarEntidad(Entidad e) {
		this.entidad = e;
	}
	
	public void eliminarEntidad() {
		this.entidad = null;
	}
	
	public Entidad getEntidad() {
		return entidad;
	}
}
