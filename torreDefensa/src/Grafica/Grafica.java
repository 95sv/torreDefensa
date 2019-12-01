package Grafica;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Botonera.Boton;
import Botonera.BotonBarricada;
import Botonera.BotonFuego;
import Botonera.BotonTorreArena;
import Botonera.BotonTorreBasica;
import Botonera.BotonTorreControl;
import Botonera.BotonTorreDoble;
import Botonera.BotonTorreRoca;
import Entidad.Entidad;
import Logica.Logica;

public class Grafica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private Logica logica;
	private Boton botonTorre;
	private JLabel lblPuntaje;
	private JLabel lblMoneda;
	private JLabel lblPerder;
	private JLabel lblGanar;
	private JButton btnPerder;

	private static final int PIXEL = 64;

	public static void main(String[] args) {
		Grafica grafica = new Grafica();
		grafica.setVisible(true);
		grafica.setTitle("Tower Defense");
	}

	public Grafica() {
		getContentPane().setLayout(null);
		setSize(1050, 470);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		crearPanel1();

		logica = new Logica(this);
		menuCompra();
		menuPuntaje();
	}

	public void crearPanel1() {
		panelFondo = new BackgroundPanel();
		panelFondo.setLayout(null);
		panelFondo.setSize(640, 384);
		panelFondo.setBounds(0, 0, 640, 384);
		setContentPane(panelFondo);
	}

	public void crearPanel2() {

		panelFondo = new BackgroundPanel2();
		panelFondo.setLayout(null);
		panelFondo.setSize(640, 384);
		panelFondo.setBounds(0, 0, 640, 384);
		setContentPane(panelFondo);
	}
	
	public void cambiarNivel() {
		crearPanel2();
	}

	public void menuPuntaje() {
		JPanel panelPuntaje = new JPanel();
		panelPuntaje.setLayout(new FlowLayout());
		panelFondo.add(panelPuntaje);
		panelPuntaje.setBackground(Color.DARK_GRAY);
		panelPuntaje.setSize(850, 50);
		panelPuntaje.setBounds(0, 384, 850, 50);

		lblPuntaje = new JLabel("Puntaje = " + logica.getPuntaje());
		lblMoneda = new JLabel("  Moneda = " + logica.getMoneda());
		lblPuntaje.setForeground(Color.YELLOW);
		lblMoneda.setForeground(Color.YELLOW);
		panelPuntaje.add(lblMoneda);
		panelPuntaje.add(lblPuntaje);
	}

	public void menuCompra() {
		// Creo panel de compras.
		JPanel panelCompras = new JPanel();
		panelCompras.setLayout(new GridLayout(5, 2));
		panelFondo.add(panelCompras);
		panelCompras.setBackground(Color.BLACK);
		panelCompras.setBounds(640, 0, 400, 384);

		panelFondo.addMouseListener(new crearTorre());
		panelCompras.add(new BotonTorreBasica(new oyenteJugador()));
		panelCompras.add(new BotonTorreArena(new oyenteJugador()));
		panelCompras.add(new BotonTorreRoca(new oyenteJugador()));
		panelCompras.add(new BotonTorreControl(new oyenteJugador()));
		panelCompras.add(new BotonTorreDoble(new oyenteJugador()));
		panelCompras.add(new BotonBarricada(new oyenteJugador()));
		panelCompras.add(new BotonFuego(new oyenteJugador()));

	}

	class BackgroundPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private Image imagen1 = new ImageIcon("./src/Recursos/Fondos/fondo1.png").getImage();

		public void paint(Graphics g) {
			g.drawImage(imagen1, 0, 0, 640, 390, this);
			setOpaque(false);
			super.paint(g);
		}

	}

	class BackgroundPanel2 extends JPanel {
		private static final long serialVersionUID = 1L;
		private Image imagen2 = new ImageIcon("./src/Recursos/Fondos/fondo2.png").getImage();

		public void paint(Graphics g) {
			g.drawImage(imagen2, 0, 0, 640, 390, this);
			setOpaque(false);
			super.paint(g);
		}

	}

	public void graficarEntidad(Entidad e) {
		JLabel label = e.getImagen();
		panelFondo.add(label);
		label.setBounds((e.getCelda().getX() * PIXEL), e.getCelda().getY() * PIXEL, PIXEL, PIXEL);
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

	public void actualizarPuntaje() {
		lblPuntaje.setText("Puntaje : " + logica.getPuntaje());
	}

	public void actualizarMoneda() {
		lblMoneda.setText("Monedas : " + logica.getMoneda());
	}

	public void perder() {

		lblPerder = new JLabel("PERDISTE");
		btnPerder = new JButton("REINICIAR");

		panelFondo.add(lblPerder);
		panelFondo.add(btnPerder);

		lblPerder.setVisible(true);
		lblPerder.setBounds(300, 100, 200, 100);

		btnPerder.setVisible(true);
		btnPerder.setBounds(260, 200, 150, 50);

		btnPerder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();
				btn.setVisible(false);
				btnPerder.setVisible(false);
				lblPerder.setVisible(false);
				
				if (btn.getText() == "REINICIAR") {
					panelFondo.remove(lblPerder);
					panelFondo.remove(btnPerder);
					logica.reiniciarNivel();
				}
				panelFondo.repaint();
			}
		});

	}
	
	public void terminar() {
		lblGanar = new JLabel("GANASTE");
		lblGanar.setVisible(true);
		lblGanar.setBounds(260, 200, 150, 50);
		
		getContentPane().add(lblGanar);
	}



	private class crearTorre extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (botonTorre != null) {
				if (e.getX() >= 196 && e.getX() <= 640) {
					if (logica.getMapa().getCelda(e.getX() / PIXEL, e.getY() / PIXEL).cantEntidades() == 0) {

						botonTorre.crearEntidad(logica.getMapa(),
								logica.getMapa().getCelda(e.getX() / PIXEL, e.getY() / PIXEL));
					}
					botonTorre.setBorder(null);
					botonTorre = null;
				}

			}

		}
	}
}