package Botonera;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Entidad.TorreArena;
import Mapa.Celda;
import Mapa.Mapa;

@SuppressWarnings("serial")
public class BotonTorreArena extends Boton {

	public BotonTorreArena(ActionListener accion) {
		super(accion);
		setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado1.png")));
	}

	@Override
	public void crearTorre(Mapa mapa, Celda celda) {
		TorreArena torre = new TorreArena(mapa, celda);
		if (torre.getPrecio() <= mapa.getLogica().getMoneda()) {
			mapa.getLogica().agregarEntidad(torre,celda);
			mapa.getLogica().agregarMoneda(torre.getPrecio()*-1);
		}
	}
}
