package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoEnemigo;
import Disparo.DisparoVerde;
import Mapa.Celda;
import Mapa.Mapa;

public class Tierra extends EnemigoLejano{

	public Tierra(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagenMover = new ImageIcon(getClass().getResource("/Recursos/Enemigos/caminante2.gif"));
		imagenAtacar = new ImageIcon(getClass().getResource("/Recursos/Enemigos/a_caminante2.gif"));
		imagen.setIcon(imagenMover);
		imagen.setBounds(x, y, PIXEL, PIXEL);
		vida = 100;
		puntos = 100;
	}

	@Override
	public DisparoEnemigo crearDisparo() {
		return new DisparoVerde(miMapa,miCelda,50,50);
	}

}
