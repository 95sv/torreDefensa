package Mapa;

public abstract class Nivel extends Thread{
	
	protected Mapa mapa;
	
	public Nivel(Mapa mapa) {
		this.mapa = mapa;
	}
	
	public void cargarOleada() {};

}