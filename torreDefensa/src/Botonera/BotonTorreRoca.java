package Botonera;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import Entidad.TorreRoca;
import Mapa.Celda;
import Mapa.Mapa;

public class BotonTorreRoca extends Boton{

	public BotonTorreRoca(ActionListener accion) {
		super(accion);
		setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado2.png")));
	}

	@Override
	public void crearEntidad(Mapa mapa, Celda celda) {
		TorreRoca torre = new TorreRoca(mapa,celda);
		if(torre.getPrecio() <= mapa.getLogica().getMoneda()) {
			mapa.getLogica().agregarEntidad(torre,celda);
			mapa.getLogica().agregarMoneda(torre.getPrecio()*-1);
		}
	}

}
