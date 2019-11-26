package Entidad;

import Disparo.DisparoAliado;
import Logica.Logica;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Torre extends Personaje {

	protected DisparoAliado disparo;
	protected Logica logica;
	protected int alcance;
	protected int precio;
	protected int tiempo = 10;


	public Torre(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
		logica = miMapa.getLogica();
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public void ejecutar() {
		if(tiempo == 10) {
			disparar();
		}
		tiempo--;
		if(tiempo == 0) {
			tiempo = 10;
		}
	}
	
	public abstract DisparoAliado crearDisparo();
	
	public void disparar() {
		logica.agregarEntidad(crearDisparo(),miCelda);
	}
}