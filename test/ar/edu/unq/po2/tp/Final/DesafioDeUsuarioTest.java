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
		 
		
	}
	 @Test 
	  void testDesafioDeUsuarioAgregaUnaMuestraQueCumpleConLasRestricciones() {
		 when(desafio.cumpleConRestriccion(muestra1)).thenReturn(true);
		 desafioDeUsuario.agregarSiCumpleRestriccion(muestra1);
		 
		assertEquals(1, desafioDeUsuario.cantidadDeMuestrasRecolectadas());
		 		 
	 }
	 
	 @Test
	 void testDesafioDeUnUsuarioNoAgregaUnaMuestraQueNoCumpleConLasRestricciones() {
		 when(desafio.cumpleConRestriccion(muestra2)).thenReturn(false);
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
	void testSeAgregaUnaMuestraPeroElDesafioNoEstaAceptado() {
		when(desafio.cumpleConRestriccion(muestra1)).thenReturn(true);
		
		desafioDeUsuario.agregarMuestra(muestra1);
		int cant = desafioDeUsuario.cantidadDeMuestrasRecolectadas();
		
		assertEquals(0, cant);
	}
	
	@Test
	void testSeAgregaUnaMuestraADesafioAceptado() {
		when(desafio.cumpleConRestriccion(muestra1)).thenReturn(true);
		desafioDeUsuario.aceptarDesafio();
		
		desafioDeUsuario.agregarMuestra(muestra1);
		int cant = desafioDeUsuario.cantidadDeMuestrasRecolectadas();
		
		assertEquals(1, cant);
	}
	
	@Test
	void testSeAgregaLaUltimaMuestraParaCompletar() {
		when(desafio.cumpleConRestriccion(muestra1)).thenReturn(true);
		when(desafio.cumpleConRestriccion(muestra2)).thenReturn(true);
		when(desafio.getCantMuestras()).thenReturn(1);
		desafioDeUsuario.aceptarDesafio();
		
		desafioDeUsuario.agregarMuestra(muestra1);
		desafioDeUsuario.agregarMuestra(muestra2);
		int cant = desafioDeUsuario.cantidadDeMuestrasRecolectadas();
		
		assertEquals(1, cant);
	}
		
}


