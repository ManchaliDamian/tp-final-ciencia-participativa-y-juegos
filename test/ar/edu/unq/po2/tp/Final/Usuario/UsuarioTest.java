package ar.edu.unq.po2.tp.Final.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Proyecto;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;

class UsuarioTest {
	Usuario usuario;
	Preferencia preferencia;
	Muestra muestra;
	Proyecto proyecto1;
	Proyecto proyecto2;
	DesafioDeUsuario desafioDeUsuario1;
	DesafioDeUsuario desafioDeUsuario2;
	Desafio desafio1;
	Desafio desafio2;
	
	@BeforeEach
	public void setUp() throws Exception {
		preferencia = mock(Preferencia.class);
		usuario = new Usuario(preferencia);
		muestra = mock(Muestra.class);
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		desafioDeUsuario1 = mock(DesafioDeUsuario.class);
		desafioDeUsuario2 = mock(DesafioDeUsuario.class);

		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);

		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarDesafio(desafioDeUsuario2);

	}

	@Test
	void testUnUsuarioAceptaLosDesafios() {
		usuario.aceptarDesafiosPendientes();

		verify(desafioDeUsuario1, times(1)).aceptarDesafio();
	}

	@Test
	void testUnUsuarioTieneUnPorcentajeDeCompletitud() {
		when(desafioDeUsuario1.esDesafioCompleto()).thenReturn(true);
		when(desafioDeUsuario2.esDesafioCompleto()).thenReturn(false);

		double porcentaje = usuario.porcentajeDeCompletitudGral();

		assertEquals(50.0, porcentaje);
	}

	@Test
	void testUnUsuarioSabeSuDesafioConMayorPuntaje() {
		when(desafioDeUsuario1.getPuntuacion()).thenReturn(4);
		when(desafioDeUsuario2.getPuntuacion()).thenReturn(2);

		DesafioDeUsuario defUsuario = usuario.desafioDeUsuarioConMayorPuntaje();
		assertEquals(desafioDeUsuario1, defUsuario);

	}

	@Test
	void testUnUsuarioAgregaProyectos() {
		usuario.agregarProyecto(proyecto1);

		int cantProyectos = usuario.getProyectos().size();
		assertEquals(1, cantProyectos);
	}

	@Test
	void testUnUsuarioTieneUnaCantidadDeMuestrasPreferidas() {
		when(preferencia.getCantidadDeMuestras()).thenReturn(6);

		int cantMuestrasPref = usuario.cantMuestrasPref();

		assertEquals(6, cantMuestrasPref);
	}

	@Test
	void testUnUsuarioTieneUnaDificultadPreferida() {
		when(preferencia.getDificultad()).thenReturn(4);

		int dif = usuario.dificultadPref();

		assertEquals(4, dif);
	}

	@Test
	void testUnUsuarioTieneUnaRecompensaPreferida() {
		when(preferencia.getRecompensa()).thenReturn(10);

		int recom = usuario.recompensaPref();

		assertEquals(10, recom);
	}

	@Test
	void testUnUsuarioAgregaDesafioDeInteres() {
		usuario.getDesafiosInteres().add(desafio1);

		usuario.agregarDesafiosDeIntereses();

		verify(desafio1, times(1)).nuevoDesafioDeUsuario();

	}

	@Test
	void testUnUsuarioConoceSusDesafiosPendientes() {
		when(desafioDeUsuario1.esDesafioPendiente()).thenReturn(true);
		when(desafioDeUsuario2.esDesafioPendiente()).thenReturn(false);
		
		List<DesafioDeUsuario> desafios = usuario.desafiosPendientes();
		
		assertTrue(desafios.contains(desafioDeUsuario1));
		assertFalse(desafios.contains(desafioDeUsuario2));
	}
	
	@Test
	void testUnUsuarioConoceSusDesafiosCompletos() {
		when(desafioDeUsuario1.esDesafioCompleto()).thenReturn(true);
		when(desafioDeUsuario2.esDesafioCompleto()).thenReturn(false);
		
		List<DesafioDeUsuario> desafios = usuario.desafiosCompletos();
		
		assertTrue(desafios.contains(desafioDeUsuario1));
		assertFalse(desafios.contains(desafioDeUsuario2));
	}

}
