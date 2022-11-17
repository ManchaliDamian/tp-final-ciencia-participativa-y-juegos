package ar.edu.unq.po2.tp.Final.EstrategiaSeleccion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

public class Favoritos extends EstrategiaDeSeleccion {

	public List<Desafio> desafiosParaElUsuario(Usuario usuario) {
		List<Desafio> desafiosParaUsuario = this.filtrarDesafiosYaRecomendados(usuario);

		return this.coincidenciaPorPreferenciaDeUsuario(desafiosParaUsuario, usuario);
	}
	
	public List<Desafio> coincidenciaPorPreferenciaDeUsuario(List<Desafio> desafios, Usuario usuario){
		List<Desafio> desafiosPorCoincidencia = desafios.stream().sorted(
				(desafio1, desafio2) -> coincidenciaDeDesafioYUsuario(desafio1, usuario).compareTo(coincidenciaDeDesafioYUsuario(desafio2, usuario)))
				.limit(20).toList();
		return desafiosPorCoincidencia;
	}
	
	
	public Integer coincidenciaDeDesafioYUsuario(Desafio desafio, Usuario usuario) {
		Desafio desafioConMayorPuntaje = usuario.desafioDeUsuarioConMayorPuntaje();
		int similitud = desafio.coincidenciaPorFav(desafioConMayorPuntaje); 
		
		
		
		int similitud = this.diferenciaEntre(desafio.getCantMuestras(),
				desafioDeUsuarioConMayorPuntaje.getCantMuestras())
				+ this.diferenciaEntre(desafio.getDificultad(), desafioDeUsuarioConMayorPuntaje.getDificultad())
				+ this.diferenciaEntre(desafio.getRecompensa(), desafioDeUsuarioConMayorPuntaje.getRecompensa());
		return similitud / 3;
	}

}
