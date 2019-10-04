package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparo.DisparoAliado;
import Disparo.DisparoBasico;
import Disparo.DisparoEnemigo;
import Mapa.Celda;

public class BarMoe extends Torre{

	public BarMoe(Celda celda) {
		super(celda);
		imagen = new JLabel();
		//imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Enemigos/Enemigo1/Walk (2)i.png")));
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosLosSimpson/MoeBar64.png")));

	}
	
	protected void crearDisparo() {
			logica.agregarBala();
		}

	

}
	

