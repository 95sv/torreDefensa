package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Celda;
import Mapa.Mapa;


public class DisparoBasico extends DisparoAliado {

	public DisparoBasico(Celda celda, float daño, int velocidad, Mapa mapa) {
		super(celda, daño, velocidad,mapa);	
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosLosSimpson/CarlitosBala.png")));
		
	}

	
	
	@Override
	public boolean visit(DisparoBasico d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(DisparoEnemigo d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void visit() {
		// TODO Auto-generated method stub

	}
	
	
}
