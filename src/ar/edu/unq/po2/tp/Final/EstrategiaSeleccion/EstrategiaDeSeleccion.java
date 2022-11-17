package ar.edu.unq.po2.tp.Final.EstrategiaSeleccion;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tp.Final.Sistema;
import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

public abstract class EstrategiaDeSeleccion {
	Sistema sistema; 

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
	public List<Desafio> desafiosDeSistema() {
		return sistema.getDesafios();
	}
	
	public List<Desafio> filtrarDesafiosYaRecomendados(Usuario usuario){
		List<Desafio> desafiosFiltrados = desafiosDeSistema().stream().filter(d -> desafiosYaRecomendados(usuario).contains(d)).toList();
		return desafiosFiltrados;
	}
	
	
	public List<Desafio> desafiosYaRecomendados(Usuario usuario){
		List<Desafio> desafiosYaRecomendados = new ArrayList<Desafio>();
		desafiosYaRecomendados = usuario.getDesafios().stream().map(d -> d.getDesafio()).toList();
		return desafiosYaRecomendados; 
	}

	public abstract List<Desafio> desafiosParaElUsuario(Usuario usuario);

	public abstract int coincidenciaDeDesafioYUsuario(Desafio desafio, Usuario usuario);

}
