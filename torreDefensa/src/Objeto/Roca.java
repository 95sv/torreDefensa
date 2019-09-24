package Objeto;

import javax.swing.ImageIcon;

import Mapa.Celda;

public class Roca extends Objeto{

	public Roca(Celda celda) {
		super(celda);
		imagen = new ImageIcon(getClass().getResource("/Recursos/Objetos/rock.png"));
	}
}
