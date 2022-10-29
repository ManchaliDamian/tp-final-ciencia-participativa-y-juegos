package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTestCase {
	Usuario usuario;
	Preferencia preferencia;

	@BeforeEach
	public void setUp() throws Exception {
		preferencia = mock(Preferencia.class);
		usuario = new Usuario(preferencia);
	}

	@Test
	void testUnUsuarioTieneUnaPreferenciaDeDesafío() {
		
	}

	@Test
	void testUnUsuarioTieneUnaPreferenciaEnRecompesa() {

		when(preferencia.getRecompensa()).thenReturn(20);
		assertEquals(20, usuario.getPreferencia().getRecompensa());
	}

}
