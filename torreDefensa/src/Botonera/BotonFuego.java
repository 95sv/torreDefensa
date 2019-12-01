package Botonera;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import Mapa.Celda;
import Mapa.Mapa;
import Objeto.Fuego;

public class BotonFuego extends Boton{
	public BotonFuego(ActionListener accion) {
		super(accion);
		setIcon(new ImageIcon(getClass().getResource("/Recursos/Objetos/fire.gif")));
	}

	@Override
	public void crearEntidad(Mapa mapa, Celda celda) {
		Fuego f = new Fuego(mapa,celda);
		if(f.getPrecio() <= mapa.getLogica().getMoneda()) {
			mapa.getLogica().agregarEntidad(f, celda);
			mapa.getLogica().agregarMoneda(f.getPrecio()*-1);
		}
	}

}
