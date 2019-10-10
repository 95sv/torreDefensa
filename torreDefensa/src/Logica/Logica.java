package Logica;

import java.util.LinkedList;
import java.util.Random;

import Disparo.Disparo;
import Disparo.DisparoBasico;
import Entidad.Enemigo;
import Entidad.Enemigo1;
import Entidad.Entidad;
import Entidad.Torre;
import Entidad.BarMoe;
import Grafica.Grafica;
import Hilos.HiloBala;
import Hilos.HiloEnemigo;
import Mapa.Celda;
import Mapa.Mapa;

public class Logica {

	protected Grafica grafica;
	protected Mapa mapa;
	protected LinkedList<Entidad> misEntidades;
	protected LinkedList<Disparo> misDisparos;
    protected HiloBala hiloBala;
	
	protected HiloEnemigo hiloEnemigo;
	

	public Logica(Grafica grafica) {
		this.grafica = grafica;
		mapa = new Mapa(this);
		misEntidades = new LinkedList<Entidad>();
        misDisparos = new LinkedList<Disparo>();	
        
        cargarOleada();
        
	}
	
	public void cargarOleada() {
		mapa.getNivel().cargarOleada();
		crearHilos();
	}

	public void crearHilos() {
		hiloEnemigo = new HiloEnemigo(this);
			hiloEnemigo.start();
	}
	
	public Grafica getGrafica() {
		return grafica;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public int cantidadEntidades() {
		return misEntidades.size();
	}

	public void agregarJugador() {
		// Celda: getCelda( [0..9], [0..5]).
		Celda celda = mapa.getCelda(9, 2);

		System.out.println("FILAS MAPA : " + mapa.getFilas());
		System.out.println("COLUMNAS MAPA : " + mapa.getColumnas());
		System.out.println("CELDA : X = " + celda.getX() + " Y = " + celda.getY());

		System.out.println("FILAS MAPA : "+ mapa.getFilas());
		System.out.println("COLUMNAS MAPA : "+ mapa.getColumnas());
		System.out.println("CELDA : X = "+ celda.getX() +" Y = "+ celda.getY());
	
		Torre j = new BarMoe(celda,mapa);
		misEntidades.add(j);
		celda.agregarEntidad(j);
		j.setCelda(celda);
		grafica.graficarEntidad(j);

		System.out.println("QUE HAY EN LA CELDA X Y " + j.getCelda().getEntidad().toString());
		System.out.println("Jugadores : " + misEntidades.size());
	}

	public void agregarEnemigo() {
		Random rnd = new Random();
		int random = rnd.nextInt(5);

		Celda celda = mapa.getCelda(0, random);
		Enemigo e = new Enemigo1(celda, mapa);
		celda.agregarEntidad(e);
		LinkedList<Entidad> misEntidades2 = new LinkedList<Entidad>(misEntidades);
		misEntidades2.addFirst(e);
		misEntidades = misEntidades2;
		e.setCelda(celda);
		grafica.graficarEntidad(e);
	}

	public void eliminarEntidad(Entidad e) {
		Celda celda = e.getCelda();
		grafica.eliminarEntidad(e);
		celda.eliminarEntidad();
		misEntidades.remove(e);
	}
	
	public void moverEnemigos() {
		for (Entidad e : misEntidades) {
			e.mover();
			grafica.graficarEntidad(e);
		}
	}

	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}

	public void agregarBala() { 
		Celda celda = mapa.getCelda(8,2);
		Disparo e = new DisparoBasico(celda,1,1, mapa); 
		celda.agregarEntidad(e);
		misDisparos.addFirst(e);
		e.setCelda(celda);
		grafica.graficarEntidad(e);
	}
	
	public void crearHilosBala() {
		hiloBala = new HiloBala(this);
		if (misDisparos.size() != 0) {
			hiloBala.start();
		}
	}
	
	public void moverBala() {
		for (Disparo e : misDisparos) {
			e.mover();
			grafica.graficarEntidad(e);
		}
	}
	
	
	public Entidad getEntidad(int x, int y) {
		return mapa.getEntidad(x, y);
	}
		
}