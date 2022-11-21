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

class PreferenciaDeJuegoTest {
	Usuario usuario;
	Desafio desafio1;
	Desafio desafio2;
	Desafio desafio3;
	Desafio desafio4;
	DesafioDeUsuario desafioUsuario1;
	DesafioDeUsuario desafioUsuario2;
	
	PreferenciasDeJuego preferencia; 
	
	@BeforeEach
	public void setUp() throws Exception {
		preferencia = new PreferenciasDeJuego();
		
		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		
		desafioUsuario1 = mock(DesafioDeUsuario.class);
		desafioUsuario2 = mock(DesafioDeUsuario.class);

		
		usuario = mock(Usuario.class); 
		
		when(desafioUsuario1.getDesafio()).thenReturn(desafio1);
		when(desafioUsuario2.getDesafio()).thenReturn(desafio2);

		
	}
	
	@Test 
	void testCoicidenciaParaElUsuario() {
		List<Desafio> desafios = Arrays.asList(desafio1, desafio2, desafio3,desafio4); 
		
		List<Desafio> desafiosConCoincidencia = preferencia.coincidenciasParaUsuario(desafios, usuario);
		
       assertTrue(desafiosConCoincidencia.contains(desafio2));
	}
	
	@Test 
	void testDesafiosYaRecomendados() {
	
		when(desafioUsuario1.getDesafio()).thenReturn(desafio1);
		when(desafioUsuario2.getDesafio()).thenReturn(desafio2);

		List<DesafioDeUsuario> desafiosUsuario = Arrays.asList(desafioUsuario1, desafioUsuario2); 

		when(usuario.getDesafios()).thenReturn(desafiosUsuario); 
		
		List<Desafio> desafiosYaRecomendados = preferencia.desafiosYaRecomendados(usuario);
		
		assertTrue(desafiosYaRecomendados.contains(desafio1));
		assertFalse(desafiosYaRecomendados.contains(desafio4)); 
		
	}
	
	@Test
	void desafiosParaElUsuarioSinDesafiosYaRecomendados() {
		List<Desafio> desafios = Arrays.asList(desafio1, desafio2, desafio3,desafio4); 

		when(desafioUsuario1.getDesafio()).thenReturn(desafio1);
		when(desafioUsuario2.getDesafio()).thenReturn(desafio2); 

		List<DesafioDeUsuario> desafiosUsuario = Arrays.asList(desafioUsuario1, desafioUsuario2); 

		when(usuario.getDesafios()).thenReturn(desafiosUsuario); 
		
		List<Desafio> desafiosParaElUsuario = preferencia.desafiosParaElUsuario(usuario, desafios);
		
		assertTrue(desafiosParaElUsuario.contains(desafio4));
		assertEquals(2, desafiosParaElUsuario.size());
		
	}
	
}
