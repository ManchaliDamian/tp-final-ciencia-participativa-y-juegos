package ar.edu.unq.po2.tp.Final.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Muestra.Muestra;

class DesafioDeUsuarioTest {
	DesafioDeUsuario desafioDeUsuario;
	Desafio desafio;
	Muestra muestra;

	@BeforeEach
	public void setUp() throws Exception {
		desafio = mock(Desafio.class);
		muestra = mock(Muestra.class);
		desafioDeUsuario = new DesafioDeUsuario(desafio);
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

}
