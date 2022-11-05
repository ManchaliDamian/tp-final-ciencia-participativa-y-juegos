package ar.edu.unq.po2.tp.Final;
import java.util.List;

public class FiltroCategoria extends Filtro {

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) {
		List<Proyecto> proyectosDePreferencia = proyectos.stream().filter(p -> this.isDePreferencia(p, preferencia.getCategoriasDeseadas())).toList();
		List<Proyecto> proyectosExcluidos = proyectosDePreferencia.stream().filter(p -> !this.isDePreferencia(p, preferencia.getCategoriasNoDeseadas())).toList();
		return proyectosExcluidos;
	}

	private boolean isDePreferencia(Proyecto p, List<Categoria> categoriasDeseadas) {
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
		
	}

}
