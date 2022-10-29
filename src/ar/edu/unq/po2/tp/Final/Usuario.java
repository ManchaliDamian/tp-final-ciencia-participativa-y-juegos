package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	// FALTA asignarle desafios (strategy) 
	// FALTA falta que cuando agregue una muestra compruebe las restricciones
	// FALTA saber si es necesario que el usuario conozca los proyectos en los que esta
	//Falta arreglar desafiosPendientes 

	private Preferencia preferencia;
	
	private List<DesafioDeUsuario> desafios = new ArrayList<DesafioDeUsuario>();

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

	}

	public void aceptarDesafiosPendientes() {
		//List <DesafioDeUsuario>desafíosPendientes = desafios.stream().filter(d -> d.getEstado().esEstadoPendiente()).toList();
		for (DesafioDeUsuario desafioDeUsuario : desafios) {
			desafioDeUsuario.aceptarDesafio();
		}
	}

	public int cantidadDeDesafiosCompletados() {
		List <DesafioDeUsuario>desafíosCompletados = desafios.stream().filter(d -> d.getEstado().estáCompletado()).toList(); 
		return desafíosCompletados.size();
	}
	
	public int porcentajeDeCompletitud(DesafioDeUsuario desafio) {
		  return (desafio.cantidadDeMuestrasRecolectadas() * desafio.muestrasNecesariasParaCompletarDesafio()) / 100; 
	}
	
	

}
