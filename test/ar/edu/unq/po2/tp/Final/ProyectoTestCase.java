package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ProyectoTestCase {
	Proyecto proyecto; 
	Usuario participante; 
	Categoria categoria; 
	Muestra muestra; 
	Preferencia preferencia; 
	
	@BeforeEach
	public void setUp() throws Exception{
		proyecto = new Proyecto("Otoño", "Estación del año");
		preferencia = new Preferencia(4, 15, 8); 
		participante = new Usuario(preferencia); 
		categoria =  new Categoria(); 
		muestra = new Muestra(null, participante, null, null, null); 
		
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
	void testUnProyectoAgregaUnaNuevaMuestraCuandoElUsuarioAgregaUna() {
		proyecto.agregarParticipante(participante);
		
		participante.agregarMuestra(muestra, proyecto);
		
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
	    participante.agregarMuestra(muestra, proyecto);
		
		assertFalse(proyecto.getMuestras().contains(muestra));
		
	}

}
