package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Mapa.Celda;

public class Enemigo1 extends Enemigo {

	public Enemigo1(Celda celda) {
		super(celda);
		imagen = new JLabel();
		//imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Enemigos/Enemigo2/Attack__004.png")));
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosLosSimpson/bart64.png")));
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