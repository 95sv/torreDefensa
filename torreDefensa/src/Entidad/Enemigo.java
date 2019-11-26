package Entidad;

import java.util.Random;

import Disparo.DisparoEnemigo;
import Logica.Logica;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public abstract class Enemigo extends Personaje {

	protected DisparoEnemigo disparo;
	protected Logica logica;
	protected int alcance;
	protected int puntos;

	public Enemigo(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		this.logica = miMapa.getLogica();
	}


	public void morir() {
		Random rnd = new Random();
		int random = rnd.nextInt(100);
		/*
		 * Si muere un enemigo, hay una probabilidad de 0.20 de que aparezca un PowerUP.
		 */
		if (random < 20) {
			logica.seleccionarPowerUp(miCelda);
		}
		logica.eliminarEntidad(this);

	}
	
	public void mover() {
		System.out.println("X "+ x);
		if(x==9) {
			logica.perder();
		}
		else if(miMapa.getCelda(x+1,y).getEntidad()==null) {
			miMapa.getCelda(x, y).eliminarEntidad();
			x = x + 1;
			miMapa.getCelda(x, y).agregarEntidad(this);
			miCelda = miMapa.getCelda(x, y);
			imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL,PIXEL,PIXEL);
		}
		else {
			miMapa.getCelda(x + 1, y).getEntidad().aceptar(miVisitor);
			miMapa.getCelda(x, y).eliminarEntidad();
		}
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}

	public void recibirDano(int dano) {
		vida = vida - dano;
		if (vida <= 0) {
			morir();
		}

	}

	public abstract int getPuntos();

}