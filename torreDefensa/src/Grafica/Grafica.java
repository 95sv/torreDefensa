package Grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Logica;
import Mapa.Mapa;

public class Grafica extends JFrame{
	
	private JPanel panelFondo;
	private Logica logica;
	private JLabel fondoImagen;
	private Icon iconoFondo;
	
	public static void main (String [] args) {
		Grafica grafica = new Grafica();		
		grafica.setVisible(true);
		grafica.setTitle("Tower Defense");
	}
	
	public Grafica() {
	
		panelFondo = new JPanel();
		setContentPane(panelFondo);
		setSize(680,460);
		setLocationRelativeTo(null);
		setResizable(false);
		panelFondo.setBorder(new EmptyBorder(0,0,0,0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		iconoFondo = new ImageIcon(this.getClass().getResource("/Recursos/Background/battleback1.png"));
		fondoImagen = new JLabel(iconoFondo);
		panelFondo.add(fondoImagen);
		fondoImagen.setIcon(iconoFondo);
		
		logica = new Logica(this);
	}
	
	
}
