package ar.edu.unq.po2.tp.Final.Filtros;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tp.Final.Categoria;
import ar.edu.unq.po2.tp.Final.PreferenciaDeProyecto;
import ar.edu.unq.po2.tp.Final.Proyecto;

public class FiltroCategoria extends Filtro {

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) {
		List<Proyecto> proyectosDePreferencia = proyectos.stream().filter(p -> this.isDePreferencia(p, preferencia.getCategoriasDeseadas())).collect(Collectors.toList());
		List<Proyecto> proyectosExcluidos = proyectosDePreferencia.stream().filter(p -> !this.isDePreferencia(p, preferencia.getCategoriasNoDeseadas())).collect(Collectors.toList());
		return proyectosExcluidos;
	}

	private boolean isDePreferencia(Proyecto p, List<Categoria> categoriasDeseadas) {
		List<Categoria> categoriasDeProyecto = p.getCategorias();
		
		return categoriasDeProyecto.stream().anyMatch(c -> categoriasDeseadas.contains(c));

	}
	
	


}
