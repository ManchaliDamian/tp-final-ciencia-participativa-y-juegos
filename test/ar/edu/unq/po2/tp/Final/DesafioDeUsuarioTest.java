package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.po2.tp.Final.Muestra.Dia;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;
import ar.edu.unq.po2.tp.Final.Restricciones.RestriccionDiaHabiles;
import ar.edu.unq.po2.tp.Final.Restricciones.Restricciones;
import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.DesafioDeUsuario;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

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
		muestra1 = new Muestra(null, usuario, fechaMuestra, null);
		muestra2 = new Muestra(null, usuario, fechaMuestra, null);
		//<<Correcion>>
		//	No inicializar objetos con variables como null. Para eso estan los Mock.
		//	No utlizan objetos doubles. 
		//	No esta claro que es SUT y que es DOC.
		restriccionDia = new RestriccionDiaHabiles();
		desafio = new Desafio(null, restriccionDia, 1, 5, 1, "Cuenta");
		desafioDeUsuario = new DesafioDeUsuario(desafio);
 
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
