package Hilos;

import Logica.Logica;

public class HiloEnemigo extends Thread {
	protected Logica logica;
	protected long timer;
	protected float estimatedTime;
	protected boolean estado = false;
	
	public HiloEnemigo(Logica logica) {
		super();
		this.logica = logica;
	}
	
	
	
	public void run() {
		while (!logica.terminar()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logica.moverEnemigos();
		}
	}

}
