package Grafica;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Entidad.Entidad;
import Logica.Logica;

public class Grafica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelFondo;
	private Logica logica;
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;

	public static void main(String[] args) {
		Grafica grafica = new Grafica();
		grafica.setVisible(true);
		grafica.setTitle("Tower Defense");
	}

	public Grafica() {
		getContentPane().setLayout(null);
		setSize(850, 430);
		setLocationRelativeTo(null);
		setResizable(false);
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
		JLabel label = e.getImagen();
		panelFondo.add(label);
		label.setBounds(e.getCelda().getX() * 64, e.getCelda().getY() * 64, 64, 64);
		label.setVisible(true);
		panelFondo.setComponentZOrder(label, 0);
	}
	
	public void eliminarEntidad(Entidad e) {
		JLabel label = e.getImagen();
		panelFondo.remove(label);
		panelFondo.revalidate();
		panelFondo.repaint();
	}
	public void menuCompra() {
		// Creo panel de compras.
		JPanel panelCompras = new JPanel();
		panelCompras.setLayout(new FlowLayout());
		panelFondo.add(panelCompras);
		panelCompras.setBackground(Color.BLACK);
		panelCompras.setSize(200, 560);
		panelCompras.setBounds(650, 0, 200, 560);

		boton1 = new JButton("Agregar Jugador");
		panelCompras.add(boton1);
		boton1.setSize(32, 32);
		oyenteJugador oyente = new oyenteJugador();
		boton1.addActionListener(oyente);
		
		boton2 = new JButton("Agregar enemigo");
		panelCompras.add(boton2);
		boton2.setSize(32,32);
		oyenteEnemigo oyenteE = new oyenteEnemigo();
		boton2.addActionListener(oyenteE);
		
		boton3 = new JButton("Eliminar Enemigo");
		panelCompras.add(boton3);
		boton3.setSize(32,32);
		oyenteEliminar oyenteEE = new oyenteEliminar();
		boton3.addActionListener(oyenteEE);;
	}

	private class oyenteJugador implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
				logica.agregarJugador();
				logica.agregarDisparo();//---------------------------------------------------
				
				boton1.setEnabled(false);
				logica.crearHiloDisparo();
				
			
		}
	}
	
	private class oyenteEnemigo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boton2.setEnabled(false);
		}	
	}
	
	private class oyenteEliminar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			boton3.setEnabled(false);
		}
		
	}
}