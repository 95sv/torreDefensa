package Hilos;

import Logica.Logica;

public class HiloEntidades extends Thread {
	protected Logica miLogica;
	protected boolean perder;
	
	public HiloEntidades(Logica miLogica) {
		super();
		this.miLogica = miLogica;
	}
	
	/*
	 *  Cuando el jugador pierde la partida, finaliza la ejecucion del hilo.
	 */
	public void perder() {
		perder = true;
	}
	
	public void run() {
		perder = false;
		while (!perder) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			miLogica.moverEntidades();
		}
	}
}

