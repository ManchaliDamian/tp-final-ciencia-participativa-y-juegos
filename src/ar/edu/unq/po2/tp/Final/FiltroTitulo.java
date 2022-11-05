package ar.edu.unq.po2.tp.Final;

import java.util.List;

public class FiltroTitulo extends Filtro {

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) { 
           List<Proyecto> proyectosDePreferencia = proyectos.stream().filter(p -> preferencia.isTituloDePreferencia(p)).toList();
           return proyectosDePreferencia; 
	}

	@Override
	public void agregarFiltro(Filtro filtro) {
		FiltroCompuesto compuesto = new FiltroAnd(); //por default
		compuesto.agregarFiltro(filtro);
		
	}

}
