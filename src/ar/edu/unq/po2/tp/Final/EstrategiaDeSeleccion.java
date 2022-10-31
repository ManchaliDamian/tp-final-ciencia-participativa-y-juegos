package ar.edu.unq.po2.tp.Final;

import java.util.List;

public abstract class EstrategiaDeSeleccion {
	
	// verificar que los desafios recomendados no esten en los del usuario
	// pasar de desafio a desafioDeUsuario

	public abstract List<Desafio> desafiosParaElUsuario(List<Desafio> desafios2, Usuario usuario);

	public  int coincidenciaDeDesafioYUsuario(Desafio desafio, Usuario usuario) {
		return (desafio.getCantMuestras() - usuario.getPreferencia().getCantidadDeMuestras())
				+ (desafio.getDificultad() - usuario.getPreferencia().getDificultad())
				+ ((desafio.getRecompensa()) - usuario.getPreferencia().getRecompensa());
	}

}
