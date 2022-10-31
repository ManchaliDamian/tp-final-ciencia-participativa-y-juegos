package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*; 

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestriccionesTest {
	RestriccionDia restriccionDia; 
	RestriccionFecha restriccionFecha;
	RestriccionDiaYFecha restriccionDiaYFecha;
	Muestra muestra; 
	
	@BeforeEach
	public void setUp() throws Exception{
		restriccionDia = new RestriccionDia(Dia.Martes);
		
		LocalDate unaFechaDeIncio = LocalDate.of(2022, 10, 20);
		LocalDate unaFechaDeFin = LocalDate.of(2022, 10, 30); 
		restriccionFecha = new RestriccionFecha(unaFechaDeIncio, unaFechaDeFin);
		 
		restriccionDiaYFecha = new RestriccionDiaYFecha(); 
		muestra = mock(Muestra.class); 
		
	} 

	@Test 
	void testUnaMuestraSeRealizaElMismoDiaQueLaRestriccionDiaEsValida() {
		when(muestra.getDia()).thenReturn(Dia.Martes);
		
		assertTrue(restriccionDia.isMuestraValida(muestra)); 
	}
	
	@Test
	void testUnaMuestraSeRealizaUnDiaDiferenteALaRestriccionDiaNoEsValida() {
		when(muestra.getDia()).thenReturn(Dia.Jueves);
		
		assertFalse(restriccionDia.isMuestraValida(muestra)); 
	}
	
	@Test
	void testUnaMuestraSeRealizaDentroDeLasFechasDeLaRestriccionFechaEsValida() {
		LocalDate fechaMuestra = LocalDate.of(2022, 10, 22);
		when(muestra.getFecha()).thenReturn(fechaMuestra); 
		
		assertTrue(restriccionFecha.isMuestraValida(muestra)); 
	}
	
	@Test
	void testUnaMuestraSeRealizaFueraDeLasFechasDeLaRestriccionFechaNoEsValida() {
		LocalDate fechaMuestra = LocalDate.of(2022, 11, 2);
		when(muestra.getFecha()).thenReturn(fechaMuestra);
		
		assertFalse(restriccionFecha.isMuestraValida(muestra)); 
	}
	
	@Test
	void testUnaRestriccionDiaYFechaAgregaUnaNuevaRestriccion() {
		restriccionDiaYFecha.agregarRestriccion(restriccionDia);
		int cantDeRestricciones = restriccionDiaYFecha.getRestricciones().size();
		
		assertEquals(1, cantDeRestricciones);
	} 

	@Test
	void testUnaMuestraSeRealizaDentroDeLosDiasYFechasDeLaRestriccionFechaYDiaEsValida() {
		LocalDate fechaMuestra = LocalDate.of(2022, 10, 22);
		when(muestra.getFecha()).thenReturn(fechaMuestra);
		when(muestra.getDia()).thenReturn(Dia.Martes);
		
		assertTrue(restriccionDiaYFecha.isMuestraValida(muestra)); 
		
		
	}
	
	@Test
	 void testUnaMuestraSeRealizaElMismoDiaPeroNoSeEncuentraDentroDeLaFecha() {
		LocalDate fechaMuestra = LocalDate.of(2022, 11, 2);
		when(muestra.getFecha()).thenReturn(fechaMuestra);
		
		restriccionDiaYFecha.agregarRestriccion(restriccionDia);
		restriccionDiaYFecha.agregarRestriccion(restriccionFecha);
	
		assertFalse(restriccionDiaYFecha.isMuestraValida(muestra)); 
	}
	
	@Test
	void testUnaMuestraSeRealizaEnFechaPeroNoEnDia() {
		LocalDate fechaMuestra = LocalDate.of(2022, 10, 22);
		when(muestra.getFecha()).thenReturn(fechaMuestra);
		when(muestra.getDia()).thenReturn(Dia.Jueves);
		
		restriccionDiaYFecha.agregarRestriccion(restriccionDia);
		restriccionDiaYFecha.agregarRestriccion(restriccionFecha);
		
		assertFalse(restriccionDiaYFecha.isMuestraValida(muestra)); 
	}

}
