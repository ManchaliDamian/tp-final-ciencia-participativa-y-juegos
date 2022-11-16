package ar.edu.unq.po2.tp.Final.EstrategiaSeleccion;

import ar.edu.unq.po2.tp.Final.Usuario.Desafio;

public class Pares {
	private Desafio desafio;
	private Integer coincidencia;

	public Pares(Desafio desafio, Integer coincidencia) {
		<<Correcion>> Menor: Este nombre de clase no es coecibo. Es ambiguo y de hecho no tiene comportamiento
         this.setDesafio(desafio);
         this.setCoincidencia(coincidencia); 
	}

	public Integer getCoincidencia() {
		return coincidencia;
	}

	public void setCoincidencia(Integer coincidencia) {
		this.coincidencia = coincidencia;
	}

	public Desafio getDesafio() {
		return desafio;
	}

	public void setDesafio(Desafio desafio) {
		this.desafio = desafio;
	}
}
