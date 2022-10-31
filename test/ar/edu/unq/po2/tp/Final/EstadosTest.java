package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadosTest {

	EstadoCompleto estadoCompleto;
	EstadoAceptado estadoAceptado;
	EstadoPendiente estadoPendiente;
	DesafioDeUsuario desafio1;
	DesafioDeUsuario desafio2;
	Usuario usuario;

	@BeforeEach
	public void setUp() throws Exception {
		estadoCompleto = new EstadoCompleto();
		estadoAceptado =new EstadoAceptado();
		estadoPendiente = new EstadoPendiente();
		usuario = mock(Usuario.class);
		desafio1 = mock(DesafioDeUsuario.class);

	}

	@Test
	void elEstadoCambiaCuandoElusuarioAcepta() {
		when(desafio1.getEstado()).thenReturn(estadoPendiente); 
 		usuario.agregarDesafio(desafio1);
		desafio1.aceptarDesafio();
		
		assertTrue(desafio1.getEstado().estaAceptado()); 

	}

}
