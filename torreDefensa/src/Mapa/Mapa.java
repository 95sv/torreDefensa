package Mapa;

import java.util.LinkedList;

import Entidad.Enemigo;
import Entidad.Entidad;
import Logica.Logica;

public class Mapa {

	protected Celda[][] mapa;
	protected int filas, columnas;
	protected Nivel siguienteNivel;
	protected Logica logica;
	protected LinkedList<Enemigo> misEnemigos;

	public Mapa(Logica logica) {
		filas = 6;
		columnas = 10;
		mapa = new Celda[10][6];
		this.logica = logica;
		misEnemigos = new LinkedList<Enemigo>();

		for (int i = 0; i < columnas; i++) {
			for (int j = 0; j < filas; j++) {
				mapa[i][j] = new Celda(this, i, j);
			}
		}

		siguienteNivel = new Nivel1(this);
		siguienteNivel.start();

	}
	
	public Logica getLogica() {
		return logica;
	}

	public void cargarNivel(Nivel nivel) {
		this.siguienteNivel = new Nivel1(this);
	}

	public void setNivel(Nivel nivel) {
		this.siguienteNivel = nivel;
	}

	public Nivel getNivel() {
		return this.siguienteNivel;
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}
	
	/*
	 * 					Parametros de la celda : ( [0..9], [0..5]).
	 */
	
	public Celda getCelda(int x, int y) {
		if ((x < this.columnas) && (x >= 0) && (y < this.filas) && (y >= 0))
			return this.mapa[x][y];
		return null;
	}

	public Entidad getEntidad(int x, int y) {
		return mapa[x][y].getEntidad();
	}

}