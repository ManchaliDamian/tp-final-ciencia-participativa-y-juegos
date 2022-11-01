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
	Muestra muestra1; 
	Muestra muestra2; 
	Muestra muestra3; 
	Usuario usuario; 
	
	@BeforeEach 
	public void setUp() throws Exception{
		restriccionDia = new RestriccionDia(Dia.Martes);
		
		LocalDate unaFechaDeIncio = LocalDate.of(2022, 10, 20);
		LocalDate unaFechaDeFin = LocalDate.of(2022, 10, 30); 
		restriccionFecha = new RestriccionFecha(unaFechaDeIncio, unaFechaDeFin);
		 
		restriccionDiaYFecha = new RestriccionDiaYFecha(); 
		
		LocalDate fechaMuestra1 = LocalDate.of(2022, 10, 22);
		LocalDate fechaMuestra2 = LocalDate.of(2022, 11, 1);
		muestra1 = new Muestra(null, usuario, fechaMuestra1, null, Dia.Martes);
		muestra2 = new Muestra(null, usuario, fechaMuestra2, null, Dia.Martes);
		muestra3 = new Muestra(null, usuario, fechaMuestra1, null, Dia.Lunes);
	} 
 
	@Test 
	void testCuandoUnaMuestraSeRealizaElMismoDiaQueLaRestriccionDiaEsValida() {
		 
		assertTrue(restriccionDia.isMuestraValida(muestra1)); 
	}
	
	@Test
	void testCuandotUnaMuestraSeRealizaUnDiaDiferenteALaRestriccionDiaNoEsValida() {
	
		assertFalse(restriccionDia.isMuestraValida(muestra3)); 
	}
	
	@Test
	void testUnaMuestraSeRealizaDentroDeLasFechasDeLaRestriccionFechaEsValida() {
		
		assertTrue(restriccionFecha.isMuestraValida(muestra1)); 
	}
	
	@Test
	void testUnaMuestraSeRealizaFueraDeLasFechasDeLaRestriccionFechaNoEsValida() {
		
		assertFalse(restriccionFecha.isMuestraValida(muestra2)); 
	}
	
	@Test
	void testUnaRestriccionDiaYFechaAgregaUnaNuevaRestriccion() {
		restriccionDiaYFecha.agregarRestriccion(restriccionDia);
		int cantDeRestricciones = restriccionDiaYFecha.getRestricciones().size();
		
		assertEquals(1, cantDeRestricciones);
	} 

	@Test
	void testUnaMuestraSeRealizaDentroDeLosDiasYFechasDeLaRestriccionFechaYDiaEsValida() {
		
		assertTrue(restriccionDiaYFecha.isMuestraValida(muestra1)); 
		
		
	}
	
	@Test
	 void testUnaMuestraSeRealizaElMismoDiaPeroNoSeEncuentraDentroDeLaFecha() {
		restriccionDiaYFecha.agregarRestriccion(restriccionDia);
		restriccionDiaYFecha.agregarRestriccion(restriccionFecha);
	
		assertFalse(restriccionDiaYFecha.isMuestraValida(muestra2)); 
	}
	
	@Test
	void testUnaMuestraSeRealizaEnFechaPeroNoEnDia() {
		restriccionDiaYFecha.agregarRestriccion(restriccionDia);
		restriccionDiaYFecha.agregarRestriccion(restriccionFecha);
		
		assertFalse(restriccionDiaYFecha.isMuestraValida(muestra3)); 
	}

}
