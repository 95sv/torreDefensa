package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class BarMoe extends Torre{

	public BarMoe(Celda celda,Mapa mapa) {
		super(celda,mapa);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosLosSimpson/MoeBar64.png")));

	}
	
	protected void crearDisparo() {
			logica.agregarBala();
		}

	@Override
	public void mover() {
	}

	@Override
	public void morir() {
	}

	@Override
	public boolean aceptar(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

}