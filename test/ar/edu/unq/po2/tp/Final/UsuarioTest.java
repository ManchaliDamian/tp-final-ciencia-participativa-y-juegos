package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Estados.Estado;
import ar.edu.unq.po2.tp.Final.Estados.EstadoAceptado;
import ar.edu.unq.po2.tp.Final.Estados.EstadoCompleto;
import ar.edu.unq.po2.tp.Final.Estados.EstadoPendiente;
import ar.edu.unq.po2.tp.Final.EstrategiaSeleccion.EstrategiaDeSeleccion;
import ar.edu.unq.po2.tp.Final.EstrategiaSeleccion.PreferenciasDeJuego;
import ar.edu.unq.po2.tp.Final.Muestra.Dia;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;
import ar.edu.unq.po2.tp.Final.Restricciones.RestriccionDia;
import ar.edu.unq.po2.tp.Final.Restricciones.Restricciones;
import ar.edu.unq.po2.tp.Final.Restricciones.Restricciones.RestriccionFecha;
import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.DesafioDeUsuario;
import ar.edu.unq.po2.tp.Final.Usuario.Preferencia;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

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
	DesafioDeUsuario desafioDeUsuarioMock1;
	DesafioDeUsuario desafioDeUsuarioMock2;
	DesafioDeUsuario desafioDeUsuarioMock3;
	Estado estadoCompleto;
	Estado estadoAceptado;
	Estado estadoPendiente;
	Muestra muestra1;
	Muestra muestra2;
	Proyecto proyecto1;
	Proyecto proyecto2;
	Proyecto proyecto3;

	Restricciones restriccionFecha;
	Restricciones restriccionDia;
	EstrategiaDeSeleccion estrategiaPreferencia;
	EstrategiaDeSeleccion estrategiaFav;

	List<Desafio> desafios = new ArrayList<Desafio>();
	List<DesafioDeUsuario> desafiosDeUsuario = new ArrayList<DesafioDeUsuario>();

	@BeforeEach
	public void setUp() throws Exception {
		preferencia = mock(Preferencia.class);
		usuario = new Usuario(preferencia);

		estadoCompleto = new EstadoCompleto();
		estadoAceptado = new EstadoAceptado();
		estadoPendiente = new EstadoPendiente();

		LocalDate unaFechaDeIncio = LocalDate.of(2022, 10, 20);
		LocalDate unaFechaDeFin = LocalDate.of(2022, 10, 30);
		restriccionFecha = new RestriccionFecha(unaFechaDeIncio, unaFechaDeFin);
		restriccionDia = new RestriccionDia(Dia.Lunes);

		LocalDate fechaDeMuestra = LocalDate.of(2022, 10, 22);
		muestra1 = new Muestra(null, usuario, fechaDeMuestra, null, Dia.Martes);
		muestra2 = new Muestra(null, usuario, fechaDeMuestra, null, Dia.Jueves);

		desafio1 = new Desafio(null, restriccionFecha, 2, 5, 1, "Cuentas");
		desafio2 = new Desafio(null, restriccionDia, 2, 5, 1, "Divisiones");
		desafio3 = new Desafio(null, restriccionDia, 5, 5, 10, "Multiplicaciones");
		desafio4 = new Desafio(null, restriccionDia, 2, 3, 10, "Raices");
		desafio5 = new Desafio(null, restriccionDia, 10, 10, 15, "Logaritmos");
		desafio6 = new Desafio(null, restriccionDia, 2, 1, 4, "Pitagoras");

		<<Correcion>>
			No inicializar objetos con variables null. Usar objetos doubles.
			
		desafioDeUsuario1 = new DesafioDeUsuario(desafio1);
		desafioDeUsuario2 = new DesafioDeUsuario(desafio2);

		desafioDeUsuarioMock1 = mock(DesafioDeUsuario.class);
		desafioDeUsuarioMock2 = mock(DesafioDeUsuario.class);
		desafioDeUsuarioMock3 = mock(DesafioDeUsuario.class);

		proyecto3 = new Proyecto("Pepito", "los pepitos");
		proyecto1 = new Proyecto("Java", "arboles");
		proyecto2 = new Proyecto("Programacion", "Lenguaje orientado a objetos");

		desafiosDeUsuario.add(desafioDeUsuario1);
		desafiosDeUsuario.add(desafioDeUsuario2);

		usuario.puntuarDesafio(desafioDeUsuario1, 4);
		usuario.puntuarDesafio(desafioDeUsuario2, 9);

		desafios.add(desafio1);
		desafios.add(desafio2);
		desafios.add(desafio3);
		
		<<Correcion>>
		ESto no es un test unitario. Esto es un test de integracion donde se innstancian todos los objetos para probar como interactuan entre si.

	}

	@Test
	void testCuandoUnUsuarioAgregaUnNuevoDesafíoLoContieneEntreSusDesafíos() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarDesafio(desafioDeUsuario2);

		int cantD = usuario.getDesafios().size();

		assertEquals(2, cantD);
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
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarDesafio(desafioDeUsuario2);

		int cantP = usuario.desafiosPendientes().size();
		assertEquals(2, cantP);

	}

	@Test
	void testUnUsuarioAceptaLosDesafíosQueTienePendientes() {
		// cuando un desafioDeUsuario se agrega comienza siendo pendiente.
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarDesafio(desafioDeUsuario2);

		usuario.aceptarDesafiosPendientes();
		int cantDesafiosPendientes = usuario.desafiosPendientes().size();

		assertTrue(desafioDeUsuario1.getEstado().estaAceptado());
		assertEquals(0, cantDesafiosPendientes);
	}

	@Test
	void testUnUsuarioNoAceptaLosDesafiosQueTienePendiente() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarDesafio(desafioDeUsuario2);

		int cantDesafiosPendientes = usuario.desafiosPendientes().size();

		assertTrue(desafioDeUsuario1.getEstado().esEstadoPendiente());
		assertEquals(2, cantDesafiosPendientes);

	}

	@Test
	void testUnUsuarioAgregaUnNuevoProyecto() {
		usuario.agregarProyecto(proyecto3);

		int cantP = usuario.getProyectos().size();

		assertEquals(1, cantP);

	}

	@Test
	void testUnUsuarioEliminaUnProyecto() {
		usuario.agregarProyecto(proyecto3);

		usuario.eliminarProyecto(proyecto3);
		int cantP = usuario.getProyectos().size();

		assertEquals(0, cantP);
	}

	@Test
	void testElUsuarioNoPuedeAgregarUnaMuestraSiElDesafioDeUsuarioNoEstaAceptado() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarMuestra(muestra1, proyecto3);

		assertFalse(desafioDeUsuario1.getMuestrasObtenidas().contains(muestra1));

	}

	@Test
	void testUnUsuarioAgregaUnaMuestraADesafioDeUsuarioAceptado() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.aceptarDesafiosPendientes();

		usuario.agregarMuestra(muestra1, proyecto3);

		assertTrue(desafioDeUsuario1.getMuestrasObtenidas().contains(muestra1));

	}

	@Test
	void testUnUsuarioConoceSusDesafiosCompletos() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarDesafio(desafioDeUsuario2);
		usuario.aceptarDesafiosPendientes();

		usuario.agregarMuestra(muestra1, proyecto3);
		usuario.agregarMuestra(muestra2, proyecto3);
		int cantC = usuario.desafiosCompletos().size();

		assertEquals(1, cantC);
	}

	@Test
	void testUnUsuarioAgregaUnaMuestraTambienSeAgregaAlProyecto() {
		proyecto3.agregarParticipante(usuario);

		usuario.agregarMuestra(muestra1, proyecto3);

		assertTrue(proyecto3.getMuestras().contains(muestra1));
	}

	@Test
	void testUnUsuarioCuandoAgregaUnaMuestraSeAgregaALosDesafiosDeUsuarioCorrepondientes() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarDesafio(desafioDeUsuario2);
		usuario.aceptarDesafiosPendientes();

		usuario.agregarMuestra(muestra1, proyecto3);
		usuario.agregarMuestra(muestra2, proyecto3);

		assertTrue(desafioDeUsuario1.getMuestrasObtenidas().contains(muestra1));
		assertFalse(desafioDeUsuario2.getMuestrasObtenidas().contains(muestra2));

	}

	@Test
	void testUnUsuarioConoceElPorcentajeDeCompletitudDeUnDesafioDeUsuario() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.aceptarDesafiosPendientes();
		usuario.agregarMuestra(muestra1, proyecto3);

		double porcentaje = usuario.getPorcentajeDeCompletitud(desafioDeUsuario1);

		assertEquals(50.0, porcentaje);

	}

	@Test

	void testUnUsuarioPuntuaUnDesafioDeUsuarioCompleto() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.aceptarDesafiosPendientes();
		usuario.agregarMuestra(muestra1, proyecto3);
		usuario.agregarMuestra(muestra2, proyecto3);

		usuario.puntuarDesafio(desafioDeUsuario1, 4);

		assertEquals(4, desafioDeUsuario1.getPuntuacion());

	}

	@Test
	void testUnUsuarioNoPuedePuntuarUnDesafioDeUsuarioNoCompleto() {
		usuario.puntuarDesafio(desafioDeUsuario1, 4);

		assertEquals(0, desafioDeUsuario1.getPuntuacion());
	}

	@Test
	void testUnUsuarioUtilizaLaEstrategiaPreferencia() {
		int cantidadAntesDeAgregarDesafios = usuario.getDesafios().size();
		usuario.setEstrategia(new PreferenciasDeJuego());

		usuario.desafiosDeInteres(desafios);
		usuario.agregarDesafiosDeIntereses();

		assertTrue(usuario.getDesafiosInteres().containsAll(desafios));
		assertEquals((cantidadAntesDeAgregarDesafios + 3), usuario.getDesafios().size());
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
		assertEquals((cantidadAntesDeAgregarDesafios + 5), usuario.getDesafios().size());
	; 
	}

	@Test
	void testElUsuarioConoceSuPorcentajeDeCompletitudGralConTodosCompletos() {
		desafiosDeUsuario.add(desafioDeUsuarioMock1);
		desafiosDeUsuario.add(desafioDeUsuarioMock2);

		usuario.agregarDesafio(desafioDeUsuarioMock1);
		usuario.agregarDesafio(desafioDeUsuarioMock2);

		when(desafioDeUsuarioMock1.getEstado()).thenReturn(estadoCompleto);
		when(desafioDeUsuarioMock2.getEstado()).thenReturn(estadoCompleto);

		assertEquals(100, usuario.porcentajeDeCompletitudGral());

	}

	@Test
	void testElUsuarioConoceSuPorcentajeDeCompletitudGralConEstadosNoCompletos() {
		desafiosDeUsuario.add(desafioDeUsuarioMock1);
		desafiosDeUsuario.add(desafioDeUsuarioMock2);

		usuario.getDesafios().add(desafioDeUsuarioMock1);
		usuario.getDesafios().add(desafioDeUsuarioMock2);

		when(desafioDeUsuarioMock1.getEstado()).thenReturn(estadoAceptado);
		when(desafioDeUsuarioMock2.getEstado()).thenReturn(estadoCompleto);

		assertEquals(50, usuario.porcentajeDeCompletitudGral()); 

	}

	@Test 
	void testElUsuarioConoceSuPorcentajeDeCompletitudGralSinNingunoCompleto() {
		desafiosDeUsuario.add(desafioDeUsuarioMock1);
		desafiosDeUsuario.add(desafioDeUsuarioMock2);

		usuario.getDesafios().add(desafioDeUsuarioMock1);
		usuario.getDesafios().add(desafioDeUsuarioMock2);

		when(desafioDeUsuarioMock1.getEstado()).thenReturn(estadoPendiente);
		when(desafioDeUsuarioMock2.getEstado()).thenReturn(estadoPendiente);

		assertEquals(0, usuario.porcentajeDeCompletitudGral());

	}

	@Test
	void testElUsuarioConoceElDesafioConMayorPuntaje() {
		desafiosDeUsuario.add(desafioDeUsuarioMock1);
		desafiosDeUsuario.add(desafioDeUsuarioMock2);

		when(desafioDeUsuarioMock1.getPuntuacion()).thenReturn(5);
		when(desafioDeUsuarioMock1.getNombre()).thenReturn("Cuentas");

		when(desafioDeUsuarioMock3.getNombre()).thenReturn("Hojas");
		when(desafioDeUsuarioMock3.getPuntuacion()).thenReturn(10);

		when(desafioDeUsuarioMock2.getNombre()).thenReturn("Arboles");
		when(desafioDeUsuarioMock2.getPuntuacion()).thenReturn(1);

		usuario.agregarDesafio(desafioDeUsuarioMock1);
		usuario.agregarDesafio(desafioDeUsuarioMock2);
		usuario.agregarDesafio(desafioDeUsuarioMock3);

		DesafioDeUsuario desafioFav = usuario.desafioDeUsuarioConMayorPuntaje();

		assertEquals(desafioFav.getNombre(), "Hojas");
	}
	
	@Test
	void testElUsuarioAgregaProyectosAsignados() {
		List<Proyecto> proyectos = Arrays.asList(proyecto1, proyecto2, proyecto3);
		
		usuario.agregarProyectos(proyectos);
		
		assertTrue(usuario.getProyectos().containsAll(proyectos)); 
	}
}
