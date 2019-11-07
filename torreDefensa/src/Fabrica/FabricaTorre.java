package Fabrica;

import Entidad.TorreArena;
import Entidad.TorreBasica;
import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;

public class FabricaTorre extends FabricaEntidad{
	
	public Torre crearTorreArena(Mapa miMapa,Celda miCelda) {
		return new TorreArena(miMapa,miCelda);
	}
	
	public Torre crearTorreBasica(Mapa miMapa, Celda miCelda) {
		return new TorreBasica(miMapa,miCelda);
	}
	
}
