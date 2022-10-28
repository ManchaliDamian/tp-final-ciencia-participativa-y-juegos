package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

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
		for (DesafioDeUsuario desafioDeUsuario : desafios) {
			desafioDeUsuario.aceptarDesafio();
			{

			}
		}
	}

	public int cantidadDeDesafiosCompletados() {
		int desafiosCompletadosHastaAhora = 0;
		for (DesafioDeUsuario desafioDeUsuario : desafios) {
			if (desafioDeUsuario.getEstado() == new EstadoCompleto()) {
				desafiosCompletadosHastaAhora += 1;
			}
		}
		return desafiosCompletadosHastaAhora;
	}
	
	public Integer porcentajeDeCompletitud(DesafioDeUsuario desafio) {
		  return (desafio.cantidadDeMuestrasRecolectadas() * desafio.muestrasNecesariasParaCompletarDesafio()) / 100; 
	}

}
