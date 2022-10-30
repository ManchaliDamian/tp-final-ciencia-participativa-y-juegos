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
	
	@BeforeEach
	public void setUp() throws Exception {
		estadoAceptado = mock(EstadoAceptado.class);
		estadoPendiente = mock(EstadoPendiente.class); 
		estadoCompleto = mock(EstadoCompleto.class); 
		desafio = mock(Desafio.class);
		muestra1 = mock(Muestra.class); 
		muestra2 = mock(Muestra.class); 
		desafioDeUsuario = new DesafioDeUsuario(5, desafio);
		 		
		when(desafio.cumpleConRestriccion(muestra1)).thenReturn(true);
		when(desafio.cumpleConRestriccion(muestra2)).thenReturn(false); 
		
		
	}
	 @Test 
	  void testDesafioDeUsuarioAgregaUnaMuestraQueCumpleConLasRestricciones() {
		desafioDeUsuario.agregarSiCumpleRestriccion(muestra1);
		 
		assertEquals(1, desafioDeUsuario.cantidadDeMuestrasRecolectadas());
		 		 
	 }
	 
	 @Test
	 void testDesafioDeUnUsuarioNoAgregaUnaMuestraQueNoCumpleConLasRestricciones() {
		 desafioDeUsuario.agregarSiCumpleRestriccion(muestra2);
		 
		 assertEquals(0, desafioDeUsuario.cantidadDeMuestrasRecolectadas());
		 		 
	 }
	 
	 @Test 
	 void testDesafioDeUsuarioTieneUnaCantDeMuestrasRecolectadas() {
		 desafioDeUsuario.agregarSiCumpleRestriccion(muestra1);
		 
		 int cant = desafioDeUsuario.cantidadDeMuestrasRecolectadas(); 
		 
		 assertEquals(1, cant);
	 }
	 
	 @Test
	 void testUnDesafioDeUsuarioTieneUnaCantDeMuestrasParaCompletarElDesafio() {
		 desafioDeUsuario.agregarSiCumpleRestriccion(muestra1);
		 when(desafio.getCantMuestras()).thenReturn(2); 
		 
		 int cant = desafioDeUsuario.cantMuestrasParaCumplirDesafio();
		 
		 assertEquals(2, cant);
	 }
	 
	 @Test
	 void testCuandoUnDesafioDeUsuarioEstaEnEstadoAceptadoYCumpleConLaRestricciónSeAgregaLaMuestra() {
		 desafioDeUsuario.setEstado(estadoAceptado);
		 when(estadoAceptado.estaAceptado()).thenReturn(true);
		 
		 desafioDeUsuario.agregarMuestraSiCorresponde(muestra1);
		 int cantMuestras = desafioDeUsuario.cantidadDeMuestrasRecolectadas();
		 
		 assertEquals(1, cantMuestras);
	 }
	 @Test
	 void testCuandoUnDesafioDeUsuarioEstaEnEstadoPendienteNoSeAgregaLaMuestra() {
		 desafioDeUsuario.setEstado(estadoPendiente);
		 when(estadoPendiente.estaAceptado()).thenReturn(false);
		 
		 desafioDeUsuario.agregarMuestraSiCorresponde(muestra1);
		 int cantMuestras = desafioDeUsuario.cantidadDeMuestrasRecolectadas();
		 
		 assertEquals(0, cantMuestras);
	 }
	 
	 @Test
	 void testCuandoUnDesafioDeUsuarioEstaEnEstadoCompletoNoSeAgregaLaMuestra() {
		 desafioDeUsuario.setEstado(estadoCompleto);
		 when(estadoPendiente.estaAceptado()).thenReturn(false);
		 
		 desafioDeUsuario.agregarMuestraSiCorresponde(muestra1);
		 int cantMuestras = desafioDeUsuario.cantidadDeMuestrasRecolectadas();
		 
		 assertEquals(0, cantMuestras);
	 }
	 
	 
	 
	 @Test
	 void testCuandoUnDesafioDeUsuarioEsCompletadoSeActualizaAEstadoCompleto() {
		 when(desafio.getCantMuestras()).thenReturn(1); 
		 desafioDeUsuario.setEstado(estadoAceptado);
		 
		 desafioDeUsuario.agregarSiCumpleRestriccion(muestra1); //cada vez que se agrega una muestra se verifica si completo el desafio
			
		 verify(estadoAceptado,times(1)).actualizarEstado(desafioDeUsuario);
		 
		 
	 }
	 
	 @Test
	 void testCuandoUnDesafioDeUsuarioNoEsCompletadoNoSeActualizaAEstadoCompleto() {
		 when(desafio.getCantMuestras()).thenReturn(2);
		 desafioDeUsuario.setEstado(estadoAceptado);
		 
		 desafioDeUsuario.agregarSiCumpleRestriccion(muestra1);
		 
		 verify(estadoAceptado, never()).actualizarEstado(desafioDeUsuario);
	 }
	 
	 
	
		
	}


