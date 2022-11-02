package ar.edu.unq.po2.tp.Final;

public class Categoria {
	private String nombre;
	private String descripción; 
	
	public Categoria (String unNombre, String unaDescripcion){
		this.nombre = unNombre;
		this.descripción = unaDescripcion; 
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripción() {
		return descripción;
	}
	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}

}
