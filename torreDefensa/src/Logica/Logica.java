package Logica;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import Disparo.Disparo;
import Disparo.DisparoBasico;
import Disparo.DisparoTierra;
import Entidad.Enemigo;
import Entidad.Entidad;
import Entidad.Torre;
import Entidad.TorreArena;
import Grafica.Grafica;
import Hilos.HiloDisparo;
import Hilos.HiloEnemigo;
import Mapa.Celda;
import Mapa.Mapa;
import PowerUp.AumentoMoneda;
import PowerUp.AumentoVida;
import PowerUp.DobleDano;
import PowerUp.PowerUp;

public class Logica {

	protected Grafica grafica;
	protected Mapa mapa;
	protected Collection<Torre> misTorres;
	protected Collection<Enemigo> misEnemigos;
	protected Collection<Disparo> misDisparos;

	protected HiloDisparo hiloDisparo;
	protected HiloEnemigo hiloEnemigo;

	private int puntaje;
	private int moneda;

	protected boolean perder = false;

	public Logica(Grafica grafica) {
		this.grafica = grafica;
		mapa = new Mapa(this);
		misTorres = new ConcurrentLinkedDeque<Torre>();
		misEnemigos = new ConcurrentLinkedDeque<Enemigo>();
		misDisparos = new ConcurrentLinkedDeque<Disparo>();

		puntaje = 0;
		moneda = 1000;

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
	
	public int getPuntaje() {
		return puntaje;
	}

	public int getMoneda() {
		return moneda;
	}

	public Grafica getGrafica() {
		return grafica;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public boolean perder() {
		perder = true;
		return terminar();
	}

	public void agregarPuntaje(int pun) {
		puntaje= puntaje+pun;
		grafica.actualizarPuntaje();
	}

	public void agregarMoneda(int moneda) {
		this.moneda += moneda;
		grafica.actualizarMoneda();
	}

	public boolean terminar() {
		return perder;
	}

	public void agregarJugador(Torre torre) {
		// Celda: getCelda( [0..9], [0..5]).
		Celda celda = mapa.getCelda(torre.getX(), torre.getY());
		misTorres.add(torre);
		celda.agregarEntidad(torre);
		torre.setCelda(celda);
		grafica.graficarEntidad(torre);
		agregarDisparo(torre);
		moneda -= torre.getPrecio();
		grafica.actualizarMoneda();
	}

	public void agregarEnemigo(Enemigo e, Celda celda) {
		celda.agregarEntidad(e);
		misEnemigos.add(e);
		e.setCelda(celda);
		grafica.graficarEntidad(e);
	}

	public void agregarEnemigoTierra(Enemigo e, Celda celda) {
		celda.agregarEntidad(e);
		misEnemigos.add(e);
		e.setCelda(celda);
		grafica.graficarEntidad(e);
	    //agregarDisparoEnemigo(e);
	}
	
	public void eliminarEntidad(Entidad e) {
		Celda celda = e.getCelda();
		grafica.eliminarEntidad(e);
		celda.eliminarEntidad();
		misTorres.remove(e);
	}

	
	public void eliminarEnemigo(Enemigo e) {
		agregarPuntaje(e.getPuntos());
		grafica.actualizarPuntaje();
		Celda celda = e.getCelda();
		grafica.eliminarEntidad(e);
		celda.eliminarEntidad();
		misEnemigos.remove(e);
		System.out.println("AGREGUE PUNTAJE");
	}

	public void eliminarDisparo(Disparo d) {
		Celda celda = d.getCelda();
		celda.eliminarEntidad();
		misDisparos.remove(d);
		grafica.eliminarEntidad(d);
	}

	public void moverEnemigos() {
		for (Enemigo e : misEnemigos) {
			e.mover();
			grafica.graficarEntidad(e);
		}
	}

	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}

	private void agregarDisparo(Torre miTorre) {
		Celda celda = mapa.getCelda(miTorre.getX() - 1, miTorre.getY());
		Disparo e = new DisparoBasico(mapa, celda, miTorre, 1, 1);
		celda.agregarEntidad(e);
		misDisparos.add(e);
		e.setCelda(celda);
		grafica.graficarEntidad(e);
	}
	
	public void agregarDisparoEnemigo(Enemigo miEnemigo) {
		 // if(miEnemigo.estoyParado()) {	
		  //System.out.println("ENTRO A DISPARO");
		  Celda celda = mapa.getCelda(miEnemigo.getX()+1,miEnemigo.getY());
		  Disparo e = new DisparoTierra(mapa, celda, miEnemigo,1,1);
		  celda.agregarEntidad(e);
		  misDisparos.add(e);
		  e.setCelda(celda);
		  grafica.graficarEntidad(e);
	  // }
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

	public void seleccionarPowerUp(Celda celda) {
		/*
		 * Elegir aleatoriamente un powerUp.
		 */

		PowerUp powerUp;
		Random rnd = new Random();
		int azar = rnd.nextInt(100);
		if (azar >= 0 && azar <= 20) {
			powerUp = new AumentoMoneda(mapa, celda);
		} else {
			if (azar > 20 && azar <= 40) {
				powerUp = new AumentoVida(mapa, celda);
			} else {
				powerUp = new DobleDano(mapa, celda);
			}
		}
		if (powerUp != null) {
			grafica.graficarEntidad(powerUp);
		}
	}

	public Collection<Enemigo> getEnemigos() {
		return misEnemigos;
	}

	public Collection<Torre> getMisTorres(){
		return misTorres;
	}
	
	public void eliminarPowerUp(PowerUp p) {
		grafica.eliminarEntidad(p);
	}
	
	public void powerUpVida() {
		for(Torre torre : misTorres) {
			torre.setVida(100);
		}
	}
}