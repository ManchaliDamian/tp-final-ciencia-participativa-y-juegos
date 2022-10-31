package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class FiltroCategoria extends Filtro {
	// Duda como hacer que exluya e incluya otras porque son dos listas 


	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) {
		List<Categoria> categoriasDeseadas = preferencia.getCategoriasDeseadas();
		List<Proyecto> proyectosConCategorias = new ArrayList<Proyecto>(); 
		for (Categoria c : categoriasDeseadas) {
			for(Proyecto p : proyectos) {
				if(p.getCategorias().contains(c) && p.getCategorias()) {
					proyectosConCategorias.add(p); 
				}
			}
			
		}
			

	}

	 
}
