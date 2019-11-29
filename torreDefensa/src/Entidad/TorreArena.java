package Entidad;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparo.DisparoAliado;
import Disparo.DisparoBasico;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class TorreArena extends Torre {

	public TorreArena(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado3.png")));
		torreListener tl = new torreListener(this);
		imagen.addMouseListener(tl);
		super.setPrecio(150);
	}

	@Override
	public DisparoAliado crearDisparo() {
		return new DisparoBasico(miMapa,miCelda,50,50);
	}
	
	protected class torreListener extends MouseAdapter{
		protected TorreArena miTorre;
		public torreListener(TorreArena torre) {
			miTorre = torre;
		}
		
		public void mouseClicked(MouseEvent e) {
			miTorre.getLogica().agregarMoneda(miTorre.getPrecio());
			miTorre.morir();
		}
		
	}

}