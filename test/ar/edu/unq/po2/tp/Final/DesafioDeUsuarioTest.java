package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DesafioDeUsuarioTest {
	DesafioDeUsuario desafioDeUsuario;
	Desafio desafio;
	Usuario usuario;
	Muestra muestra1;
	Muestra muestra2;
	Restricciones restriccionDia;

	@BeforeEach
	public void setUp() throws Exception {
		usuario = mock(Usuario.class);
		LocalDate fechaMuestra = LocalDate.of(2022, 10, 20);
		muestra1 = new Muestra(null, usuario, fechaMuestra, null, Dia.Sabado);
		muestra2 = new Muestra(null, usuario, fechaMuestra, null, Dia.Viernes);

		restriccionDia = new RestriccionDia(Dia.Sabado);
		desafio = new Desafio(null, restriccionDia, 1, 5, 1);
		desafioDeUsuario = new DesafioDeUsuario(desafio);
 
	}

	@Test
	void testUnDesafioDeUsuarioComienzaSiendoUnEstadoPediente() {
		assertTrue(desafioDeUsuario.getEstado().esEstadoPendiente());
	}

	@Test
	void testDesafioDeUsuarioActualizaSuEstadoAEstadoAceptado() {
		desafioDeUsuario.aceptarDesafio();

		assertTrue(desafioDeUsuario.getEstado().estaAceptado());

	}

	@Test
	void testUnDesafioDeUsuarioConEstadoAceptadoAgregaUnaMuestra() {
		desafioDeUsuario.aceptarDesafio();

		desafioDeUsuario.agregarMuestra(muestra1);

		assertTrue(desafioDeUsuario.getMuestrasObtenidas().contains(muestra1));
	}

	@Test
	void testUnDesafioDeUsuarioConEstadoPendienteNoAgregaUnaMuestra() {
		desafioDeUsuario.agregarMuestra(muestra1);

		assertFalse(desafioDeUsuario.getMuestrasObtenidas().contains(muestra1));
	}

	@Test
	void testUnDesafioDeUsuarioConEstadoCompletoNoAgregaUnaMuestra() {
		desafioDeUsuario.agregarMuestra(muestra1);

		desafioDeUsuario.agregarMuestra(muestra2);

		assertFalse(desafioDeUsuario.getMuestrasObtenidas().contains(muestra2));
	}

	@Test
	void testUnDesafioDeUsuarioAgregaUnaMuestraQueCumpleConRestriccionesDeDesafio() {
		desafioDeUsuario.agregarSiCumpleRestriccion(muestra1);

		assertTrue(desafioDeUsuario.getMuestrasObtenidas().contains(muestra1));
	}

	@Test
	void testUnDesafioDeUsuarioNoAgregaUnaMuestraSiNoCumpleConLaRestriccionesDeDesafio() {
		desafioDeUsuario.agregarMuestra(muestra2);

		assertFalse(desafioDeUsuario.getMuestrasObtenidas().contains(muestra2));
	}

	@Test
	void testCuandoUnDesafioDeUsuarioEsCompletadoSeActualizaAEstadoCompleto() {
		desafioDeUsuario.aceptarDesafio();

		desafioDeUsuario.agregarMuestra(muestra1);

		assertTrue(desafioDeUsuario.getEstado().estaCompleto());
	}

	@Test
	void testUnDesafioDeUsuarioTieneUnaCantidadDeMuestrasRecolectadas() {
		desafioDeUsuario.aceptarDesafio();
		desafioDeUsuario.agregarMuestra(muestra1);

		int cantMuestras = desafioDeUsuario.cantidadDeMuestrasRecolectadas();

		assertEquals(1, cantMuestras);
	}

	@Test
	void testUnDesafioDeUsuarioTieneUnaCantDeMuestrasParaCompletarElDesafio() {
		int cant = desafioDeUsuario.cantMuestrasParaCumplirDesafio();

		assertEquals(1, cant);
	}
	
	@Test
	void testUnDesafioDeUsuarioConoceSuPorcentajeDeCompletitud() {
		desafioDeUsuario.aceptarDesafio();
		desafioDeUsuario.agregarMuestra(muestra1);
		
		double porcentaje = desafioDeUsuario.getPorcentajeDeCompletitud();
		
		assertEquals(100.0, porcentaje);
	}
} 
