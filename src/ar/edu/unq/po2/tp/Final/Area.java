package ar.edu.unq.po2.tp.Final;

public class Area {
    private Coordenada coordenada;
    private int radio;
    
    public Area(Coordenada unaCoordenada , int unRadio) {
    	setCoordenada(unaCoordenada);
    	setRadio(unRadio);  	
    }
    
    public int calcularArea() {
    	return sumaDeLatitudYLonguitud() + getRadio();
    }
    
    public int sumaDeLatitudYLonguitud() {
    	return getCoordenada().getLatitud() + getCoordenada().getLonguitud(); 
    }
    
    public Coordenada getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	public int getRadio() {
		return radio;
	}
	public void setRadio(int radio) {
		this.radio = radio;
	}
}
