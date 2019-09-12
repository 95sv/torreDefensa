package Grafica;

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
		setSize(800, 560);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelFondo = new BackgroundPanel();
		panelFondo.setLayout(null);
		setContentPane(panelFondo);

		logica = new Logica(this);
		//graficar();
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
		label.setBounds(e.getCelda().getX()*32,e.getCelda().getY()*32, 32,32);
		label.setVisible(true);
	}

}
