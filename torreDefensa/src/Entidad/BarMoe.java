package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Celda;
import Mapa.Mapa;

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

}