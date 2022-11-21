package ar.edu.unq.po2.tp.Final.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Proyecto;
import ar.edu.unq.po2.tp.Final.EstrategiaSeleccion.EstrategiaDeSeleccion;
import ar.edu.unq.po2.tp.Final.EstrategiaSeleccion.Favoritos;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;

class UsuarioTest {
	Usuario usuario;
	Preferencia preferencia;
	EstrategiaDeSeleccion favoritos;
	Muestra muestra;
	Proyecto proyecto1;
	Proyecto proyecto2;
	DesafioDeUsuario desafioDeUsuario1;
	DesafioDeUsuario desafioDeUsuario2;
	Desafio desafio1;
	Desafio desafio2;
	Desafio desafio3;
	Desafio desafio4;
	Desafio desafio5;
	Desafio desafio6;
	Desafio desafio7;
	Desafio desafio8;

	@BeforeEach
	public void setUp() throws Exception {
		preferencia = mock(Preferencia.class);
		usuario = new Usuario(preferencia);
		muestra = mock(Muestra.class);
		favoritos = mock(Favoritos.class);
		proyecto1 = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		desafioDeUsuario1 = mock(DesafioDeUsuario.class);
		desafioDeUsuario2 = mock(DesafioDeUsuario.class);

		when(desafioDeUsuario1.getDesafio()).thenReturn(desafio1);
		when(desafioDeUsuario2.getDesafio()).thenReturn(desafio2);

		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		desafio5 = mock(Desafio.class);
		desafio6 = mock(Desafio.class);
		desafio7 = mock(Desafio.class);
		desafio8 = mock(Desafio.class);

		when(preferencia.getCantidadDeMuestras()).thenReturn(4);
		when(preferencia.getDificultad()).thenReturn(2);
		when(preferencia.getRecompensa()).thenReturn(10);

		when(desafio1.getCantMuestras()).thenReturn(4);
		when(desafio1.getDificultad()).thenReturn(2);
		when(desafio1.getRecompensa()).thenReturn(10);

		when(desafio3.getCantMuestras()).thenReturn(12);
		when(desafio3.getDificultad()).thenReturn(4);
		when(desafio3.getRecompensa()).thenReturn(10);

		when(desafio4.getCantMuestras()).thenReturn(10);
		when(desafio4.getDificultad()).thenReturn(2);
		when(desafio4.getRecompensa()).thenReturn(10);

		when(desafio5.getCantMuestras()).thenReturn(12);
		when(desafio5.getDificultad()).thenReturn(2);
		when(desafio5.getRecompensa()).thenReturn(12);

		when(desafio6.getCantMuestras()).thenReturn(6);
		when(desafio6.getDificultad()).thenReturn(4);
		when(desafio6.getRecompensa()).thenReturn(10);

		when(desafio7.getCantMuestras()).thenReturn(12);
		when(desafio7.getDificultad()).thenReturn(4);
		when(desafio7.getRecompensa()).thenReturn(10);

		when(desafio8.getCantMuestras()).thenReturn(20);
		when(desafio8.getDificultad()).thenReturn(5);
		when(desafio8.getRecompensa()).thenReturn(20);

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

	@Test
	void testUnUsuarioHaceMathConDesafiosConEstrategiaDePreferenciaDeJuego() {
		List<Desafio> desafios = Arrays.asList(desafio3, desafio4, desafio5, desafio6, desafio7, desafio8);

		usuario.buscarMathConDesafios(desafios);

		verify(desafio8, never()).nuevoDesafioDeUsuario();
		verify(desafio4, times(1)).nuevoDesafioDeUsuario();
	}


	
	 
	@Test
	void testElUsuarioConoceElporcentajeDeCompletitudDeSusDesafios() {
		when(desafioDeUsuario1.getPorcentajeDeCompletitud()).thenReturn(55.0);
		
		double porcentajeDeDesafio = usuario.getPorcentajeDeCompletitud(desafioDeUsuario1);
		
		assertEquals(55.0 , porcentajeDeDesafio);
		verify(desafioDeUsuario1, times(1)).getPorcentajeDeCompletitud();
	}
	
	@Test
	void testelUsuarioPuntuaSusDesafiosCompletos() {
		when(desafioDeUsuario1.esDesafioCompleto()).thenReturn(true);
		usuario.puntuarDesafio(desafioDeUsuario1, 5);
		
		verify(desafioDeUsuario1, times(1)).puntuarDesafio(5);;
	}
	
   @Test
   void testElUsuarioAgregaUnaMuestra() {
	   usuario.agregarMuestra(muestra, proyecto1);
	   
	   verify(proyecto1 , times(1)).agregarMuestra(muestra);
   }
   
   @Test  
   void testElUsuarioAgregaProyectos() {
	   List <Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2);
	   
	   usuario.agregarProyectos(proyectos);
	   
	   assertTrue(usuario.getProyectos().containsAll(proyectos));
   }
}
