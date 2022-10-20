package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	private String nombre;
	private String descripción;
	List<Muestra> muestras = new ArrayList<Muestra>();
	List<Categoria> categorias = new ArrayList<Categoria>();
	List<Usuario> participantesActivos = new ArrayList<Usuario>();
	
	public Proyecto(String nombre, String descripción) {
		this.nombre = nombre;
		this.descripción = descripción; 
		new ArrayList<Muestra>();
		new ArrayList<Categoria>();
		new ArrayList<Usuario>();
	}
	
	public void agregarMuestra(Muestra unaMuestra) {
		muestras.add(unaMuestra); 
	}
	
	public void agregarCategoria(Categoria unaCategoria) {
		categorias.add(unaCategoria);
	}
	
	public void agregarParticipante(Usuario unParticipante) {
		participantesActivos.add(unParticipante);  
	}
	
	public List<Muestra> getMuestras() {
		return muestras;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public List<Usuario> getUsuarios() {
		return participantesActivos;
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
