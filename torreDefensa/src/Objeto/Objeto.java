package Objeto;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Entidad.Enemigo;
import Entidad.Entidad;
import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class Objeto extends Entidad{
	
	public Objeto(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
	}

	
	public void morir() {}
	
	public void mover() {		
	}


	@Override
	public boolean aceptar(Visitor visitor) {
		// TODO Auto-generated method stub
		return true;
	}


}