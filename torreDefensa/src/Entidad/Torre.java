package Entidad;

import Disparo.DisparoAliado;
import Logica.Logica;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Torre extends Entidad {

	protected DisparoAliado disparo;
	protected Logica logica;
	protected int alcance;


	public Torre(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
	}


}