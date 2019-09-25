package Logica;

import java.util.LinkedList;
import java.util.Random;

import Entidad.Enemigo;
import Entidad.Enemigo1;
import Entidad.Entidad;
import Entidad.Jugador;
import Entidad.Jugador1;
import Grafica.Grafica;
import Mapa.Celda;
import Mapa.Mapa;

public class Logica {

	protected Grafica grafica;
	protected Mapa mapa;
	protected LinkedList<Entidad> misEntidades;
	protected LinkedList<Enemigo> misEnemigos;
	
	public Logica(Grafica grafica) {
		this.grafica = grafica;
		mapa = new Mapa(this);
		misEntidades = new LinkedList<Entidad>();
		misEnemigos = new LinkedList<Enemigo>();
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
		Celda celda = mapa.getCelda(9,2);

		System.out.println("FILAS MAPA : "+ mapa.getFilas());
		System.out.println("COLUMNAS MAPA : "+ mapa.getColumnas());
		System.out.println("CELDA : X = "+ celda.getX() +" Y = "+ celda.getY());
	
		Jugador j = new Jugador1(celda);
		misEntidades.add(j);
		celda.agregarEntidad(j);
		j.setCelda(celda);
		grafica.graficarEntidad(j);
		
		System.out.println("QUE HAY EN LA CELDA X Y "+ j.getCelda().getEntidad().toString());
		System.out.println("Jugadores : "+misEntidades.size());
	}
	
	public void agregarEnemigo() {
		Random rnd = new Random();
		int random = rnd.nextInt(8);
		
		Celda celda = mapa.getCelda(random, 3);
		Enemigo e = new Enemigo1(celda);
		misEnemigos.add(e);
		e.setCelda(celda);
		grafica.graficarEntidad(e);
	}
	
	public void eliminarEnemigo() {
		if(misEnemigos.size() > 0) {
			System.out.println("ENEMIGOS : "+ misEnemigos.size());
			Celda celda = misEnemigos.getFirst().getCelda();
			celda.eliminarEntidad();	
			grafica.eliminarEntidad(misEnemigos.getFirst());
			misEnemigos.remove();
			System.out.println("ENEMIGOS : "+ misEnemigos.size());
			
		}
	}
	
	/*
	 *  hacerMitrabajo(){
	* 	mapa.getState().crearOleada()
	* 	mientras tengo enemigos en mis lista de enemigos
	* 	Agarrar un enimgo de la lista, 
	* 	obtener un numero randpm entre 0 y 5.
	* y coloca enemeigo en [random][0]
	* }
	* 
	* 
	*/
	
	
	
	/* idea de pulso de juego (hilo)
	 * por cada pulso
	 * 	tomo una entidad (Enemigos)
	 * y decido acciones a partir de lo que haya en el mapa...
	 * 
	 * 
	 *
	 */
	
	
	/*
	 * Disparo
	 * 	DisparoAliado
	 * 	DisparoEnemigo
	 *  Visitor (Aca van a tener un visit por cada entidad (EntidadRespectiva r)
	 *  	VisitadorEnemigo
	 *  	Visitador aliado
	 */
	
	/*
	 * enemigo ataca():
	 * 	new DisparoEnemigo(this, miX, miY)
	 * ----
	 * en DisparoEnemigo // la vida del disparo
	 * memuero(); memuevo() hagoDanio()
	 * 	entidadEnFrente.aceptar(new VisitadorEnemigo())
	 * 
	 * En entidad un metodo que se llama aceptar(Visitor v){
	 * 	v.visit(this).
	 * }
	 * 
	 * En visitadorEnemigo tienen entre tantos visit
	 * 
	 * visit(Aliado: a){
	 * 	a.recibirdanio(miEnemigo.getDanio());
	 * 
	 * 
	 * 
	 * */
	
}
