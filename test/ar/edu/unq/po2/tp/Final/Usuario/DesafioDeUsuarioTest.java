package ar.edu.unq.po2.tp.Final.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Estados.Estado;
import ar.edu.unq.po2.tp.Final.Estados.EstadoCompleto;
import ar.edu.unq.po2.tp.Final.Estados.EstadoPendiente;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;

class DesafioDeUsuarioTest {
	DesafioDeUsuario desafioDeUsuario;
	Desafio desafio;
	Muestra muestra;
	Estado estado;

	@BeforeEach
	public void setUp() throws Exception {
		desafio = mock(Desafio.class);
		muestra = mock(Muestra.class);
		desafioDeUsuario = new DesafioDeUsuario(desafio);
		estado = mock(EstadoPendiente.class);
	}

	@Test
	void testUnDesafioDeUsuarioAgregaUnaMuestraValida() {
		when(desafio.cumpleConRestriccion(muestra)).thenReturn(true);

		desafioDeUsuario.agregarSiCumpleRestriccion(muestra);

		assertTrue(desafioDeUsuario.getMuestrasObtenidas().contains(muestra));

	}

	@Test
	void testUnDesafioDeUsuarioNoAgregaUnaMuestraInvalida() {
		when(desafio.cumpleConRestriccion(muestra)).thenReturn(false);

		desafioDeUsuario.agregarSiCumpleRestriccion(muestra);

		assertFalse(desafioDeUsuario.getMuestrasObtenidas().contains(muestra));
	}

	@Test
	void testElDesafioAceptaElDesafio() {
		assertTrue(desafioDeUsuario.esDesafioPendiente());

		desafioDeUsuario.aceptarDesafio();

		assertTrue(desafioDeUsuario.esDesafioAceptado());
	}

	@Test
	void testPuntuarDesafioSinSerCompletado() {
		desafioDeUsuario.puntuarDesafio(5);

		assertEquals(0, desafioDeUsuario.getPuntuacion());
	}
	
	@Test 
	void testElDesafioSePuntuaAlEstarCompleto() {
		desafioDeUsuario.setEstado(new EstadoCompleto());
		
		desafioDeUsuario.puntuarDesafio(5);

		assertEquals(5, desafioDeUsuario.getPuntuacion());

	}
	
	@Test
	void testcantMuestrasParaCumplirDesafio() {
		when(desafio.getCantMuestras()).thenReturn(5);
		
		assertEquals(desafioDeUsuario.cantMuestrasParaCumplirDesafio(), 5);
	}
	

}
