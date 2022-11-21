package ar.edu.unq.po2.tp.Final.Muestra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Usuario.Usuario;

class MuestraTest {

	Muestra muestra;
	CoordenadaGeografica cordGeografica;
	Usuario usuario;

	@BeforeEach
	public void setUp() throws Exception {
		cordGeografica = mock(CoordenadaGeografica.class);
		usuario = mock(Usuario.class);
		muestra = new Muestra(cordGeografica, usuario, LocalDate.of(2022, 8, 25), LocalTime.of(15, 56)); 

	}
	
	@Test
	void testseEncuentraDentroDeLasFechasDeDesafio() {
		assertTrue(muestra.seEncuentraDentroDeLasFechasDeDesafio(LocalDate.of(2022, 7, 25), LocalDate.of(2022, 10, 25)));
		assertEquals(LocalDate.of(2022, 8, 25), muestra.getFecha()); 
	}
	
	@Test
	void testNoseEncuentraDentroDeLasFechasDeDesafio() {
		assertFalse(muestra.seEncuentraDentroDeLasFechasDeDesafio(LocalDate.of(2022, 9, 25), LocalDate.of(2022, 10, 25)));

	} 
	
	@Test
	void testDiaDeLaSemana() {
		assertEquals( DayOfWeek.THURSDAY , muestra.diaDeLaSemana()); 
	}
	
	@Test
	void testvalorDeDiaDeSemana() {
		assertEquals(4, muestra.valorDeDiaDeSemana()); 
	}
	 
}
