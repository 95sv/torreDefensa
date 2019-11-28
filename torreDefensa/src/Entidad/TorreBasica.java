package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparo.DisparoAliado;
import Disparo.DisparoBasico;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class TorreBasica extends Torre {

	public TorreBasica(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado1.png")));
		super.setPrecio(100);
		golpe = 100;
	}

	@Override
	public DisparoAliado crearDisparo() {
		return new DisparoBasico(miMapa, miCelda, 50, 50);
	}

}