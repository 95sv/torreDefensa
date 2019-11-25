package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorDisparoAliado;

public class DisparoBasico extends DisparoAliado {

	public DisparoBasico(Mapa miMapa, Celda miCelda,int golpe,int velocidad) {
		super(miMapa, miCelda, golpe, velocidad);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/d_1.png")));
		imagen.setBounds(miCelda.getX() * PIXEL, miCelda.getY() * PIXEL,PIXEL,PIXEL);
		miVisitor = new VisitorDisparoAliado(this);	
	}
	
	public void mover() {
		super.mover();
	}

	public int getGolpe() {
		return 50;
	}

}