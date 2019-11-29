package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorDisparoAliado;

public abstract class DisparoAliado extends Disparo {
	protected boolean seguirMoviendo;

	public DisparoAliado(Mapa miMapa, Celda miCelda, int golpe, int velocidad) {
		super(miMapa, miCelda, golpe, velocidad);
		miVisitor = new VisitorDisparoAliado(this);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/d_1.png")));
		imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
		seguirMoviendo = true;
	}

	public void ejecutar() {
		mover();
	}

	public void mover() {

		if (x == 0) {
			morir();
		} else {
			if (miMapa.getCelda(x - 1, y).getEntidad() == null) {
				miMapa.getCelda(x, y).eliminarEntidad();
				x = x - 1;
				miMapa.getCelda(x, y).agregarEntidad(this);
				miCelda = miMapa.getCelda(x, y);
				imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
			} else {
				miMapa.getCelda(x - 1, y).getEntidad().aceptar(miVisitor);

				if (seguirMoviendo) {
					miMapa.getCelda(x, y).eliminarEntidad();
					x = x - 1;
					miMapa.getCelda(x, y).agregarEntidad(this);
					miCelda = miMapa.getCelda(x, y);
					imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
				}
			}
		}
	}

	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}

	public void morir() {
		miMapa.getLogica().eliminarEntidad(this);
	}

	public void setSeguirMoviendo(boolean b) {
		seguirMoviendo = b;
	}

}