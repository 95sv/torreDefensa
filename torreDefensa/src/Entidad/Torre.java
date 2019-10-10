package Entidad;

import Logica.Logica;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Torre extends Entidad {

	protected int disparo;
	protected int alcance;
	protected Logica logica;
	protected Mapa mapa;

	public Torre(Celda celda,Mapa mapa) {
		super(celda,mapa);
	}


}