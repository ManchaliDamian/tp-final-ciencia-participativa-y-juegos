package ar.edu.unq.po2.tp.Final.Filtros;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tp.Final.Proyecto;

public class FiltroNegacion extends FiltroCompuesto{

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		List<Proyecto> proyectosFiltrados = proyectos;
		for(Filtro f : filtros) {
			List<Proyecto> proyectosFiltro = f.filtrar(proyectosFiltrados);
			proyectosFiltrados.addAll(proyectosFiltro);
		}
		return filtrarProyectos(proyectosFiltrados, proyectos);

		
	}

	public List<Proyecto> filtrarProyectos(List<Proyecto> proyectosFiltrados, List<Proyecto> proyectos) {
		List<Proyecto> proys = proyectos.stream().filter(p -> !p.isPerteneceA(proyectosFiltrados)).collect(Collectors.toList()); 
		return proys;
		
	}

}
