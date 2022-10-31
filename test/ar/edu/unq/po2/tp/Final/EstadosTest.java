package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
	void testElEstadoCambiaCuandoElusuarioAceptaElDesafio() {
		when(desafio1.getEstado()).thenReturn(estadoPendiente); 
        //desafio1.aceptarDesafio();
		estadoPendiente.actualizarEstado(desafio1);
		
		assertTrue(desafio1.getEstado().estaAceptado());
		

	}

}
