package Mapa;

public class Mapa {
	
	protected Celda [][] mapa;
	protected int filas,columnas;

	public Mapa() {
		filas = 6;
		columnas = 10;
		mapa = new Celda [10][6];
		
		for (int i = 0; i < mapa.length ; i++) {
			for(int j = 0 ; j < mapa[0].length ; j++) {
				mapa[i][j] = new Celda(this,i,j);
			}
		}
	}
	
	public int getFilas() {
		return filas;
	}
	public int getColumnas() {
		return columnas;
	}
	public Celda getCelda(int x, int y){
		return mapa[x][y];
	}
}
