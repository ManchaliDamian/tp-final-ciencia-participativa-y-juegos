package ar.edu.unq.po2.tp.Final.Estados;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Muestra.Muestra;
import ar.edu.unq.po2.tp.Final.Usuario.DesafioDeUsuario;

class EstadoAceptadoTest {
	EstadoAceptado estado;
	DesafioDeUsuario desafio;
	Muestra muestra;

	@BeforeEach
	public void setUp() throws Exception {
		desafio = mock(DesafioDeUsuario.class);
		muestra = mock(Muestra.class);
		estado = new EstadoAceptado();

	}

	@Test
	void testEsEstadoAceptado() {
		assertTrue(estado.estaAceptado());
	}

	@Test
	void testElEstadoAceptadoTieneUnPorcentajeDeCompletitud() {
		when(desafio.cantidadDeMuestrasRecolectadas()).thenReturn(5);
		when(desafio.cantMuestrasParaCumplirDesafio()).thenReturn(9);

		assertEquals(55.0, estado.porcentajeDeCompletitud(desafio));

	}

	@Test
	void testElAceptadoPuedeAgregarMuestras() {

		estado.agregarSiCumpleRestriccion(muestra, desafio);

		verify(desafio, times(1)).agregarMuestra(muestra);
	}

	@Test
	void testLosDesafiosAceptadosNoSePuntuan() {
		estado.puntuarDesafio(0, desafio);

		verify(desafio, times(0)).setPuntuacion(0);
	}
	
/*
	@Test
	void testElEstadoAceptadoCambiaSuEstadoCuandoTienePorcentaje100() {
	
		when(desafio.getEstado()).thenReturn(estado);
		when(desafio.cantidadDeMuestrasRecolectadas()).thenReturn(5);
		when(desafio.cantMuestrasParaCumplirDesafio()).thenReturn(5);
		
		estado.actualizarEstado(desafio);

       assertTrue(desafio.getEstado().equals(new EstadoCompleto())); 
	}

*/ 

}
