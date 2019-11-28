package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparo.DisparoAliado;
import Disparo.DisparoBasico;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class TorreArena extends Torre {

	public TorreArena(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado3.png")));
		super.setPrecio(150);
	}

	@Override
	public DisparoAliado crearDisparo() {
		return new DisparoBasico(miMapa,miCelda,50,50);
	}

}