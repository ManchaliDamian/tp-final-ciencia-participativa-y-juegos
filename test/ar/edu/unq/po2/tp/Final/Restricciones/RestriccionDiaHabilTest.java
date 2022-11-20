package ar.edu.unq.po2.tp.Final.Restricciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Muestra.Muestra;

class RestriccionDiaHabilTest {

	Restricciones restriccionDiaHabil;
	Muestra muestra; 
	
	@BeforeEach
	public void setUp() throws Exception{
		restriccionDiaHabil = new RestriccionDiaHabil();
		muestra = mock(Muestra.class);
		
	}
	
	@Test
	void testUnaRestriccionDiaHabilVerificaUnaMuestraValida() {
		when(muestra.valorDeDiaDeSemana()).thenReturn(8);
		
		assertTrue(restriccionDiaHabil.isMuestraValida(muestra));
	}
	
	@Test
	void testUnaRestriccionDiaHabilVerificaUnaMuestraNoValida() {
		when(muestra.valorDeDiaDeSemana()).thenReturn(4);
		
		assertFalse(restriccionDiaHabil.isMuestraValida(muestra));
	}

}
