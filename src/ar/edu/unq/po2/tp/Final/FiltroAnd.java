package ar.edu.unq.po2.tp.Final;

import java.util.List;

public class FiltroAnd extends FiltroCompuesto{

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) {
		List<Proyecto> proyectosFiltrados = proyectos; 
        for(Filtro f : filtros) {
      	  proyectosFiltrados = f.filtrar(proyectosFiltrados, preferencia); 
        }
       return proyectosFiltrados;
	}

}
