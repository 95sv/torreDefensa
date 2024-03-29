package PowerUp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;
import Visitor.VisitorPUvida;

public class AumentoVida extends MagiaTemporal {

	public AumentoVida(Mapa mapa, Celda celda) {
		super(mapa, celda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Objetos/vida.gif")));
		puListener listener = new puListener(this);
		imagen.addMouseListener(listener);
		miVisitor = new VisitorPUvida(this);

	}

	@Override
	public void activarPowerUp() {
		miMapa.getLogica().visitarEntidades(miVisitor);
	}

	@Override
	public void mover() {
	}

	@Override
	public void morir() {
		miMapa.getLogica().eliminarEntidad(this);
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
			morir();
		}
	}

}