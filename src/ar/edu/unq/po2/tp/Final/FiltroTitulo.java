package ar.edu.unq.po2.tp.Final;

import java.util.List;

public class FiltroTitulo extends Filtro {

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) { 
           List<Proyecto> proyectosDePreferencia = proyectos.stream().filter(p -> this.isTituloDePreferencia(p, preferencia.getTitulosDeseados())).toList();
           return proyectosDePreferencia; 
	}

	private boolean isTituloDePreferencia(Proyecto p, List<String> titulos) {
		return titulos.contains(p.getNombre());
	}

	@Override
	public void agregarFiltro(Filtro filtro) {
		FiltroCompuesto compuesto = new FiltroCompuesto(); 
		compuesto.agregarFiltro(filtro);
		
	}

}
