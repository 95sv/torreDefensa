package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.VisitorEnemigo;

public class Hielo extends EnemigoCombate {

	public Hielo(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();	
		imagenMover = new ImageIcon(getClass().getResource("/Recursos/Enemigos/caminante1.gif"));
		imagenAtacar = new ImageIcon(getClass().getResource("/Recursos/Enemigos/a_caminante1.gif"));
		imagen.setIcon(imagenMover);
		imagen.setBounds(x, y, PIXEL, PIXEL);
		miVisitor = new VisitorEnemigo(this);
		vida = 120;
		puntos = 75;
		golpe= 25;
	}

}
