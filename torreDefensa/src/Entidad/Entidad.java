package Entidad;

import javax.swing.ImageIcon;

import Mapa.Celda;

public abstract class Entidad {
	
	protected Celda miCelda;
	protected ImageIcon imagen;
	
	public  void setCelda(Celda c){
		miCelda = c;
	}
	
	public ImageIcon getImagen() {
		return imagen;
	}
	
	public void setImagen(ImageIcon i)	{
		imagen = i;
	}

}
