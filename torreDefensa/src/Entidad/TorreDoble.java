package Entidad;

import Disparo.DisparoAliado;
import Disparo.DisparoBasico;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class TorreDoble extends Torre {

	public TorreDoble(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mover() {}

	@Override
	public void morir() {}

	@Override
	public void aceptar(Visitor visitor) {
	}

	@Override
	public DisparoAliado crearDisparo() {
		return new DisparoBasico(miMapa,miCelda,50,50);
	}

}