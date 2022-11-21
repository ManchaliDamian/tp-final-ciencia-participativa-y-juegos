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

class FiltroCategoriaNoDeseadaTest {
	Filtro filtroCategoriaNoDeseada; 
	Categoria categoria1;
	Categoria categoria2; 
	Proyecto proyecto1;
	Proyecto proyecto2;
	Proyecto proyecto3;
	Proyecto proyecto4;

	@BeforeEach
	public void setUp() throws Exception{
		List<Categoria> categoriasDeseadas = Arrays.asList(categoria1, categoria2);
		filtroCategoriaNoDeseada = new FiltroCategoriasNoDeseadas(categoriasDeseadas);
		
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		proyecto4 = mock(Proyecto.class);
		
		when(proyecto1.isCategoriasDeseadas(categoriasDeseadas)).thenReturn(true);
		when(proyecto2.isCategoriasDeseadas(categoriasDeseadas)).thenReturn(false);
		when(proyecto3.isCategoriasDeseadas(categoriasDeseadas)).thenReturn(false);
		when(proyecto4.isCategoriasDeseadas(categoriasDeseadas)).thenReturn(true);
	}
	@Test
	void testUnFiltroCategoriaNoDeseadaFiltraPorCategoriasExcluyentes() {
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4);
		
		List<Proyecto> proys = filtroCategoriaNoDeseada.filtrar(proyectos);
		
		assertTrue(proys.contains(proyecto2));
		assertEquals(2, proys.size());
	}
	

}
