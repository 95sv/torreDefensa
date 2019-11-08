package Grafica;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Botonera.Boton;
import Botonera.BotonTorreArena;
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
	
	public static void main(String[] args) {
		Grafica grafica = new Grafica();
		grafica.setVisible(true);
		grafica.setTitle("Tower Defense");
	}

	public Grafica() {
		getContentPane().setLayout(null);
		setSize(850, 470);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelFondo = new BackgroundPanel();
		panelFondo.setLayout(null);
		panelFondo.setSize(640,384);
		panelFondo.setBounds(0, 0, 640, 384);
		setContentPane(panelFondo);
		
		logica = new Logica(this);
		menuCompra();
		menuPuntaje();
	}
	
	public void menuPuntaje() {
		JPanel panelPuntaje = new JPanel();
		panelPuntaje.setLayout(new FlowLayout());
		panelFondo.add(panelPuntaje);
		panelPuntaje.setBackground(Color.DARK_GRAY);
		// Panel puntaje ocupa todo el ancho.
		panelPuntaje.setSize(850,50);
		panelPuntaje.setBounds(0, 384, 850, 50);
		
		lblPuntaje = new JLabel("Puntaje = " + logica.getPuntaje());
		lblMoneda = new JLabel("  Moneda = "+ logica.getMoneda());
		lblPuntaje.setForeground(Color.YELLOW);
		lblMoneda.setForeground(Color.YELLOW);
		panelPuntaje.add(lblMoneda);
		panelPuntaje.add(lblPuntaje);
	}

	public void menuCompra() {
		// Creo panel de compras.
		JPanel panelCompras = new JPanel();
		panelCompras.setLayout(new FlowLayout());
		panelFondo.add(panelCompras);
		panelCompras.setBackground(Color.BLACK);
		// Panel compra ocupa todo el alto.
		panelCompras.setBounds(640, 0, 200, 384);

		panelFondo.addMouseListener(new crearTorre());
		panelCompras.add(new BotonTorreArena(new oyenteJugador()));

	}

	class BackgroundPanel extends JPanel {
		private static final long serialVersionUID = 1L;
	    private Image imagen = new ImageIcon("./src/Recursos/Fondos/fondo1.png").getImage();
		public void paint(Graphics g) {
			g.drawImage(imagen, 0, 0, 640, 390, this);
			setOpaque(false);
			super.paint(g);
		}

	}

	public void graficarEntidad(Entidad e) {
		JLabel label = e.getImagen();
		panelFondo.add(label);
		label.setBounds((e.getCelda().getX() * 64),e.getCelda().getY() * 64 , 64, 64);
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

	private class crearTorre extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (botonTorre != null) {
				if (e.getX() >= 196 && e.getX()<= 640) {
						if(logica.getMapa().getCelda(e.getX() / 64, e.getY() / 64).getEntidad() == null) {
					       botonTorre.crearTorre(logica.getMapa(), logica.getMapa().getCelda(e.getX() / 64, e.getY() / 64));      
						}
						 botonTorre.setBorder(null);
						botonTorre = null;
				}		
				
			}
			
		}
	}
}