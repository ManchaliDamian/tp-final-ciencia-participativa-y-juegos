package ar.edu.unq.po2.tp.Final.Muestra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AreaGeograficaTest {

	AreaGeografica area;
	CoordenadaGeografica coordenada;
	CoordenadaGeografica coordenada1;


	@BeforeEach
	public void setUp() throws Exception {
		coordenada = new CoordenadaGeografica(10, 6);
		coordenada1 = new CoordenadaGeografica(10, 2);

		area = new AreaGeografica(coordenada, 6);

	}

	@Test
	void testLongitudDeCoordenada() {
		assertEquals(6, area.longitudDeCoordenada());
	}
	
	@Test 
	void testLatitudDeCoordenada() {
		assertEquals(10 , area.latitudDeCoordenada());
	}
	
	@Test
	void testesCoordenadaGeograficaValida() {
		
		assertTrue(area.esCoordenadaGeograficaValida(coordenada));
	}
	
	@Test
	void testNoesCoordenadaGeograficaValida() {
		
		assertTrue(area.esCoordenadaGeograficaValida(coordenada1));
	}
}
