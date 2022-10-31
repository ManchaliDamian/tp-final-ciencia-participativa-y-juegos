package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	// FALTA asignarle desafios (strategy) 
	// FALTA falta que cuando agregue una muestra compruebe las restricciones

	private Preferencia preferencia;
	
	private List<DesafioDeUsuario> desafios = new ArrayList<DesafioDeUsuario>();
	private List<Proyecto> proyectos = new ArrayList<Proyecto>(); 

	public Usuario(Preferencia unaPreferencia) {
		this.preferencia = unaPreferencia;
		
	} 

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
	}
	
	public void agregarDesafio(DesafioDeUsuario desafio) {
		 this.desafios.add(desafio); 
	}
	
	public List<DesafioDeUsuario> getDesafios() {
		return desafios;
	}

	public void setDesafios(List<DesafioDeUsuario> desafios) {
		this.desafios = desafios;
	}

	public void agregarMuestra(Muestra muestra, Proyecto proyecto) {
		proyecto.agregarMuestra(muestra);
		for(DesafioDeUsuario d : desafios) {
			d.agregarMuestra(muestra); 
		}

	}

	public void aceptarDesafiosPendientes() {
		for (DesafioDeUsuario d : desafios) {
			d.aceptarDesafio();
		}
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

}
