package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	Preferencia preferencia;
	Usuario usuario;
	Desafio desafio1;
	Desafio desafio2;
	Desafio desafio3;
	Desafio desafio4;
	Desafio desafio5;
	Desafio desafio6;
	DesafioDeUsuario desafioDeUsuario1;
	DesafioDeUsuario desafioDeUsuario2;
	DesafioDeUsuario desafioDeUsuario3;
	Estado estadoCompleto;
	Estado estadoAceptado;
	Estado estadoPendiente;
	Muestra muestra;
	Proyecto proyecto;
	Restricciones restriccion;
	EstrategiaDeSeleccion estrategia;

	// tambien el de agregarMuestra hacer uno o dos de como
	// afecta al mock de Desafio de usuario

	@BeforeEach
	public void setUp() throws Exception {
		preferencia = mock(Preferencia.class);
		usuario = new Usuario(preferencia);
		proyecto = new Proyecto("Pepito", "los pepitos"); 


		estadoCompleto = new EstadoCompleto();
		estadoAceptado =new EstadoAceptado(); 
		estadoPendiente = new EstadoPendiente(); 
		
		LocalDate unaFechaDeIncio = LocalDate.of(2022, 10, 20);
		LocalDate unaFechaDeFin = LocalDate.of(2022, 10, 30);
		restriccion = new RestriccionFecha(unaFechaDeIncio, unaFechaDeFin);
		muestra = new Muestra(null, usuario , unaFechaDeIncio , null, Dia.Martes);
		
		desafio1 = new Desafio(null, restriccion, 5, 5, 1); 
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		desafio5 = mock(Desafio.class);
		desafio6 = mock(Desafio.class);

		desafioDeUsuario1 = new DesafioDeUsuario(desafio1); 
		desafioDeUsuario2 = mock(DesafioDeUsuario.class);
		desafioDeUsuario3 = mock(DesafioDeUsuario.class);
		

		muestra = new Muestra(null, usuario , unaFechaDeIncio , null, Dia.Martes);
		proyecto = new Proyecto("Pepito", "los pepitos"); 


		List<Desafio> desafios = new ArrayList<Desafio>();
		desafios.add(desafio1);
		desafios.add(desafio2);
		desafios.add(desafio3);

	}

	@Test
	void testCuandoUnUsuarioAgregaUnNuevoDesafíoLoContieneEntreSusDesafíos() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarDesafio(desafioDeUsuario2);
		usuario.agregarDesafio(desafioDeUsuario3);

		int cantD = usuario.getDesafios().size();

		assertEquals(3, cantD);
	}

	@Test
	void testUnUsuarioEliminaUnDesafioDeSusDesafios() {
		usuario.agregarDesafio(desafioDeUsuario1);

		usuario.eliminarDesafio(desafioDeUsuario1);
		int cantD = usuario.getDesafios().size();

		assertEquals(0, cantD);
	}

	@Test
	void testUnUsuarioConoceSusDesafiosPendientes() {
		usuario.agregarDesafio(desafioDeUsuario2);
		usuario.agregarDesafio(desafioDeUsuario3);
		when(estadoPendiente.esEstadoPendiente()).thenReturn(true);
		when(estadoAceptado.esEstadoPendiente()).thenReturn(false);
		when(desafioDeUsuario3.getEstado()).thenReturn(estadoPendiente);
		when(desafioDeUsuario2.getEstado()).thenReturn(estadoAceptado);

		int cantP = usuario.desafiosPendientes().size();
		assertEquals(1, cantP);

	}

	@Test
	void testUnUsuarioAceptaLosDesafíosQueTienePendientes() {
		usuario.agregarDesafio(desafioDeUsuario3);
		when(desafioDeUsuario3.getEstado()).thenReturn(estadoPendiente);

		usuario.aceptarDesafiosPendientes();
		int cantDesafiosPendientes = usuario.desafiosPendientes().size();

		assertEquals(0, cantDesafiosPendientes);
	}

	@Test
	void testUnUsuarioNoAceptaLosDesafiosQueTienePendiente() {
		usuario.agregarDesafio(desafioDeUsuario3);
		when(desafioDeUsuario3.getEstado()).thenReturn(estadoPendiente);
		when(estadoPendiente.esEstadoPendiente()).thenReturn(true);

		int cantDesafiosPendientes = usuario.desafiosPendientes().size();

		assertEquals(1, cantDesafiosPendientes);

	}

	@Test
	void testUnUsuarioAgregaUnNuevoProyecto() {
		usuario.agregarProyecto(proyecto);

		int cantP = usuario.getProyectos().size();

		assertEquals(1, cantP);

	}
	
	@Test 
	void testElUsuarioDebeAceptarLosTestParaSumarMuestras() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarMuestra(muestra, proyecto);
		
	    assertFalse(desafioDeUsuario1.getMuestrasObtenidas().contains(muestra)); 
		// el desafio nunca recibe el mensaje
	}
	
	@Test 
	void testElUsuarioAceptaElDesafiotParaSumarMuestras() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.aceptarDesafiosPendientes();
		usuario.agregarMuestra(muestra, proyecto); 
		
	    assertTrue(desafioDeUsuario1.getMuestrasObtenidas().contains(muestra)); 
		
		//hay algo mal entre agregar muestra y agregarSiCumpleRestriccion, seguro problemas con el estado
	
	}

	@Test
	void testUnUsuarioEliminaUnProyecto() {
		usuario.agregarProyecto(proyecto);

		usuario.eliminarProyecto(proyecto);
		int cantP = usuario.getProyectos().size();

		assertEquals(0, cantP);
	}

	@Test
	void testUnUsuarioConoceSusDesafiosCompletos() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarDesafio(desafioDeUsuario2);
		when(estadoCompleto.estaCompleto()).thenReturn(true);
		when(estadoAceptado.estaCompleto()).thenReturn(false);
		when(desafioDeUsuario1.getEstado()).thenReturn(estadoCompleto);
		when(desafioDeUsuario2.getEstado()).thenReturn(estadoAceptado);

		int cantC = usuario.desafiosCompletos().size();

		assertEquals(1, cantC);
	}

	@Test
	void testUnUsuarioAgregaUnaMuestraTambienSeAgregaAlProyecto() {
		usuario.agregarMuestra(muestra, proyecto);

		verify(proyecto, times(1)).agregarMuestra(muestra);
	}

	@Test
	void testUnUsuarioAgregaUnaMuestraSeEnviaUnMensajeATodosLosDesafiosDeUsuarioParaAgregarMuestra() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarDesafio(desafioDeUsuario2);

		usuario.agregarMuestra(muestra, proyecto);

		verify(desafioDeUsuario1, times(1)).agregarMuestra(muestra);
		verify(desafioDeUsuario2, times(1)).agregarMuestra(muestra);
	}

	@Test
	void testUnUsuarioCuandoAgregaUnaMuestraSeAgregaALosDesafiosDeUsuarioCorrepondientes() {

	}

	@Test
	void testUnUsuarioConoceElPorcentajeDeCompletitudDeUnDesafioDeUsuario() {
		when(estadoAceptado.porcentajeDeCompletitud(desafioDeUsuario1)).thenReturn(20);
		when(desafioDeUsuario1.getEstado()).thenReturn(estadoAceptado);
		usuario.agregarDesafio(desafioDeUsuario1);
		double comp = usuario.getPorcentajeDeCompletitud(desafioDeUsuario1);
		assertEquals(20.0, comp);
	}

	@Test

	void testUnUsuarioPuntuaUnDesafio() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.puntuarDesafio(desafioDeUsuario1, 4);

		verify(desafioDeUsuario1, times(1)).setPuntuacion(4);

	}

	@Test
	void testUnUsuarioUtilizaLaEstrategiaPreferencia() {
		

		int cantidadAntesDeAgregarDesafios = usuario.getDesafios().size();
		usuario.setEstrategia(new PreferenciasDeJuego());

		List<Desafio> desafios = new ArrayList<Desafio>();
		desafios.add(desafio1);
		desafios.add(desafio2);
		desafios.add(desafio3);

		usuario.desafiosDeInteres(desafios);
		usuario.agregarDesafiosDeIntereses();

		assertTrue(usuario.getDesafiosInteres().containsAll(desafios));
		assertEquals((cantidadAntesDeAgregarDesafios + 3) , usuario.getDesafios().size());
		// compruebo que la cantidad que de desafios de usuario incrementa en 3 

	}
	
	@Test
	void testNoSeRecomiendanMasDe5Desafios() {

		int cantidadAntesDeAgregarDesafios = usuario.getDesafios().size();
		usuario.setEstrategia(new PreferenciasDeJuego());

		List<Desafio> desafios = new ArrayList<Desafio>();
		desafios.add(desafio1);
		desafios.add(desafio2);
		desafios.add(desafio3);
		desafios.add(desafio4); 
		desafios.add(desafio5);
		desafios.add(desafio6);
	
		usuario.desafiosDeInteres(desafios);
		usuario.agregarDesafiosDeIntereses();
		
		assertFalse(usuario.getDesafiosInteres().containsAll(desafios)); // se comprueba que excluye un desafio 
		assertEquals((cantidadAntesDeAgregarDesafios + 5) , usuario.getDesafios().size());
	}
	
	

}
