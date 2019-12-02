package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoEnemigo;
import Disparo.DisparoVerde;
import Mapa.Celda;
import Mapa.Mapa;

public class Fantasma extends EnemigoLejano{

	public Fantasma(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();		
		imagenMover = new ImageIcon(getClass().getResource("/Recursos/Enemigos/caminante6.gif"));
		imagenAtacar = new ImageIcon(getClass().getResource("/Recursos/Enemigos/a_caminante6.gif"));
		imagen.setIcon(imagenMover);
		imagen.setBounds(x, y, PIXEL, PIXEL);
		vida = 200;
		puntos = 200;
	}

	@Override
	public DisparoEnemigo crearDisparo() {
		return new DisparoVerde(miMapa,miCelda,50,50);
	}

}