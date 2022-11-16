package ar.edu.unq.po2.tp.Final.Filtros;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroOr extends FiltroCompuesto {

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) {
		List<Proyecto> proyectosFiltrados = new ArrayList<Proyecto>(); 
			for(Filtro f: filtros) {
				List<Proyecto> proyectosDeFiltro = f.filtrar(proyectos, preferencia);
				proyectosFiltrados.addAll(proyectosDeFiltro);
			}
		
		return proyectosFiltrados.stream().distinct().collect(Collectors.toList());
	}

}
