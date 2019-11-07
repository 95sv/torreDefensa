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

	public DisparoAliado(Mapa miMapa, Celda miCelda, Torre miTorre, int dano, int velocidad) {
		super(miMapa, miCelda, dano, velocidad);
		this.miTorre = miTorre;
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosGif/DisparoTorreArena.png")));
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
				nuevaCelda = miMapa.getCelda(miTorre.getX() - 1, miTorre.getY());
				setCelda(nuevaCelda);
				nuevaCelda.agregarEntidad(this);
				return true;
			} else {
				miCelda.eliminarEntidad();
				setCelda(nuevaCelda);
				nuevaCelda.agregarEntidad(this);
				return true;
			}
		} else {
			/*
			 * Si el disparo llega al final del mapa, se reinicia a la posicion inicial.
			 */
			miCelda.eliminarEntidad();
			Celda celdaReinicio = miMapa.getCelda(miTorre.getX() - 1, miTorre.getY());
			setCelda(celdaReinicio);
			celdaReinicio.agregarEntidad(this);
			return true;
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

	public int getDano() {
		return 50;
	}

}