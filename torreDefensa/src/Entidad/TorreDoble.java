package Entidad;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Disparo.DisparoAliado;
import Disparo.DisparoBasico;
import Mapa.Celda;
import Mapa.Mapa;

public class TorreDoble extends Torre {
	protected TorreDoble mitad;
	
	public TorreDoble(Mapa miMapa, Celda miCelda) {
		super(miMapa, miCelda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/aliado5.png")));
		torreListener tl = new torreListener(this);
		imagen.addMouseListener(tl);
		super.setPrecio(100);
		golpe = 100;
	}

	@Override
	public DisparoAliado crearDisparo() {
		return new DisparoBasico(miMapa,miCelda,50,50);
	}
	
	protected class torreListener extends MouseAdapter{
		protected TorreDoble miTorre;
		public torreListener(TorreDoble torre) {
			miTorre = torre;
		}
		
		public void mouseClicked(MouseEvent e) {
			miTorre.getLogica().agregarMoneda(miTorre.getPrecio());
			miTorre.morir();
		}
		
	}
}