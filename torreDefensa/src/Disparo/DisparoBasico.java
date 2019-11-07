package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorDisparoAliado;

public class DisparoBasico extends DisparoAliado {

	public DisparoBasico(Mapa miMapa, Celda miCelda, Torre miTorre, int dano, int velocidad) {
		super(miMapa, miCelda, miTorre, dano, velocidad);
		this.miTorre = miTorre;
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/RecursosGif/DisparoTorreArena.png")));
		miVisitor = new VisitorDisparoAliado(this);
		miMapa.getLogica().crearHiloDisparo();
	
	}

	public int getDaño() {
		return 50;
	}
	
	
	
}
