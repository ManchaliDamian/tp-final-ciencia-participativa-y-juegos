package ar.edu.unq.po2.tp.Final;

public class Desafio {
	private Area area;
	private Restricciones restriccionesTemp;
	private int cantMuestras;
	private int dificultad;
	private int recompensa;
	
	public Desafio(Area area, Restricciones restriciones, int cantMuestras , int dificultad , int recompesas) {
		setArea(area);
		setRestriccionesTemp(restriciones); 
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

	public boolean cumpleConRestriccion(Muestra muestra) { 
		return getRestriccionesTemp().isMuestraValida(muestra);
	}  

}
