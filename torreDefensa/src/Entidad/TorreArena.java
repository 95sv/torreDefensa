package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class TorreArena extends Torre{

	public TorreArena(Mapa miMapa,Celda miCelda) {
		super(miMapa,miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosGif/TorreArena.png")));

	}
	
	/*public void crearDisparo() {
		System.out.println("CREO DISPARO EN : "+miCelda.getX());
		//miMapa.getLogica().agregarDisparo(new DisparoAliado(miMapa,miCelda,1,1));
		miMapa.getLogica().crearHiloDisparo();
	}
*/
	
	public void morir() {
	}

	public boolean mover() {
		return false;
	}
	
	public boolean aceptar(Visitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

	
}