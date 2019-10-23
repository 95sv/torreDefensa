package Botonera;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Entidad.BarMoe;
import Mapa.Celda;
import Mapa.Mapa;

public class BotonBarMoe extends Boton{
	public BotonBarMoe(ActionListener accion) {
		super(accion);
		setIcon(new ImageIcon(getClass().getResource("/RecursosLosSimpson/MoeBar64.png")));
	}

	@Override
	public void crearTorre(Mapa mapa,Celda celda) {
		BarMoe bar = new BarMoe(mapa,celda);
		mapa.getLogica().agregarJugador(bar);
	}
}
