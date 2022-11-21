package ar.edu.unq.po2.tp.Final.Estados;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Muestra.Muestra;
import ar.edu.unq.po2.tp.Final.Usuario.DesafioDeUsuario;

class EstadoPendienteTest {
 EstadoPendiente estado;
 DesafioDeUsuario desafio;
 Muestra muestra;
	
 @BeforeEach 
	public void setUp() throws Exception{
	 desafio = mock(DesafioDeUsuario.class);
	 muestra = mock(Muestra.class); 
	 estado = new EstadoPendiente(); 
 }

 
	@Test
	void testEsEstadoPendiente() {

		assertTrue(estado.esEstadoPendiente()); 
	}
	
	@Test
	void testElPendienteNoAgregaMuestras() {
	
		estado.agregarSiCumpleRestriccion(muestra, desafio);
		
		verify(desafio, times(0)).agregarMuestra(muestra);
	}
	
	@Test
	void testLosDesafiosPendientesNoSePuntuan() {
		estado.puntuarDesafio(0, desafio);
		
		verify(desafio, times(0)).setPuntuacion(0);
	}
	
	@Test
	void testLosEstadosPendientesTienenPorcentajeDeCompletitud0() {
		desafio.agregarMuestra(muestra);
		assertEquals(0 , estado.porcentajeDeCompletitud(desafio)); 
	}
	
	
	

}
