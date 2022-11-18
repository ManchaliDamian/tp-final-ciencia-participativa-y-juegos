package ar.edu.unq.po2.tp.Final.Restricciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Muestra.Muestra;

class RestriccionFinDeSemanaTest {
	Restricciones restriccionFinDeSemana;
	Muestra muestra; 
	
	@BeforeEach
	public void setUp() throws Exception{
		restriccionFinDeSemana = new RestriccionesFinDeSemana();
		muestra = mock(Muestra.class);
		
	}

	@Test
	void testUnaRestriccionFinDeSemanaVerificaUnaMuestraValida() {
		when(muestra.valorDeDiaDeSemana()).thenReturn(6);
		
		assertTrue(restriccionFinDeSemana.isMuestraValida(muestra));
	}
	
	@Test
	void testUnaRestriccionFinDeSemanaVerificaUnaMuestraNoValida() {
		when(muestra.valorDeDiaDeSemana()).thenReturn(4);
		
		assertFalse(restriccionFinDeSemana.isMuestraValida(muestra));
	}


}
