package Grafica;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Botonera.Boton;
import Botonera.BotonBarMoe;
import Entidad.BarMoe;
import Entidad.Entidad;
import Entidad.Torre;
import Logica.Logica;
import Mapa.Celda;

public class Grafica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelFondo;
	private Logica logica;
	private Boton botonTorre;

	public static void main(String[] args) {
		Grafica grafica = new Grafica();
		grafica.setVisible(true);
		grafica.setTitle("Tower Defense");
	}

	public Grafica() {
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		//setContentPane(contentPane);
		setSize(850, 430);
		//contentPane.setSize(850,430);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelFondo = new BackgroundPanel();
		panelFondo.setLayout(null);
		panelFondo.setSize(640,384);
		setContentPane(panelFondo);
		
		logica = new Logica(this);
		menuCompra();
	}

	public void menuCompra() {
		// Creo panel de compras.
		JPanel panelCompras = new JPanel();
		panelCompras.setLayout(new FlowLayout());
		panelFondo.add(panelCompras);
		panelCompras.setBackground(Color.BLACK);
		panelCompras.setSize(200, 560);
		panelCompras.setBounds(650, 0, 200, 560);

		panelFondo.addMouseListener(new crearTorre());
		panelCompras.add(new BotonBarMoe(new oyenteJugador()));

	}

	class BackgroundPanel extends JPanel {
		private static final long serialVersionUID = 1L;
	    private Image imagen = new ImageIcon("./src/Recursos/Background/battleback1.png").getImage();
		//private Image imagen = new ImageIcon("./src/RecursosLosSimpson/springfieldFondo.png").getImage();
		public void paint(Graphics g) {
			g.drawImage(imagen, 0, 0, 650, 390, this);
			setOpaque(false);
			super.paint(g);
		}

	}

	public void graficarEntidad(Entidad e) {
		JLabel label = e.getImagen();
		panelFondo.add(label);
		label.setBounds(e.getCelda().getX() * 64, e.getCelda().getY() * 64, 64, 64);
		label.setVisible(true);
		panelFondo.setComponentZOrder(label, 0);
	}

	public void eliminarEntidad(Entidad e) {
		JLabel label = e.getImagen();
		panelFondo.remove(label);
		panelFondo.repaint();
	}

	private class oyenteJugador implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (botonTorre != null) {
				botonTorre.setBorder(null);
			}
			botonTorre = (Boton) e.getSource();
			botonTorre.setBorder(BorderFactory.createLineBorder(Color.RED));
		}
	}

	private class crearTorre extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (botonTorre != null) {
				System.out.println("X = " + e.getX() / 64 + " Y =" + e.getY() / 64);
				if (e.getX() >= 196 && e.getX()<= 640) {
						if(logica.getMapa().getCelda(e.getX() / 64, e.getY() / 64).getEntidad() == null) {
						
					       botonTorre.crearTorre(logica.getMapa(), logica.getMapa().getCelda(e.getX() / 64, e.getY() / 64));
					       System.out.println("X = " + e.getX() / 64 + " Y =" + e.getY() / 64);
					      
						}
						 botonTorre.setBorder(null);
						botonTorre = null;
				}		
				
			}
			
		}
	}
}