package Fabrica;

import Entidad.Bart;
import Mapa.Celda;
import Mapa.Mapa;

public class FabricaEnemigo extends FabricaEntidad{
	
	public Bart crearBart(Celda miCelda,Mapa miMapa) {
		return new Bart(miMapa,miCelda);
	}
}
