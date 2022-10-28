package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	private String nombre;
	private String descripción;
	private List<Muestra> muestras = new ArrayList<Muestra>();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private List<Usuario> participantesActivos = new ArrayList<Usuario>();
	
	public Proyecto(String nombre, String descripción) {
		this.nombre = nombre;
		this.descripción = descripción; 
		new ArrayList<Muestra>();
		new ArrayList<Categoria>();
		new ArrayList<Usuario>();
	}
	
	public void agregarMuestra(Muestra unaMuestra) {
		if(participantesActivos.contains(unaMuestra.getUsuario())) {
			muestras.add(unaMuestra); 
		}
		
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
	
	public List<Usuario> getParticipantesActivos() {
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

	public void eliminarParticipante(Usuario participante) {
		participantesActivos.remove(participante); 
		
	}

	public void eliminarCategoria(Categoria categoria) {
		categorias.remove(categoria); 
		
	}

	public void eliminarMuestra(Muestra muestra) {
		muestras.remove(muestra); 
		
	}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	
	
=======
>>>>>>> 154b7b74123081a7c56f829157473bfa6f5f32a2
=======
>>>>>>> 154b7b74123081a7c56f829157473bfa6f5f32a2
=======
>>>>>>> 154b7b74123081a7c56f829157473bfa6f5f32a2

}
