package Entidad;

import Disparo.DisparoEnemigo;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.VisitorEnemigoLejano;

public abstract class EnemigoLejano extends Enemigo {

	int tiempo = 3;
	boolean seguirMoviendo;

	public EnemigoLejano(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		miVisitor = new VisitorEnemigoLejano(this);
		seguirMoviendo = true;
	}

	public void seguirMoviendo(boolean seguirMoviendo) {
		this.seguirMoviendo = seguirMoviendo;
	}

	public void disparar(Entidad e) {
		imagen.setIcon(imagenAtacar);
		logica.agregarEntidad(crearDisparo(), miCelda);
	}

	public abstract DisparoEnemigo crearDisparo();

	public void mover() {
		imagen.setIcon(imagenMover);
		if (x == 9) {
			logica.perder();
		} else if (miMapa.getCelda(x + 1, y).cantEntidades() == 0) {
			miMapa.getCelda(x, y).eliminarEntidad(this);
			x = x + 1;
			miMapa.getCelda(x, y).agregarEntidad(this);
			miCelda = miMapa.getCelda(x, y);
			imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);		
		} else {
			
			Entidad [] entidadesArreglo = miMapa.getCelda(x+1, y).getArregloEntidades();
			int pos=0;
			while(entidadesArreglo[pos]!=null) {
				entidadesArreglo[pos].aceptar(miVisitor);
                pos++;					
			}
			//System.out.println("seguirMoviendo: "+seguirMoviendo);
			if (seguirMoviendo) {
				//System.out.println("seguirMoviendo: "+seguirMoviendo);
				miMapa.getCelda(x, y).eliminarEntidad(this);
				x = x + 1;
				miMapa.getCelda(x, y).agregarEntidad(this);
				miCelda = miMapa.getCelda(x, y);
				imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
				imagen.setIcon(imagenMover);
			}
		}

	}

	public void ejecutar() {

		if (tiempo == 5) {
			if (x < 9) {
				for (int i = 0; i < 9; i++) {
					Entidad [] entidadesArreglo= miMapa.getCelda(9 - i, y).getArregloEntidades();
					int pos=0;
					
					while(entidadesArreglo[pos]!=null) {
						entidadesArreglo[pos].aceptar(miVisitor);
		                pos++;					
					}
					
				}
			}
		}
		tiempo--;
		
		if (tiempo == 0) {
			tiempo = 5;
			mover();
			this.seguirMoviendo(true);
		}
	}
}
