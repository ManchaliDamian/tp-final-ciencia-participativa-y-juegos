package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class PreferenciasDeJuego implements EstrategiaDeSeleccion {

	public List<Desafio> desafiosParaElUsuario(List<Desafio> desafios2, Usuario usuario) {
		ArrayList<Pares> paresClaveValor = new ArrayList<Pares>();
		paresClaveValor.addAll(
				desafios2.stream().map(d -> new Pares(d, this.coincidenciaDeDesafioYUsuario(d, usuario))).toList());
		paresClaveValor.sort((p1, p2) -> p1.getCoincidencia().compareTo(p2.getCoincidencia()));
		return paresClaveValor.stream().limit(5).map(p -> p.getDesafio()).toList();
	}

	public Integer coincidenciaDeDesafioYUsuario(Desafio desafio, Usuario usuario) {
		return (desafio.getCantMuestras() - usuario.getPreferencia().getCantidadDeMuestras())
				+ (desafio.getDificultad() - usuario.getPreferencia().getDificultad())
				+ ((desafio.getRecompensa()) - usuario.getPreferencia().getRecompensa());
	}

}

