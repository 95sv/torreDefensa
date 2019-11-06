package Fabrica;

import Entidad.Verde;
import Mapa.Celda;
import Mapa.Mapa;

public class FabricaEnemigo extends FabricaEntidad{
	
	public Verde crearVerde(Celda miCelda,Mapa miMapa) {
		return new Verde(miMapa,miCelda);
	}
}
