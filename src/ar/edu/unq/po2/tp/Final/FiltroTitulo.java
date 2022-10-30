package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class FiltroTitulo extends Filtro {

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) {
            List<String> tituloDeseado = preferencia.getTitulosDeseados(); 
            List<Proyecto> proyectosFiltrados = new ArrayList<Proyecto>(); 
		           for (Proyecto p : proyectos) {
		        	   if (tituloDeseado.contains(p.getNombre())) {
		        		   proyectosFiltrados.add(p);  
		        	   } 
				} return proyectosFiltrados; 
	}

}
