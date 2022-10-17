package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CienciaYJuegosTest {

	Usuario usuario1; 
	Preferencia prefencia1;
	Area area1; 
	Coordenada coordenada; 
	Proyecto proyecto;
	Muestra muestra;
	LocalDate fecha; 
	
	
	@BeforeEach
	public void setUp() throws Exception {
		prefencia1 = new Preferencia (5,10,20);
		usuario1 = new Usuario(prefencia1);
		coordenada = new Coordenada(50,20);
		area1 = new Area(coordenada , 5); 
		proyecto = new Proyecto("Otoño", "Estación del año"); 
		fecha = LocalDate.now(); // agregar dos fechas
		ChronoLocalDate hora = ChronoLocalDate.from(fecha); 
		muestra = new Muestra(coordenada, usuario1, fecha, hora); 
		
	    		
	}
	
	@Test
	void testUsuarioConoceSuPreferenciaDeCantDeMuestras() {
		int cantidadDeMuestraDelUsuario = usuario1.getPreferencia().getCantidadDeMuestras();
		assertEquals(20 , cantidadDeMuestraDelUsuario);
	}
	@Test
	void testUsuarioConoceSuPrerenciaDeDificultad() {
		int dificultadDeseadaPorElusuario = usuario1.getPreferencia().getDificultad();
		assertEquals(5 , dificultadDeseadaPorElusuario);
	}
	 @Test 
	 void testUsuarioConoceSuPreferenciaDeRecompensa() {
		 int cantidadDeRecompensaDeseadaPorElUsuario = usuario1.getPreferencia().getRecompensa();
		 assertEquals(10 , cantidadDeRecompensaDeseadaPorElUsuario);
	 }
	 
	 @Test 
	 void testAreaConoceSuRadio() {
		 int radioDelArea = area1.calcularArea(); 
		 assertEquals(75 , radioDelArea); // CORREGIR ! 
	 }
	 
	 @Test
	 void testProyectoConoceASusParticipantes() {
		 proyecto.agregarParticipante(usuario1);
		 assertTrue(proyecto.getUsuarios().contains(usuario1)); 
	 }
	 
	 @Test
	 void testProyectoConoceLasMuestrasQuePosee() {
		 
	 }

}
