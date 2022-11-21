package ar.edu.unq.po2.tp.Final.Estados;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Muestra.Muestra;
import ar.edu.unq.po2.tp.Final.Usuario.DesafioDeUsuario;

class EstadoCompletoTest {
	
	EstadoCompleto estado; 
	DesafioDeUsuario desafio;
	Muestra muestra;

	@BeforeEach
	public void setUp() throws Exception {
		desafio = mock(DesafioDeUsuario.class);
		muestra = mock(Muestra.class);
		estado = new EstadoCompleto();
		
	}
	
	@Test
	void testEsEstadoCompleto() {
		assertTrue(estado.estaCompleto());
	}
	
	@Test
	void testElCompletoNoAgregaMuestras() {
	
		estado.agregarSiCumpleRestriccion(muestra, desafio);
		
		verify(desafio, times(0)).agregarMuestra(muestra);
	}
	
	@Test
	void testLosDesafiosCompletosSePuntuan() {
		estado.puntuarDesafio(5, desafio);
		
		verify(desafio, times(1)).setPuntuacion(5);
	}
	
	@Test
	void testLosEstadosAceptadosTienenPorcentajeDeCompletitud100() {
		desafio.agregarMuestra(muestra);
		assertEquals(100 , estado.porcentajeDeCompletitud(desafio)); 
	}
	
	@Test 
	void testElEstadoCompletoNoSeActualiza() {
		estado.actualizarEstado(desafio);
		
		verify(desafio, times(0)).setEstado(estado);
	}
	

}
