package Mapa;

import java.util.Random;

import Entidad.Corona;
import Entidad.Entidad;
import Entidad.Fantasma;
import Entidad.Hielo;
import Entidad.Magma;
import Entidad.Tierra;
import Entidad.Verde;
import Objeto.Agua;
import Objeto.Fuego;
import Objeto.Roca;

public class Nivel2 extends Nivel{
	protected int enemigosCreados = 0;
	
	public Nivel2(Mapa mapa) {
		super(mapa);
		cargarNivel();
		nivel = 2;
		perder = false;
	}
	
	public void perder() {
		perder = true;
	}
	
	public void run() {
		int cantEnemigos = 0;
		int oleada = 1;

		while (!perder && enemigosCreados<10) {

			try {
				Thread.sleep(3000 / oleada);
				cantEnemigos += 3000 / oleada / 1000;
				cargarOleada();
				if (cantEnemigos >= 10) {
					Thread.sleep(10000);
					cantEnemigos = 0;
					oleada++;
					if (oleada > 3) {
						mapa.getLogica().perder();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(!perder) {
			mapa.getLogica().ganar();
		}
		else {
			mapa.getLogica().perder();
		}
	}
	
	public void cargarOleada() {

		Random random = new Random();
		int enemigoRandom = random.nextInt(100);
		int celdaRandom = random.nextInt(5);
		Celda celda = mapa.getCelda(0, celdaRandom);
		Entidad e = null;

		if (enemigoRandom < 10) {
			e = new Verde(mapa, celda);
			mapa.getLogica().agregarEntidad(e, celda);
		} else if (enemigoRandom < 30) {
			e = new Tierra(mapa, celda);
			mapa.getLogica().agregarEntidad(e, celda);
		} else if (enemigoRandom < 50) {
			e = new Magma(mapa, celda);
			mapa.getLogica().agregarEntidad(e, celda);
		} else if(enemigoRandom < 70) {
			e = new Hielo(mapa,celda);
			mapa.getLogica().agregarEntidad(e, celda);
		} else if(enemigoRandom < 90) {
			e = new Fantasma(mapa,celda);
			mapa.getLogica().agregarEntidad(e, celda);
		} else {
			e = new Corona(mapa,celda);
			mapa.getLogica().agregarEntidad(e, celda);
		}

	}

	
	public void cargarNivel() {
		Random numeroRandom = new Random();
		int aguas = 0;
		int rocas = 0;
		int fuegos = 0;
		int barricadas = 0;
		int i, j;
		Entidad e = null;

		while (rocas < 2) {
			// Genero rocas en columnas distintas al princio y final del mapa.
			i = numeroRandom.nextInt(5) + 2;
			j = numeroRandom.nextInt(5);
			if (mapa.getCelda(i, j).cantEntidades() == 0){
				rocas++;
				e = new Roca(mapa, mapa.getCelda(i, j));
				mapa.getLogica().agregarEntidad(e, mapa.getCelda(i, j));
			}
		}

		while (aguas < 2) {
			// Genero aguas en columnas distintas al princio y final del mapa.
			i = numeroRandom.nextInt(5) + 2; // Entre 2 y 6
			j = numeroRandom.nextInt(5);
			if(mapa.getCelda(i, j).cantEntidades() == 0) {
				aguas++;
				e = new Agua(mapa, mapa.getCelda(i, j));
				mapa.getLogica().agregarEntidad(e, mapa.getCelda(i, j));
			}
		}
		
		while(fuegos < 2) {
			i = numeroRandom.nextInt(5) + 2; // Entre 2 y 6
			j = numeroRandom.nextInt(5);
			if (mapa.getCelda(i, j).cantEntidades() == 0) {
				fuegos++;
				e = new Fuego(mapa, mapa.getCelda(i, j));
				mapa.getLogica().agregarEntidad(e, mapa.getCelda(i, j));
			}
		}
	}


}
