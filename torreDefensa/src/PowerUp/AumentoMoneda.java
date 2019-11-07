package PowerUp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Hilos.HiloPowerUp;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class AumentoMoneda extends MagiaTemporal {

	public AumentoMoneda(Mapa mapa, Celda celda) {
		super(mapa, celda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Objetos/moneda.gif")));
		// agregarListener();
		puListener listener = new puListener(this);
		imagen.addMouseListener(listener);
		
	}

	@Override
	public boolean mover() {
		return false;
	}

	@Override
	public void morir() {

	}

	@Override
	public boolean aceptar(Visitor visitor) {
		return false;
	}

	@Override
	protected void activarPowerUp() {
		System.out.println("Activo el Power UP ");
		miMapa.getLogica().agregarMoneda(100);
	}

	protected class puListener extends MouseAdapter {
		
		public puListener(PowerUp pu) {
			miPowerUp = pu;
		}
		
		public void mouseClicked(MouseEvent e) {
			System.out.println("Listener del power UP ");
			imagen = (JLabel) e.getSource();
			//miMapa.getLogica().agregarPowerUp(miCelda);
			miPowerUp.activarPowerUp();
			miMapa.getLogica().eliminarPowerUp(miPowerUp);
			new HiloPowerUp(miMapa.getLogica()).start();
		}
	}
}
