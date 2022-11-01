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
	Muestra muestra1;
	Muestra muestra2;
	Proyecto proyecto;
	Restricciones restriccionFecha;
	Restricciones restriccionDia; 
	EstrategiaDeSeleccion estrategia;

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
		restriccionFecha = new RestriccionFecha(unaFechaDeIncio, unaFechaDeFin);
		restriccionDia = new RestriccionDia(Dia.Lunes); 
		
		LocalDate fechaDeMuestra = LocalDate.of(2022, 10, 22);
		muestra1 = new Muestra(null, usuario, fechaDeMuestra, null, Dia.Martes);
		muestra2 = new Muestra(null, usuario, fechaDeMuestra, null, Dia.Jueves);
		
	
		desafio1 = new Desafio(null, restriccionFecha, 2, 5, 1); 
		desafio2 = new Desafio(null, restriccionDia, 2, 5, 1);

		desafioDeUsuario1 = new DesafioDeUsuario(desafio1); 
		desafioDeUsuario2 = new DesafioDeUsuario(desafio2); 
		
		proyecto = new Proyecto("Pepito", "los pepitos"); 


		List<Desafio> desafios = new ArrayList<Desafio>();
		desafios.add(desafio1);
		desafios.add(desafio2);

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
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarDesafio(desafioDeUsuario2);
		
		int cantP = usuario.desafiosPendientes().size();
		assertEquals(2, cantP);

	}

	@Test
	void testUnUsuarioAceptaLosDesafíosQueTienePendientes() {
		//cuando un desafioDeUsuario se agrega comienza siendo pendiente.
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
		usuario.agregarProyecto(proyecto);

		int cantP = usuario.getProyectos().size();

		assertEquals(1, cantP);

	}
	
	@Test
	void testUnUsuarioEliminaUnProyecto() {
		usuario.agregarProyecto(proyecto);

		usuario.eliminarProyecto(proyecto);
		int cantP = usuario.getProyectos().size();

		assertEquals(0, cantP);
	}
	
	@Test 
	void testElUsuarioNoPuedeAgregarUnaMuestraSiElDesafioDeUsuarioNoEstaAceptado() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarMuestra(muestra1, proyecto);
		
	    assertFalse(desafioDeUsuario1.getMuestrasObtenidas().contains(muestra1)); 
	
	}
	
	@Test 
	void testUnUsuarioAgregaUnaMuestraADesafioDeUsuarioAceptado() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.aceptarDesafiosPendientes();
		
		usuario.agregarMuestra(muestra1, proyecto); 
	
	    assertTrue(desafioDeUsuario1.getMuestrasObtenidas().contains(muestra1)); 
		
	
	}

	@Test
	void testUnUsuarioConoceSusDesafiosCompletos() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarDesafio(desafioDeUsuario2);
		usuario.aceptarDesafiosPendientes();
		
		usuario.agregarMuestra(muestra1, proyecto);
		usuario.agregarMuestra(muestra2, proyecto);
		int cantC = usuario.desafiosCompletos().size();

		assertEquals(1, cantC);
	}

	@Test
	void testUnUsuarioAgregaUnaMuestraTambienSeAgregaAlProyecto() {
		proyecto.agregarParticipante(usuario);
		
		usuario.agregarMuestra(muestra1, proyecto);

		assertTrue(proyecto.getMuestras().contains(muestra1));
	}

	@Test
	void testUnUsuarioCuandoAgregaUnaMuestraSeAgregaALosDesafiosDeUsuarioCorrepondientes() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.agregarDesafio(desafioDeUsuario2);
		usuario.aceptarDesafiosPendientes();
		
		usuario.agregarMuestra(muestra1, proyecto);
		usuario.agregarMuestra(muestra2, proyecto);
		
		assertTrue(desafioDeUsuario1.getMuestrasObtenidas().contains(muestra1));
		assertFalse(desafioDeUsuario2.getMuestrasObtenidas().contains(muestra2));
		
	}

	@Test
	void testUnUsuarioConoceElPorcentajeDeCompletitudDeUnDesafioDeUsuario() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.aceptarDesafiosPendientes();
		usuario.agregarMuestra(muestra1, proyecto);
		
		double porcentaje = usuario.getPorcentajeDeCompletitud(desafioDeUsuario1);
		
		assertEquals(50.0, porcentaje);
		
	}

	@Test

	void testUnUsuarioPuntuaUnDesafioDeUsuarioCompleto() {
		usuario.agregarDesafio(desafioDeUsuario1);
		usuario.aceptarDesafiosPendientes();
		usuario.agregarMuestra(muestra1, proyecto);
		usuario.agregarMuestra(muestra2, proyecto);
		
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
