package ar.edu.unq.po2.tp.Final.EstrategiaSeleccion;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

public abstract class EstrategiaDeSeleccion {
	
	public List<Desafio> filtrarDesafiosYaRecomendados(Usuario usuario, List<Desafio> desafios){
		List<Desafio> desafiosFiltrados = desafios.stream().filter(d -> !desafiosYaRecomendados(usuario).contains(d)).toList();
		return desafiosFiltrados;  
	}
	
	
	public List<Desafio> desafiosYaRecomendados(Usuario usuario){
		List<Desafio> desafiosYaRecomendados = new ArrayList<Desafio>();
		desafiosYaRecomendados = usuario.getDesafios().stream().map(d -> d.getDesafio()).toList();
		return desafiosYaRecomendados;   
	}

	public List<Desafio> desafiosParaElUsuario(Usuario usuario, List<Desafio> desafios) {
		List<Desafio> desafiosParaUsuario = this.filtrarDesafiosYaRecomendados(usuario, desafios);

		return this.coincidenciasParaUsuario(desafiosParaUsuario, usuario);
	}
	
	public abstract List<Desafio> coincidenciasParaUsuario(List<Desafio> desafios, Usuario usuario);


}
