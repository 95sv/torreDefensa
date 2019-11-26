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

public class DisparoVerde extends DisparoEnemigo {

	public DisparoVerde(Mapa miMapa, Celda miCelda, int golpe, int velocidad) {
		super(miMapa, miCelda, golpe, velocidad);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Enemigos/d_caminante2.png")));
		miVisitor = new VisitorDisparoEnemigo(this);
	}

	@Override
	public int getGolpe() {
		return 10;
	}


}