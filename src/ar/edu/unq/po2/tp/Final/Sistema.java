package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tp.Final.Filtros.Filtro;
import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

public class Sistema {
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Desafio> desafios = new ArrayList<Desafio>(); 
	private Filtro filtro;

	public Sistema(Filtro unFiltro) {
		this.filtro = unFiltro; 
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	
	public List<Desafio> getDesafios(){
		return desafios;
	}
	
	public List<Usuario> getUsuarios(){
		return usuarios; 
	}

	public List<Proyecto> busquedaDeProyectos() {
		List<Proyecto> proys = new ArrayList<Proyecto>();
		proys.addAll(filtro.filtrar(proyectos));
		
		return proys; 

	}

	public void recomendarDesafios(List<Desafio> desafios) {
		for (Usuario u : usuarios) {
			u.buscarMathConDesafios(desafios);;
		}
	}
	
	public void asignarProyectos() {
		for (Usuario u : usuarios) {
		     u.agregarProyectos(busquedaDeProyectos());
		}
	}

}
