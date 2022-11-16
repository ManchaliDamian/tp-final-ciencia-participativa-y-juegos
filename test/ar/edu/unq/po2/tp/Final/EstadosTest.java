package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Estados.EstadoAceptado;
import ar.edu.unq.po2.tp.Final.Estados.EstadoCompleto;
import ar.edu.unq.po2.tp.Final.Estados.EstadoPendiente;

class EstadosTest {

	EstadoCompleto estadoCompleto;
	EstadoAceptado estadoAceptado;
	EstadoPendiente estadoPendiente;
	DesafioDeUsuario desafio1;
	DesafioDeUsuario desafio2;
	Usuario usuario;
	Desafio desafio;

	@BeforeEach
	public void setUp() throws Exception {

		estadoCompleto = new EstadoCompleto();
		estadoAceptado = new EstadoAceptado();
		estadoPendiente = new EstadoPendiente();
		usuario = mock(Usuario.class);
		desafio = mock(Desafio.class);
		desafio1 = new DesafioDeUsuario(desafio);

	}

	@Test
	void testElDesafioActualizaSuEstado() {

		assertFalse(desafio1.getEstado().estaAceptado());
		when(desafio1.cantMuestrasParaCumplirDesafio()).thenReturn(5);

		estadoPendiente.actualizarEstado(desafio1); 
		<<Correcion>> La forma de testear cosas relacionadas al estado no se hace de esta manera,
						El estado es interno del objeto desafio, por lo que la orma de testear los estados no es correcta.
						Ayudaria unsa mocks
		assertTrue(desafio1.getEstado().estaAceptado());

	}
	<<Correcion>>
	Test muy pobre.
	

}
