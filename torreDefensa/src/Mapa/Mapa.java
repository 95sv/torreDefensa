package Mapa;

public class Mapa {

	protected Celda[][] mapa;
	protected int filas, columnas;

	public Mapa() {
		filas = 6;
		columnas = 10;
		mapa = new Celda[10][6];

		for (int i = 0; i < columnas; i++) {
			for (int j = 0; j < filas; j++) {
				mapa[i][j] = new Celda(this, i, j);
			}
		}
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public Celda getCelda(int x, int y) {
		if ((x < this.columnas) && (x >= 0) && (y < this.filas) && (y >= 0))
			return this.mapa[x][y];
		return null;
	}

}