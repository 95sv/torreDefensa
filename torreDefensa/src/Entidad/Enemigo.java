package Entidad;


import java.util.Random;

import Disparo.DisparoEnemigo;
import Logica.Logica;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public abstract class Enemigo extends Entidad {
	
	protected DisparoEnemigo disparo;
	protected int alcance;
	protected Logica logica;
	protected int vida=100;
	
	
	public Enemigo(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
		this.logica = miMapa.getLogica();
	}
	
	public abstract boolean mover();

	public void morir() {
		Random rnd = new Random();
		int random = rnd.nextInt(100);
		/*
		 *  Si muere un enemigo, hay una probabilidad de 0.20 de que aparezca un PowerUP.
		 */
		logica.eliminarEnemigo(this);
		logica.seleccionarPowerUp(miCelda);
	}
	

	public boolean aceptar(Visitor visitor) {
		return visitor.visit(this);
	}
	
	public void recibirDano(int dano) {
		vida= vida-dano;
		if(vida<=0) {
			morir();	
		}
		
	}
	

}