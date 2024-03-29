package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Entidad;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorDisparoEnemigo;

public abstract class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(Mapa miMapa, Celda miCelda, int golpe, int velocidad) {
		super(miMapa, miCelda, golpe, velocidad);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Enemigos/d_caminante2.png")));
		imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL,PIXEL,PIXEL);
		miVisitor = new VisitorDisparoEnemigo(this);
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
			if(miMapa.getCelda(x + 1, y).cantEntidades()==0 ) {
				miMapa.getCelda(x, y).eliminarEntidad(this);
				x = x + 1;
				miMapa.getCelda(x, y).agregarEntidad(this);
				miCelda = miMapa.getCelda(x, y);
				imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL,PIXEL,PIXEL);
			}
			else {
				Entidad [] entidadesArreglo = miMapa.getCelda(x+1, y).getArregloEntidades();
				int pos=0;
				while(entidadesArreglo[pos]!=null) {
					entidadesArreglo[pos].aceptar(miVisitor);
                    pos++;					
				}
				miMapa.getCelda(x, y).eliminarEntidad(this);
				x = x + 1;
				miMapa.getCelda(x, y).agregarEntidad(this);
				miCelda = miMapa.getCelda(x, y);
				imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL, PIXEL, PIXEL);
				
			}
		}
	}

	public void aceptar(Visitor visitor) {
		visitor.visit(this);
	}
}