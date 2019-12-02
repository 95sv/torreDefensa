package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoEnemigo;
import Disparo.DisparoTierra;
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
		puntos = 80;
	}

	@Override
	public DisparoEnemigo crearDisparo() {
		return new DisparoTierra(miMapa,miCelda,50,50);
	}

}
