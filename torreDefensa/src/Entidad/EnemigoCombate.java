package Entidad;

import Mapa.Celda;
import Mapa.Mapa;

public abstract class EnemigoCombate extends Enemigo {

	int tiempo = 3;

	public EnemigoCombate(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		seguirMoviendo = true;
	}

	public void seguirMoviendo(boolean seguirMoviendo) {
		this.seguirMoviendo = seguirMoviendo;
	}

	public void ejecutar() {

		if(x== 9) {
			logica.perder();
		}
		else 
			if(miMapa.getCelda(x+1,y).cantEntidades() == 0) {
				miMapa.getCelda(x,y).eliminarEntidad(this);
				x = x + 1;
				miMapa.getCelda(x,y).agregarEntidad(this);
				miCelda = miMapa.getCelda(x,y);
				imagen.setBounds(miCelda.getX()*PIXEL,miCelda.getY()*PIXEL, PIXEL,PIXEL);
				imagen.setIcon(imagenMover);
			}
			else {
				
				Entidad [] entidadesArreglo = miMapa.getCelda(x+1, y).getArregloEntidades();
				int pos=0;
				while(entidadesArreglo[pos]!=null) {
					entidadesArreglo[pos].aceptar(miVisitor);
                    pos++;					
				}	
				 if(seguirMoviendo) {
					miMapa.getCelda(x,y).eliminarEntidad(this);
					x = x + 1;
					miMapa.getCelda(x,y).agregarEntidad(this);
					miCelda = miMapa.getCelda(x,y);
					imagen.setBounds(miCelda.getX()*PIXEL,miCelda.getY()*PIXEL,PIXEL,PIXEL);
					imagen.setIcon(imagenMover);
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
