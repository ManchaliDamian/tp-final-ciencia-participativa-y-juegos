package ar.edu.unq.po2.tp.Final.Filtros;

import java.util.List;

import ar.edu.unq.po2.tp.Final.Proyecto;

public class FiltroAnd extends FiltroCompuesto {

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		List<Proyecto> proyectosFiltrados = proyectos;
		for (Filtro f : filtros) {
			proyectosFiltrados = f.filtrar(proyectosFiltrados);
		}
		return proyectosFiltrados;
	}
}
