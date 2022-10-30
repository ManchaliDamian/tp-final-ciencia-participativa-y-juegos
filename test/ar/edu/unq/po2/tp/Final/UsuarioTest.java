package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	Preferencia preferencia;
	Usuario usuario;
	DesafioDeUsuario desafio1;
	DesafioDeUsuario desafio2;
	DesafioDeUsuario desafio3; 
	Estado estadoCompleto;
	Estado estadoAceptado; 
	Estado estadoPendiente; 
	
	//FALTA test de complejidad y de aceptar desafios
	//tambien el de agregarMuestra hacer uno o dos de como 
	//afecta al mock de Desafio de usuario

	@BeforeEach
	public void setUp() throws Exception {
		preferencia = mock(Preferencia.class);
		usuario = new Usuario(preferencia);
		
		estadoCompleto = mock(EstadoCompleto.class);
		when(estadoCompleto.estáCompletado()).thenReturn(true);
		
		estadoAceptado = mock(EstadoAceptado.class); 
		when(estadoAceptado.estáCompletado()).thenReturn(false); 
		
		estadoPendiente = mock(EstadoPendiente.class);
		when(estadoPendiente.estáCompletado()).thenReturn(false); 
		
		desafio1 = mock(DesafioDeUsuario.class);
		when(desafio1.getEstado()).thenReturn(estadoCompleto); 
		
		desafio2 = mock(DesafioDeUsuario.class); 
		when(desafio2.getEstado()).thenReturn(estadoAceptado);
		
		desafio3 = mock(DesafioDeUsuario.class);
		when(desafio3.getEstado()).thenReturn(estadoPendiente); 
		
		usuario.agregarDesafio(desafio1);
		usuario.agregarDesafio(desafio2);
		usuario.agregarDesafio(desafio3);
		
	}
	
	@Test
	void testCuandoUnUsuarioAgregaUnNuevoDesafíoLoContieneEntreSusDesafíos() {
		int cant = usuario.getDesafios().size();
		assertEquals(2, cant);
	}

	@Test
	void testElUsuarioConoceSusDesafiosCompletos() {
		int cant = usuario.cantidadDeDesafiosCompletados();
		assertEquals(1, cant);

	}
	
	@Test
	void testUnUsuarioAceptaLosDesafíosQueTienePendientes() {
		usuario.aceptarDesafiosPendientes();
		int cant = 0; // arreglar
		assertEquals(3, cant);
	}

}
