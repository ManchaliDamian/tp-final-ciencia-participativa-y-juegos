package ar.edu.unq.po2.tp.Final.Restricciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Muestra.Muestra;

class RestriccionFechaTest {
	Restricciones restriccionFecha; 
	Muestra muestra; 
	LocalDate fechaInicio;
	LocalDate fechaFin;

	@BeforeEach
	public void setUp() throws Exception{
		LocalDate fechaInicio = LocalDate.of(2022, 6, 4);
		LocalDate fechaFin = LocalDate.of(2022, 6, 20);
		restriccionFecha = new RestriccionFecha(fechaInicio, fechaFin);
		
		muestra = mock(Muestra.class);
		when(muestra.seEncuentraDentroDeLasFechasDeDesafio(fechaInicio, fechaFin)).thenReturn(true);
	}
	
	@Test
	void testUnaRestriccionFechaVerificaSiEsMuestraValida() {
		
		assertTrue(restriccionFecha.isMuestraValida(muestra));
	}
	

}
