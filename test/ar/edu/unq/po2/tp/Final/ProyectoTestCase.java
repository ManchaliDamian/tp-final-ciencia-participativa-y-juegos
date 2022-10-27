package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ProyectoTestCase {
	Proyecto proyecto; 
	Usuario participante; 
	Categoria categoria; 
	Muestra muestra; 
	Usuario unUsuario; 
	
	@BeforeEach
	public void setUp() throws Exception{
		proyecto = new Proyecto("Otoño", "Estación del año");
		participante = mock(Usuario.class);
		categoria = mock(Categoria.class); 
		muestra = mock(Muestra.class); 
		unUsuario = mock(Usuario.class); 
		
	}
	
	@Test
	void testUnProyectoAgregaAParticipante() {
		proyecto.agregarParticipante(participante);
		
		assertTrue(proyecto.getParticipantesActivos().contains(participante)); 
	}
	
	@Test
	void testUnProyectoEliminaAUnParticipante() {
		proyecto.agregarParticipante(participante);
		
		proyecto.eliminarParticipante(participante);
		
		assertFalse(proyecto.getParticipantesActivos().contains(participante)); 
		
	}
	
	@Test
	void testUnProyectoAgregaUnaNuevaCategoría() {
		proyecto.agregarCategoria(categoria);
		
		assertTrue(proyecto.getCategorias().contains(categoria)); 
	}
	
	@Test
	void testUnProyectoEliminaUnaCategoria() {
		proyecto.agregarCategoria(categoria);
		
		proyecto.eliminarCategoria(categoria);
		
		assertFalse(proyecto.getCategorias().contains(categoria));
	}
	
	@Test
	void testUnProyectoAgregaUnaNuevaMuestra() {
		proyecto.agregarParticipante(participante);
		when(muestra.getUsuario()).thenReturn(participante);
		
		proyecto.agregarMuestra(muestra);
		
		assertTrue(proyecto.getMuestras().contains(muestra)); 
	}
	
	@Test
	void testUnProyectoEliminaUnaMuestra() {
		proyecto.agregarMuestra(muestra);
		
		proyecto.eliminarMuestra(muestra);
		
		assertFalse(proyecto.getMuestras().contains(muestra));
		
	}
	
	@Test 
	void testUnProyectoNoAgregaUnaMuestraSiElUsuarioNoEsParticipante() {
		when(muestra.getUsuario()).thenReturn(unUsuario);
		
		proyecto.agregarMuestra(muestra);
		
		assertFalse(proyecto.getMuestras().contains(muestra));
		
	}

}
