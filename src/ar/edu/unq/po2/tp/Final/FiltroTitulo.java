package ar.edu.unq.po2.tp.Final;

import java.util.List;

public class FiltroTitulo extends Filtro {

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) { 
           List<Proyecto> proyectosDePreferencia = proyectos.stream().filter(p -> this.isDePreferencia(p, preferencia)).toList();
           return proyectosDePreferencia; 
	}

	private boolean isDePreferencia(Proyecto p, PreferenciaDeProyecto preferencia) {
		
		return preferencia.getTitulosDeseados().contains(p.getNombre());
	}

}
