

import ar.edu.unq.po2.tp.Final.Muestra.CoordenadaGeografica;

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
	
	public int longitudDeCoordenada() {
		return coordenada.getLongitud();
	}
	
	public int latitudDeCoordenada() {
		return coordenada.getLatitud();
	}

	public boolean esCoordenadaGeograficaValida(CoordenadaGeografica cordGeografica) {
		//return calculoPitagoras(cordGeografica) <= radio;
		return cordGeografica.seEncuentraDentroDelRario(this);
	}

	
 
}
