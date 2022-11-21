package ar.edu.unq.po2.tp.Final.Filtros;

import java.util.ArrayList;
import java.util.List;

public abstract class FiltroCompuesto extends Filtro {
	
	protected List<Filtro> filtros = new ArrayList<Filtro>();
	
	public void agregarFiltro(Filtro filtro) {
		filtros.add(filtro);
	}
	
	public List<Filtro> getFiltros() {
		return filtros; 
	}
	
	

}
