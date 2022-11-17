package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tp.Final.Filtros.Filtro;
import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

public class Sistema {
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();
	private List<Usuario> usuariosEnSistema = new ArrayList<Usuario>();
	private List<Desafio> desafios = new ArrayList<Desafio>(); 
	private Filtro filtro;
	private PreferenciaDeProyecto preferencia;

	public Sistema(Filtro unFiltro, PreferenciaDeProyecto unaPreferencia) {
		this.filtro = unFiltro; 
		this.preferencia = unaPreferencia;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public List<Usuario> getUsuariosEnSistema() {
		return usuariosEnSistema;
	}

	public PreferenciaDeProyecto getPreferencia() {
		return preferencia;
	}
	
	public List<Desafio> getDesafios(){
		return desafios;
	}

	public List<Proyecto> proyectosDePreferencia() {
		List<Proyecto> proys = new ArrayList<Proyecto>();
		proys.addAll(filtro.filtrar(proyectos, preferencia));
		
		return proys; 

	}

	public void recomendarDesafios(List<Desafio> desafios) {
		for (Usuario u : usuariosEnSistema) {
			u.desafiosDeInteres(desafios);
		}
	}
	
	public void asignarProyectos() {
		for (Usuario u : usuariosEnSistema) {
		     u.agregarProyectos(proyectosDePreferencia());
		}
	}

}
