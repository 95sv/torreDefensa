package Entidad;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparo.DisparoAliado;
import Disparo.DisparoBasico;
import Entidad.TorreControl.torreListener;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class TorreRoca extends Torre {

	public TorreRoca(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado2.png")));
		torreListener tl = new torreListener(this);
		imagen.addMouseListener(tl);
		super.setPrecio(200);
	}

	@Override
	public DisparoAliado crearDisparo() {
		return new DisparoBasico(miMapa,miCelda,50,50);
	}
	
	protected class torreListener extends MouseAdapter{
		protected TorreRoca miTorre;
		public torreListener(TorreRoca torre) {
			miTorre = torre;
		}
		
		public void mouseClicked(MouseEvent e) {
			miTorre.getLogica().agregarMoneda(miTorre.getPrecio());
			miTorre.morir();
		}
		
	}
}