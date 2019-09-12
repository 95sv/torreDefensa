package Logica;

import java.util.LinkedList;

import Entidad.Jugador;
import Entidad.Jugador1;
import Grafica.Grafica;
import Mapa.Celda;
import Mapa.Mapa;

public class Logica {
	
	protected Grafica grafica;
	protected Mapa mapa;
	protected LinkedList<Jugador> jugadores;
	
	public Logica(Grafica grafica) {
		this.grafica = grafica;
		mapa = new Mapa();
		jugadores = new LinkedList<Jugador>();
		agregarJugador();
	}
	
	public Mapa getMapa() {
		return mapa;
	}
	
	private void agregarJugador() {
		Celda celda = mapa.getCelda(3,1);

		System.out.println("FILAS MAPA : "+ mapa.getFilas());
		System.out.println("COLUMNAS MAPA : "+ mapa.getColumnas());
		System.out.println("CELDA : X = "+ celda.getX() +" Y = "+ celda.getY());
	
		Jugador j = new Jugador1(3,1);
		jugadores.add(j);
		celda.agregarEntidad(j);
		j.setCelda(celda);
		grafica.graficarEntidad(j);
		
		System.out.println("QUE HAY EN LA CELDA X Y "+mapa.getCelda(3, 1).getEntidad().toString());
		System.out.println("Jugadores : "+jugadores.size());
		
		grafica.repaint();
	}
}