package Hilos;


import Logica.Logica;


public class HiloEnemigo extends Thread{
	protected Logica logica;
	
	public HiloEnemigo(Logica logica) {
		super();
		this.logica = logica;
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(300);
			}catch (InterruptedException e) {e.printStackTrace();}
				logica.moverEnemigos();
			}
		}
	

}
