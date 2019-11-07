package PowerUp;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class AumentoMoneda extends MagiaTemporal{

	public AumentoMoneda(Mapa mapa, Celda celda) {
		super(mapa, celda);
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Objetos/moneda.gif")));
		//agregarListener();
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
		miMapa.getLogica().agregarMoneda(100);
	}

}
