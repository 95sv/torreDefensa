package Grafica;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Entidad.Entidad;
import Logica.Logica;
import Mapa.Mapa;

public class Grafica extends JFrame {

	private JPanel panelFondo;
	private Logica logica;
	private JLabel fondoImagen;
	private Icon iconoFondo;

	public static void main(String[] args) {
		Grafica grafica = new Grafica();
		grafica.setVisible(true);
		grafica.setTitle("Tower Defense");
	}

	public Grafica() {
		getContentPane().setLayout(null);
		setSize(650, 430);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelFondo = new BackgroundPanel();
		panelFondo.setLayout(null);
		setContentPane(panelFondo);

		logica = new Logica(this);
		menuCompra();
	}

	class BackgroundPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image imagen = new ImageIcon("./src/Recursos/Background/battleback1.png").getImage();

		public void paint(Graphics g) {
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paint(g);
		}

	}
	
	public void graficarEntidad(Entidad e) {
		ImageIcon icon = e.getImagen();
		JLabel label = new JLabel();
		System.out.println("IMAGEN : "+ icon.toString());
		label.setIcon(icon);
		panelFondo.add(label);
		label.setBounds(e.getCelda().getX()*64,e.getCelda().getY()*64,64,64);
		label.setVisible(true);
	}
	
	public void menuCompra() {
		//Creo panel de compras.
		JPanel panelCompras = new JPanel();
		panelCompras.setLayout(new FlowLayout());
		panelFondo.add(panelCompras);
		panelCompras.setSize(200, 560);
		panelCompras.setBounds(800, 0,200,560);
	}

}
