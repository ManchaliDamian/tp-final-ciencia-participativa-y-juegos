package ar.edu.unq.po2.tp.Final.Filtros;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tp.Final.Categoria;
import ar.edu.unq.po2.tp.Final.Proyecto;

public class FiltroCategoriasNoDeseadas extends Filtro {
	private List<Categoria> categoriasNoDeseadas = new ArrayList<Categoria>();

	public FiltroCategoriasNoDeseadas(List<Categoria> categoriasNoDeseadas) {
		this.categoriasNoDeseadas = categoriasNoDeseadas;
	}

	@Override

	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		List<Proyecto> proyectosExcluidos = proyectos.stream().filter(p -> !this.isDePreferencia(p))
				.collect(Collectors.toList());
		return proyectosExcluidos;

	}

	public boolean isDePreferencia(Proyecto p) {
		return p.isCategoriasDeseadas(categoriasNoDeseadas);
	}

}