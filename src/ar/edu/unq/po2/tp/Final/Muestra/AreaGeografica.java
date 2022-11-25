package ar.edu.unq.po2.tp.Final.Muestra;

public class AreaGeografica {
	private CoordenadaGeografica coordenada;
	private int radio;

	public AreaGeografica(CoordenadaGeografica unaCoordenada, int unRadio) {
		setCoordenada(unaCoordenada);
		setRadio(unRadio);
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
		return cordGeografica.seEncuentraDentroDelRadio(this);
	}

	

}
