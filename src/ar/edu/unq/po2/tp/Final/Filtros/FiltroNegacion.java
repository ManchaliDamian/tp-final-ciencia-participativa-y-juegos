package ar.edu.unq.po2.tp.Final.Filtros;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroNegacion extends FiltroCompuesto{

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) {
		List<Proyecto> proyectosFiltrados = proyectos;
		for(Filtro f : filtros) {
			List<Proyecto> proyectosFiltro = f.filtrar(proyectosFiltrados, preferencia);
			proyectosFiltrados = this.filtrarProyectos(proyectosFiltrados, proyectosFiltro);
		}
		return proyectosFiltrados;
	}

	public List<Proyecto> filtrarProyectos(List<Proyecto> proyectosFiltrados, List<Proyecto> proyectosFiltro) {
		List<Proyecto> proyectos = proyectosFiltrados.stream().filter(p -> !p.isPerteneceA(proyectosFiltro)).collect(Collectors.toList()); 
		return proyectos;
		
	}

}
