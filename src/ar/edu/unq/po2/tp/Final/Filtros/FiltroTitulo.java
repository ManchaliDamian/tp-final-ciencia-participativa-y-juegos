package ar.edu.unq.po2.tp.Final.Filtros;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tp.Final.Proyecto;

public class FiltroTitulo extends Filtro {
	private String tituloDeseado;

	public FiltroTitulo(String tituloDeseado) {
		this.tituloDeseado = tituloDeseado; 
	}
	
	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {

		 List<Proyecto> proyectosDePreferencia = proyectos.stream()
				.filter(p -> esTituloDeseado(p)).collect(Collectors.toList());
		return proyectosDePreferencia;
	}

	public boolean esTituloDeseado(Proyecto p) {
		return p.isTituloDeseado(tituloDeseado);
	}

}
