package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();
	private List<Usuario> usuariosEnSistema = new ArrayList<Usuario>();
	private Filtro filtro;
	private PreferenciaDeProyecto preferencia;

	 public Sistema() {
		 proyectos = new ArrayList<Proyecto>();
		 usuariosEnSistema = new ArrayList<Usuario>();
	 }
	
	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public void buscarProyecto(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) {
		proyectos.addAll(filtro.filtrar(proyectos, preferencia));
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

	public void recomendarDesafios(List<Usuario> usuariosEnSistema, List<Desafio> desafios) {
		for (Usuario u : usuariosEnSistema) {
            u.desafiosDeInteres(desafios) ;
		}
	}
}