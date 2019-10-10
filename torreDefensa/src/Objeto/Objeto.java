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
	
	public Objeto(Celda celda,Mapa mapa) {
		super(celda,mapa);
	}

	
	public void morir() {}
	
	public void mover() {		
	}


	@Override
	public boolean aceptar(Visitor visitor) {
		return true;
	}


}