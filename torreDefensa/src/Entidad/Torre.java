package Entidad;

import Disparo.DisparoAliado;
import Logica.Logica;
import Mapa.Celda;
import Mapa.Mapa;

public abstract class Torre extends Entidad {

	protected DisparoAliado disparo;
	protected int alcance;
	protected Logica logica;


	public Torre(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
	}


}