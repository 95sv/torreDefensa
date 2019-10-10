package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;

public class Roca extends Objeto{

	public Roca(Celda celda, Mapa mapa) {
		super(celda,mapa);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Objetos/rock.png")));
	}
}
