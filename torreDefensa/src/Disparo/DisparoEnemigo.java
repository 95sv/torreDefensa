package Disparo;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public abstract class DisparoEnemigo extends Disparo {
	protected int tiempo = 10;
	public DisparoEnemigo(Mapa miMapa, Celda miCelda, int golpe, int velocidad) {
		super(miMapa, miCelda, golpe, velocidad);
	}

	public void morir() {
		miMapa.getLogica().eliminarEntidad(this);
	}
	
	public void ejecutar() {
			mover();
	}
	
	public void mover() {
		if(x == 9) {
			morir();
		}
		else {
			if(miMapa.getCelda(x + 1, y).getEntidad() == null) {
				miMapa.getCelda(x, y).eliminarEntidad();
				x = x + 1;
				miMapa.getCelda(x, y).agregarEntidad(this);
				miCelda = miMapa.getCelda(x, y);
				imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL,PIXEL,PIXEL);
			}
			else {
				miMapa.getCelda(x + 1, y).getEntidad().aceptar(miVisitor);
				miMapa.getCelda(x, y).eliminarEntidad();
				morir();				
			}
		}
	}

	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}
}