package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tp.Final.Muestra.Muestra;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

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


	public List<Usuario> getParticipantesActivos() {
		return participantesActivos;
	}

	public String getNombre() {
		return nombre;
	}


	public boolean isPerteneceA(List<Proyecto> proyectosFiltro) {
		return proyectosFiltro.contains(this);  
	}

	public boolean isTituloDeseado(String tituloDeseado) {
		return nombre == tituloDeseado;  
	}

	public boolean isCategoriasDeseadas(List<Categoria> categoriasDeseadas) {
		return categorias.stream().anyMatch(c -> categoriasDeseadas.contains(c));
	}
}
