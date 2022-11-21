package ar.edu.unq.po2.tp.Finall;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Muestra.Muestra;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

class ProyectoTest {

	Proyecto proyecto1;
	Proyecto proyecto2;
	Proyecto proyecto3;
	Proyecto proyecto4;

	Muestra muestra1;

	Categoria categoria1;
	Categoria categoria2;
	Categoria categoria3;
	Categoria categoria4;
	
	Usuario usuario1;



	@BeforeEach
	public void setUp() throws Exception {
		muestra1 = mock(Muestra.class);
		categoria1 = mock(Categoria.class);
		categoria2 = mock(Categoria.class);
		categoria3 = mock(Categoria.class);
		categoria4 = mock(Categoria.class);
		usuario1 = mock(Usuario.class);



		proyecto1 = new Proyecto("Proyecto Java", "Orientada a Objetos");
		proyecto2 = new Proyecto("Proyecto Matematica", "Logaritmos Naturales");
		proyecto3 = new Proyecto("Proyecto Ingles", "Tecnica de Traduccion");
		proyecto4 = new Proyecto("Proyecto Estructuras", "Arboles");

	}

	@Test
	void testEsTituloDeseado() {

		assertTrue(proyecto1.isTituloDeseado("Proyecto Java"));
		assertEquals(proyecto1.getNombre(), "Proyecto Java"); 

	}
	
	@Test
	void testPerteceneAOtrosProyecto() {
		List <Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3, proyecto4);
		
		assertTrue(proyecto1.isPerteneceA(proyectos)); 
	}
	
	@Test
	void testEsCategoriaDeseada() {
		List<Categoria> categorias = Arrays.asList(categoria1, categoria2, categoria3, categoria4);
		proyecto1.agregarCategoria(categoria1);
		
		assertTrue(proyecto1.isCategoriasDeseadas(categorias)); 
	}
	
	@Test
	void testElProyectoAgregaMuestra() {
		proyecto1.agregarMuestra(muestra1);
		
		assertTrue(proyecto1.getMuestras().contains(muestra1));

	}
	
	@Test
	void testAgregarParticiapante() {
		proyecto1.agregarParticipante(usuario1);
		
		assertTrue(proyecto1.getParticipantesActivos().contains(usuario1));
	}
	
	
}
