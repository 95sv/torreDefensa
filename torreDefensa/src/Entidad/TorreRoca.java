package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class TorreRoca extends Torre{

	public TorreRoca(Mapa miMapa, Celda miCelda) {
		super(miMapa,miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado3.png")));
		super.setPrecio(200);
	}
	
	public void crearDisparo() {
		miMapa.getLogica().crearHiloDisparo();
	}
	
	@Override
	public boolean mover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean aceptar(Visitor visitor) {
		// TODO Auto-generated method stub
		return false;
	}

}
