package ar.edu.unq.po2.tp.Final.Muestra;

public class CoordenadaGeografica {

	private int latitud;
	private int longitud;
	
	public CoordenadaGeografica(int latitud, int longitud) {
		this.latitud = latitud;
		this.longitud = longitud; 
	}

	public int getLatitud() {
		return latitud;
	}

	public void setLatitud(int latitud) {
		this.latitud = latitud;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public boolean seEncuentraDentroDelRario(Area area) {
		return distanciaSobreElArea(area) <= area.getRadio();
	}
	
	public double distanciaSobreElArea(Area area) {
		int resultado = diferenciaYMultEntre(area.longitudDeCoordenada(), longitud)
				+ diferenciaYMultEntre(area.latitudDeCoordenada(), latitud);

		return Math.sqrt(resultado); //Raíz cuadrada
	}

	public int diferenciaYMultEntre(int longitud, int longitud2) {
		int dif = longitud2 - longitud;
		int mult = dif * dif; 
		return mult;
	}
	
	
}
