package ar.edu.unq.po2.tp.Final.Usuario;

import ar.edu.unq.po2.tp.Final.Muestra.Area;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;
import ar.edu.unq.po2.tp.Final.Restricciones.Restricciones;

public class Desafio {
	private Area area;
	private String nombre; 
	private Restricciones restriccionesTemp;
	private int cantMuestras;
	private int dificultad;
	private int recompensa;
	
	
	<<Correcion>> Este Objeto no tiene mucha responsabilidades. Esto es debido a que rompen encapsulamiento 
	
	
	public Desafio(Area area, Restricciones restriciones, int cantMuestras , int dificultad , int recompesas, String nombre) {
		setArea(area);
		setRestriccionesTemp(restriciones); 
		setNombre(nombre);
		setCantMuestras(cantMuestras);
		setDificultad(dificultad);
		setRecompensa(recompesas);
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Restricciones getRestriccionesTemp() {
		return restriccionesTemp;
	}

	public void setRestriccionesTemp(Restricciones restriccionesTemp) {
		this.restriccionesTemp = restriccionesTemp;
	}

	public int getCantMuestras() { 
		return cantMuestras;
	}

	public void setCantMuestras(int cantMuestras) {
		this.cantMuestras = cantMuestras;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	public int getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(int recompensa) {
		this.recompensa = recompensa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer coincidenciaPorPref(Usuario usuario) {
		int coin = this.diferenciaEntre(cantMuestras, usuario.cantMuestrasPref()) + 
				diferenciaEntre(dificultad, usuario.dificultadPref()) + 
				diferenciaEntre(recompensa, usuario.recompensaPref()); 
				
		return coin;
	}  
	
	public Integer coincidenciaPorFav(Desafio desafioConMayorPuntaje) {
		int coin = this.diferenciaEntre(cantMuestras, desafioConMayorPuntaje.getCantMuestras()) + 
				diferenciaEntre(dificultad, desafioConMayorPuntaje.getDificultad()) + 
				diferenciaEntre(recompensa, desafioConMayorPuntaje.getRecompensa());
		return coin;
	}
	
	public int diferenciaEntre(int unNumero, int otroNumero) {
		return Math.abs(unNumero - otroNumero); 
	}

	
	
	//public boolean cumpleConRestriccion(Muestra muestra) {
		//	<<Correcion>> Falta la validacion sobre la muestra y el area.
		//	return getRestriccionesTemp().isMuestraValida(muestra);
		//}


	
	
}
