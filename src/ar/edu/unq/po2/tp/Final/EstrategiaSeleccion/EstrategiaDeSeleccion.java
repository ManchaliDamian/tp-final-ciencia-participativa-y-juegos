package ar.edu.unq.po2.tp.Final.EstrategiaSeleccion;

import java.util.List;

import ar.edu.unq.po2.tp.Final.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario;

public interface EstrategiaDeSeleccion {
	
	// verificar que los desafios recomendados no esten en los del usuario

	public abstract List<Desafio> desafiosParaElUsuario(List<Desafio> desafios2, Usuario usuario);

	public Integer coincidenciaDeDesafioYUsuario(Desafio desafio, Usuario usuario);

}
