package Mapa;

public abstract class Nivel extends Thread {

	protected Mapa mapa;
	protected boolean perder = false;
	protected int nivel = 0;
	protected int enemigos = 0;

	public Nivel(Mapa mapa) {
		this.mapa = mapa;
	}

	public int getNivel() {
		return nivel;
	}
	
	public void perder() {
		perder = true;
	}

	public void cargarOleada() {
	}
	
	public void eliminarEnemigo() {
		enemigos--;
	}

}