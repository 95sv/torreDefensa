package PowerUp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class Escudo extends ObjetoPrecioso{

	public Escudo(Mapa mapa, Celda celda) {
		super(mapa, celda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Objetos/campo.gif")));
		puListener listener = new puListener(this);
		imagen.addMouseListener(listener);
	}

	@Override
	public void activarPowerUp() {
	}

	@Override
	public void aceptar(Visitor visitor) {
	}

	@Override
	public void mover() {
	}
	

	protected class puListener extends MouseAdapter {

		public puListener(PowerUp pu) {
			miPowerUp = pu;
		}

		public void mouseClicked(MouseEvent e) {
			imagen = (JLabel) e.getSource();
			miPowerUp.activarPowerUp();
			morir();
		}
	}

}
