package Disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Torre;
import Mapa.Celda;
import Mapa.Mapa;
import Visitor.Visitor;

public class DisparoDoble extends DisparoAliado {

	protected Torre miTorre;
	
	public DisparoDoble(Mapa miMapa, Celda miCelda, Torre miTorre,int dano, int velocidad) {
		super(miMapa, miCelda, miTorre, dano, velocidad);
		this.miTorre = miTorre;
		imagen = new JLabel();
		imagen.setIcon(new ImageIcon(getClass().getResource("/Recursos/Aliados/d_2.png")));
	}

	@Override
	public int getDaño() {
		return 100;
	}
	
}
