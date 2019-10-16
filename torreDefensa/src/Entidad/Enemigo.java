package Entidad;


import Disparo.DisparoEnemigo;
import Logica.Logica;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public abstract class Enemigo extends Entidad {
	
	protected DisparoEnemigo disparo;
	protected int alcance;
	protected Logica logica;
	
	public Enemigo(Celda miCelda, Mapa miMapa) {
		super(miMapa,miCelda);
		this.logica = miMapa.getLogica();
	}
	
	public abstract void mover();

	public void morir() {
		logica.eliminarEntidad(this);
	}
	

	public boolean aceptar(Visitor visitor) {
		return visitor.visit(this);
	}
	

}