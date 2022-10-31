package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DesafioDeUsuarioTest {
	DesafioDeUsuario desafioDeUsuario;
	Estado estadoAceptado;
	Estado estadoPendiente;
	Estado estadoCompleto;
	Desafio desafio;
	Muestra muestra1;
	Muestra muestra2;
	Restricciones restricciones;

	@BeforeEach
	public void setUp() throws Exception {
		estadoAceptado = mock(EstadoAceptado.class);
		estadoPendiente = mock(EstadoPendiente.class);
		estadoCompleto = mock(EstadoCompleto.class);
		restricciones = mock(Restricciones.class);
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);

		desafio = mock(Desafio.class);
		desafioDeUsuario = new DesafioDeUsuario(desafio);

	}

	@Test
	void testDesafioDeUsuarioSeAgregaComoEstadoPendiente() {
		assertTrue(desafioDeUsuario.getEstado().esEstadoPendiente());
	}

	@Test
	void testDesafioDeUsuarioAceptaDesafiosPendientes() {
		desafioDeUsuario.aceptarDesafio();

		assertTrue(desafioDeUsuario.getEstado().estaAceptado());

	}

	@Test
	void testCuandoUnDesafioDeUsuarioEsCompletadoSeActualizaAEstadoCompleto() {
		when(desafio.getCantMuestras()).thenReturn(1);
		when(estadoAceptado.estaAceptado()).thenReturn(true);
		when(desafio.cumpleConRestriccion(muestra1)).thenReturn(true);
		desafioDeUsuario.setEstado(estadoAceptado);
		
		desafioDeUsuario.agregarMuestra(muestra1);  
		
		verify(estadoAceptado, times(1)).actualizarEstado(desafioDeUsuario);
		// no podemos lograr comparar tipos de estado, de esta manera si estadoAceptado
		// actualiza su estado, verifica que el mismo paso a completo
	} 
 
	@Test
	void testDesafioDeUsuarioAgregaUnaMuestraSiElDesafioEstaAceptado() {
		desafioDeUsuario.setEstado(estadoAceptado);
		when(estadoAceptado.estaAceptado()).thenReturn(true);
		when(desafio.cumpleConRestriccion(muestra1)).thenReturn(true);

		desafioDeUsuario.agregarMuestra(muestra1);
		int cant = desafioDeUsuario.cantidadDeMuestrasRecolectadas();

		assertEquals(1, cant);
	}
 
	@Test
	void testDesafioDeUsuarioNoAgregaUnaMuestraSiElDesafioEstaPendiente() {
		desafioDeUsuario.setEstado(estadoPendiente);
		when(estadoAceptado.estaAceptado()).thenReturn(false);
		when(desafio.cumpleConRestriccion(muestra1)).thenReturn(true);

		desafioDeUsuario.agregarMuestra(muestra1);
		int cant = desafioDeUsuario.cantidadDeMuestrasRecolectadas();

		assertEquals(0, cant);
	}

	@Test
	void testCuandoSeCompletaUnDesafioNoAceptaMasMuestras() {
		desafioDeUsuario.setEstado(estadoCompleto);
		when(estadoCompleto.estaAceptado()).thenReturn(false);
		when(desafio.cumpleConRestriccion(muestra1)).thenReturn(true);

		desafioDeUsuario.agregarMuestra(muestra1);
		int cant = desafioDeUsuario.cantidadDeMuestrasRecolectadas();

		assertEquals(0, cant);
	}

	@Test
	void testDesafioDeUsuarioAgregaUnaMuestraSiEstaAceptadoYLaMuestraEsValida() {
		desafioDeUsuario.setEstado(estadoAceptado);
		when(estadoAceptado.estaAceptado()).thenReturn(true);
		when(desafio.cumpleConRestriccion(muestra1)).thenReturn(true);

		desafioDeUsuario.agregarMuestra(muestra1);
		int cant = desafioDeUsuario.cantidadDeMuestrasRecolectadas();

		assertEquals(1, cant);

	}

	@Test
	void testDesafioDeUsuarioNoAgregaUnaMuestraSiEstaAceptadoPeroLaMuestraNoEsValida() {
		desafioDeUsuario.setEstado(estadoAceptado);
		when(estadoAceptado.estaAceptado()).thenReturn(true);
		when(desafio.cumpleConRestriccion(muestra1)).thenReturn(false);

		desafioDeUsuario.agregarMuestra(muestra1);
		int cant = desafioDeUsuario.cantidadDeMuestrasRecolectadas();

		assertEquals(0, cant);
	} 
	
	@Test
	void testUnDesafioDeUsuarioTieneUnaCantDeMuestrasParaCompletarElDesafio() {
		when(desafio.getCantMuestras()).thenReturn(2); 

		int cant = desafioDeUsuario.cantMuestrasParaCumplirDesafio();

		assertEquals(2, cant);
	}
}
