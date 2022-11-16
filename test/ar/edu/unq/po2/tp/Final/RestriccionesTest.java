package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp.Final.Restricciones.RestriccionCompuesta;
import ar.edu.unq.po2.tp.Final.Restricciones.RestriccionDia;
import ar.edu.unq.po2.tp.Final.Restricciones.Restricciones.RestriccionArea;
import ar.edu.unq.po2.tp.Final.Restricciones.Restricciones.RestriccionFecha;

class RestriccionesTest {
	RestriccionDia restriccionDia;
	RestriccionFecha restriccionFecha;
	RestriccionArea restriccionArea;
	RestriccionCompuesta restriccionCompuesta;
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Muestra muestra4;
	Usuario usuario;
	CoordenadaGeografica coordenada1;
	CoordenadaGeografica coordenada2;
	CoordenadaGeografica coordenada3;
	Area area;

	@BeforeEach
	public void setUp() throws Exception {
		restriccionDia = new RestriccionDia(Dia.Martes);

		LocalDate unaFechaDeIncio = LocalDate.of(2022, 10, 20);
		LocalDate unaFechaDeFin = LocalDate.of(2022, 10, 30);
		restriccionFecha = new RestriccionFecha(unaFechaDeIncio, unaFechaDeFin);

		coordenada1 = new CoordenadaGeografica(1, 4);
		area = new Area(coordenada1, 20);
		restriccionArea = new RestriccionArea(area);

		restriccionCompuesta = new RestriccionCompuesta();

		LocalDate fechaMuestra1 = LocalDate.of(2022, 10, 22);
		LocalDate fechaMuestra2 = LocalDate.of(2022, 11, 1);
		coordenada2 = new CoordenadaGeografica(6, 6);
		coordenada3 = new CoordenadaGeografica(30, 22);
		muestra1 = new Muestra(coordenada2, usuario, fechaMuestra1, null, Dia.Martes);
		muestra2 = new Muestra(coordenada3, usuario, fechaMuestra2, null, Dia.Martes);
		muestra3 = new Muestra(null, usuario, fechaMuestra1, null, Dia.Lunes);
		muestra4 = new Muestra(coordenada3, usuario, fechaMuestra1, null, Dia.Martes);
		<<Correcion>> Esto es un test de integracion. No tulizan doubles.
	}

	@Test
	void testUnaMuestraConTodasSusRestricciones() {
        assertEquals(muestra1.getCordGeografica(), coordenada2);
        assertEquals(muestra1.getUsuario() , usuario);
        assertEquals(muestra1.getDia(), Dia.Martes);  
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
	void testUnaMuestraSeRealizaDentroDeLaCoordenadaGeograficaDelArea() {

		assertTrue(restriccionArea.isMuestraValida(muestra1));
	}

	@Test
	void testUnaMuestraSeRealizaFueraDeLaCoordenadaGeograficaDelArea() {

		assertFalse(restriccionArea.isMuestraValida(muestra2));
	}

	@Test
	void testUnaRestriccionCompuestaAgregaUnaNuevaRestriccion() {
		restriccionCompuesta.agregarRestriccion(restriccionDia);
		int cantDeRestricciones = restriccionCompuesta.getRestricciones().size();

		assertEquals(1, cantDeRestricciones);
	}

	@Test
	void testUnaMuestraCumpleConTodasLasRestriccionesDeLaRestriccionArea() {

		assertTrue(restriccionCompuesta.isMuestraValida(muestra1));

	}

	@Test
	void testUnaMuestraSeRealizaElMismoDiaPeroNoSeEncuentraDentroDeLaFechaDelDesafio() {
		restriccionCompuesta.agregarRestriccion(restriccionDia);
		restriccionCompuesta.agregarRestriccion(restriccionFecha);

		assertFalse(restriccionCompuesta.isMuestraValida(muestra2));
	}

	@Test
	void testUnaMuestraSeRealizaEnFechaPeroNoEnDiaDelDesafio() {
		restriccionCompuesta.agregarRestriccion(restriccionDia);
		restriccionCompuesta.agregarRestriccion(restriccionFecha);

		assertFalse(restriccionCompuesta.isMuestraValida(muestra3));
	}

	@Test
	void testUnaMuestraSeRealizaEnFechaYDiaPeroNoEnAreaDelDesafio() {
		restriccionCompuesta.agregarRestriccion(restriccionArea);
		restriccionCompuesta.agregarRestriccion(restriccionDia);
		restriccionCompuesta.agregarRestriccion(restriccionFecha);

		assertFalse(restriccionCompuesta.isMuestraValida(muestra4));
	}

}
