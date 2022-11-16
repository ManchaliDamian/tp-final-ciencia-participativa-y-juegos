package ar.edu.unq.po2.tp.Final.Filtros;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tp.Final.PreferenciaDeProyecto;
import ar.edu.unq.po2.tp.Final.Proyecto;

public class FiltroTitulo extends Filtro {

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) { 
           List<Proyecto> proyectosDePreferencia = proyectos.stream().filter(p -> preferencia.isTituloDePreferencia(p)).collect(Collectors.toList());
           return proyectosDePreferencia; 
	}

	

}
