package Mapa;

import java.util.Random;

import Objeto.Agua;
import Objeto.Roca;

public class Nivel1 extends Nivel {

	/*
	 * public Nivel siguienteNivel(Mapa mapa){ mapa.setState(this); }
	 */

	public Nivel1(Mapa mapa) {
		super(mapa);
		cargarNivel();
	}

	public void cargarNivel() {
		System.out.println("NIVEL 1 ");
		int numeroFilas = mapa.getFilas();
		int numeroColumnas = mapa.getColumnas();
		Random numeroRandom = new Random();
		int aguas = 0;
		int rocas = 0;
		int i, j;

		while (rocas < 4) {
			// Genero rocas en columnas distintas al princio y final del mapa.
			i = numeroRandom.nextInt(6) + 2;
			j = numeroRandom.nextInt(6);
			if (mapa.getCelda(i, j).getEntidad() == null) {
				rocas++;
				Roca roca = new Roca(mapa.getCelda(i, j));
				mapa.getCelda(i, j).agregarEntidad(roca);
				roca.setCelda(mapa.getCelda(i, j));
				mapa.getLogica().getGrafica().graficarEntidad(roca);
			}
		}

		while (aguas < 5) {
			// Genero aguas en columnas distintas al princio y final del mapa.
			i = numeroRandom.nextInt(6) + 2; // Entre 2 y 7
			j = numeroRandom.nextInt(6);
			if (mapa.getCelda(i, j).getEntidad() == null) {
				aguas++;
				Agua agua = new Agua(mapa.getCelda(i, j));
				mapa.getCelda(i, j).agregarEntidad(agua);
				agua.setCelda(mapa.getCelda(i, j));
				mapa.getLogica().getGrafica().graficarEntidad(agua);
			}
		}
	}

}
