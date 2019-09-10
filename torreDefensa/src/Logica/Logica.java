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
	//	agregarJugador();
	}
	
	public Mapa getMapa() {
		return mapa;
	}
	
	/*private void agregarJugador() {
		jugadores = new LinkedList<Jugador>();
		Celda celda = mapa.getCelda(3,0);
		
		Jugador j = new Jugador1(3,0);
		celda.agregarEntidad(j);
		j.setCelda(celda);
		grafica.repaint();
	}*/
}
