package Botonera;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import Entidad.TorreControl;
import Mapa.Celda;
import Mapa.Mapa;

public class BotonTorreControl extends Boton{

	public BotonTorreControl(ActionListener accion) {
		super(accion);
		setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado4.png")));
	}

	@Override
	public void crearEntidad(Mapa mapa, Celda celda) {
		TorreControl torre = new TorreControl(mapa,celda);
		if(torre.getPrecio() <= mapa.getLogica().getMoneda()) {
			mapa.getLogica().agregarEntidad(torre,celda);
			mapa.getLogica().agregarMoneda(torre.getPrecio()*-1);
		}
		
	}

}
