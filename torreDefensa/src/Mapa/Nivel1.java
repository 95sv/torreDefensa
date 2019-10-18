package Mapa;

import java.util.Random;

import Objeto.Agua;
import Objeto.Roca;

public class Nivel1 extends Nivel {

	public Nivel1(Mapa mapa) {
		super(mapa);
		cargarNivel();
	}
	
	public void run() {
		int cantEnemigos = 10;
		while(cantEnemigos > 0) {
			mapa.getLogica().agregarEnemigo();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void cargarOleada() {
		
	}
	public void cargarNivel() {
		System.out.println("NIVEL 1 ");
		Random numeroRandom = new Random();
		int aguas = 0;
		int rocas = 0;
		int i, j;

		while (rocas < 4) {
			// Genero rocas en columnas distintas al princio y final del mapa.
			i = numeroRandom.nextInt(5) + 2;
			j = numeroRandom.nextInt(5);
			if (mapa.getCelda(i, j).getEntidad() == null) {
				rocas++;
				Roca roca = new Roca(mapa,mapa.getCelda(i, j));
				mapa.getCelda(i, j).agregarEntidad(roca);
				roca.setCelda(mapa.getCelda(i, j));
				mapa.getLogica().getGrafica().graficarEntidad(roca);
			}
		}

		while (aguas < 5) {
			// Genero aguas en columnas distintas al princio y final del mapa.
			i = numeroRandom.nextInt(5) + 2; // Entre 2 y 6
			j = numeroRandom.nextInt(5);
			if (mapa.getCelda(i, j).getEntidad() == null) {
				aguas++;
				Agua agua = new Agua(mapa,mapa.getCelda(i, j));
				mapa.getCelda(i, j).agregarEntidad(agua);
				agua.setCelda(mapa.getCelda(i, j));
				mapa.getLogica().getGrafica().graficarEntidad(agua);
			}
		}
	}

}