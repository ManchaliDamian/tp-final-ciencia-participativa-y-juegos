package ar.edu.unq.po2.tp.Final.Usuario;

public class Preferencia {
    private int dificultad; // es de 1 a 5 
    private int recompensa;
    private int cantidadDeMuestras;
    
    public Preferencia(int unaDificultad , int unaRecompensa , int cantMuestras) {
    	setCantidadDeMuestras(cantMuestras);
    	setDificultad(unaDificultad);
    	setRecompensa(unaRecompensa);
    }
     
	public Integer getDificultad() {
		return dificultad;
	}
	public void setDificultad(Integer dificultad) {
		this.dificultad = dificultad;
	}
	public Integer getRecompensa() {
		return recompensa;
	}
	public void setRecompensa(Integer recompensa) {
		this.recompensa = recompensa;
	}
	public Integer getCantidadDeMuestras() {
		return cantidadDeMuestras;
	}
	public void setCantidadDeMuestras(Integer cantidadDeMuestras) {
		this.cantidadDeMuestras = cantidadDeMuestras;
	} 
}
