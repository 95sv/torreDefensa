package Mapa;

import java.util.LinkedList;

import Entidad.Entidad;

public class Celda {
	protected int x;
	protected int y;
	protected Mapa mapa;
	protected LinkedList<Entidad> entidades;
	protected int cantEntidades;
	
	public Celda(Mapa mapa,int x, int y) {
		this.mapa = mapa;
		entidades = new LinkedList<Entidad>();
		this.x = x;
		this.y = y;
		cantEntidades=0;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int cantEntidades() {
		return cantEntidades;
	}
	
	public void agregarEntidad(Entidad e) {
	  entidades.add(e);
	  cantEntidades++;
	}
	
	public void eliminarEntidad(Entidad entidad) {
		entidades.remove(entidad);
		cantEntidades--;
	}
	
	public LinkedList<Entidad> getEntidades(){
		return entidades;
	}
	
	public Entidad[] getArregloEntidades(){
	
	Entidad [] entidadesArreglo = new Entidad[100];
	int pos=0;
	 for(Entidad e: entidades) {
	  entidadesArreglo[pos]=e;
	  pos++;
	 }
	return entidadesArreglo;
	}
		
		

}
