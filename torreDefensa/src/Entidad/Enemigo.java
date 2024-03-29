package Entidad;

import java.util.Random;

import javax.swing.Icon;
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
	protected Icon imagenMover;
	protected Icon imagenAtacar;
	protected boolean seguirMoviendo;

	public Enemigo(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		this.logica = miMapa.getLogica();
		seguirMoviendo = true;
		
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}

	public abstract void disparar(Entidad e);

	public void morir() {
		Random rnd = new Random();
		int random = rnd.nextInt(100);
		logica.getMapa().getNivel().eliminarEnemigo();
		logica.agregarPuntaje(puntos);
		/*
		 * Si muere un enemigo, hay una probabilidad de 0.20 de que aparezca un PowerUP.
		 */
		if (random < 20) {
			logica.seleccionarPowerUp(miCelda);
		}
		logica.eliminarEntidad(this);

	}
	
	public int getPuntos() {
		return puntos;
	}

	public void seguirMoviendo(boolean seguirMoviendo) {
		this.seguirMoviendo = seguirMoviendo;
	}
}