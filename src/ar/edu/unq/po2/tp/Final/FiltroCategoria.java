package ar.edu.unq.po2.tp.Final;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroCategoria extends Filtro {

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) {
		List<Proyecto> proyectosDePreferencia = proyectos.stream().filter(p -> this.isDePreferencia(p, preferencia.getCategoriasDeseadas())).collect(Collectors.toList());
		List<Proyecto> proyectosExcluidos = proyectosDePreferencia.stream().filter(p -> !this.isDePreferencia(p, preferencia.getCategoriasNoDeseadas())).collect(Collectors.toList());
		return proyectosExcluidos;
	}

	private boolean isDePreferencia(Proyecto p, List<Categoria> categoriasDeseadas) {
		<<Correcion>> Este algoritmo es muy rudimentario. Podria utilizar mensajes de alto orden para verificar si algun objeto de la lista cumple con la condicion.
					  Buscar documentacion de anyMatch o reimplementarlo usando streams.
		List<Categoria> categoriasDeProyecto = p.getCategorias();
		while (!categoriasDeProyecto.isEmpty()
				&& !categoriasDeseadas.contains(categoriasDeProyecto.get(0))) {
			categoriasDeProyecto.remove(0);

		}
		return (!categoriasDeProyecto.isEmpty());

	}

	@Override
	public void agregarFiltro(Filtro filtro) {
		FiltroCompuesto compuesto = new FiltroAnd();  //por default
		compuesto.agregarFiltro(filtro);
		<<Correcion>> No se hace nada con la instancia de FiltroCompuesto creada. Este objeto se pierde en la memoria.
					  Tiene sentido que FiltroProCategoria entienda el mensaje agregarFiltro?
		
	}

}
