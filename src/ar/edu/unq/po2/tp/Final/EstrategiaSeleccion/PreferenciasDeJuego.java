package ar.edu.unq.po2.tp.Final.EstrategiaSeleccion;

import java.util.List;

import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

public class PreferenciasDeJuego extends EstrategiaDeSeleccion {

	@Override
	public List<Desafio> desafiosParaElUsuario(Usuario usuario) {
		List<Desafio> desafiosParaUsuario = this.filtrarDesafiosYaRecomendados(usuario);
		
		return this.coincidenciaPorPreferenciaDeUsuario(desafiosParaUsuario, usuario);
	}

	public List<Desafio> coincidenciaPorPreferenciaDeUsuario(List<Desafio> desafios, Usuario usuario) {
		List<Desafio> desafiosPorCoincidencia = desafios.stream().sorted(
				(desafio1, desafio2) -> desafio1.coincidenciaCon(usuario).compareTo(desafio2.coincidenciaCon(usuario)))
				.limit(5).toList();
		return desafiosPorCoincidencia;
	}

}
