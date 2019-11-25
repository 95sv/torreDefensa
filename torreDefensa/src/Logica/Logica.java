package Logica;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import Entidad.Entidad;
import Grafica.Grafica;
import Hilos.HiloEntidades;
import Mapa.Celda;
import Mapa.Mapa;
import PowerUp.AumentoMoneda;
import PowerUp.AumentoVida;
import PowerUp.DobleGolpe;
import PowerUp.PowerUp;

public class Logica {

	protected Grafica grafica;
	protected Mapa mapa;
	protected Collection<Entidad> misEntidades;
	
	protected HiloEntidades hiloEntidades;

	private int puntaje;
	private int moneda;

	protected boolean perder = false;

	public Logica(Grafica grafica) {
		this.grafica = grafica;
		misEntidades = new ConcurrentLinkedDeque<Entidad>();

		puntaje = 0;
		moneda = 1000;
		
		mapa = new Mapa(this);
		cargarOleada();
	}

	public void cargarOleada() {
		mapa.getNivel().cargarOleada();
		crearHilos();
	}

	public void crearHilos() {
		hiloEntidades = new HiloEntidades(this);
		hiloEntidades.start();
	}
	
	
	public boolean perder() {
		perder = true;
		return terminar();
	}

	public void agregarPuntaje(int puntaje) {
		this.puntaje += puntaje;
		grafica.actualizarPuntaje();
	}

	public void agregarMoneda(int moneda) {
		this.moneda += moneda;
		grafica.actualizarMoneda();
	}

	public boolean terminar() {
		return perder;
	}
	
	public void moverEntidades() {
		for(Entidad e : misEntidades) {
			e.mover();
		}
	}
	public void agregarEntidad(Entidad e,Celda celda) {
		misEntidades.add(e);
		celda.agregarEntidad(e);
		e.setCelda(celda);
		grafica.graficarEntidad(e);
	}
	
	public void eliminarEntidad(Entidad e) {
		Celda celda = e.getCelda();
		grafica.eliminarEntidad(e);
		celda.eliminarEntidad();
		misEntidades.remove(e);
	}

	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}
	
	public void seleccionarPowerUp(Celda celda) {
		/*
		 * 
		 * Elegir aleatoriamente un powerUp.
		 *
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
				powerUp = new DobleGolpe(mapa, celda);
			}
		}
		if (powerUp != null) {
			grafica.graficarEntidad(powerUp);
		}
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

/*
*	Hay que volver a acomodar los power ups, ahora que solamente tenemos una lista de entidades.
*	Para eso, tenemos que tener un metodo en Personaje o Entidad, que solo sera implementado por los personajes 
*	que reciban efecto de un power up.
*
*
	public void eliminarPowerUp(PowerUp p) {
		grafica.eliminarEntidad(p);
	}
	
	public void powerUpVida() {
		for(Entidad e : misEntidades) {
			e.activarPowerUp();s
		}
	}
*/
}