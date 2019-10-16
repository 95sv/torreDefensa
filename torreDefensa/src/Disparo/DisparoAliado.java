package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Enemigo;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorDisparoAliado;

public class DisparoAliado extends Disparo {

	
	public DisparoAliado(Mapa miMapa,Celda miCelda, float daño, int velocidad) {
		super(miMapa,miCelda, daño, velocidad);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosLosSimpson/CarlitosBala.png")));
		miVisitor = new VisitorDisparoAliado(this);
	}
	
	public void mover() {
		int x = miCelda.getX();
		int y = miCelda.getY();
		
			if(x<9 && x>=1) {
				 x = x-1;
				 Celda nuevaCelda = miMapa.getCelda(x, y);
				 if(nuevaCelda.getEntidad() != null && nuevaCelda.getEntidad().aceptar(miVisitor)) {
					 
				 }else
				       {
				        miCelda.eliminarEntidad();
				        setCelda(nuevaCelda);
				        nuevaCelda.agregarEntidad(this);
				       }
		  }
	   }
		

	   public boolean aceptar(Visitor visitor) {
		  return visitor.visit(this);
	     
	   }
	


	   public void morir() {
			miMapa.getLogica().eliminarDisparo(this);
		}

}
