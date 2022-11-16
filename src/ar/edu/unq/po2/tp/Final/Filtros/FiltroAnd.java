package ar.edu.unq.po2.tp.Final.Filtros;

import java.util.List;

import ar.edu.unq.po2.tp.Final.PreferenciaDeProyecto;
import ar.edu.unq.po2.tp.Final.Proyecto;

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
