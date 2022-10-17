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

	public int cantidadMuestras() {
		return preferencia.getCantidadDeMuestras();
	}

	public List<DesafioDeUsuario> getDesafios() {
		return desafios;
	}

	public void setDesafios(List<DesafioDeUsuario> desafios) {
		this.desafios = desafios;
	}
}
