package ar.edu.unq.po2.tp.Final.EstrategiaSeleccion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
	Desafio desafio5;
	Desafio desafio6; 
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
		desafio5 = mock(Desafio.class);
		desafio6 = mock(Desafio.class);
		
		desafioUsuario1 = mock(DesafioDeUsuario.class);
		desafioUsuario2 = mock(DesafioDeUsuario.class);

		
		usuario = mock(Usuario.class);
		
		when(usuario.desafioDeUsuarioConMayorPuntaje()).thenReturn(desafioUsuario2);
		
		when(desafioUsuario2.getDesafio()).thenReturn(desafio4);
		
		when(desafio4.getCantMuestras()).thenReturn(10);
		when(desafio4.getDificultad()).thenReturn(2);
		when(desafio4.getRecompensa()).thenReturn(4);
		
		when(desafio1.getCantMuestras()).thenReturn(4);
		when(desafio1.getDificultad()).thenReturn(2);
		when(desafio1.getRecompensa()).thenReturn(10);
		
		when(desafio2.getCantMuestras()).thenReturn(12);
		when(desafio2.getDificultad()).thenReturn(4);
		when(desafio2.getRecompensa()).thenReturn(10);
		
		when(desafio3.getCantMuestras()).thenReturn(12);
		when(desafio3.getDificultad()).thenReturn(2);
		when(desafio3.getRecompensa()).thenReturn(12);
		
		when(desafio5.getCantMuestras()).thenReturn(6);
		when(desafio5.getDificultad()).thenReturn(4);
		when(desafio5.getRecompensa()).thenReturn(10);
		
		when(desafio6.getCantMuestras()).thenReturn(20);
		when(desafio6.getDificultad()).thenReturn(4);
		when(desafio6.getRecompensa()).thenReturn(10);
		
	}
	
	@Test
	void testEstrategiaDeSeleccionFavoritosBuscaCoincidenciasParaUnUsuario() {
		List<Desafio> desafios = Arrays.asList(desafio1, desafio2, desafio3,desafio4, desafio5, desafio6); 
		
		List<Desafio> desafiosParaUsuario = favoritos.desafiosParaElUsuario(usuario, desafios);
		
		assertTrue(desafiosParaUsuario.contains(desafio4));
		assertFalse(desafiosParaUsuario.contains(desafio6));
		
		
	}
	
	

}
