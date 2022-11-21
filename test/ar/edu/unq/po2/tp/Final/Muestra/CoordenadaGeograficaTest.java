package ar.edu.unq.po2.tp.Final.Muestra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoordenadaGeograficaTest {
	CoordenadaGeografica coordenada; 
	AreaGeografica area; 
	
	@BeforeEach
	public void setUp() throws Exception{
		coordenada = new CoordenadaGeografica(10, 6);
		area = mock(AreaGeografica.class); 
	}
	
	@Test
	void testUnaCoordenadaGeograficaSeEncuentraDentroDeArea() {
		when(area.getRadio()).thenReturn(20);
		when(area.longitudDeCoordenada()).thenReturn(10);
		when(area.latitudDeCoordenada()).thenReturn(4);
		
		assertTrue(coordenada.seEncuentraDentroDelRadio(area));
	}
	
	@Test
	void testUnaCoordenadaGeograficaNoSeEncuentraDentroDelArea() {
		when(area.getRadio()).thenReturn(4);
		when(area.longitudDeCoordenada()).thenReturn(10);
		when(area.latitudDeCoordenada()).thenReturn(4);
		
		assertFalse(coordenada.seEncuentraDentroDelRadio(area));
	}
	
	@Test
	void testUnaCoordenadaGeograficaSabeLaDistanciaEntreUnArea() {
		when(area.longitudDeCoordenada()).thenReturn(10);
		when(area.latitudDeCoordenada()).thenReturn(4);
		
		double distancia = coordenada.distanciaSobreElArea(area);
		
		assertEquals(7.211102550927978, distancia);
	}
	
	

}
