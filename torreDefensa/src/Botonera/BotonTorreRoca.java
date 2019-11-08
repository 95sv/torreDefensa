package Botonera;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import Entidad.TorreRoca;
import Mapa.Celda;
import Mapa.Mapa;

public class BotonTorreRoca extends Boton{

	public BotonTorreRoca(ActionListener accion) {
		super(accion);
		setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado3.png")));
	}

	@Override
	public void crearTorre(Mapa mapa, Celda celda) {
		TorreRoca torre = new TorreRoca(mapa,celda);
		if(torre.getPrecio() <= mapa.getLogica().getMoneda()) {
			mapa.getLogica().agregarJugador(torre);
		}
	}

}
