package ar.edu.unq.po2.tp.Final.Filtros;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Categoria;
import ar.edu.unq.po2.tp.Final.Proyecto;

class FiltroAndTest {
	FiltroCompuesto filtroAnd;
	Filtro filtroTitulo;
	Filtro filtroCategoriaDeseada;
	Proyecto proyecto1;
	Proyecto proyecto2;
	Proyecto proyecto3;
	Proyecto proyecto4;
	Categoria categoria1;
	Categoria categoria2;

	@BeforeEach
	public void setUp() throws Exception {
		filtroAnd = new FiltroAnd();
		filtroTitulo = new FiltroTitulo("Java");

		List<Categoria> categoriasDeseadas = Arrays.asList(categoria1, categoria2);
		filtroCategoriaDeseada = new FiltroCategoriaDeseada(categoriasDeseadas);

		filtroAnd.agregarFiltro(filtroTitulo);
		filtroAnd.agregarFiltro(filtroCategoriaDeseada);

		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		proyecto4 = mock(Proyecto.class);

		when(proyecto1.isCategoriasDeseadas(categoriasDeseadas)).thenReturn(true);
		when(proyecto2.isCategoriasDeseadas(categoriasDeseadas)).thenReturn(false);
		when(proyecto3.isCategoriasDeseadas(categoriasDeseadas)).thenReturn(false);
		when(proyecto4.isCategoriasDeseadas(categoriasDeseadas)).thenReturn(true);

		when(proyecto1.isTituloDeseado("Java")).thenReturn(true);
		when(proyecto2.isTituloDeseado("Java")).thenReturn(false);
		when(proyecto3.isTituloDeseado("Java")).thenReturn(false);
		when(proyecto4.isTituloDeseado("Java")).thenReturn(true); 
	}

	@Test
	void testUnFiltroAndFiltraPorOperadorLogicoAnd() {
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4);

		List<Proyecto> proys = filtroAnd.filtrar(proyectos);
		
		assertTrue(proys.contains(proyecto1));
		assertEquals(2, proys.size());
	}

}
