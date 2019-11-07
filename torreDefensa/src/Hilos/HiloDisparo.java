package Hilos;

import Logica.Logica;

public class HiloDisparo extends Thread {
	protected Logica miLogica;

	public HiloDisparo(Logica miLogica) {
		super();
		this.miLogica = miLogica;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			miLogica.moverDisparos();
		}
	}

}
