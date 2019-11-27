package Mapa;

import java.util.Random;

import Entidad.Verde;
import Entidad.Enemigo;
import Entidad.Entidad;
import Entidad.Magma;
import Entidad.Tierra;
import Objeto.Agua;
import Objeto.Roca;

public class Nivel1 extends Nivel {

	public Nivel1(Mapa mapa) {
		super(mapa);
		cargarNivel();
	}

	public void run() {
		int cantEnemigos = 7;
		while (cantEnemigos > 0) {
			cargarOleada();
			cantEnemigos--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void cargarOleada() {
		Random random = new Random();
		int enemigoRandom = random.nextInt(100);
		int celdaRandom = random.nextInt(5);
		Celda celda = mapa.getCelda(0, celdaRandom);
		Entidad e = null;
	
		if(enemigoRandom < 20) {
			e = new Verde(mapa,celda);
			mapa.getLogica().agregarEntidad(e, celda);
		}
		else if(enemigoRandom < 40) {
			//e = new Verde(mapa,celda);
			//mapa.getLogica().agregarEntidad(e, celda);
			e = new Tierra(mapa,celda);
			mapa.getLogica().agregarEntidad(e, celda);
		}
		else if(enemigoRandom < 60) {
			//e = new Verde(mapa,celda);
			//mapa.getLogica().agregarEntidad(e, celda);
			e = new Magma(mapa,celda);
			mapa.getLogica().agregarEntidad(e, celda);
		}

	}

	public void cargarNivel() {
		Random numeroRandom = new Random();
		int aguas = 0;
		int rocas = 0;
		int i, j;
		Entidad e = null;

		while (rocas < 3) {
			// Genero rocas en columnas distintas al princio y final del mapa.
			i = numeroRandom.nextInt(5) + 2;
			j = numeroRandom.nextInt(5);
			if (mapa.getCelda(i, j).getEntidad() == null) {
				rocas++;
				e = new Roca(mapa,mapa.getCelda(i, j));
				mapa.getLogica().agregarEntidad(e, mapa.getCelda(i, j));
			}
		}

		while (aguas < 3) {
			// Genero aguas en columnas distintas al princio y final del mapa.
			i = numeroRandom.nextInt(5) + 2; // Entre 2 y 6
			j = numeroRandom.nextInt(5);
			if (mapa.getCelda(i, j).getEntidad() == null) {
				aguas++;
				e = new Agua(mapa,mapa.getCelda(i, j));
				mapa.getLogica().agregarEntidad(e, mapa.getCelda(i, j));
			}
		}
	}

}