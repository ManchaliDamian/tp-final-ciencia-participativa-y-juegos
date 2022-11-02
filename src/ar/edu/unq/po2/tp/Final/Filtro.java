package ar.edu.unq.po2.tp.Final;

import java.util.List;

public abstract class Filtro {
   
	public abstract List<Proyecto> filtrar(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) ; 
	
	public abstract void agregarFiltro(Filtro filtro); 
}
