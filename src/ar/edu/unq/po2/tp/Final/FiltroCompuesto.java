package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class FiltroCompuesto extends Filtro {
   private List<Filtro> filtros = new ArrayList<Filtro>(); 
	
	@Override
	public List<Proyecto> filtrar( List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) {
            		
	}

	public List<Filtro> getFiltros() {
		return filtros;
	}

	public void setFiltros(List<Filtro> filtros) {
		this.filtros = filtros; 
	}

}
