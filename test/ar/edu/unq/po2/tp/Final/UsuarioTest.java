package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
	
	//tambien el de agregarMuestra hacer uno o dos de como 
	//afecta al mock de Desafio de usuario

	@BeforeEach
	public void setUp() throws Exception {
		preferencia = mock(Preferencia.class);
		usuario = new Usuario(preferencia);
		
		estadoCompleto = mock(EstadoCompleto.class);
		estadoAceptado = mock(EstadoAceptado.class);  
		estadoPendiente = mock(EstadoPendiente.class);
		
		when(estadoPendiente.esEstadoPendiente()).thenReturn(true); 
		
		
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
		assertEquals(3, cant);
	}
	
	@Test 
	void testUnUsuarioAceptaLosDesafíosQueTienePendientes() {
		usuario.aceptarDesafiosPendientes();
		
		verify(desafio3, times(1)).aceptarDesafio();
	}
	
	@Test
	void testLosDesafiosDeUnUsuarioQueNoSeEncuentranPendientesNoSeActualizan() {
		usuario.aceptarDesafiosPendientes();
		
		verify(desafio2, never()).aceptarDesafio();
		verify(desafio1, never()).aceptarDesafio();
	}

}
