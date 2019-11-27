package PowerUp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Hilos.HiloPowerUp;
import Mapa.Celda;
import Mapa.Mapa;
import PowerUp.AumentoMoneda.puListener;
import Visitor.Visitor;

public class DobleGolpe extends ObjetoPrecioso {

	public DobleGolpe(Mapa mapa, Celda celda) {
		super(mapa, celda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Objetos/campo.gif")));
		puListener listener = new puListener(this);
		imagen.addMouseListener(listener);
	}

	@Override
	protected void activarPowerUp() {
	}

	@Override
	public void mover() {
	}

	@Override
	public void morir() {
	}

	@Override
	public void aceptar(Visitor visitor) {
	}

	protected class puListener extends MouseAdapter {

		public puListener(PowerUp pu) {
			miPowerUp = pu;
		}

		public void mouseClicked(MouseEvent e) {
			imagen = (JLabel) e.getSource();
			miPowerUp.activarPowerUp();
			//miMapa.getLogica().eliminarPowerUp(miPowerUp);
			new HiloPowerUp(miMapa.getLogica()).start();
		}
	}

}