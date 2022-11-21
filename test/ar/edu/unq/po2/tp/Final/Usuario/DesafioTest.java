package ar.edu.unq.po2.tp.Final.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Muestra.AreaGeografica;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;
import ar.edu.unq.po2.tp.Final.Restricciones.RestriccionDiaHabil;
import ar.edu.unq.po2.tp.Final.Restricciones.Restricciones;

class DesafioTest {
	Desafio desafio;
	Desafio desafio2;
	Usuario usuario;
	AreaGeografica area;
	Muestra muestra;
	Restricciones restriccionDiaHabil;

	@BeforeEach
	public void setUp() throws Exception {
		area = mock(AreaGeografica.class);
		usuario = mock(Usuario.class);
		muestra = mock(Muestra.class);
		desafio = new Desafio(area, 10, 4, 10, "Desafio matematico");
		desafio2 = new Desafio(area, 10, 2, 20, "Desafio programacion");
		restriccionDiaHabil = mock(RestriccionDiaHabil.class);

	}

	@Test
	void testUnDesafioTieneCoincidenciaPreferidaConUnUsuario() {
		when(usuario.cantMuestrasPref()).thenReturn(4);
		when(usuario.dificultadPref()).thenReturn(4);
		when(usuario.recompensaPref()).thenReturn(20);

		int coincidenciaPref = desafio.coincidenciaPorPref(usuario);

		assertEquals(16, coincidenciaPref);
	}

	@Test
	void testUnDesafioTieneCoincidenciaPorFavoritos() {
		int coincidenciaFav = desafio.coincidenciaPorFav(desafio2);

		assertEquals(12, coincidenciaFav);
	}

	@Test
	void testNuevoDesafioDeUsuario() {
		DesafioDeUsuario desafioDeUsuarioNuevo = desafio.nuevoDesafioDeUsuario();

		assertEquals(desafioDeUsuarioNuevo.getDesafio(), desafio);
	}

	@Test
	void testCumpleConRestriccion() {
		desafio.setRestriccion(restriccionDiaHabil);
		Restricciones restricionDesafio = desafio.getRestriccionTemp();

		
		desafio.cumpleConRestriccion(muestra);
		
		verify(restricionDesafio, times(1)).isMuestraValida(muestra); 
	}

}
