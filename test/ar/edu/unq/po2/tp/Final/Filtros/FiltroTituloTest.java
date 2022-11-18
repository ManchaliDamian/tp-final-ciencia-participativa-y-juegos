package ar.edu.unq.po2.tp.Final.Filtros;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Proyecto;

class FiltroTituloTest {
	Filtro filtroTitulo; 
	Proyecto proyecto1;
	Proyecto proyecto2;
	Proyecto proyecto3;
	Proyecto proyecto4;

	@BeforeEach
	public void setUp() throws Exception{
		filtroTitulo = new FiltroTitulo("Java");
		
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		proyecto3 = mock(Proyecto.class);
		proyecto4 = mock(Proyecto.class);
		
		when(proyecto1.isTituloDeseado("Java")).thenReturn(true);
		when(proyecto2.isTituloDeseado("Java")).thenReturn(false);
		when(proyecto3.isTituloDeseado("Java")).thenReturn(false);
		when(proyecto4.isTituloDeseado("Java")).thenReturn(true);
		
	}
	
	@Test
	void testUnFiltroTituloFiltraPorTituloDeseado() {
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4);
		
		List<Proyecto> proys = filtroTitulo.filtrar(proyectos);
		
		assertTrue(proys.contains(proyecto1));
		assertEquals(2, proys.size());
		
		
	}

}
