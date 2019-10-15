package Disparo;

import Entidad.Enemigo;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorDisparoAliado;

public abstract class DisparoAliado extends Disparo {

	
	public DisparoAliado(Celda celda, float daño, int velocidad, Mapa mapa) {
		super(celda, daño, velocidad,mapa);
		miVisitor = new VisitorDisparoAliado(this);
	}
	
	public void mover() {
		int x = miCelda.getX();
		int y = miCelda.getY();
		
			if(x<9 && x>=1) {
				 x = x-1;
				 Celda nuevaCelda = mapa.getCelda(x, y);
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
	
	   public boolean visit(Enemigo enemigo) {
			return true;
	    }


}
