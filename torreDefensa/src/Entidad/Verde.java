package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparo.DisparoEnemigo;
import Disparo.DisparoVerde;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.VisitorEnemigo;
import Visitor.VisitorEnemigoLejano;

public class Verde extends EnemigoLejano{
	
	protected int tiempo = 3;
	
	public Verde(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Enemigos/a_caminante5.gif")));
		miVisitor = new VisitorEnemigoLejano(this);
		vida = 50;
		puntos = 100;
	}

	public int getPuntos() {
		return puntos;
	}

	@Override
	public DisparoEnemigo crearDisparo() {
		return new DisparoVerde(miMapa,miCelda,1,1);
	}

}