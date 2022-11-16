package ar.edu.unq.po2.tp.Final.EstrategiaSeleccion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PreferenciasDeJuego implements EstrategiaDeSeleccion {

	<<Correcion>> No respeta el UML. Donde dice que Pares es una variable dentro de PreferenciaDeJuego.
	
	public List<Desafio> desafiosParaElUsuario(List<Desafio> desafios2, Usuario usuario) {
		ArrayList<Pares> paresClaveValor = new ArrayList<Pares>();
		paresClaveValor.addAll(
				desafios2.stream().map(d -> new Pares(d, this.coincidenciaDeDesafioYUsuario(d, usuario))).collect(Collectors.toList()));
		paresClaveValor.sort((p1, p2) -> p1.getCoincidencia().compareTo(p2.getCoincidencia()));
		return paresClaveValor.stream().limit(5).map(p -> p.getDesafio()).collect(Collectors.toList());
	}

	public Integer coincidenciaDeDesafioYUsuario(Desafio desafio, Usuario usuario) {
		return (desafio.getCantMuestras() - usuario.getPreferencia().getCantidadDeMuestras())
				+ (desafio.getDificultad() - usuario.getPreferencia().getDificultad())
				+ ((desafio.getRecompensa()) - usuario.getPreferencia().getRecompensa());
	}
	<<Correcion>> Rompen encapsulamiento de usuario pidiendole las preferencias, deberian de delegar en el usuario retornar la cantidad de muestras o las recompensas.

}

