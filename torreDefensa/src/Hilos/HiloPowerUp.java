package Hilos;

import Entidad.Torre;
import Logica.Logica;

public class HiloPowerUp extends Thread{
	protected Logica miLogica;
	protected Torre miTorre;
	
	public HiloPowerUp(Logica miLogica) {
		this.miLogica = miLogica;
	}
	
	public void run() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
