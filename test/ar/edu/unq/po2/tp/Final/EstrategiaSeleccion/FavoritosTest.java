package ar.edu.unq.po2.tp.Final.EstrategiaSeleccion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Usuario.Desafio;
import ar.edu.unq.po2.tp.Final.Usuario.DesafioDeUsuario;
import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

class FavoritosTest {
	Usuario usuario;
	Desafio desafio1;
	Desafio desafio2;
	Desafio desafio3;
	Desafio desafio4;
	DesafioDeUsuario desafioUsuario1;
	DesafioDeUsuario desafioUsuario2;

	Favoritos favoritos; 
	
	@BeforeEach
	public void setUp() throws Exception {
		favoritos = new Favoritos();
		
		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		
		desafioUsuario1 = mock(DesafioDeUsuario.class);
		desafioUsuario2 = mock(DesafioDeUsuario.class);

		
		usuario = mock(Usuario.class);
		
		when(usuario.desafioDeUsuarioConMayorPuntaje()).thenReturn(desafioUsuario2);
		
		when(desafioUsuario2.getDesafio()).thenReturn(desafio4);
		
		when(desafio4.getCantMuestras()).thenReturn(10);
		when(desafio4.getDificultad()).thenReturn(6);
		when(desafio4.getRecompensa()).thenReturn(4);
		
	}
	
	@Test 
	void testCoicidenciaParaElUsuario() {
		List<Desafio> desafios = Arrays.asList(desafio1, desafio2, desafio3,desafio4); 
		
		List<Desafio> desafiosConCoincidencia = favoritos.coincidenciasParaUsuario(desafios, usuario);
		
       assertTrue(desafiosConCoincidencia.contains(desafio2));
	}
	
	

}
