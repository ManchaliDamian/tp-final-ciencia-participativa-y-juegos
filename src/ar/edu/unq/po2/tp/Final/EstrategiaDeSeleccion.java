package ar.edu.unq.po2.tp.Final;

import java.util.List;

public interface EstrategiaDeSeleccion {
	
	// verificar que los desafios recomendados no esten en los del usuario

	public abstract List<Desafio> desafiosParaElUsuario(List<Desafio> desafios2, Usuario usuario);

	public Integer coincidenciaDeDesafioYUsuario(Desafio desafio, Usuario usuario);

}
