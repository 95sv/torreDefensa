package Botonera;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import Entidad.TorreBasica;
import Mapa.Celda;
import Mapa.Mapa;

public class BotonTorreBasica extends Boton{

	public BotonTorreBasica(ActionListener accion) {
		super(accion);
		setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado1.png")));
	}

	@Override
	public void crearEntidad(Mapa mapa, Celda celda) {
		TorreBasica torre = new TorreBasica(mapa,celda);
		if(torre.getPrecio() <= mapa.getLogica().getMoneda()) {
			mapa.getLogica().agregarEntidad(torre,celda);
			mapa.getLogica().agregarMoneda(torre.getPrecio()*-1);
		}
	}

}
