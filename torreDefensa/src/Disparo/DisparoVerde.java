package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.VisitorDisparoEnemigo;

public class DisparoVerde extends DisparoEnemigo {

	public DisparoVerde(Mapa miMapa, Celda miCelda, int golpe, int velocidad) {
		super(miMapa, miCelda, golpe, velocidad);
	}

	@Override
	public int getGolpe() {
		return 10;
	}


}