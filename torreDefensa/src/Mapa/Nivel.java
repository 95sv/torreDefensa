package Mapa;

public abstract class Nivel extends Thread{
	
	protected Mapa mapa;
	protected boolean perder;
	
	public Nivel(Mapa mapa) {
		this.mapa = mapa;
	}
	
	public void cargarOleada() {};

}