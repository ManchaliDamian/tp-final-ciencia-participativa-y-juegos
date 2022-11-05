package ar.edu.unq.po2.tp.Final;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {
	Sistema sistema;
	Usuario usuario1;
	Usuario usuario2;
	Filtro filtroTitulo;
	Filtro filtroCategoria;
	Filtro filtroAnd;
	Preferencia preferecia;
	PreferenciasDeJuego preJuego;
	Proyecto proyecto1;
	Proyecto proyecto2;
	Proyecto proyecto3;
	Proyecto proyecto4;
	PreferenciaDeProyecto preferenciaDeProyecto;
	Categoria categoria1;
	Categoria categoria2;

	Desafio desafio1;
	Desafio desafio2;
	List<Desafio> desafios = new ArrayList<Desafio>();

	@BeforeEach
	public void setUp() throws Exception {

		preJuego = new PreferenciasDeJuego();
		filtroTitulo = new FiltroTitulo();
		filtroCategoria = new FiltroCategoria();
		filtroAnd = new FiltroAnd();

		categoria1 = new Categoria("Programación", "Lenguaje orientado a objetos");
		categoria2 = new Categoria("Matematicas", "Logaritmo");

		preferenciaDeProyecto = new PreferenciaDeProyecto();
		preferenciaDeProyecto.agregarTituloDePreferencia("Programacion");
		preferenciaDeProyecto.agregarCategoriaDeseada(categoria1);
		preferenciaDeProyecto.agregarCategoriaNoDeseada(categoria2);

		preferecia = new Preferencia(4, 10, 6);
		desafio1 = new Desafio(null, null, 10, 4, 15, "Matematica logaritmica");
		desafio2 = new Desafio(null, null, 5, 10, 6, "Programacion informatica");
		usuario1 = new Usuario(preferecia);

		proyecto1 = new Proyecto("Java", "arboles");
		proyecto2 = new Proyecto("Programacion", "Lenguaje orientado a objetos");
		proyecto3 = new Proyecto("Matematicas", "Proyectos logaritmicos");
		proyecto4 = new Proyecto("Java", "ramas");

		proyecto1.agregarCategoria(categoria1);
		proyecto2.agregarCategoria(categoria1);
		proyecto3.agregarCategoria(categoria1);
		proyecto3.agregarCategoria(categoria2);
		proyecto4.agregarCategoria(categoria1);

		filtroAnd.agregarFiltro(filtroTitulo);
		filtroAnd.agregarFiltro(filtroCategoria);

		desafios.add(desafio1);
		desafios.add(desafio2);

	}

	@Test
	void testUnSistemaBuscaProyectosPorFiltroTitulo() {
		sistema = new Sistema(filtroTitulo);
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4);

		sistema.buscarProyectos(proyectos, preferenciaDeProyecto);

		assertEquals(1, sistema.getProyectosDePreferencia().size());
	}

	@Test
	void testUnSistemaBuscaProyectosPorFiltroCategoria() {
		sistema = new Sistema(filtroCategoria);
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4);

		sistema.buscarProyectos(proyectos, preferenciaDeProyecto);

		assertEquals(3, sistema.getProyectosDePreferencia().size());

	}

	@Test
	void testUnSistemaBuscaProyectosPorFiltroCompuestoAnd() {
		sistema = new Sistema(filtroAnd);
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4);

		sistema.buscarProyectos(proyectos, preferenciaDeProyecto);

		assertEquals(1, sistema.getProyectosDePreferencia().size());
	}

	@Test
	void testElSistemaRecomiendaDesafiosALosUsuariosDelSistema() {
		sistema = new Sistema(filtroCategoria);
		usuario1.setEstrategia(preJuego);

		sistema.getUsuariosEnSistema().add(usuario1);
		sistema.recomendarDesafios(desafios);

		assertEquals(usuario1.getDesafiosInteres().get(0), desafio2);
		assertEquals(usuario1.getDesafiosInteres().get(1), desafio1);

		assertTrue(usuario1.getDesafiosInteres().containsAll(desafios));
	}

}
