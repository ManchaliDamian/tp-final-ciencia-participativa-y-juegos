package ar.edu.unq.po2.tp.Final.EstrategiaSeleccion;

import java.util.List;

import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

public interface EstrategiaDeSeleccion {
	

	public abstract List<Desafio> desafiosParaElUsuario(List<Desafio> desafios2, Usuario usuario);

	public Integer coincidenciaDeDesafioYUsuario(Desafio desafio, Usuario usuario);

}
