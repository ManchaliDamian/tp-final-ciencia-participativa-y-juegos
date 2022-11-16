package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Favoritos implements EstrategiaDeSeleccion {

	public List<Desafio> desafiosParaElUsuario(List<Desafio> desafios2, Usuario usuario) {
		ArrayList<Pares> paresClaveValor = new ArrayList<Pares>();
		paresClaveValor.addAll(
				desafios2.stream().map(d -> new Pares(d, this.coincidenciaDeDesafioYUsuario(d, usuario))).collect(Collectors.toList()));
		paresClaveValor.sort((p1, p2) -> p1.getCoincidencia().compareTo(p2.getCoincidencia()));

		return paresClaveValor.stream().limit(5).map(p -> p.getDesafio()).collect(Collectors.toList());
	}

	public Integer coincidenciaDeDesafioYUsuario(Desafio desafio, Usuario usuario) {
		<<Correcion>> Rompen encampsulamiento de usuario. Deberian pedirle a la clase usuario que les retorne el desafio con mayor puntaje directamente.
					  El calculo de diferencias entre Desafios podria ser responsabilidad de la clase Desafio para evitar "abrir" el objeto. 
					  Si es necesario, podrian utilizar Double Dispatch para dejar la logica del algoritmo definida en esta clase y pasarla como parametro al desafio al momento de la comparacion.
		Desafio desafioDeUsuarioConMayorPuntaje = usuario.desafioDeUsuarioConMayorPuntaje().getDesafio(); 
		int similitud = this.diferenciaEntre(desafio.getCantMuestras(), desafioDeUsuarioConMayorPuntaje.getCantMuestras())
				+ this.diferenciaEntre(desafio.getDificultad(), desafioDeUsuarioConMayorPuntaje.getDificultad())
				+ this.diferenciaEntre(desafio.getRecompensa(), desafioDeUsuarioConMayorPuntaje.getRecompensa()); 
		return similitud / 3; 
	}  
	
	public int diferenciaEntre(int unNumero, int otroNumero) {
		return Math.abs(unNumero - otroNumero); 
	}

}
 