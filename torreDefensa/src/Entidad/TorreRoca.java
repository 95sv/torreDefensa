package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparo.DisparoAliado;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class TorreRoca extends Torre {

	public TorreRoca(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado3.png")));
		super.setPrecio(200);
	}

	@Override
	public void mover() {}

	@Override
	public void morir() {}

	@Override
	public void aceptar(Visitor visitor) {
	}

	@Override
	public DisparoAliado crearDisparo() {
		// TODO Auto-generated method stub
		return null;
	}

}