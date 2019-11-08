package Botonera;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Entidad.TorreArena;
import Entidad.TorreBasica;
import Mapa.Celda;
import Mapa.Mapa;

public class BotonTorreBasica extends Boton{

	public BotonTorreBasica(ActionListener accion) {
		super(accion);
		setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado2.png")));
	}

	@Override
	public void crearTorre(Mapa mapa, Celda celda) {
		TorreBasica torre = new TorreBasica(mapa,celda);
		if(torre.getPrecio() <= mapa.getLogica().getMoneda()) {
			mapa.getLogica().agregarJugador(torre);
		}
	}

}
