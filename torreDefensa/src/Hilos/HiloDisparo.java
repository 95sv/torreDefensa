package Hilos;

import Logica.Logica;

public class HiloDisparo extends Thread {
	protected Logica logica;

	public HiloDisparo(Logica logica) {
		super();
		this.logica = logica;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logica.moverDisparos();
		}
	}

}
