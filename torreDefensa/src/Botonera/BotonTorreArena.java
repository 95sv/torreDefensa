package Botonera;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Entidad.TorreArena;
import Mapa.Celda;
import Mapa.Mapa;

@SuppressWarnings("serial")
public class BotonTorreArena extends Boton{
	public BotonTorreArena(ActionListener accion) {
		super(accion);
		setIcon(new ImageIcon(getClass().getResource("/RecursosGif/TorreArena.png")));
	}

	@Override
	public void crearTorre(Mapa mapa,Celda celda) {
		TorreArena bar = new TorreArena(mapa,celda);
		mapa.getLogica().agregarJugador(bar);
	}
}
