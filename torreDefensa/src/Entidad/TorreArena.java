package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparo.DisparoAliado;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class TorreArena extends Torre {

	public TorreArena(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado2.png")));
		super.setPrecio(150);
	}

	public void morir() {}

	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}
	@Override
	public void mover() {}

	@Override
	public DisparoAliado crearDisparo() {
		// TODO Auto-generated method stub
		return null;
	}

}