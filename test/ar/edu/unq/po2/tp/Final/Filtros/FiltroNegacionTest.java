package ar.edu.unq.po2.tp.Final.Filtros;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Finall.Categoria;
import ar.edu.unq.po2.tp.Finall.Proyecto;

class FiltroNegacionTest {
	FiltroCompuesto filtroNegacion;
	Filtro filtroTitulo;
	Filtro filtroCategoriaDeseada;
	Proyecto proyecto1;
	Proyecto proyecto2;
	Proyecto proyecto3;
	Proyecto proyecto4;
	Categoria categoria1;
	Categoria categoria2;

	@BeforeEach
	public void setUp() throws Exception{
		filtroNegacion = new FiltroNegacion();
		filtroTitulo = new FiltroTitulo("Java");

		List<Categoria> categoriasDeseadas = Arrays.asList(categoria1, categoria2);
		filtroCategoriaDeseada = new FiltroCategoriaDeseada(categoriasDeseadas);

		filtroNegacion.agregarFiltro(filtroTitulo);
		filtroNegacion.agregarFiltro(filtroCategoriaDeseada);

		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		proyecto4 = mock(Proyecto.class);
		
	}

	@Test
	void testUnFiltroNegacionFiltraPorOperadorLogicoNegacion() {
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4);
		when(proyecto1.isPerteneceA(proyectos)).thenReturn(true);
		when(proyecto2.isPerteneceA(proyectos)).thenReturn(false);
		when(proyecto3.isPerteneceA(proyectos)).thenReturn(true);
		when(proyecto4.isPerteneceA(proyectos)).thenReturn(false);
		
		List<Proyecto> proys = filtroNegacion.filtrar(proyectos);
		
		assertTrue(proys.contains(proyecto4));
		assertEquals(2, proys.size());
	}

}
