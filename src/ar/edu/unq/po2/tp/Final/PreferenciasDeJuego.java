package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PreferenciasDeJuego extends EstrategiaDeSeleccion {

	public List<Desafio> desafiosParaElUsuario(List<Desafio> desafios2, Usuario usuario) {
		List<Desafio> desafiosRecomendados = new ArrayList<Desafio>(); 
		List<Integer> resultadoDeCoincidencia = losResultados(desafios2 , usuario); 
		for (Desafio d : desafios2) {
			if (resultadoDeCoincidencia.contains(coincidenciaDeDesafioYUsuario(d, usuario))) {
				resultadoDeCoincidencia.remove(coincidenciaDeDesafioYUsuario(d, usuario)); 
				desafiosRecomendados.add(d); 		
			}
		}
		System.out.print(desafiosRecomendados.stream().limit(5).toList());
		return desafiosRecomendados.stream().limit(5).toList(); 
		
		
	}  
	
	public List<Integer> losResultados(List<Desafio> desafios2, Usuario usuario) {
		 List<Integer> losResultadosHastaAhora = new ArrayList<Integer>(); 
		 for (Desafio d : desafios2) {
			 losResultadosHastaAhora.add(coincidenciaDeDesafioYUsuario(d , usuario));
		}
		 Collections.sort(losResultadosHastaAhora); 
		 return  losResultadosHastaAhora ; 
	} 
	 
}