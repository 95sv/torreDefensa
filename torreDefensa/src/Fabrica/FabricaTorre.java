package Fabrica;

import Entidad.BarMoe;
import Entidad.CasaSimpson;
import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;

public class FabricaTorre extends FabricaEntidad{
	
	public Torre crearBarMoe(Mapa miMapa,Celda miCelda) {
		return new BarMoe(miMapa,miCelda);
	}
	
	public Torre crearCasaSimpson(Mapa miMapa, Celda miCelda) {
		return new CasaSimpson(miMapa,miCelda);
	}
	
}
