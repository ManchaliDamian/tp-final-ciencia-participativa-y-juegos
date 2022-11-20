package ar.edu.unq.po2.tp.Final.EstrategiaSeleccion;

import java.util.List;

import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

public class PreferenciasDeJuego extends EstrategiaDeSeleccion {

	public List<Desafio> coincidenciasParaUsuario(List<Desafio> desafios, Usuario usuario) {
		List<Desafio> desafiosPorCoincidencia = desafios.stream().sorted(
				(desafio1, desafio2) -> desafio1.coincidenciaPorPref(usuario).compareTo(desafio2.coincidenciaPorPref(usuario)))
				.limit(5).toList();
		return desafiosPorCoincidencia;  
	}

}
