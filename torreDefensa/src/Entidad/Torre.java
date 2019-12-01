package Entidad;

import Disparo.DisparoAliado;
import Logica.Logica;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorTorre;

public abstract class Torre extends Personaje {

	protected DisparoAliado disparo;
	protected Logica logica;
	protected int alcance;
	protected int precio;
	protected int tiempo = 6;

	public Torre(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
		logica = miMapa.getLogica();
		miVisitor = new VisitorTorre(this);
	}
	
	public Logica getLogica() {
		return logica;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public void ejecutar() {
		if(tiempo == 6) {
			disparar();
		}
		tiempo--;
		if(tiempo == 0) {
			tiempo = 6;
		}
	}
	
	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}
	
	public void mover() {}
	
	public abstract DisparoAliado crearDisparo();
	
	public void disparar() {
		Celda celdaAux= miMapa.getCelda(x-1,y);
		//problema de concurrencia 
		logica.agregarEntidad(crearDisparo(),celdaAux);
	}
}