package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tp.Final.Filtros.Filtro;
import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

public class Sistema {
	private List<Proyecto> proyectosDePreferencia = new ArrayList<Proyecto>();
	private List<Usuario> usuariosEnSistema = new ArrayList<Usuario>();
	private Filtro filtro;
	private PreferenciaDeProyecto preferencia;

	public Sistema(Filtro unFiltro) {
		this.filtro = unFiltro; 
	}

	public List<Proyecto> getProyectosDePreferencia() {
		return proyectosDePreferencia;
	}

	public void setProyectosDePreferencia(List<Proyecto> proyectos) {
		this.proyectosDePreferencia = proyectos;
	}

	public List<Usuario> getUsuariosEnSistema() {
		return usuariosEnSistema;
	}

	public void setUsuariosEnSistema(List<Usuario> usuariosEnSistema) {
		this.usuariosEnSistema = usuariosEnSistema;
	}

	public PreferenciaDeProyecto getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(PreferenciaDeProyecto preferencia) {
		this.preferencia = preferencia;
	}

	public void buscarProyectos(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) {
		proyectosDePreferencia.addAll(filtro.filtrar(proyectos, preferencia));
		<<Correcion>> Porque esta clase tiene un colaborador PreferenciaDeProyecto si para filtrar utiliza la que viene como parametro?
					  Como recibe los proyectos como parametros? Quien tiene conocimiento de todos los proyectos?

	}

	public void recomendarDesafios(List<Desafio> desafios) {
		for (Usuario u : usuariosEnSistema) {
			u.desafiosDeInteres(desafios);
		}
	}
	
	public void asignarProyectos(List<Usuario> usuariosEnSistema, List<Proyecto> proyectosDePreferencia) {
		for (Usuario u : usuariosEnSistema) {
		     u.agregarProyectos(proyectosDePreferencia);
		}
	}

}
