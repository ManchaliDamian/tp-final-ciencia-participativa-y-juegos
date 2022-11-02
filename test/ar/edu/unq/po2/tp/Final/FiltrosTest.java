package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FiltrosTest {
	Filtro filtroTitulo;
	Filtro filtroCategoria;
	Filtro filtroCompuesto; 
	Proyecto proyecto1;
	Proyecto proyecto2;
	Proyecto proyecto3;
	Proyecto proyecto4; 
	PreferenciaDeProyecto preferenciaDeProyecto; 
	Categoria categoria1;
	Categoria categoria2;
	
	@BeforeEach
	public void setUp() throws Exception{
		filtroTitulo = new FiltroTitulo();
		filtroCategoria = new FiltroCategoria(); 
		filtroCompuesto = new FiltroCompuesto();
		
		filtroCompuesto.agregarFiltro(filtroCategoria); 
		
		
		proyecto1 = new Proyecto("Java", "arboles");
		proyecto2 = new Proyecto("Programacion","Lenguaje orientado a objetos");
		proyecto3 = new Proyecto("Matematicas", "Poryectos logaritmicos");
		proyecto4 = new Proyecto("Java", "ramas");	
		
		categoria1 = new Categoria("Programación", "Lenguaje orientado a objetos");
		categoria2 = new Categoria("Matematicas", "Logaritmo");
		
		proyecto1.agregarCategoria(categoria1);
		proyecto2.agregarCategoria(categoria2);
		proyecto3.agregarCategoria(categoria1);
		proyecto3.agregarCategoria(categoria2);
		proyecto4.agregarCategoria(categoria1);
		
		preferenciaDeProyecto = new PreferenciaDeProyecto(); 
	}

	@Test
	void testUnFiltroTituloFiltraUnaListaDeProyetos() {
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4);
		preferenciaDeProyecto.agregarTituloDePreferencia("Java");
		
		List<Proyecto> proyectosFiltrados = filtroTitulo.filtrar(proyectos, preferenciaDeProyecto);
		
		assertTrue(proyectosFiltrados.contains(proyecto1));
		assertEquals(2, proyectosFiltrados.size());
	}
	
	@Test
	void testFiltroDeCategoriasFiltraUnaListaDeProyectosPorSusCategoriasDeseadas() {
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4);
		preferenciaDeProyecto.agregarCategoriaDeseada(categoria1);
		
		List<Proyecto> proyectosFiltrados = filtroCategoria.filtrar(proyectos, preferenciaDeProyecto);
		
		assertTrue(proyectosFiltrados.contains(proyecto1));
	}
	
	@Test
	void testUnFiltroCategoriaFiltraUnaListaDeProyectosPorCategoriasNoDeseadas() {
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4);
		preferenciaDeProyecto.agregarCategoriaNoDeseada(categoria2);
		
		List<Proyecto> proyectosFiltrados = filtroCategoria.filtrar(proyectos, preferenciaDeProyecto);
		
		assertFalse(proyectosFiltrados.contains(proyecto2));
	}
	
	@Test
	void testUnFiltroCategoriaFiltraUnaListaDeProyectosPorCategoriasDeseadasYNoDeseadas() {
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4);
		preferenciaDeProyecto.agregarCategoriaDeseada(categoria1);
		preferenciaDeProyecto.agregarCategoriaNoDeseada(categoria2);
		
		List<Proyecto> proyectosFiltrados = filtroCategoria.filtrar(proyectos, preferenciaDeProyecto);
		
		assertTrue(proyectosFiltrados.contains(proyecto1));
		assertFalse(proyectosFiltrados.contains(proyecto2));
	}
	
	@Test
	void testCuandoUnProyectoTieneCategoriasDeseadasYNoDeseadasElProyectoNoSeIncluye() {
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4);
		preferenciaDeProyecto.agregarCategoriaDeseada(categoria1);
		preferenciaDeProyecto.agregarCategoriaNoDeseada(categoria2);
		
		List<Proyecto> proyectosFiltrados = filtroCategoria.filtrar(proyectos, preferenciaDeProyecto);
		
		assertFalse(proyectosFiltrados.contains(proyecto3));
	}
	
	@Test
	void testFiltroCompuestoFiltraPorTitulosYCategorias() {
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4);
		preferenciaDeProyecto.agregarTituloDePreferencia("Java");
		preferenciaDeProyecto.agregarCategoriaDeseada(categoria1);
		preferenciaDeProyecto.agregarCategoriaNoDeseada(categoria2);
		
		List<Proyecto> proyectosFiltrados = filtroCompuesto.filtrar(proyectos, preferenciaDeProyecto); 
		
		assertTrue(proyectosFiltrados.contains(proyecto4));
		assertTrue(proyectosFiltrados.contains(proyecto1));
		assertEquals(2, proyectosFiltrados.size());
	}

} 
