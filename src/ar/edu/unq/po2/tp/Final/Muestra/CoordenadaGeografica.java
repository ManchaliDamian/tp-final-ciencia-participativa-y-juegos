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
	
	
}
