package Objeto;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;

public class Roca extends Objeto{

	public Roca(Celda celda) {
		super(celda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Objetos/rock.png")));
	}
}
