package Entidad;

import Mapa.Celda;
import Mapa.Mapa;

public abstract class EnemigoCombate extends Enemigo {
	protected boolean seguirMoviendo;
	int tiempo = 3;

	public EnemigoCombate(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		seguirMoviendo = true;
	}

	public void seguirMoviendo(boolean b) {
		seguirMoviendo = b;
	}

	public void ejecutar() {
		Entidad e;

		if (x < 9) {
			e = miMapa.getCelda(x + 1, y).getEntidad();
			if (e != null) {
				imagen.setIcon(imagenAtacar);
				e.aceptar(miVisitor);
			} else {
				if (seguirMoviendo) {
					imagen.setIcon(imagenMover);
					miMapa.getCelda(x, y).eliminarEntidad();
					x = x + 1;
					miMapa.getCelda(x, y).agregarEntidad(this);
					miCelda = miMapa.getCelda(x, y);
					imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
					seguirMoviendo = true;
				}
			}
		}
	}

	public void mover() {
	}

	public void disparar(Entidad e) {
		imagen.setIcon(imagenAtacar);
		e.recibirGolpe(this.getGolpe());
	}

}
