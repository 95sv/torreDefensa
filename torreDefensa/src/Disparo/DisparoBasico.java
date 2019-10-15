package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Enemigo;
import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;


public class DisparoBasico extends DisparoAliado {

	public DisparoBasico(Celda celda, float daño, int velocidad, Mapa mapa) {
		super(celda, daño, velocidad,mapa);	
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosLosSimpson/CarlitosBala.png")));
		
	}

	public boolean visit(DisparoBasico d) {
		return false;
	}

	public boolean visit(DisparoEnemigo d) {
		return false;
	}

	public void visit() {
	}

	public void morir() {
	}
	
	
}