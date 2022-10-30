package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class PreferenciaDeProyecto {
	private List<Categoria> categoriasNoDeseadas = new ArrayList<Categoria>();
	private List<String> titulosDeseados = new ArrayList<String>();
	private List<Categoria> categoriasDeseadas = new ArrayList<Categoria>();
	
	
	public List<Categoria> getCategoriasDeseadas() {
		return categoriasDeseadas;
	}
	public void setCategoriasDeseadas(List<Categoria> categoriasDeseadas) {
		this.categoriasDeseadas = categoriasDeseadas;
	}
	public List<Categoria> getCategoriasNoDeseadas() {
		return categoriasNoDeseadas;
	}
	public void setCategoriasNoDeseadas(List<Categoria> categoriasNoDeseadas) {
		this.categoriasNoDeseadas = categoriasNoDeseadas;
	}
	public List<String> getTitulosDeseados() {
		return titulosDeseados;
	}
	public void setTitulosDeseados(List<String> titulosDeseados) {
		this.titulosDeseados = titulosDeseados;
	}
	
	
}
