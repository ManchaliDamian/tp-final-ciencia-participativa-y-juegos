package ar.edu.unq.po2.tp.Final;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Proyecto> proyectos = new ArrayList<Proyecto>();
    private Filtro filtro; 
    private PreferenciaDeProyecto preferencia; 

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	public List<Proyecto> buscarProyecto( List<Proyecto> proyectos ,PreferenciaDeProyecto preferencia) {
		proyectos.addAll(filtro.filtrar(proyectos, preferencia));
	}
	
}
