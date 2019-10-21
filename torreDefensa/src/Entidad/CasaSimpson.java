package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class CasaSimpson extends Torre {

	public CasaSimpson(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosLosSimpson/casaSimpson.png")));
	}

	public void crearDisparo() {
		System.out.println("CREO DISPARO EN : "+miCelda.getX());
		//miMapa.getLogica().agregarDisparo(new DisparoAliado(miMapa,miCelda,1,1));
		miMapa.getLogica().crearHiloDisparo();
	}
	
	public boolean mover() {
		return false;
	}

	public void morir() {
	}

	public boolean aceptar(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}
	
	
}
