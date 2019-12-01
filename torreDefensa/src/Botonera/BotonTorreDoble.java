package Botonera;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import Entidad.TorreDoble;
import Mapa.Celda;
import Mapa.Mapa;

public class BotonTorreDoble extends Boton {

	public BotonTorreDoble(ActionListener accion) {
		super(accion);
		setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado5.png")));
	}

	@Override
	public void crearEntidad(Mapa mapa, Celda celda) {
		TorreDoble torre = new TorreDoble(mapa,celda);
		if(torre.getPrecio() <= mapa.getLogica().getMoneda()) {
			mapa.getLogica().agregarEntidad(torre,celda);
			mapa.getLogica().agregarMoneda(torre.getPrecio()*-1);
		}
	}
}
