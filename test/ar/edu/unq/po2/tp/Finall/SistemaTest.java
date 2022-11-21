package ar.edu.unq.po2.tp.Finall;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Filtros.FiltroAnd;
import ar.edu.unq.po2.tp.Final.Filtros.FiltroCategoriaDeseada;
import ar.edu.unq.po2.tp.Final.Filtros.FiltroCategoriasNoDeseadas;
import ar.edu.unq.po2.tp.Final.Filtros.FiltroNegacion;
import ar.edu.unq.po2.tp.Final.Filtros.FiltroOr;
import ar.edu.unq.po2.tp.Final.Filtros.FiltroTitulo;
import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

class SistemaTest {
	Sistema sistema;
	FiltroAnd filtroAnd;
	FiltroCategoriaDeseada filtroCategoria;
	FiltroCategoriasNoDeseadas filtroCategoriaNoDeseada;
	FiltroNegacion filtroNegacion;
	FiltroTitulo filtroTitulo;
	FiltroOr filtroOr;

	Proyecto proyecto1;
	Proyecto proyecto2;
	Proyecto proyecto3;
	Proyecto proyecto4;
	Proyecto proyecto5;

	Desafio desafio1;
	Desafio desafio2;
	Desafio desafio3;
	Desafio desafio4;
	
	Usuario usuario1;
	Usuario usuario2;

	
	@BeforeEach
	public void setUp() throws Exception {

		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		
		filtroAnd = mock(FiltroAnd.class);
		filtroCategoria = mock(FiltroCategoriaDeseada.class);
		filtroTitulo = mock(FiltroTitulo.class);
		
		usuario1 = mock(Usuario.class);
		
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		proyecto4 = mock(Proyecto.class);
		proyecto5 = mock(Proyecto.class);
		
		sistema = new Sistema(filtroAnd);
		
		
	}
	
	@Test
	void testElSistemaBuscaProyectosConFiltro() {
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4, proyecto5) ; 
		sistema.getProyectos().addAll(proyectos);
		
		sistema.busquedaDeProyectos();
		
		verify(filtroAnd, times(1)).filtrar(proyectos); 
	}
	
	@Test
	void testElSistemaRecomiendaDesafiosAlUsuario() {
		List <Desafio> desafios = Arrays.asList(desafio1, desafio2, desafio3, desafio4);
		sistema.getDesafios().addAll(desafios);
		sistema.getUsuarios().add(usuario1);
		
		sistema.recomendarDesafios(desafios);
		
	   verify(usuario1, times(1)).buscarMathConDesafios(desafios);
	}
	
	@Test
	void testElSistemaLeAsignaProyectosAlUsuario() {
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4, proyecto5) ; 
		sistema.getProyectos().addAll(proyectos);
		sistema.getUsuarios().add(usuario1);
		
		sistema.asignarProyectos();
		
		  verify(usuario1, times(1)).agregarProyectos(sistema.busquedaDeProyectos());
	}
	
}
