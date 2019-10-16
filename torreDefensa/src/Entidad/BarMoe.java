package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparo.DisparoAliado;
import Disparo.DisparoEnemigo;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class BarMoe extends Torre{

	public BarMoe(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosLosSimpson/MoeBar64.png")));

	}
	
	public void crearDisparo() {
		System.out.println("CREO DISPARO EN : "+miCelda.getX());
		//miMapa.getLogica().agregarDisparo(new DisparoAliado(miMapa,miCelda,1,1));
		miMapa.getLogica().crearHiloDisparo();
	}

	@Override
	public void mover() {
	}

	@Override
	public void morir() {
	}

	@Override
	public boolean aceptar(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

}