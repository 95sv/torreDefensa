package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Enemigo;
import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorDisparoAliado;
import Visitor.VisitorDisparoEnemigo;

public class DisparoTierra extends DisparoEnemigo{

	public DisparoTierra(Mapa miMapa, Celda miCelda, Enemigo miEnemigo, int dano, int velocidad) {
		super(miMapa, miCelda, miEnemigo, dano, velocidad);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Enemigos/d_caminante2.png")));
		miVisitor = new VisitorDisparoEnemigo(this);
		miMapa.getLogica().crearHiloDisparo();
	}

	@Override
	public int getDaño() {
		return 10;
	}


	
	
}
