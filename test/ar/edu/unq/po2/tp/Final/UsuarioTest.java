package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
      Preferencia preferencia; 
      Usuario usuario;
      DesafioDeUsuario desafio; 
      Estado estado; 
      
      @BeforeEach
  	public void setUp() throws Exception{
  		preferencia = mock(Preferencia.class);
  		desafio = mock(DesafioDeUsuario.class);
  		estado = mock(Estado.class);
  		usuario = new Usuario(preferencia); 
      }
      
	@Test
	void testElUsuarioAceptaDesafiosPendientes() {
	

}
