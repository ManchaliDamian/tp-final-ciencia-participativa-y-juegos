package ar.edu.unq.po2.tp.Final.Filtros;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tp.Final.Categoria;
import ar.edu.unq.po2.tp.Final.Proyecto;

public class FiltroCategoriaDeseada extends Filtro {

	private List<Categoria> categoriasDeseadas = new ArrayList<Categoria>();
	
	public FiltroCategoriaDeseada(List<Categoria> categoriasDeseadas) {
		this.categoriasDeseadas = categoriasDeseadas; 
	}

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		List<Proyecto> proyectosConCategoriasDeseadas = proyectos.stream()
				.filter(p -> isDePreferencia(p)).collect(Collectors.toList());
		return proyectosConCategoriasDeseadas;
	}

	public boolean isDePreferencia(Proyecto p) {
		return p.isCategoriasDeseadas(categoriasDeseadas);

	}

}
