package ar.edu.unq.po2.tp.Final.Restricciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Muestra.AreaGeografica;
import ar.edu.unq.po2.tp.Final.Muestra.Muestra;

class RestriccionCompuestaTest {
	Restricciones restriccionCompuesta;
	Restricciones restriccionFecha;
	Restricciones restriccionArea; 
	Muestra muestra; 
	AreaGeografica area; 
	LocalDate fechaInicio;
	LocalDate fechaFin;
	
	@BeforeEach
	public void setUp() throws Exception{
		restriccionCompuesta = new RestriccionCompuesta();
		
		area = mock(AreaGeografica.class);
		restriccionArea = new RestriccionArea(area);
		
		fechaInicio = LocalDate.of(2022, 6, 4);
		fechaFin = LocalDate.of(2022, 6, 20);
		restriccionFecha = new RestriccionFecha(fechaInicio, fechaFin);
		
		muestra = mock(Muestra.class);
		
		restriccionCompuesta.agregarRestriccion(restriccionArea);
		restriccionCompuesta.agregarRestriccion(restriccionFecha);
	}
	
	@Test
	void testUnaRestriccionCompuestaVerificaMuestraValida() {
		when(area.esCoordenadaGeograficaValida(muestra.getCordGeografica())).thenReturn(true);
		when(muestra.seEncuentraDentroDeLasFechasDeDesafio(fechaInicio, fechaFin)).thenReturn(true);
		
		assertTrue(restriccionCompuesta.isMuestraValida(muestra));
		
		
	}
	
	@Test
	void testUnaRestriccionCompuestaVerificaMuestraNoValidaPorRestriccionArea() {
		when(area.esCoordenadaGeograficaValida(muestra.getCordGeografica())).thenReturn(false);
		when(muestra.seEncuentraDentroDeLasFechasDeDesafio(fechaInicio, fechaFin)).thenReturn(true);
		
		assertFalse(restriccionCompuesta.isMuestraValida(muestra));
		
		
	}
	
	@Test
	void testUnaRestriccionCompuestaVerificaMuestraNoValidaPorRestriccionFecha() {
		when(area.esCoordenadaGeograficaValida(muestra.getCordGeografica())).thenReturn(true);
		when(muestra.seEncuentraDentroDeLasFechasDeDesafio(fechaInicio, fechaFin)).thenReturn(false);
		
		assertFalse(restriccionCompuesta.isMuestraValida(muestra));
		
		
	}

}
