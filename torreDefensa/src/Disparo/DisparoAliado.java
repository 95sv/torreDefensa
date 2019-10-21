package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorDisparoAliado;

public class DisparoAliado extends Disparo {
	protected Torre miTorre;
	
	public DisparoAliado(Mapa miMapa, Celda miCelda, Torre miTorre,float da�o, int velocidad) {
		super(miMapa, miCelda, da�o, velocidad);
		this.miTorre = miTorre;
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosLosSimpson/CarlitosBala.png")));
		miVisitor = new VisitorDisparoAliado(this);
		miMapa.getLogica().crearHiloDisparo();
	}

	public boolean mover() {
		int x = miCelda.getX();
		int y = miCelda.getY();

		if (x < 9 && x >= 1) {
			x = x - 1;
			System.out.println("MOVER A : " + x);
			Celda nuevaCelda = miMapa.getCelda(x, y);
			if (nuevaCelda.getEntidad() != null && nuevaCelda.getEntidad().aceptar(miVisitor)) {
				miCelda.eliminarEntidad();
				nuevaCelda=miMapa.getCelda(miTorre.getX()-1, miTorre.getY());
				setCelda(nuevaCelda);
				nuevaCelda.agregarEntidad(this);
				return true;
			} else {
				miCelda.eliminarEntidad();
				setCelda(nuevaCelda);
				nuevaCelda.agregarEntidad(this);
				return true;
			}
		}
		else {
			morir();//habria que ponerlo como esta antes para que vuelva a aparecer
			return false;
		}
	}

	public boolean aceptar(Visitor visitor) {
		return visitor.visit(this);

	}
	
	public Torre getTorre() {
		return miTorre;
	}

	public void morir() {
		miMapa.getLogica().eliminarDisparo(this);
	}

}
