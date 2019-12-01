package Botonera;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Mapa.Celda;
import Mapa.Mapa;
import Objeto.Barricada;

public class BotonBarricada extends Boton{

	public BotonBarricada(ActionListener accion) {
		super(accion);
		setIcon(new ImageIcon(getClass().getResource("/Recursos/Objetos/barricada.png")));
	}

	@Override
	public void crearEntidad(Mapa mapa, Celda celda) {
		Barricada barricada = new Barricada(mapa,celda);
		if(barricada.getPrecio() <= mapa.getLogica().getMoneda()) {
			mapa.getLogica().agregarEntidad(barricada, celda);
			mapa.getLogica().agregarMoneda(barricada.getPrecio()*-1);
		}
	}

}
