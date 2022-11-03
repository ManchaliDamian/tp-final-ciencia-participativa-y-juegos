package ar.edu.unq.po2.tp.Final;

public class Area {
	private CoordenadaGeografica coordenada;
	private int radio;

	public Area(CoordenadaGeografica unaCoordenada, int unRadio) {
		setCoordenada(unaCoordenada);
		setRadio(unRadio);
	}

	public CoordenadaGeografica getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(CoordenadaGeografica coordenada) {
		this.coordenada = coordenada;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public boolean esCoordenadaGeograficaValida(CoordenadaGeografica cordGeografica) {
		return calculoPitagoras(cordGeografica) <= radio;
	}

	public double calculoPitagoras(CoordenadaGeografica cordGeografica) {
		int resultado = diferenciaYMultEntre(coordenada.getLongitud(), cordGeografica.getLongitud())
				+ diferenciaYMultEntre(coordenada.getLatitud(), cordGeografica.getLatitud());

		return Math.sqrt(resultado); //Raíz cuadrada
	}

	public int diferenciaYMultEntre(int longitud, int longitud2) {
		int dif = longitud2 - longitud;
		int mult = dif * dif; 
		return mult;
	}
 
}
