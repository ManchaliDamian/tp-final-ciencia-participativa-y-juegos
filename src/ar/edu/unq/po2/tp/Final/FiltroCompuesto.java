package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class FiltroCompuesto extends Filtro {
	private List<Filtro> filtros = new ArrayList<Filtro>();
	
	public void agregarFiltro(Filtro filtro) {
		filtros.add(filtro);
	}

	@Override
	public List<Proyecto> filtrar( List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) {
          List<Proyecto> proyectosFiltrados = new ArrayList<Proyecto>(); 
          for(Filtro f : filtros) {
        	  List<Proyecto> proyectosDeFiltro = f.filtrar(proyectos, preferencia); 
        	  proyectosFiltrados.addAll(proyectosDeFiltro); 
          }
         
          return proyectosFiltrados; 
	}

	public List<Filtro> getFiltros() {
		return filtros;
	}

}
