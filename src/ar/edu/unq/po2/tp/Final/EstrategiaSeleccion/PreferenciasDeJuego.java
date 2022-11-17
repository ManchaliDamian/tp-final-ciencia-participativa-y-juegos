package ar.edu.unq.po2.tp.Final.EstrategiaSeleccion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

public class PreferenciasDeJuego extends EstrategiaDeSeleccion {

	@Override
	public List<Desafio> desafiosParaElUsuario(Usuario usuario) {
		List<Desafio> desafiosParaUsuario = this.filtrarDesafiosYaRecomendados(usuario);
		
		return this.coincidenciaPorPreferenciaDeUsuario(desafiosParaUsuario, usuario);
	}

	
	public List<Desafio> coincidenciaPorPreferenciaDeUsuario(List<Desafio> desafios, Usuario usuario){
		desafios.stream().sorted((desafio1, desafio2) -> ).toList();
	}
	

	
	
	
	
	
	//<<Correcion>> Rompen encapsulamiento de usuario pidiendole las preferencias, deberian de delegar en el usuario retornar la cantidad de muestras o las recompensas.

}

