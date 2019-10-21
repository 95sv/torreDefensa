package Logica;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import Disparo.Disparo;
import Disparo.DisparoAliado;
import Entidad.Enemigo;
import Entidad.Entidad;
import Entidad.Torre;
import Entidad.BarMoe;
import Entidad.Bart;
import Entidad.CasaSimpson;
import Grafica.Grafica;
import Hilos.HiloDisparo;
import Hilos.HiloEnemigo;
import Mapa.Celda;
import Mapa.Mapa;

public class Logica {

	protected Grafica grafica;
	protected Mapa mapa;
	protected Collection<Entidad> misEntidades;
	protected Collection<Disparo> misDisparos;

	protected HiloDisparo hiloDisparo;
	protected HiloEnemigo hiloEnemigo;

	public Logica(Grafica grafica) {
		this.grafica = grafica;
		mapa = new Mapa(this);
		misEntidades = new ConcurrentLinkedDeque<Entidad>();
		misDisparos = new ConcurrentLinkedDeque<Disparo>();

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
		Random rnd = new Random();
		int random = rnd.nextInt(5);
		Celda celda = mapa.getCelda(9, random);
		Torre j = new BarMoe(mapa, celda);
		misEntidades.add(j);
		celda.agregarEntidad(j);
		j.setCelda(celda);
		grafica.graficarEntidad(j);
		agregarDisparo(j);

	}

	public void agregarEnemigo() {
		Random rnd = new Random();
		int random = rnd.nextInt(5);

		Celda celda = mapa.getCelda(0, random);
		Enemigo e = new Bart(mapa, celda);
		celda.agregarEntidad(e);
		misEntidades.add(e);
		e.setCelda(celda);
		grafica.graficarEntidad(e);
	}

	public void eliminarEntidad(Entidad e) {
		Celda celda = e.getCelda();
		grafica.eliminarEntidad(e);
		celda.eliminarEntidad();
		misEntidades.remove(e);
	}

	public void eliminarDisparo(Disparo d) {
		System.out.println("Eliminar Disparo " + misDisparos.size());
		Celda celda = d.getCelda();
		celda.eliminarEntidad();
		misDisparos.remove(d);
		grafica.eliminarEntidad(d);
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

	private void agregarDisparo(Torre miTorre) {
		Celda celda = mapa.getCelda(miTorre.getX()-1, miTorre.getY());
		Disparo e = new DisparoAliado(mapa, celda, miTorre, 1, 1);
		celda.agregarEntidad(e);
		misDisparos.add(e);
		e.setCelda(celda);
		grafica.graficarEntidad(e);
	}

	public void crearHiloDisparo() {
		hiloDisparo = new HiloDisparo(this);
		hiloDisparo.start();
	}

	public void moverDisparos() {
		for (Disparo e : misDisparos) {
			if (e.mover()) {
				grafica.graficarEntidad(e);
			}
		}
	}

	public Entidad getEntidad(int x, int y) {
		return mapa.getEntidad(x, y);
	}

}