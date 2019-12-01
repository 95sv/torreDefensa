package Botonera;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import Mapa.Celda;
import Mapa.Mapa;

@SuppressWarnings("serial")
public abstract class Boton extends JButton{
	
	public Boton(ActionListener accion) {
		super();
		setBorder(null);
	    setContentAreaFilled(false);
	    addActionListener(accion);
	}
	
	public abstract void crearEntidad(Mapa mapa,Celda celda);
}
