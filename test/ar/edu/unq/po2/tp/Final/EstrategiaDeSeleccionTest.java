package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstrategiaDeSeleccionTest {
	EstrategiaDeSeleccion favoritos;
	EstrategiaDeSeleccion preferenciaDeJuego;
	Desafio desafio1;
	Desafio desafio2;
	Desafio desafio3;
	Desafio desafio4;
	Desafio desafio5;
	Desafio desafio6;
	DesafioDeUsuario desafioDeUsuario;
	Usuario usuario;
	Preferencia preferencia;
	Area area;
	Restricciones restriccion;

	@BeforeEach
	public void setUp() throws Exception {
		favoritos = new Favoritos();
		preferenciaDeJuego = new PreferenciasDeJuego();

		area = mock(Area.class);
		restriccion = mock(RestriccionArea.class);
		
		preferencia = new Preferencia(4, 20, 10);
		usuario = new Usuario(preferencia);

		desafio1 = new Desafio(area, restriccion, 4, 4, 10, "Programacion");
		desafio2 = new Desafio(area, restriccion, 10, 2, 20, "Analisis logaritmico");
		desafio3 = new Desafio(area, restriccion, 20, 5, 40, "Biologia marina");
		desafio4 = new Desafio(area, restriccion, 14, 4, 10, "Artropologia");
		desafio5 = new Desafio(area, restriccion, 10, 3, 20, "Analisis de hojas");
		desafio6 = new Desafio(area, restriccion, 26, 4, 40, "Programacion con objetos");

		desafioDeUsuario = new DesafioDeUsuario(desafio4);

		usuario.agregarDesafio(desafioDeUsuario);
	}

	@Test
	void testEstrategiaDeSeleccionFavoritosEligePorCoincidenciaDelDesafioDeUsuarioConMayorPuntaje() {
		int distEntre = favoritos.coincidenciaDeDesafioYUsuario(desafio1, usuario);

		assertEquals(3, distEntre);
	}
	
	@Test
	void testEstrategiaDeSeleccionPreferenciaDeJuegoEligePorCoincidenciaDeLaPreferenciaDelUsuario() {
		int distEntre = preferenciaDeJuego.coincidenciaDeDesafioYUsuario(desafio1, usuario);
		
		assertEquals(-16, distEntre);
		
	}

	@Test
	void testEstrategiaDeSeleccionFavoritosEligeDesafiosParaElUsuario() {
		List<Desafio> desafios = Arrays.asList(desafio1, desafio2, desafio3, desafio4, desafio5, desafio6);

		List<Desafio> desafiosParaUsuario = favoritos.desafiosParaElUsuario(desafios, usuario);

		assertFalse(desafiosParaUsuario.contains(desafio6));
	}

	@Test
	void testEstrategiaDeSeleccionPreferenciaDeJuegoEligeDesafiosParaElUsuario() {
		List<Desafio> desafios = Arrays.asList(desafio1, desafio2, desafio3, desafio4, desafio5, desafio6);

		List<Desafio> desafiosParaUsuario = preferenciaDeJuego.desafiosParaElUsuario(desafios, usuario);
		
		assertFalse(desafiosParaUsuario.contains(desafio6));
	}

}
