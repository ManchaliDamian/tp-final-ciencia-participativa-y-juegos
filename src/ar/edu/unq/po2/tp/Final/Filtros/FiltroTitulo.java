package ar.edu.unq.po2.tp.Final.Filtros;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroTitulo extends Filtro {

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos, PreferenciaDeProyecto preferencia) { 
           List<Proyecto> proyectosDePreferencia = proyectos.stream().filter(p -> preferencia.isTituloDePreferencia(p)).collect(Collectors.toList());
           return proyectosDePreferencia; 
	}

	@Override
	public void agregarFiltro(Filtro filtro) {
		FiltroCompuesto compuesto = new FiltroAnd(); //por default
		compuesto.agregarFiltro(filtro);
		<<Correcion>> Este mensaje no hace nada. Crea un objeto FiltroCompueto pero no lo retorna. Este objeto queda perdido en la memoria.
	}

}
