package ar.edu.unq.po2.tp.Final.EstrategiaSeleccion;

import java.util.List;

import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.DesafioDeUsuario;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

public class Favoritos extends EstrategiaDeSeleccion {

	public List<Desafio> coincidenciasParaUsuario(List<Desafio> desafios, Usuario usuario) {
		List<Desafio> desafiosPorCoincidencia = desafios.stream()
				.sorted((desafio1, desafio2) -> coincidenciaDeDesafioYUsuario(desafio1, usuario)
						.compareTo(coincidenciaDeDesafioYUsuario(desafio2, usuario)))
				.limit(5).toList(); 
		return desafiosPorCoincidencia;
	}

	public Integer coincidenciaDeDesafioYUsuario(Desafio desafio, Usuario usuario) {
		DesafioDeUsuario desafioConMayorPuntaje = usuario.desafioDeUsuarioConMayorPuntaje();
		Integer similitud = desafio.coincidenciaPorFav(desafioConMayorPuntaje.getDesafio());
		return similitud / 3; 
	}

}
