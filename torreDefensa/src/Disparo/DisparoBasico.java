package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;

import Mapa.Mapa;

public class DisparoBasico extends DisparoAliado {

	public DisparoBasico(Celda celda, float daño, int velocidad) {
		super(celda, daño, velocidad);
		
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosLosSimpson/CarlitosBala.png")));
		
	}

	@Override
	public boolean visit(DisparoAliado d) {
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
