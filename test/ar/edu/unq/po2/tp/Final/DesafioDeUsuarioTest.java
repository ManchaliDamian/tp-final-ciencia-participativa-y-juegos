package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DesafioDeUsuarioTest {
	Usuario usuario;
	DesafioDeUsuario unDesafio;
	Estado estado;
	Desafio desafio;
	Muestra muestra;
// No funciona el mock ;(
	
	@BeforeEach
	public void setUp() throws Exception {
		estado = mock(Estado.class);
		usuario = mock(Usuario.class);
		desafio = mock(Desafio.class);
		muestra = mock(Muestra.class);
		unDesafio = new DesafioDeUsuario(5, desafio);
	}
	 @Test 
	  public void testDesafioCompletado() {
		 unDesafio.getMuestrasObtenidas().add(muestra);
		assertEquals(1 , unDesafio.cantidadDeMuestrasRecolectadas());		 
	 }
	
		
	}


