package ar.edu.unq.po2.tp.Final;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CienciaYJuegosTest {

	Usuario usuario1; 
	Preferencia prefencia1;
	Area area1; 
	Coordenada coordenada; 
	
	@BeforeEach
	public void setUp() throws Exception {
		prefencia1 = new Preferencia (5,10,20);
		usuario1 = new Usuario(prefencia1);
		coordenada = new Coordenada(50,20);
		area1 = new Area(coordenada , 5); 
	    		
	}
	
	@Test
	void elUsuarioConoceSuPreferenciaDeCantDeMuestras() {
		int cantidadDeMuestraDelUsuario = usuario1.getPreferencia().getCantidadDeMuestras();
		assertEquals(20 , cantidadDeMuestraDelUsuario);
	}
	@Test
	void elUsuarioConoceSuPrerenciaDeDificultad() {
		int dificultadDeseadaPorElusuario = usuario1.getPreferencia().getDificultad();
		assertEquals(5 , dificultadDeseadaPorElusuario);
	}
	 @Test 
	 void elUsuarioConoceSuPreferenciaDeRecompensa() {
		 int cantidadDeRecompensaDeseadaPorElUsuario = usuario1.getPreferencia().getRecompensa();
		 assertEquals(10 , cantidadDeRecompensaDeseadaPorElUsuario);
	 }
	 
	 @Test 
	 void elAreaConoceSuRadio() {
		 int radioDelArea = area1.calcularArea(); 
		 assertEquals(75 , radioDelArea); // CORREGIR ! 
	 }

}
