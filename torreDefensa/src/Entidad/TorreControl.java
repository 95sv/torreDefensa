package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparo.DisparoAliado;
import Disparo.DisparoBasico;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class TorreControl extends Torre {

	public TorreControl(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado4.png")));
		super.setPrecio(300);
	}

	@Override
	public DisparoAliado crearDisparo() {
		return new DisparoBasico(miMapa,miCelda,50,50);
	}

}