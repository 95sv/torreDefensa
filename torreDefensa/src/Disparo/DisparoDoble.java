package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;

public class DisparoDoble extends DisparoAliado {

	protected Torre miTorre;
	
	public DisparoDoble(Mapa miMapa, Celda miCelda,int golpe, int velocidad) {
		super(miMapa, miCelda, golpe, velocidad);
	}

	@Override
	public int getGolpe() {
		return 100;
	}

	
}
