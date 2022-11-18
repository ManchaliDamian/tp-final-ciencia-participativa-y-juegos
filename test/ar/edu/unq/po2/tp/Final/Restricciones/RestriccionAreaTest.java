package ar.edu.unq.po2.tp.Final.Restricciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Muestra.AreaGeografica;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;

class RestriccionAreaTest {
	AreaGeografica area; 
	Muestra muestra;  
	Restricciones restriccionArea;

	@BeforeEach
	public void setUp() throws Exception {
		area = mock(AreaGeografica.class); 
		muestra = mock(Muestra.class);
		restriccionArea = new RestriccionArea(area);
		
	}
	
	@Test
	void testRestriccionAreaVerificaMuestraValida() {
		when(area.esCoordenadaGeograficaValida(muestra.getCordGeografica())).thenReturn(true);
		
		assertTrue(restriccionArea.isMuestraValida(muestra));
	}
	
	@Test
	void testRestriccionAreaVerificaMuestraNoValida() {
		when(area.esCoordenadaGeograficaValida(muestra.getCordGeografica())).thenReturn(false);
		
		assertFalse(restriccionArea.isMuestraValida(muestra));
	}

}
